package kr.co.sist.vo;

import java.sql.Date;

/**
 * Desc : 출퇴근 이력 표시에 필요한 VO<br>
 * 작성일 : 2024.03.19<br>
 * 작성자 : 고한별
 */
public class CommuteVO {
    int empNo;
    String empName;
    Date commuteDate, attendTime, quitTime;

    String workStatus;

    public CommuteVO() {
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

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }

    public Date getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(Date quitTime) {
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

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
