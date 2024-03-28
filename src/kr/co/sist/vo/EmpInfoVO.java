package kr.co.sist.vo;

import java.sql.Date;

public class EmpInfoVO {
    int empno;
    String name, position, job, tel, dept;
    Date hiredate, modifiedDate;

    public EmpInfoVO() {

    }

    public EmpInfoVO(int empno, String tel) {
        this.empno = empno;
        this.tel = tel;

    }

    public EmpInfoVO(int empno, String name, String job, String position, String dept, Date hiredate, String tel,
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

    public int getEmpno() {
        return empno;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getJob() {
        return job;
    }

    public String getTel() {
        return tel;
    }

    public String getDept() {
        return dept;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getModifiedDate() {
        return modifiedDate;
    }


}//EmpInfoVO
