package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.ListAccount;

public class ListView {
	//単体テスト用
	//public static void main(String[] args) {
	/****************************************
	  
	一覧画面に表示するIDと名前をSELECTするメソッド
	 
	 *********************************************/
	public List<ListAccount> findAll() {
		// ユーザー情報格納するためのインスタンス
		ArrayList<ListAccount> accList = new ArrayList<>();

		// JDBCドライバの読み込み
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		Connection conn = null;

		// 接続
		try {
			// データベースへの接続(竹田さんのDBに接続する!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!)
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampleteams", "postgres",
					"reizero9422");

			String sql = "SELECT ID,NAME FROM member ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// SELECTの実行。結果表を取得
			ResultSet res = pstmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// listAccountに設定し、AllayListインスタンスに追加
			while (res.next()) {
				String id = res.getString("ID");
				String name = res.getString("NAME");
				// 取得した値をListAccountインスタンスに格納する
				ListAccount listAccount = new ListAccount(id, name);
				accList.add(listAccount);
			}
			// 単体テスト用あとで消す!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			//for (ListAccount acc : accList) {
			//System.out.println(acc.getId());
			//System.out.println(acc.getName());
			//}

		} catch (SQLException sql_e) {
			// エラーハンドリング
			System.out.println("sql実行失敗");
			sql_e.printStackTrace();

		} finally {
			// データベース接続の切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// リストを返す
		return accList;
	}
}