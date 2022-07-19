package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDAO;
import dto.MemberDTO;
import src.util.dbutil;

public class LoginService {
	/**
	 * メールアドレスを引数に会員情報を取得DAOを呼び出す
	 */
	public MemberDTO loginService (String mail) {
		Connection con = dbutil.getConnection();
		MemberDAO memdao = new MemberDAO(con);
		MemberDTO loginData = new MemberDTO();

		try {
			loginData = memdao.select(mail);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return loginData;
	}
}
