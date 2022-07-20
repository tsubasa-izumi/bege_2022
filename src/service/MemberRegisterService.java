package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDAO;
import src.util.dbutil;

public class MemberRegisterService {
	public void memberRegisterService(String name, String kana, String telnumber, String mail, String password,
			String ques, String ans, String address,
			String prefecture, String cardnumber, String city, String housenumber, String code,
			String cardlimit, String meigi) {
		Connection con = dbutil.getConnection();
		MemberDAO daoinsert = new MemberDAO(con);
		try {
			daoinsert.mbrInsert(name, kana, telnumber, mail, password, ques, ans, address,
					prefecture, cardnumber, city, housenumber, Integer.parseInt(code),
					Integer.parseInt(cardlimit), meigi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
