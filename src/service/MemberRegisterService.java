package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDAO;
import src.util.dbutil;

public class MemberRegisterService {
	public void memberRegisterService(String name, String kana, String telnumber, String mail, String password,
			String ques, String ans, String address,
			String prefecture, String city, String housenumber, String cardnumber, String code,
			String cardlimit, String meigi) {
		Connection con = dbutil.getConnection();
		MemberDAO daoinsert = new MemberDAO(con);
		try {
			daoinsert.mbrInsert(name, kana, telnumber, mail, password, ques, ans, address,
					prefecture, city, housenumber, cardnumber, Integer.parseInt(code),
					Integer.parseInt(cardlimit), meigi);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
