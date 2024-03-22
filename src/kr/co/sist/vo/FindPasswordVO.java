package kr.co.sist.vo;

public class FindPasswordVO {

	String emp_no, password, tel;

	public FindPasswordVO() {
		super();
	}

	public FindPasswordVO(String emp_no, String password) {
		super();
		this.emp_no = emp_no;
		this.password = password;
	}
	
	public FindPasswordVO(String emp_no, String password, String tel) {
		super();
		this.emp_no = emp_no;
		this.password = password;
		this.tel =tel;
	}

	
	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getPassword() {
		return password;
	}
	
	public String getTel() {
		return tel;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "FindPasswordVO [emp_no=" + emp_no + ", password=" + password + "]";
	}
	
	
	
}
