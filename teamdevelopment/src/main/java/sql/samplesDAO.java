package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import object.userList;

public class samplesDAO {
	// idとnameを受け取るメソッドを作成
	public List<userList> findAll() {
		List<userList> userlist = new ArrayList<>();
		// ドライバを読み込みその際にtry文でエラー判定
		try {
			Class.forName("org.postgresql.Driver");
		// エラーが起きた場合
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		// データベースに接続する
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "takedakai", "Sketdance0729")) {
			// idとnameをselect文で取得
			String sql = "SELECT ID, NAME FROM user_info";
			// sql文の送信を行う
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// DBMSから検索結果を受け取る
			ResultSet rs = pStmt.executeQuery();
			
			// 検索結果がある限りwhile文で取得
			while (rs.next()) {
				// 変数に取得した値を代入
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				// userListのインスタンスに値を代入
				userList userl = new userList(id, name);
				// リストに挿入
				userlist.add(userl);
			}
		// エラーが出た場合
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		// リストを返す
		return userlist;
	}
	
	// データベースの情報全てを取得
	public List<userList> findUser() {
		// リストを宣言
		List<userList> userlist = new ArrayList<>();
		
		// ドライバを読み込みその際にtry文でエラー判定
		try {
			Class.forName("org.postgresql.Driver");
		// エラーが起きた場合
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		// データベースに接続
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "takedakai", "Sketdance0729")) {
			String sql = "SELECT ID, NAME, KANRI, SEX, SELF_INTRO FROM user_info";
			// sql文の送信を行う
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// DBMSから検索結果を受け取る
			ResultSet rs = pStmt.executeQuery();
			
			// 検索結果がある限りwhile文で取得
			while (rs.next()) {
				// 変数に受け取った値を代入
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String kanri = rs.getString("KANRI");
				String sex = rs.getString("SEX");
				String self_intro = rs.getString("SELF_INTRO");
				// インスタンスに変数を渡す
				userList userl = new userList(id, name, kanri, sex, self_intro);
				// リストに代入
				userlist.add(userl);
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	// リストを返す
	return userlist;
	}
	
	// 情報を削除するメソッドを作成
	public void DeleteUser(String id) {
		// 送信を行うための変数を宣言
		Statement pStmt = null;
		
		// ドライバを読み込みその際にtry文でエラー判定
		try {
			Class.forName("org.postgresql.Driver");
		// エラーが起きた場合
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		// データベースに接続
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "takedakai", "Sketdance0729")) {
			String sql = "DELETE FROM user_info WHERE id = '" + id + "'";
			// DBMSへの接続
			pStmt = conn.createStatement();
			// 削除結果を受け取る
			pStmt.executeUpdate(sql);
		// エラーが起きた場合
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
