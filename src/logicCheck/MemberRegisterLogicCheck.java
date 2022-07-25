package logicCheck;


import static commonprocess.errormessage.ErrorIDConstants.*;
import static commonprocess.errormessage.StringConstants.*;
import static commonprocess.errormessage.TableConstants.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commonprocess.CheckDuplicateDAO;
import commonprocess.FormatCheck;
import commonprocess.LengthCheck;
import commonprocess.errormessage.ErrorMsg;
import commonprocess.formatchecksub.HarfWidthAlphanumFormatCheck;
import commonprocess.formatchecksub.HarfWidthNumFormatCheck;
import commonprocess.formatchecksub.MailFormatCheck;
import src.util.dbutil;

public class MemberRegisterLogicCheck {
	List<String> errorList = new ArrayList<String>();
	Connection con = dbutil.getConnection();
	ErrorMsg errorMsg = new ErrorMsg();
	LengthCheck lengthCheck = new LengthCheck();
	FormatCheck harfWidthAlphanumFormatCheck = new HarfWidthAlphanumFormatCheck();
	FormatCheck harfWidthNumFormatCheck = new HarfWidthNumFormatCheck();
	CheckDuplicateDAO checkDuplicateDAO = new CheckDuplicateDAO(con);



	/**
	 * 入出値を引数に各項目のエラーチェックメソッドを呼び出し、エラーメッセージのリストを返す
	 * @param name
	 * @param kana
	 * @param telnumber
	 * @param mail
	 * @param password
	 * @param ques
	 * @param ans
	 * @param address
	 * @param prefecture
	 * @param cardnumber
	 * @param city
	 * @param housenumber
	 * @param code
	 * @param cardlimit
	 * @param meigi
	 * @return errorList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<String> memberRegisterLogicCheck(String name, String kana, String telnumber, String mail, String password,
			String ques, String ans, String address,
			String prefecture, String city, String housenumber, String cardnumber, String code,
			String cardlimit, String meigi) throws ClassNotFoundException, SQLException{
		errorList = errorMsg.errorMsgNullCheck(checkName(name), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkKana(kana), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkTelnumber(telnumber), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkMail(mail), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkPassword(password), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkQuestion(ques), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkAnswer(ans), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkAddressPost(address), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkPrefecture(prefecture), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkCity(city), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkHouseNumber(housenumber), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkCardNumber(cardnumber), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkCode(code), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkCardLimit(cardlimit), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkMeigi(meigi), errorList);
		return errorList;
	}

	/**
	 * 予期せぬエラーが発生した場合、システムエラーを知らせるエラーメッセージを返す
	 * @return errorList
	 */
	public List<String> unExpectedError() {
		errorList = errorMsg.errorMsgNullCheck(errorMsg.returnErrorMsg(ERROR), errorList);
		return errorList;
	}

	/**
	 * 名前のエラーチェック
	 * @param name
	 * @return　エラーメッセージ
	 */
	private String checkName(String name) {
		String[] msgElement = { KANJI_NAME, "50" };
 		// 入力値が50文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(name, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * フリガナのエラーチェック
	 * @param kana
	 * @return エラーメッセージ
	 */
	private String checkKana(String kana) {
		String[] msgElement = { FURIGANA_NAME, "50" };
		// 入力値が50文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(kana, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * 電話番号のエラーチェック
	 * @param telnumber
	 * @return エラーメッセージ
	 */
	private String checkTelnumber(String telnumber) {
		String[] msgElement = { PHONE_NUMBER, "11" };
		// 入力値が11文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(telnumber, 11) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		// 入力値が半角数字ではない場合、エラーメッセージを返す
		if (harfWidthNumFormatCheck.isCorrectFormat(telnumber) == false) {
			return errorMsg.returnErrorMsg(HARF_WIDTH_NUM_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * メールアドレスのエラーチェック
	 * @param mail
	 * @return エラーメッセージ
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private String checkMail(String mail) throws ClassNotFoundException, SQLException {
		String[] msgElement = { MAIL_ADDRESS, "256" };
		// 入力値が256文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(mail, 256) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		// 入力値が半角英数字ではない場合、エラーメッセージを返す
		if (harfWidthAlphanumFormatCheck.isCorrectFormat(mail) == false) {
			return errorMsg.returnErrorMsg(HALFWIDTH_ALPHANUMERIC_ERROR_MESSAGE, msgElement);
		}
		FormatCheck mailFormatCheck = new MailFormatCheck();
		// 入力値が@を含んでいない場合、エラーメッセージを返す
		if (mailFormatCheck.isCorrectFormat(mail) == false) {
			return errorMsg.returnErrorMsg(FORMAT_INPUT_ERROR_MESSAGE, msgElement);
		}
		// 入力値がすでにDBに登録されている場合、エラーメッセージを返す
		int numMail = checkDuplicateDAO.checkDuplicate(mail, MEMBER_TABLE, COLUMN_USER_MAIL);
		if (numMail != 0) {
			return errorMsg.returnErrorMsg(INPUT_DUPLICATE_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * パスワードのエラーチェック
	 * @param password
	 * @return エラーメッセージ
	 */
	private String checkPassword(String password) {
		String[] minMsgElement = { PASSWORD, "4" };
		String[] maxMsgElement = { PASSWORD, "10" };
		// 入力値が4文字に満たない場合、エラーメッセージを返す
		if (lengthCheck.isMinStringLength(password, 4) == false) {
			return errorMsg.returnErrorMsg(INPUT_MIN_LENGTH_ERROR_MESSAGE, minMsgElement);
		}
		// 入力値が10文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(password, 10) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, maxMsgElement);
		}
		// 入力値が半角英数字ではない場合、エラーメッセージを返す
		if (harfWidthAlphanumFormatCheck.isCorrectFormat(password) == false) {
			return errorMsg.returnErrorMsg(HALFWIDTH_ALPHANUMERIC_ERROR_MESSAGE, minMsgElement);
		}
		return null;
	}

	/**
	 * 秘密の質問のエラーチェック
	 * @param ques
	 * @return エラーメッセージ
	 */
	private String checkQuestion(String ques) {
		String[] msgElement = { SEACRET_QUESTION, "50" };
 		// 入力値が50文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(ques, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * 秘密の質問の答えのエラーチェック
	 * @param ans
	 * @return エラーメッセージ
	 */
	private String checkAnswer(String ans) {
		String[] msgElement = { SEACRET_QUESTION_ANSWER, "50" };
 		// 入力値が50文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(ans, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * 郵便番号のエラーチェック
	 * @param address
	 * @return エラーメッセージ
	 */
	private String checkAddressPost(String address) {
		String[] msgElement = { ADDRESS_POST, "7" };
		// 入力値が7文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(address, 7) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		// 入力値が半角数字ではない場合、エラーメッセージを返す
		if (harfWidthNumFormatCheck.isCorrectFormat(address) == false) {
			return errorMsg.returnErrorMsg(HARF_WIDTH_NUM_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * 都道府県のエラーチェック
	 * @param prefecture
	 * @return エラーメッセージ
	 */
	private String checkPrefecture(String prefecture) {
		String[] msgElement = { ADDRESS_PREFECTURE, "4" };
 		// 入力値が4文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(prefecture, 4) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * 市区町村のエラーチェック
	 * @param city
	 * @return　エラーメッセージ
	 */
	private String checkCity(String city) {
		String[] msgElement = { ADDRESS_CITY, "50" };
 		// 入力値が50文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(city, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * 番地のエラーチェック
	 * @param housenumber
	 * @return エラーメッセージ
	 */
	private String checkHouseNumber(String housenumber) {
		String[] msgElement = { HOUSE_NUMBER, "50" };
 		// 入力値が50文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(housenumber, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * カード番号のエラーチェック
	 * @param cardnumber
	 * @return エラーメッセージ
	 */
	private String checkCardNumber(String cardnumber) {
		String[] msgElement = { CARD_ADDRESS_NUMBER, "16" };
 		// 入力値が16文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(cardnumber, 16) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		// 入力値が半角数字ではない場合、エラーメッセージを返す
		if (harfWidthNumFormatCheck.isCorrectFormat(cardnumber) == false) {
			return errorMsg.returnErrorMsg(HARF_WIDTH_NUM_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * セキュリティーコードのエラーチェック
	 * @param code
	 * @return エラーメッセージ
	 */
	private String checkCode(String code) {
		String[] msgElement = { CARD_SECURITY_CODE, "11" };
 		// 入力値が11文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(code, 11) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		// 入力値が半角数字ではない場合、エラーメッセージを返す
		if (harfWidthNumFormatCheck.isCorrectFormat(code) == false) {
			return errorMsg.returnErrorMsg(HARF_WIDTH_NUM_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * 有効期限のエラーチェック
	 * @param cardlimit
	 * @return エラーメッセージ
	 */
	private String checkCardLimit(String cardlimit) {
		String[] msgElement = { CARD_EXPIRY, "11" };
 		// 入力値が11文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(cardlimit, 11) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		// 入力値が半角数字ではない場合、エラーメッセージを返す
		if (harfWidthNumFormatCheck.isCorrectFormat(cardlimit) == false) {
			return errorMsg.returnErrorMsg(HARF_WIDTH_NUM_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	private String checkMeigi(String meigi) {
		String[] msgElement = { CARD_NAME, "50" };
 		// 入力値が50文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(meigi, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}
}

