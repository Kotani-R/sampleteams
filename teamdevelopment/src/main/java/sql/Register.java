package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {
	/****************************************
	  
	 新規会員登録で入力した情報をINSERTするメソッド
	 
	 *********************************************/
	public void insert(String id, String address, String pass) {
		System.out.println(id+address+pass);
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
			// データベースへの接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teamdevelopment", "postgres",
					"reizero9422");
			// SQL送信処理??????????
			Statement stmt = conn.createStatement();
			// 入力した情報をINSERT
			String sql = "INSERT INTO MEMBER (ID, ADDRESS,PASS) values (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// INSERT文中の「？」に使用する値を設定
			pStmt.setString(1, id);
			pStmt.setString(2, address);
			pStmt.setString(3, pass);

			int result = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース接続の切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("DB切断に失敗しました");
					e.printStackTrace();
				}
			}
		}
	}
}