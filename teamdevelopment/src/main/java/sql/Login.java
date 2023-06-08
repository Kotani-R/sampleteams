package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.UserAccount;

public class Login {
	/****************************************
	  
	ログイン画面で入力した情報をDBのid,passと照会するメソッド
	 
	 *********************************************/

	// 戻り値をbooleanからAllayListに変更予定!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public boolean login(String id, String pass) {
		// 検索結果格納のため、Beanクラスをインスタンス
		UserAccount resultUserInfo = new UserAccount(id, pass);
		// 複数のユーザ情報を格納するため、Beanを格納する配列を作成
		ArrayList<UserAccount> array_userinfo = new ArrayList<UserAccount>();

		// JDBCドライバの読み込み
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		Connection conn = null;
		boolean user_list = true;
		// 接続
		try {
			// データベースへの接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampleteams", "postgres",
					"reizero9422");

			String sql = "SELECT id FROM member WHERE id=? AND pass=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// 入力されたユーザーIDとパスワードをSQLの条件にする
			pstmt.setString(1, resultUserInfo.getId());
			pstmt.setString(2, resultUserInfo.getPass());

			// SELECTの実行。結果表を取得
			ResultSet res = pstmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーが存在した時
			if (res.next()) {
				System.out.println("ユーザーIDとパスワードが一致するユーザーが存在しました");
				user_list = true;
			} else {
				System.out.println("ユーザーIDとパスワードが一致するユーザーが存在しませんでした");
				user_list = false;
			}

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
		return user_list;
	}
}