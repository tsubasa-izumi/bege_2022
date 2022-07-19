package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ManagementDTO;
import src.util.dbutil;

public class ManagementDAO {

	private static final String ITEM_ID = "item_id";
	private static final String ITEM_NAME = "item_name";
	private static final String ITEM_STOCK = "item_stock";
	private static final String ITEM_PRICE = "item_price";
	private static final String FARMER_ID = "farmer_id";
	private static final String FARMER_NAME = "farmer_name";
	private static final String TBL_NAME = "management";

	/** DBコネクション */
	public Connection con;
	/** DBステートメント */
	PreparedStatement stmt;
	/** 検索結果 */
	ResultSet rs;

	int result;

	public ManagementDAO(Connection con) {
		this.con = con;
	}

	public List<ManagementDTO> selectItem() throws SQLException, ClassNotFoundException {
		List<ManagementDTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       m.item_id");
		sql.append("      ,m.item_name");
		sql.append("      ,m.item_price");
		sql.append("      ,m.item_stock");
		sql.append("      ,m.farmer_id");
		sql.append("      ,f.farmer_name");
		sql.append(" FROM ");
		sql.append("     management m INNER JOIN farmer f");
		sql.append("         ON m.farmer_id = f.farmer_id");
		try {

			this.stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ManagementDTO mgt = new ManagementDTO();

				mgt.setItem_id(rs.getInt(ITEM_ID));
				mgt.setItem_name(rs.getString(ITEM_NAME));
				mgt.setItem_price(rs.getInt(ITEM_PRICE));
				mgt.setItem_stock(rs.getInt(ITEM_STOCK));
				mgt.setFarmer_id(rs.getInt(FARMER_ID));
				mgt.setFarmer_name(rs.getString(FARMER_NAME));



				rtnList.add(mgt);

			}
		} finally {
			dbutil.closeStatement(this.stmt);
		}
		return rtnList;
	}

	public void itemBuyUpdate(int idItem,int buyminus) throws SQLException, ClassNotFoundException {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE ");
		sql.append(TBL_NAME);
		sql.append(" SET ");
		sql.append(ITEM_STOCK + "=" + ITEM_STOCK + "-" + buyminus);
		sql.append(" WHERE " + ITEM_ID + "=" + idItem + ";");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			result = stmt.executeUpdate();


		} finally {
			dbutil.closeStatement(this.stmt);
		}

	}
	public ManagementDTO buyItem(int idItem) throws SQLException, ClassNotFoundException {
		ManagementDTO buyData = new ManagementDTO();

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       m.item_id");
		sql.append("      ,m.item_name");
		sql.append("      ,m.item_price");
		sql.append("      ,f.farmer_name");
		sql.append(" FROM ");
		sql.append("     management m INNER JOIN farmer f");
		sql.append("         ON m.farmer_id = f.farmer_id");
		sql.append(" WHERE " + "m." + ITEM_ID + "=" + idItem + ";");
		System.out.println(sql);
		try {

			this.stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				buyData.setItem_id(rs.getInt(ITEM_ID));
				buyData.setItem_name(rs.getString(ITEM_NAME));
				buyData.setItem_price(rs.getInt(ITEM_PRICE));
				buyData.setFarmer_name(rs.getString(FARMER_NAME));


			}
		} finally {
			dbutil.closeStatement(this.stmt);
		}
		return buyData;
	}

}
