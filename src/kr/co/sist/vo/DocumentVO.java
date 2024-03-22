package kr.co.sist.vo;

import java.sql.Date;

public class DocumentVO {

    String docNo, title, workDesc, workLog, apprDesc, fileName,dept;
    int empNo, code2;
    Date docDate,modifiedDate;

    public int getCode2() {
		return code2;
	}

	public String getDept() {
		return dept;
	}

    
	public DocumentVO(String docNo, String title, String workLog, String dept, String fileNm ,int empNo) {
		super();
		this.docNo = docNo;
		this.title = title;
		this.workLog = workLog;
		this.dept = dept;
		this.fileName= fileNm;
		this.empNo = empNo;
	}


	public DocumentVO() {
    }

    public void setCode2(int code2) {
		this.code2 = code2;
	}

	public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    public String getWorkLog() {
        return workLog;
    }

    public void setWorkLog(String workLog) {
        this.workLog = workLog;
    }

    public String getApprDesc() {
        return apprDesc;
    }

    public void setApprDesc(String apprDesc) {
        this.apprDesc = apprDesc;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    

	public DocumentVO(String docNo, String title, String workDesc, String workLog, String apprDesc, String fileName,
			String dept, int empNo,int code2, Date docDate, Date modifiedDate) {
		super();
		this.docNo = docNo;
		this.title = title;
		this.workDesc = workDesc;
		this.workLog = workLog;
		this.apprDesc = apprDesc;
		this.fileName = fileName;
		this.dept = dept;
		this.empNo = empNo;
		this.code2 = code2;
		this.docDate = docDate;
		this.modifiedDate = modifiedDate;
	}

    public DocumentVO(String docNo, String title, String workDesc, String workLog, String apprDesc, String fileName,
                      String dept, int empNo, Date docDate, Date modifiedDate) {
        super();
        this.docNo = docNo;
        this.title = title;
        this.workDesc = workDesc;
        this.workLog = workLog;
        this.apprDesc = apprDesc;
        this.fileName = fileName;
        this.dept = dept;
        this.empNo = empNo;
        this.docDate = docDate;
        this.modifiedDate = modifiedDate;
    }

	@Override
	public String toString() {
		return "DocumentVO [docNo=" + docNo + ", title=" + title + ", workDesc=" + workDesc + ", workLog=" + workLog
				+ ", apprDesc=" + apprDesc + ", fileName=" + fileName + ", dept=" + dept + ", empNo=" + empNo
				+ ", code2=" + code2 + ", docDate=" + docDate + ", modifiedDate=" + modifiedDate + "]";
	}
    
}