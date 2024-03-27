package kr.co.sist.service;

import kr.co.sist.controller.event.LoginEvent;
import kr.co.sist.dao.UserMenuDAO;
import kr.co.sist.vo.CommuteVO;
import kr.co.sist.vo.VacationVO;

import java.sql.SQLException;
import java.util.List;

/**
 * Desc : 사원 근무 일정과 관련된 내용을 DAO를 통해 처리하게 하는 클래스<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class RunUserMenuDAO {
    /**
     * Desc : 휴가일 정보를 List로 반환
     * @return 승인된 휴가의 시작일과 종료일이 기록된 VacationVO List
     */
    public static List<VacationVO> loadMonthlyWorkSchedule() {
        List<VacationVO> list = null;
        try {
            list = UserMenuDAO.getInstance().selectVacationDate(Integer.parseInt(LoginEvent.getEmpno()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * Desc : 출퇴근 기록시간 불러오기
     * @return 날짜와 출퇴근시간이 기록된 VO list
     */
    public static List<CommuteVO> loadStampTime() {
        List<CommuteVO> list;
        try {
            list = UserMenuDAO.getInstance().selectCommuteLog(Integer.parseInt(LoginEvent.getEmpno()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
