package commonprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.util.dbutil;

public class CheckDuplicateDAO {

	/** DBコネクション */
	public Connection con;
	/** DBステートメント */
	PreparedStatement stmt;
	/** 検索結果 */
	ResultSet rs;

	int result;

	public CheckDuplicateDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 検索処理を実行し、テーブル内のデータに重複がないか確認する。戻り値として検索結果の件数を返す。
	 *
	 * @param inputData
	 * @param tableName
	 * @param columnName
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int checkDuplicate(String inputData, String tableName, String columnName)
			throws SQLException, ClassNotFoundException {
		int targetNum = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT");
		sql.append("(" + columnName + ")");
		sql.append("  FROM ");
		sql.append(" (SELECT " + columnName + " FROM ");
		sql.append(tableName);
		sql.append(" WHERE ");
		sql.append(columnName + "= ? )");
		sql.append("AS " + columnName);
		try {

			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, inputData);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				targetNum = rs.getInt("COUNT(" + columnName + ")");

			}
		} finally {
			dbutil.closeStatement(this.stmt);
		}
		return targetNum;
	}
}
