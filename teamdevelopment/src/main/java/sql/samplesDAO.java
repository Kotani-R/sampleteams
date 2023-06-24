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
	public List<userList> findAll() {
		List<userList> userlist = new ArrayList<>();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "takedakai", "Sketdance0729")) {
			String sql = "SELECT ID, NAME FROM user_inf";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				userList userl = new userList(id, name);
				userlist.add(userl);
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return userlist;
	}
	public List<userList> findUser() {
		List<userList> userlist = new ArrayList<>();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "takedakai", "Sketdance0729")) {
			String sql = "SELECT ID, NAME, KANRI, SEX, SELF_INTRO, HOBBY FROM user_inf";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String kanri = rs.getString("KANRI");
				String sex = rs.getString("SEX");
				String self_intro = rs.getString("SELF_INTRO");
				String[] hobby = rs.getString("HOBBY").split(",");
				userList userl = new userList(id, name, kanri, sex, self_intro, hobby);
				userlist.add(userl);
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	return userlist;
	}
	public void DeleteUser(String id) {
		Statement pStmt = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "takedakai", "Sketdance0729")) {
			String sql = "DELETE FROM user_inf WHERE id = '" + id + "'";
			pStmt = conn.createStatement();
			// pStmt.setString(0, user.getId());
			pStmt.executeUpdate(sql);
			
			// ResultSet rs = pStmt.executeQuery();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
