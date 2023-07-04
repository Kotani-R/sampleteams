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

	
	// ログイン処理をするときにしようするコンストラクタ
	public LoginAccount(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
}