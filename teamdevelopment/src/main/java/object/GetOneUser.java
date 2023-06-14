package object;

import java.util.List;

import sql.samplesDAO;

public class GetOneUser {
	public List<userList> execute() {
		// DAOを呼び出す
		samplesDAO samDAO = new samplesDAO();
		// データベースのインスタンスをリストに挿入
		List<userList> userlist = samDAO.findUser();
		// リストを返す
		return userlist;
			
	}

}
