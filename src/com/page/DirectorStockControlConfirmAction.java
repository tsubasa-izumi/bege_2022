package com.page;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DirectorStockControlConfirmAction extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws
	ServletException,IOException {

	req.setCharacterEncoding("UTF-8");


	Integer.parseInt(req.getParameter("item_id"));
	String item_name = req.getParameter("item_name");
	Integer.parseInt(req.getParameter("item_price"));
	Integer.parseInt(req.getParameter("farmer_id"));


	req.setAttribute("item_id", "item_id");
	req.setAttribute("item_name", "item_name");
	req.setAttribute("item_price", "item_price");
	req.setAttribute("user_id", "user_id");
	req.setAttribute("farmer_id", "farmer_id");
	}
}
