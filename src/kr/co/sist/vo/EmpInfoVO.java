package kr.co.sist.vo;

import java.sql.Date;

public class EmpInfoVO {
 int empno;
 String name,position,job,tel,dept;
 Date hiredate,modifiedDate;
 
public EmpInfoVO() {
}

public EmpInfoVO(int empno, String name, String position, String job, String tel, String dept, Date hiredate,
		Date modifiedDate) {
	super();
	this.empno = empno;
	this.name = name;
	this.position = position;
	this.job = job;
	this.tel = tel;
	this.dept = dept;
	this.hiredate = hiredate;
	this.modifiedDate = modifiedDate;
}

/**
 * 사원정보변경창에서
 * 선택된 사원의 정보를 띄울 때
 */
@Override
public String toString() {
	return "EmpInfoVO [empno=" + empno + ", name=" + name + ", position=" + position + ", job=" + job + ", tel=" + tel
			+ ", dept=" + dept + "]";
}

 
}//EmpInfoVO
