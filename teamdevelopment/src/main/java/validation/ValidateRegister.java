package validation;

import java.util.regex.Pattern;

public class ValidateRegister {
	private String messageId;
	private String messageAddress;
	private String messagePass;

	public ValidateRegister() {
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageAddress() {
		return messageAddress;
	}

	public void setMessageAddress(String messageAdress) {
		this.messageAddress = messageAdress;
	}

	public String getMessagePass() {
		return messagePass;
	}

	public void setMessagePass(String messagePass) {
		this.messagePass = messagePass;
	}

	public void checkAll(String id, String address, String pass) {
		this.setMessageId(checkId(id));
		this.setMessageAddress(checkAddress(address));
		this.setMessagePass(checkPass(pass));
		System.out.println(this.getMessagePass() + "かきくけこ");
	}

	private String checkId(String id) {// [40]
		if (!checkNull(id)) {//[41]
			messageId = "UserIDは必須項目です。";//[42]
			return messageId;
		}
		if (checkLength(id, 11)) {//[54]
			messageId = "UserIDは10文字以内で入力してください";//[45]
			return messageId;
		}
		return messageId;
	}

	private String checkAddress(String address) {//[50]
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$");
		if (!checkNull(address)) {//[51]
			messageAddress = "メールアドレスは必須項目です。";//[52]
			return messageAddress;//[53]
		}
		if (!pattern.matcher(address).matches()) {//[54]
			messageAddress = "メールアドレスは正しい形式で入力してください。";//[56]
			return messageAddress;//[57]
		}
		return messageAddress;//[61]
	}

	private String checkPass(String pass) {// [40]
		if (!checkNull(pass)) {//[41]
			messagePass = "パスワードは必須項目です。";//[42]
			return messagePass;//[43]
		}
		if (checkLength(pass, 11)) {//[54]
			messagePass = "パスワードは10文字以内で入力してください。";//[45]
			return messagePass;//[46]
		}
		return messagePass;//[47]
	}

	private boolean checkNull(String value) {//[70]
		if (value == null)//[71]
			return false;//[72]
		return true;//[73]
	}

	private boolean checkEmpty(String value) {//[80]
		if (value.isEmpty())//[81]
			return false;//[82]
		return true;//[83]
	}

	private boolean checkLength(String value, int minimumLength) {//[90]
		if (value.length() < minimumLength)//[91]
			return false;//[92]
		return true;//[93]
	}

	private boolean checkNumber(String value) {//[100]
		try {//[101]
			Integer.parseInt(value);//[102]
			return true;//[1031
		} catch (NumberFormatException numberFormatException) {//[104]
			return false;//[105]
		}

	}

}
