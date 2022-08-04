package logicCheck;

import static commonprocess.errormessage.ErrorIDConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import commonprocess.errormessage.ErrorMsg;
import dto.MemberDTO;

public class LoginLogicCheck {
	List<String> errorList = new ArrayList<String>();
	ErrorMsg errorMsg = new ErrorMsg();

	/**
	 * DBから取得した会員情報のチェック処理を呼び出す
	 * @param loginData
	 * @param pass
	 * @return errorList
	 */
	public List<String> loginlogicCheck(MemberDTO loginData, String pass){
		errorList = errorMsg.errorMsgNullCheck(checkLoginSuccess(loginData, pass), errorList);
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
	 * DBから取得した会員情報のチェック処理を呼び出す
	 * @param loginData
	 * @param pass
	 * @return エラーメッセージ
	 */
	private String checkLoginSuccess(MemberDTO loginData, String pass) {

		if (Objects.isNull(loginData.getUser_mail()) || !(loginData.getUser_password().equals(pass))) {
			return errorMsg.returnErrorMsg(LOGIN_ERROR);
		}
		return null;
	}
}
