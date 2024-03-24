package kr.co.sist.vo;

public class UpdatePasswordVO {

	int emp_no;
	String password,tel;

	public UpdatePasswordVO() {
		super();
	}

	public UpdatePasswordVO(int emp_no, String password) {
		super();
		this.emp_no = emp_no;
		this.password = password;
	}

	public int getEmp_no() {
		return emp_no;
	}


	public String getPassword() {
		return password;
	}


	@Override
	public String toString() {
		return "UpdatePasswordVO [emp_no=" + emp_no + ", password=" + password + "]";
	}
	
	public UpdatePasswordVO(int emp_no, String password, String tel) {
		super();
		this.emp_no = emp_no;
		this.password = password;
		this.tel =tel;
	}
}
