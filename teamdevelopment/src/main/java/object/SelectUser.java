package object;

import java.util.List;

import sql.samplesDAO;

public class SelectUser {
	public List<userList> execute() {
		// DAOをインスタンス化
		samplesDAO samDAO = new samplesDAO();
		// リストに挿入
		List<userList> userlist = samDAO.findAll();
		// リストを返す
		return userlist;
			
	}
}

