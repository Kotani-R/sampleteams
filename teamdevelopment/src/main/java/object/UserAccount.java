package object;

import java.io.Serializable;

// ログインするときに使用するmodel
// UserAccountとListAccountは統合する予定
public class UserAccount implements Serializable {
	private String id;
	private String address;
	private String pass;
	private String name;//使わない

	public UserAccount() {
	}

	// 新規会員登録用コンストラクタ
	public UserAccount(String id, String address, String pass) {
		this.id = id;
		this.address = address;
		this.pass = pass;
	}
	// ログイン処理をするときにしようするコンストラクタ
	public UserAccount(String id, String pass) {
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