package logicCheck;


import java.util.ArrayList;
import java.util.List;


public class MemberRegisterLogicCheck {
	List<String> errorList = new ArrayList<String>();

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
			String prefecture, String cardnumber, String city, String housenumber, String code,
			String cardlimit, String meigi){
		//errorList = errorMsg.errorMsgNullCheck(checkName(name), errorList);
		//errorList = errorMsg.errorMsgNullCheck(checkKana(kana), errorList);
		//errorList = errorMsg.errorMsgNullCheck(checkTelnumber(telnumber), errorList);
		//errorList = errorMsg.errorMsgNullCheck(checkMail(mail), errorList);
		return errorList;
	}

	/**
	 * 予期せぬエラーが発生した場合、システムエラーを知らせるエラーメッセージを返す
	 * @return errorList
	 */
	public List<String> unExpectedError() {
		//errorList = errorMsg.errorMsgNullCheck(errorMsg.returnErrorMsg(CommonConstants.), errorList);
		return errorList;
	}

	/**
	 * 名前のエラーチェック
	 * @param name
	 * @return　エラーメッセージ
	 */
	private String checkName(String name) {
		//String[] msgElement = { KANJI_NAME, "50" };
 		// 入力値が50文字以上の場合、エラーメッセージを返す
		if (lengthCheck.isStringLength(name, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * フリガナのエラーチェック
	 * @param kana
	 * @return エラーメッセージ
	 */
	private String checkKana(String kana) {
		//String[] msgElement = { FURIGANA_NAME, "50" };
		// 入力値が50文字以上の場合、エラーメッセージを返す
		if (lengthCheck.isStringLength(kana, 50) == false) {
			return errorMsg.returnErrorMsg(INPUT_LENGTH_ERROR_MESSAGE, msgElement);
		}
		return null;
	}

	/**
	 * 電話番号のエラーチェック
	 * @param telnumber
	 * @return エラーメッセージ
	 */
	private String checkTelnumber(String telnumber) {
		//String[] msgElement = { PHONE_NUMBER, "50" };
		// 入力値が11文字以上の場合、エラーメッセージを返す
		if (lengthCheck.isStringLength(telnumber, 11) == false) {
			return errorMsg.returnErrorMsg(INPUT_LENGTH_ERROR_MESSAGE, msgElement);
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
		//String[] msgElement = { MAIL_ADDRESS, "256" };
		// 入力値が256文字以上の場合、エラーメッセージを返す
		if (lengthCheck.isStringLength(mail, 256) == false) {
			return errorMsg.returnErrorMsg(INPUT_LENGTH_ERROR_MESSAGE, msgElement);
		}
		// 入力値が半角英数字ではない場合、エラーメッセージを返す
		if (harfWidthAlphanumAtSignFormatCheck.isCorrectFormat(mail) == false) {
			return errorMsg.returnErrorMsg(HALFWIDTH_ALPHANUMERIC_ERROR_MESSAGE, msgElement);
		}
		FormatCheck mailGFormatCheck = new MailFormatCheck();
		// 入力値が@を含んでいない場合、エラーメッセージを返す
		if (mailGFormatCheck.isCorrectFormat(mail) == false) {
			return errorMsg.returnErrorMsg(FORMAT_INPUT_ERROR_MESSAGE, msgElement);
		}
		return null;
	}


}

