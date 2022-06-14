package com.page;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagementDAO;
import dao.MemberDAO;
import dto.ManagementDTO;
import dto.MemberDTO;
import src.util.dbutil;
public class LoginAction extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String mail = req.getParameter("mail_address");
		String pass = req.getParameter("pass");

		System.out.println(mail);
		System.out.println(pass);

		Connection con = dbutil.getConnection();

		ManagementDAO manedao = new ManagementDAO(con);
		List<ManagementDTO> maneList = new ArrayList<>();

		MemberDAO memdao = new MemberDAO(con);
		MemberDTO loginData = new MemberDTO();

		//DAOのメソッド　引数
		try {
			maneList =manedao.selectItem();

			loginData = memdao.select(mail);

			System.out.println(loginData);
			if (loginData.getUser_id() == 0) {
			req.setAttribute("error", "メールアドレスまたはパスワードが間違っています");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
		} catch (ClassNotFoundException | SQLException e) {

			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//loginData.get(0); //mail
		//loginData.get(1); //password
		session.setAttribute("maneList", maneList);
		session.setAttribute("loginData", loginData);
		req.setAttribute("user_mail", mail);
		req.setAttribute("user_password", pass);//ここsession
		System.out.println(mail);
		System.out.println(pass);
		req.getRequestDispatcher("productSelect.jsp").forward(req, res);
	}
}