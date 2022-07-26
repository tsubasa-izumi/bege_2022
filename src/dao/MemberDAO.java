package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;
import src.util.dbutil;
public class MemberDAO {
	private static final String USER_ID = "user_id";
	private static final String USER_NM = "user_name";
	private static final String USER_KN = "user_kana";
	private static final String USER_TEL = "tel_number";
	private static final String MAILADDRESS = "user_mail";
	private static final String PASSWORD = "user_password";
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";
	private static final String USER_ADDRESS = "user_address";
	private static final String USER_PREFECTURE = "user_prefecture";
	private static final String USER_CITY = "user_city";
	private static final String USER_HOUSENUMBER = "user_housenumber";
	private static final String USER_CARDNUMBER = "user_cardnumber";
	private static final String CARD_CODE = "user_code";
	private static final String CARD_LIMIT = "card_limit";
	private static final String CARD_NAME = "user_meigi";
	private static final String TBL_NAME = "member";
	/** DBコネクション */
	public Connection con;
	/** DBステートメント */
	PreparedStatement stmt;
	/** 検索結果 */
	ResultSet rs;
	int result;
	public MemberDAO(Connection con) {
		this.con = con;
	}
	public List<MemberDTO> selectAll() throws SQLException, ClassNotFoundException {
		List<MemberDTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();//全検索（クレカ情報、パスワード、秘密の質問は除く）
		sql.append(" SELECT ");
		sql.append("      user_id");
		sql.append("      user_name");
		sql.append("      user_kana");
		sql.append("      tel_number");
		sql.append("      user_mail");
		sql.append("      user_address");
		sql.append("      user_prefecture");
		sql.append("      user_city");
		sql.append("      user_housenumber");
		sql.append(" FROM ");
		sql.append("    " + TBL_NAME);
		try {
			this.stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			System.out.println(stmt);
			while (rs.next()) {
				MemberDTO mem = new MemberDTO();
				mem.setUser_id(rs.getInt(USER_ID));
				mem.setUser_name(rs.getString(USER_NM));
				mem.setUser_kana(rs.getString(USER_KN));
				mem.setTel_number(rs.getString(USER_TEL));
				mem.setUser_mail(rs.getString(MAILADDRESS));
				mem.setUser_address(rs.getString(USER_ADDRESS));
				mem.setUser_prefecture(rs.getString(USER_PREFECTURE));
				mem.setUser_city(rs.getString(USER_CITY));
				mem.setHousenumber(rs.getString(USER_HOUSENUMBER));
				rtnList.add(mem);
			}
		} finally {
			dbutil.closeStatement(this.stmt);
		}
		return rtnList;
	}
	public MemberDTO select(String mail) throws SQLException, ClassNotFoundException {
		MemberDTO rtnList = new MemberDTO();//ログインで使う
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("user_id, ");
		sql.append("uesr_mail, ");
		sql.append("user_password");
		sql.append(" FROM ");
		sql.append("    " + TBL_NAME);
		sql.append(" WHERE uesr_mail = ? ");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, mail);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				rtnList.setUser_id(rs.getInt(USER_ID));
				rtnList.setUser_mail(rs.getString(MAILADDRESS));
				rtnList.setUser_password(rs.getString(PASSWORD));
			}
		} finally {
			dbutil.closeStatement(this.stmt);
		}
		return rtnList;
	}


	public void mbrInsert(String name, String kana, String telnumber, String mail, String password,
			String ques,
			String ans, String address, String prefecture, String city, String housenumber, String cardnumber,
			int code, int cardlimit, String meigi) throws SQLException {
		//会員登録 //スペル変更済み
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT");
		sql.append(" INTO ");
		sql.append(TBL_NAME);
		sql.append( "(" + "user_name" + "," + "user_kana" + "," + "uesr_mail" + "," + "tel_number" + ","
				+ "user_password" + "," +" question"
				+ "," + "answer" + "," +"user_cardnumber"+ "," +"user_meigi"+ "," +"card_limit"+ "," + "user_code"
				+ "," + "user_address" + "," + "user_prefecture" + "," + "uesr_city" + ","
				+"user_housenumber" + ")");
		sql.append(" VALUES " + "('" + name + "','" + kana + "','" + mail + "','" + telnumber + "','"
				+ password + "','" + ques
				+ "','" + ans + "','" + cardnumber + "','" + meigi + "'," + cardlimit + "," + code
				+ ",'" + address + "','" + prefecture + "','" + city + "','"
				+ housenumber + "');");
		try {
			this.stmt = con.prepareStatement(sql.toString());
			result = stmt.executeUpdate();
		} finally {
			dbutil.closeStatement(this.stmt);
		}
	}

	public void memUpdate(String name, String knname, String tel, String mail, String pass, String question,
			String answer, String address, String prefecture, String city, String housenum, String code, int limit,
			String meigi) throws SQLException, ClassNotFoundException {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE ");
		sql.append(TBL_NAME);
		sql.append(" SET ");
		sql.append(USER_NM + "='" + name + "'," + USER_KN + "='" + knname + "'," + USER_TEL + "='" + tel + MAILADDRESS
				+ "='" + mail + "'," + PASSWORD + "='" + pass + "'," + QUESTION + "='" + question + "'," + ANSWER + "='"
				+ answer + "'," + USER_ADDRESS + "='" + address + "'," + USER_PREFECTURE + "='" + prefecture + "',"
				+ USER_CITY + "='" + city + "'," + USER_HOUSENUMBER + "='" + housenum + "'," + CARD_CODE + "='" + code
				+ "'," + CARD_LIMIT + "='" + limit + "'," + CARD_NAME + "='" + meigi + "'");
		sql.append(" WHERE " + MAILADDRESS + "=" + mail + ";");
		try {
			System.out.println(sql);
			this.stmt = con.prepareStatement(sql.toString());
			result = stmt.executeUpdate();
		} finally {
			dbutil.closeStatement(this.stmt);
		}
	}
	public List<MemberDTO> selectQ() throws SQLException, ClassNotFoundException {
		List<MemberDTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();//全検索（クレカ情報、パスワード、秘密の質問は除く）
		sql.append(" SELECT ");
		sql.append("      question");
		sql.append("      answer");
		sql.append(" FROM ");
		sql.append("    " + TBL_NAME);
		try {
			this.stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			System.out.println(stmt);
			while (rs.next()) {
				MemberDTO mem = new MemberDTO();
				mem.setQuestion(rs.getString(QUESTION));
				mem.setAnswer(rs.getString(ANSWER));
				rtnList.add(mem);
			}
		} finally {
			dbutil.closeStatement(this.stmt);
		}
		return rtnList;
	}
	public List<MemberDTO> selectPass() throws SQLException, ClassNotFoundException {
		List<MemberDTO> rtnList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();//全検索（クレカ情報、パスワード、秘密の質問は除く）
		sql.append(" SELECT ");
		sql.append("      user_password");
		sql.append(" FROM ");
		sql.append("    " + TBL_NAME);
		try {
			this.stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			System.out.println(stmt);
			while (rs.next()) {
				MemberDTO mem = new MemberDTO();
				mem.setUser_password(rs.getString(PASSWORD));
				rtnList.add(mem);
			}
		} finally {
			dbutil.closeStatement(this.stmt);
		}
		return rtnList;
	}
}

