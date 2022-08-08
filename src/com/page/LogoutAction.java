package com.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		//セッション情報を破棄
		session.invalidate();

		// ログアウト画面に遷移する。
		req.getRequestDispatcher("logOut.jsp").forward(req, res);
	}
}
