package src.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbutil {

	// 定数定義（共通）
	private static final String DB_HOST = "127.0.0.1";
	private static final String DB_NAME = "rezodb";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";

	// 定数定義（PostgreSQL用）
	// private static final String DBMS = "postgresql";
	// private static final String DB_DRIVER = "org." + DBMS + ".Driver";
	// private static final String DB_PORT = "5432";
	// private static final String DB_URL = "jdbc:" + DBMS + "://" + DB_HOST +
	// ":" + DB_PORT + "/" + DB_NAME;

	// 定数定義（MySQL用）
	private static final String DBMS = "mysql";
	private static final String DB_DRIVER = "com." + DBMS + ".cj.jdbc.Driver";
	private static final String DB_PORT = "3306";
	private static final String DB_URL = "jdbc:" + DBMS + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
	//		+ "?serverTimezone=JST";	//JDBCドライバのバージョン8.0.22以前を利用する場合は必要

	// インスタンス化の禁止
	// Connectionを単一のインスタンスとする
	private dbutil() {
	}

	private static Connection con;

	/*
	 * TODO 以下の仕様でメソッドを作成してください。
	 *
	 * 戻り値		：Connection
	 * メソッド名	：getConnection
	 * 引数			：なし
	 * 例外			：ClassNotFoundException, SQLException
	 * 処理			：JDBCドライバを読み込み後、DB接続する。
	 * 				  生成されたConnectionを返却する
	 * 				  ※Connection生成には上記の定数を活用してください
	 */
	public static Connection getConnection() {

		try {
			Class.forName(DB_DRIVER);
			 con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


		return con;
	}

	/*
	 * TODO 以下の仕様でメソッドを作成してください。
	 *
	 * 戻り値		：なし
	 * メソッド名	：closeStatement
	 * 引数			：DBステートメント(PreparedStatement型)
	 * 例外			：SQLException
	 * 処理			：引数のDBステートメントがnullでない場合、そのDBステートメントをクローズする
	 */
	public static void closeStatement(PreparedStatement stmt) {

		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/*
	 * TODO 以下の仕様でメソッドを作成してください。
	 *
	 * 戻り値		：なし
	 * メソッド名	：closeConnection()
	 * 引数			：切断するコネクション(Connection型)
	 * 例外			：SQLException
	 * 処理			：引数のコネクションがnullでない場合、そのコネクションを切断する
	 */
	public static void closeConnection(Connection con) {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
