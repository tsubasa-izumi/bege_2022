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

import dao.ManagementDAO;
import dto.ManagementDTO;
import src.util.dbutil;

public class ProductBuyAction extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//getParameterを使って、前の画面から飛ばされた値を取得する
		int sum=0;
		String idItem0 = req.getParameter("idItem0");
		String idItem1 = req.getParameter("idItem1");
		String idItem2 = req.getParameter("idItem2");
		String idItem3 = req.getParameter("idItem3");

		int buyminus0 = Integer.parseInt(req.getParameter("ItemCount0"));
		int buyminus1 = Integer.parseInt(req.getParameter("ItemCount1"));
		int buyminus2 = Integer.parseInt(req.getParameter("ItemCount2"));
		int buyminus3 = Integer.parseInt(req.getParameter("ItemCount3"));

		int[] buyminus = {buyminus0, buyminus1, buyminus2, buyminus3};


		Connection con = dbutil.getConnection();
		ManagementDAO itemdao = new ManagementDAO(con);
		ManagementDTO dto0 = new ManagementDTO();
		ManagementDTO dto1= new ManagementDTO();
		ManagementDTO dto2 = new ManagementDTO();
		ManagementDTO dto3 = new ManagementDTO();

		List<ManagementDTO> buyDataList = new ArrayList<ManagementDTO>();


		try {

			//在庫を減らす
			itemdao.itemBuyUpdate(Integer.parseInt(idItem0), buyminus[0]);
			itemdao.itemBuyUpdate(Integer.parseInt(idItem1), buyminus[1]);
			itemdao.itemBuyUpdate(Integer.parseInt(idItem2), buyminus[2]);
			itemdao.itemBuyUpdate(Integer.parseInt(idItem3), buyminus[3]);

			//購入データ取得
			dto0 = itemdao.buyItem(Integer.parseInt(idItem0));
			dto1 = itemdao.buyItem(Integer.parseInt(idItem1));
			dto2 = itemdao.buyItem(Integer.parseInt(idItem2));
			dto3 = itemdao.buyItem(Integer.parseInt(idItem3));

			buyDataList.add(dto0);
			buyDataList.add(dto1);
			buyDataList.add(dto2);
			buyDataList.add(dto3);



			//各購入データの金額×個数をセットする

			for(int i = 0 ; i < buyDataList.size(); i++) {
				buyDataList.get(i).setItem_price(buyDataList.get(i).getItem_price() * buyminus[i]);
				sum += buyDataList.get(i).getItem_price();
			}

		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Integer i = Integer.valueOf(sum);
		String totalsum = i.toString();
		//合計金額
		req.setAttribute("totalsum", totalsum);
		//
		req.setAttribute("dto0", dto0);
		req.setAttribute("dto1", dto1);
		req.setAttribute("dto2", dto2);
		req.setAttribute("dto3", dto3);

		req.setAttribute("quantity0", buyminus0);
		req.setAttribute("quantity1", buyminus1);
		req.setAttribute("quantity2", buyminus2);
		req.setAttribute("quantity3", buyminus3);

		req.setAttribute("buyDataList", buyDataList);
		req.getRequestDispatcher("productCheck.jsp").forward(req, res);

	}
}
