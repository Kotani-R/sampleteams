package object;

import java.io.Serializable;
 
// 一覧画面に表示するIDとNAMEのmodel
public class ListAccount implements Serializable{
	private String id;
	private String name;

	public ListAccount() {
	}
	
	public ListAccount(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
}