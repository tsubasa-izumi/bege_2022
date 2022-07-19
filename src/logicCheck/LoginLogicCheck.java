package logicCheck;

import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

public class LoginLogicCheck {
	List<String> errorList = new ArrayList<String>();

	public List<String> loginlogicCheck(MemberDTO loginData, String mail, String pass){
		//errorList = errorMsg.errorMsgNullCheck(checkLoginSuccess(loginData,mail,pass), errorList);
		return errorList;
	}

	public List<String> unExpectedError() {
		//errorList = errorMsg.errorMsgNullCheck(errorMsg.returnErrorMsg(CommonConstants.), errorList);
		return errorList;
	}

	private String checkLoginSuccess(MemberDTO loginData, String mail, String pass) {
		// 入力値がDB内の情報と一致しなかった場合、エラーメッセージを返す
		if (!(loginData.getUser_mail().equals(mail) && loginData.getUser_password().equals(pass))) {
			//return errorMsg.returnErrorMsg(CommonConstants.);
		}
		return null;
	}


}
