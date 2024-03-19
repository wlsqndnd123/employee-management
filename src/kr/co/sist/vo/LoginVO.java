package kr.co.sist.vo;

public class LoginVO {

	String emp_no, password;

	public LoginVO() {
		super();
	}

	public LoginVO(String emp_no, String password) {
		super();
		this.emp_no = emp_no;
		this.password = password;
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

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginVO [emp_no=" + emp_no + ", password=" + password + "]";
	}
	
	
}