package com.page;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BuyHistoryDAO;
import src.util.dbutil;

@WebServlet(urlPatterns = { "/ProductConfirmAction" })
public class ProductConfirmAction extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
	req.setCharacterEncoding("UTF-8");

	//getParameterを使って、前の画面から飛ばされた値を取得する



	String itemId0 = req.getParameter("itemId0");
	String totalPrice0 = req.getParameter("total_price0");
	String quantity0 = req.getParameter("quantity0");

	String itemId1 = req.getParameter("itemId1");
	String totalPrice1 = req.getParameter("total_price1");
	String quantity1 = req.getParameter("quantity1");

	String itemId2 = req.getParameter("itemId2");
	String totalPrice2 = req.getParameter("total_price2");
	String quantity2 = req.getParameter("quantity2");

	String itemId3 = req.getParameter("itemId3");
	String totalPrice3 = req.getParameter("total_price3");
	String quantity3 = req.getParameter("quantity3");

	String userId=req.getParameter("user_id");



	Connection con=dbutil.getConnection();
	BuyHistoryDAO buydao=new BuyHistoryDAO(con);

	try {
		buydao.BuyHistoryInsert(Integer.parseInt(itemId0), Integer.parseInt(totalPrice0), Integer.parseInt(quantity0),Integer.parseInt(userId ));
		buydao.BuyHistoryInsert(Integer.parseInt(itemId1), Integer.parseInt(totalPrice1), Integer.parseInt(quantity1),Integer.parseInt(userId ));
		buydao.BuyHistoryInsert(Integer.parseInt(itemId2), Integer.parseInt(totalPrice2), Integer.parseInt(quantity2),Integer.parseInt(userId ));
		buydao.BuyHistoryInsert(Integer.parseInt(itemId3), Integer.parseInt(totalPrice3), Integer.parseInt(quantity3),Integer.parseInt(userId ));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}

		//次の遷移先を指定
		req.getRequestDispatcher("productConfirm.jsp").forward(req, res);
		}
	}

