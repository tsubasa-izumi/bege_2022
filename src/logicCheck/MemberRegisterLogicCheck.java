package logicCheck;


import static commonprocess.errormessage.ErrorIDConstants.*;
import static commonprocess.errormessage.StringConstants.*;
import static commonprocess.errormessage.TableConstants.*;

import java.sql.Connection;
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
	HarfWidthAlphanumFormatCheck harfWidthAlphanumFormatCheck = new HarfWidthAlphanumFormatCheck();
	HarfWidthNumFormatCheck harfWidthNumFormatCheck = new HarfWidthNumFormatCheck();
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
	 */
	public List<String> memberRegisterLogicCheck(String name, String kana, String telnumber, String mail, String password,
			String ques, String ans, String address,
			String prefecture, String city, String housenumber, String cardnumber, String code,
			String cardlimit, String meigi){
		errorList = errorMsg.errorMsgNullCheck(checkName(name), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkKana(kana), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkTelnumber(telnumber), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkMail(mail), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkPassword(password), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkQuestion(ques), errorList);
		errorList = errorMsg.errorMsgNullCheck(checkAnswer(ans), errorList);

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
		String[] msgElement = { PHONE_NUMBER, "50" };
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
	 */
	private String checkMail(String mail) {
		String[] msgElement = { MAIL_ADDRESS, "256" };
		// 入力値が256文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(mail, 256) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		// 入力値が半角英数字ではない場合、エラーメッセージを返す
		if (harfWidthAlphanumFormatCheck.isCorrectFormat(mail) == false) {
			return errorMsg.returnErrorMsg(HALFWIDTH_ALPHANUMERIC_ERROR_MESSAGE, msgElement);
		}
		FormatCheck mailGFormatCheck = new MailFormatCheck();
		// 入力値が@を含んでいない場合、エラーメッセージを返す
		if (mailGFormatCheck.isCorrectFormat(mail) == false) {
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

	private String checkPrefecture(String prefecture) {
		String[] msgElement = { ADDRESS_PREFECTURE, "4" };
 		// 入力値が4文字を超えている場合、エラーメッセージを返す
		if (lengthCheck.isMaxStringLength(prefecture, 4) == false) {
			return errorMsg.returnErrorMsg(INPUT_MAX_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

}

