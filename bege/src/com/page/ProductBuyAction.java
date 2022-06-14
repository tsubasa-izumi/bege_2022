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

		String buyminus0 = req.getParameter("ItemCount0");
		String buyminus1 = req.getParameter("ItemCount1");
		String buyminus2 = req.getParameter("ItemCount2");
		String buyminus3 = req.getParameter("ItemCount3");

		System.out.println("ここから値渡しの確認");
		System.out.println(idItem0);
		System.out.println(idItem1);
		System.out.println(idItem2);
		System.out.println(idItem3);
		System.out.println(buyminus0);
		System.out.println(buyminus1);
		System.out.println(buyminus2);
		System.out.println(buyminus3);

		Connection con = dbutil.getConnection();
		ManagementDAO itemdao = new ManagementDAO(con);
		ManagementDTO dto0 = new ManagementDTO();
		ManagementDTO dto1= new ManagementDTO();
		ManagementDTO dto2 = new ManagementDTO();
		ManagementDTO dto3 = new ManagementDTO();

		List<ManagementDTO> buyDataList = new ArrayList<ManagementDTO>();



		try {
			itemdao.itemBuyUpdate(Integer.parseInt(idItem0), Integer.parseInt(buyminus0));
			itemdao.itemBuyUpdate(Integer.parseInt(idItem1), Integer.parseInt(buyminus1));
			itemdao.itemBuyUpdate(Integer.parseInt(idItem2), Integer.parseInt(buyminus2));
			itemdao.itemBuyUpdate(Integer.parseInt(idItem3), Integer.parseInt(buyminus3));
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

			for(ManagementDTO data : buyDataList) {
				if(data.getItem_id() == Integer.parseInt(idItem0)) {
					data.setItem_price(data.getItem_price() * Integer.parseInt(buyminus0));
				}else if(data.getItem_id() == Integer.parseInt(idItem1)) {
					data.setItem_price(data.getItem_price() * Integer.parseInt(buyminus1));
				}else if(data.getItem_id() == Integer.parseInt(idItem2)) {
					data.setItem_price(data.getItem_price() * Integer.parseInt(buyminus2));
				}else if(data.getItem_id() == Integer.parseInt(idItem3)) {
					data.setItem_price(data.getItem_price() * Integer.parseInt(buyminus3));
				}
				sum+=data.getItem_price();
			}


			//itemdao.itemBuyUpdate(Integer.parseInt(idItem0),Integer.parseInt(idItem1), Integer.parseInt(idItem2), Integer.parseInt(idItem3),Integer.parseInt(buyminus0),Integer.parseInt(buyminus1),Integer.parseInt(buyminus2),Integer.parseInt(buyminus3));
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
