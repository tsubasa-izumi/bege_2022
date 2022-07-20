package logicCheck;

import static commonprocess.errormessage.ErrorIDConstants.*;

import java.util.ArrayList;
import java.util.List;

import commonprocess.errormessage.ErrorMsg;
import dto.MemberDTO;

public class LoginLogicCheck {
	List<String> errorList = new ArrayList<String>();
	ErrorMsg errorMsg = new ErrorMsg();

	public List<String> loginlogicCheck(MemberDTO loginData, String mail, String pass){
		errorList = errorMsg.errorMsgNullCheck(checkLoginSuccess(loginData,mail,pass), errorList);
		return errorList;
	}

	public List<String> unExpectedError() {
		errorList = errorMsg.errorMsgNullCheck(errorMsg.returnErrorMsg(ERROR), errorList);
		return errorList;
	}

	private String checkLoginSuccess(MemberDTO loginData, String mail, String pass) {
		// 入力値がDB内の情報と一致しなかった場合、エラーメッセージを返す
		if (!(loginData.getUser_mail().equals(mail) && loginData.getUser_password().equals(pass))) {
			return errorMsg.returnErrorMsg(LOGIN_ERROR);
		}
		return null;
	}
}
