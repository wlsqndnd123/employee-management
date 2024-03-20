package kr.co.sist.vo;

import java.sql.Date;

/**
 * Desc : 출퇴근 이력 표시에 필요한 VO<br>
 * 작성일 : 2024.03.19<br>
 * 작성자 : 고한별
 */
public class CommuteVO {
    int empNo, use_count, assign_count;
    String empName, attendTime, quitTime ;
    Date commuteDate;
    
    String workStatus;

    public CommuteVO() {
    }
    
 

	public CommuteVO(int empNo, int use_count, int assign_count, String empName, String attendTime, String quitTime,
			Date commuteDate, String workStatus) {
		super();
		this.empNo = empNo;
		this.use_count = use_count;
		this.assign_count = assign_count;
		this.empName = empName;
		this.attendTime = attendTime;
		this.quitTime = quitTime;
		this.commuteDate = commuteDate;
		this.workStatus = workStatus;
	}







	public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Date getCommuteDate() {
        return commuteDate;
    }

    public void setCommuteDate(Date commuteDate) {
        this.commuteDate = commuteDate;
    }

    public String getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(String attendTime) {
        this.attendTime = attendTime;
    }

    public String getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(String quitTime) {
        this.quitTime = quitTime;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getEmpName() {
        return empName;
    }

    public int getUse_count() {
		return use_count;
	}

	public void setUse_count(int use_count) {
		this.use_count = use_count;
	}

	public int getAssign_count() {
		return assign_count;
	}

	public void setAssign_count(int assign_count) {
		this.assign_count = assign_count;
	}

	public void setEmpName(String empName) {
        this.empName = empName;
    }

	@Override
	public String toString() {
		return "CommuteVO [empNo=" + empNo + ", empName=" + empName + ", attendTime=" + attendTime + ", quitTime=" + quitTime 
				+ ", use_count=" + use_count + ", assign_count=" + assign_count
				+ ", commuteDate=" + commuteDate + "]";
	}
}
