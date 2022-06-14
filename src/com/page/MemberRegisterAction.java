package com.page;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import src.util.dbutil;

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
		System.out.println("値が入っているか確認～～～");
		System.out.println(ques);
		System.out.println(address);
		System.out.println("ここまで");
		/*System.out.println(name);
		System.out.println(kana);
		System.out.println(telnumber);*/
		Connection con = dbutil.getConnection();
		MemberDAO daoinsert = new MemberDAO(con);
		try {
			daoinsert.mbrInsert(name, kana, telnumber, mail, password, ques, ans, address,
					prefecture, cardnumber, city, housenumber, Integer.parseInt(code),
					Integer.parseInt(cardlimit), meigi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<>();
		list.add(name);
		list.add(kana);
		list.add(telnumber);
		list.add(mail);
		list.add(password);
		list.add(ques);
		list.add(ans);
		list.add(address);
		list.add(prefecture);
		list.add(cardnumber);
		list.add(city);
		list.add(housenumber);
		list.add(code);
		list.add(cardlimit);
		list.add(meigi);
		req.setAttribute("list", list);
		/* req.setAttribute("user_name", "user_name");
		 req.setAttribute("user_kana", "user_kana");
		 req.setAttribute("tel_number ", "tel_number");
		 req.setAttribute("user_mail", "user_mail");
		 req.setAttribute("user_password", "user_password");
		 req.setAttribute("answer","answer");
		 req.setAttribute("question","question");
		 req.setAttribute("address", "address");
		 req.setAttribute("prefecture", "prefecture");
		 req.setAttribute("city", "city");
		 req.setAttribute(" housenumber ", "housenumber");
		 req.setAttribute("card_limit","card_limit");
		 req.setAttribute("user_code","user_code");
		 req.setAttribute("user_meigi ","user_meigi");*/

		req.getRequestDispatcher("confirm.jsp").forward(req, res);
	}
}
