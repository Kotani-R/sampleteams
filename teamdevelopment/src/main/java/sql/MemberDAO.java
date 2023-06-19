package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.ListAccount;
import object.LoginAccount;

public class MemberDAO {
	/****************************************
	  
	 新規会員登録で入力した情報をINSERTするメソッド
	 
	 *********************************************/
	public void insert(String id, String address, String pass) {
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
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampleteams", "postgres",
					"reizero9422");
			// SQL送信処理いらないかも??????????
			//Statement stmt = conn.createStatement();

			// 入力した情報をINSERT
			String sql = "INSERT INTO user_info (ID, ADDRESS,PASS) values (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文中の「？」に使用する値を設定
			pStmt.setString(1, id);
			pStmt.setString(2, address);
			pStmt.setString(3, pass);

			int result = pStmt.executeUpdate();
			System.out.println("レジスタ－41行目INSERT成功");//***************************************後で消す

		} catch (SQLException e) {
			System.out.println(" データベースへの接続が失敗しました");
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

	/****************************************
	  
	ログイン画面で入力した情報をDBのid,passと照会するメソッド
	 
	 *********************************************/

	// 戻り値をbooleanからAllayListに変更予定!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public boolean login(String id, String pass) {
		// 検索結果格納のため、Beanクラスをインスタンス
		LoginAccount resultUserInfo = new LoginAccount(id, pass);
		// 複数のユーザ情報を格納するため、Beanを格納する配列を作成
		ArrayList<LoginAccount> array_userinfo = new ArrayList<LoginAccount>();

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

			String sql = "SELECT id FROM user_info WHERE id=? AND pass=?";
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

			String sql = "SELECT ID,NAME FROM user_info ";
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