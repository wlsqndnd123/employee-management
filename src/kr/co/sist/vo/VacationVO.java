package kr.co.sist.vo;

import java.sql.Date;

/**
 * Desc : 사원의 휴가 신청에 필요한 VO<br>
 * 작성일 : 2024.03.19<br>
 * 작성자 : 고한별
 */
public class VacationVO {
    int empNo,assignCount,useCount,code2;
    String docNo, workLog, docName, empName, deptDesc, apprDesc, rejectReason, title, dept_name;
    Date startDate, endDate, createdDate;

    public VacationVO(int empNo, int assignCount, int useCount, int code2, String docNo, String workLog, String docName,
			String empName, String deptDesc, String apprDesc, String rejectReason,String title,String dept_name, Date startDate, Date endDate,
			Date createdDate) {
		super();
		this.empNo = empNo;
		this.assignCount = assignCount;
		this.useCount = useCount;
		this.code2 = code2;
		this.docNo = docNo;
		this.workLog = workLog;
		this.docName = docName;
		this.empName = empName;
		this.deptDesc = deptDesc;
		this.apprDesc = apprDesc;
		this.rejectReason = rejectReason;
		this.title = title;
		this.dept_name = dept_name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdDate = createdDate;
	}

	public VacationVO() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getAssignCount() {
        return assignCount;
    }

    public int getCode2() {
		return code2;
	}

	public void setCode2(int code2) {
		this.code2 = code2;
	}

	public void setAssignCount(int assignCount) {
        this.assignCount = assignCount;
    }

    public int getUseCount() {
        return useCount;
    }

    public void setUseCount(int useCount) {
        this.useCount = useCount;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    public String getApprDesc() {
        return apprDesc;
    }

    public void setApprDesc(String apprDesc) {
        this.apprDesc = apprDesc;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetp_name() {
		return dept_name;
	}

	public void setDetp_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

	@Override
	public String toString() {
		return "VacationVO [empNo=" + empNo + ", assignCount=" + assignCount + ", useCount=" + useCount + ", code2="
				+ code2 + ", docNo=" + docNo + ", workLog=" + workLog + ", docName=" + docName + ", empName=" + empName
				+ ", deptDesc=" + deptDesc + ", apprDesc=" + apprDesc + ", rejectReason=" + rejectReason + ", title="
				+ title + ", dept_name=" + dept_name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", createdDate=" + createdDate + "]";
	}
	
}
