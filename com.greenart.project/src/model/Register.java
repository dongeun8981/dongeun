package model;

public class Register {
	private int id;
	private String userid;
	private String passwd;
	private String name;
	private String addr;
	private String email;
	private int age;

	public Register() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		
		String str = "";
		str += "회원번호 : " + getId();
		str += "\t회원아이디 : " + getUserid();
		str += "\t비밀번호 : " + getPasswd();
		str += "\t이름 : " + getName();
		str += "\t주소 : " + getAddr();
		str += "\t나이 : " + getAge();
		return str;

	}

}
