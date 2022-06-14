package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BuyHistoryDTO;
import src.util.dbutil;

public class BuyHistoryDAO {

	private static final String BUY_ID = "buy_id";
	private static final String ITEM_ID = "item_id";
	private static final String ITEM_NM = "item_name";
	private static final String TOTAL_PRICE = "total_price";
	private static final String QUANTITY = "quantity";
	private static final String FARMER_ID = "farmer_id";
	private static final String DATE = "buy_date";
	private static final String USER_ID = "user_id";
	private static final String USER_NM = "user_name";
	private static final String TBL_NAME = "buyhistory";

	/** DBコネクション */
	public Connection con;
	/** DBステートメント */
	PreparedStatement stmt;
	/** 検索結果 */
	ResultSet rs;

	public BuyHistoryDAO(Connection con) {
		this.con = con;
	}

	public void BuyHistoryInsert(int itemId,int total_price,int quantity,int user_id) throws SQLException, ClassNotFoundException {





		StringBuilder sql = new StringBuilder();
		sql.append("INSERT");
		sql.append(" INTO ");
		sql.append(TBL_NAME);

		sql.append(" ( ");
		sql.append(ITEM_ID + ",");
		sql.append(TOTAL_PRICE + ",");
		sql.append(QUANTITY + ",");
		sql.append(FARMER_ID + ",");
		sql.append(DATE + ",");
		sql.append(USER_ID);
		sql.append(" ) ");
		sql.append(" VALUES " + "(" + itemId + "," + total_price + "," + quantity + ", 1 , now() ," + user_id + ");");



		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.executeUpdate();

		} finally {
			dbutil.closeStatement(this.stmt);
		}

	}

	public List<BuyHistoryDTO> selectItemBuy(int buy_id) throws SQLException, ClassNotFoundException {
		List<BuyHistoryDTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       m.item_name");
		sql.append("    history  ,b.quantity");
		sql.append("      ,b.total_price");
		sql.append(" FROM ");
		sql.append("     buyhistory b INNER JOIN management m");
		sql.append("         ON b.item_id = m.item_id");
		sql.append(" WHERE buy_id = ? ");
		System.out.println(sql);
		try {

			this.stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, buy_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				BuyHistoryDTO bh = new BuyHistoryDTO();

				bh.setItem_name(rs.getString(ITEM_NM));
				bh.setQuantity(rs.getInt(QUANTITY));
				bh.setTotal_price(rs.getInt(TOTAL_PRICE));

				rtnList.add(bh);

			}
		} finally {
			dbutil.closeStatement(this.stmt);
		}
		return rtnList;
	}

}
