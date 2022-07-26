package com.page;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logicCheck.MemberRegisterLogicCheck;
import service.MemberRegisterService;

public class MemberRegisterAction extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String kana = req.getParameter("kana");
		String telnumber = req.getParameter("telnumber");
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		String ques = req.getParameter("ques");
		String ans = req.getParameter("ans");
		String address = req.getParameter("address");
		String prefecture = req.getParameter("prefecture");
		String cardnumber = req.getParameter("cardnumber");
		String city = req.getParameter("city");
		String housenumber = req.getParameter("housenumber");
		String code = req.getParameter("code");
		String cardlimit = req.getParameter("cardlimit");
		String meigi = req.getParameter("meigi");
		MemberRegisterService memberRegisterService = new MemberRegisterService();
		MemberRegisterLogicCheck memberRegisterLogicCheck = new MemberRegisterLogicCheck();
		List<String> errorList;

		try {
			errorList = memberRegisterLogicCheck.memberRegisterLogicCheck(name, kana, telnumber, mail, password, ques,
					ans, address, prefecture, city, housenumber, cardnumber,  code, cardlimit, meigi);
			if(!(errorList == null || errorList.size() == 0)) {
				req.setAttribute("error", errorList);
				req.getRequestDispatcher("memberRegister.jsp").forward(req, res);
			}
			memberRegisterService.memberRegisterService(name, kana, telnumber, mail, password, ques, ans, address,
					prefecture, city, housenumber, cardnumber, code, cardlimit, meigi);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			errorList = memberRegisterLogicCheck.unExpectedError();
			req.setAttribute("error", errorList);
			req.getRequestDispatcher("memberRegister.jsp").forward(req, res);
		}
		req.getRequestDispatcher("confirm.jsp").forward(req, res);
	}
}
