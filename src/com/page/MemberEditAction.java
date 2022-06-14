package com.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberEditAction extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws
	ServletException,IOException {

	req.setCharacterEncoding("UTF-8");

 String user_id = req.getParameter("user_id");
 String user_name = req.getParameter("user_name");
 String user_kana = req.getParameter("user_kana");
 String tel_number = req.getParameter("tel_number");
 String user_mail = req.getParameter("user_mail");
 String user_password = req.getParameter("user_password");
 String question = req.getParameter("question");
 String answer = req.getParameter("ansewer");
 String address = req.getParameter("address");
 String prefecture = req.getParameter("prefecture");
 String city = req.getParameter("city");
 String housenumber = req.getParameter("housenumber");
 Integer.parseInt(req.getParameter("card_limit"));
 Integer.parseInt(req.getParameter("user_code"));
 String user_meigi = req.getParameter("user_meigi");




 req.setAttribute("user_id", "user_id");
 req.setAttribute("user_name", "user_name");
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
 req.setAttribute("user_meigi ","user_meigi");




	}
}