package object;
import java.io.Serializable;
public class UserAccount implements Serializable{
	private String id;
	private String address;
	private String pass;

	public UserAccount() {
	}

	public UserAccount(String id, String address,String pass) {
		this.id = id;
		this.address = address;
		this.pass = pass;
	}public UserAccount(String id, String pass) {
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
	public void setId(String id) {
		this.id = id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}