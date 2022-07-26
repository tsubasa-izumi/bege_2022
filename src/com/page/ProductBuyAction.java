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

		//getParameterを使って、商品選択購入画面から飛ばされた選択された個数の値を取得する
		int sum=0;

		String cabbageCount = req.getParameter("cabbageCount");
		String ChinesecCabbageCount = req.getParameter("ChinesecCabbageCount");
		String GinsengCount = req.getParameter("GinsengCount");
		String tomatoCount = req.getParameter("tomatoCount");


		String cabbageID = "1";
		String ChinesecCabbageID = "2";
		String GinsengID = "3";
		String tomatoID = "4";


		Connection con = dbutil.getConnection();
		ManagementDAO itemdao = new ManagementDAO(con);
		ManagementDTO dto0 = new ManagementDTO();
		ManagementDTO dto1= new ManagementDTO();
		ManagementDTO dto2 = new ManagementDTO();
		ManagementDTO dto3 = new ManagementDTO();

		List<ManagementDTO> buyDataList = new ArrayList<ManagementDTO>();

		//商品が一つも選択されなかった場合の処理



		try {
			itemdao.itemBuyUpdate(Integer.parseInt(cabbageID), Integer.parseInt(cabbageCount));
			itemdao.itemBuyUpdate(Integer.parseInt(ChinesecCabbageID), Integer.parseInt(ChinesecCabbageCount));
			itemdao.itemBuyUpdate(Integer.parseInt(GinsengID), Integer.parseInt(GinsengCount));
			itemdao.itemBuyUpdate(Integer.parseInt(tomatoID), Integer.parseInt(tomatoCount));
			//購入データ取得
			dto0 = itemdao.buyItem(Integer.parseInt(cabbageID));
			dto1 = itemdao.buyItem(Integer.parseInt(ChinesecCabbageID));
			dto2 = itemdao.buyItem(Integer.parseInt(GinsengID));
			dto3 = itemdao.buyItem(Integer.parseInt(tomatoID));

			buyDataList.add(dto0);
			buyDataList.add(dto1);
			buyDataList.add(dto2);
			buyDataList.add(dto3);
			//各購入データの金額×個数をセットする

			for(ManagementDTO data : buyDataList) {
				if(data.getItem_id() == Integer.parseInt(cabbageID)) {
					data.setItem_price(data.getItem_price() * Integer.parseInt(cabbageCount));
				}else if(data.getItem_id() == Integer.parseInt(ChinesecCabbageID)) {
					data.setItem_price(data.getItem_price() * Integer.parseInt(ChinesecCabbageCount));
				}else if(data.getItem_id() == Integer.parseInt(GinsengID)) {
					data.setItem_price(data.getItem_price() * Integer.parseInt(GinsengCount));
				}else if(data.getItem_id() == Integer.parseInt(tomatoID)) {
					data.setItem_price(data.getItem_price() * Integer.parseInt(tomatoCount));
				}
				sum+=data.getItem_price();
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

		req.setAttribute("quantity0", cabbageID);
		req.setAttribute("quantity1", ChinesecCabbageID);
		req.setAttribute("quantity2", GinsengID);
		req.setAttribute("quantity3", tomatoID);



		req.setAttribute("buyDataList", buyDataList);
		req.getRequestDispatcher("productCheck.jsp").forward(req, res);

	}
}
