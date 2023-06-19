package object;

import java.io.Serializable;

// ログインするときに使用するmodel
// UserAccountとListAccountは統合する予定
public class LoginAccount implements Serializable {
	private String id;
	private String address;
	private String pass;

	public LoginAccount() {
	}

	// 新規会員登録用コンストラクタいらないかも？
	//	public UserAccount(String id, String address, String pass) {
	//		this.id = id;
	//		this.address = address;
	//		this.pass = pass;
	//	}
	// ログイン処理をするときにしようするコンストラクタ
	public LoginAccount(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return this.id;
	}

	public String getPass() {
		return this.pass;
	}

	public String getAddress() {
		return this.address;
	}
}