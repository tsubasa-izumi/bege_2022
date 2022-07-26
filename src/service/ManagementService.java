package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ManagementDAO;
import dto.ManagementDTO;
import src.util.dbutil;

public class ManagementService {
	public List<ManagementDTO> managementService () {
		Connection con = dbutil.getConnection();
		ManagementDAO manedao = new ManagementDAO(con);
		List<ManagementDTO> maneList = new ArrayList<>();

		try {
			maneList = manedao.selectItem();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return maneList;
	}

}
