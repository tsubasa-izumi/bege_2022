package com.page;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ManagementDTO;
import dto.MemberDTO;
import logicCheck.LoginLogicCheck;
import service.LoginService;
import service.ManagementService;
public class LoginAction extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String mail = req.getParameter("mail_address");
		String pass = req.getParameter("pass");

		List<ManagementDTO> maneList = new ArrayList<>();
		LoginService loginService = new LoginService();
		LoginLogicCheck loginLogicCheck = new LoginLogicCheck();
		MemberDTO loginData = new MemberDTO();
		ManagementService managementService = new ManagementService();
		List<String> errorList;

		try {
			loginData = loginService.loginService(mail);
			errorList = loginLogicCheck.loginlogicCheck(loginData, mail, pass);
			//errorListにエラーメッセージが格納されている場合、入力値とエラーメッセージをリクエストスコープにセットしてログイン画面に遷移する。
			if(!(errorList == null || errorList.size() == 0)) {
				req.setAttribute("error", errorList);
				req.setAttribute("mail_address", mail);
				req.setAttribute("pass", pass);
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
			maneList = managementService.managementService();
		//例外発生時の処理
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			errorList = loginLogicCheck.unExpectedError();
			req.setAttribute("error", errorList);
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
		//セッションに商品情報とログイン情報をセットして商品選択・購入画面に遷移する。
		session.setAttribute("maneList", maneList);
		session.setAttribute("loginData", loginData);
		req.getRequestDispatcher("productSelect.jsp").forward(req, res);
	}
}