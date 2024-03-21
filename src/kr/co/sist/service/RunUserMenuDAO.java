package kr.co.sist.service;

import kr.co.sist.dao.UserMenuDAO;
import kr.co.sist.vo.CommuteVO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc : 사원 근무 일정과 관련된 내용을 DAO를 통해 처리하게 하는 클래스<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class RunUserMenuDAO {
    public void loadMonthlyWorkSchedule(){

    }

    public static List<CommuteVO> loadStampTime(){
        List<CommuteVO> list;
        try {
            list = UserMenuDAO.getInstance().selectCommuteLog(240004);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
