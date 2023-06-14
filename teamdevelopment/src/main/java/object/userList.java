package object;

public class userList {
	// 
	private String id;
	private String name;
	private String kanri;
	private String sex;
	private String self_intro;
	
	// コンストラクタを作成
	public userList() {
	}
	
	public userList(String id) {
		this.id = id;
	}
	
	public userList(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public userList(String id, String name, String kanri, String sex, String self_intro) {
		this.id = id;
		this.name = name;
		this.kanri = kanri;
		this.sex = sex;
		this.self_intro = self_intro;
	}
	
	// ゲッターを作成
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getKanri() {
		return this.kanri;
	}
	public String getSex() {
		return this.sex;
	}
	public String getSelf_intro() {
		return this.self_intro;
	}
	
}
