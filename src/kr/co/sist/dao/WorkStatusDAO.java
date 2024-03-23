package kr.co.sist.dao;

import kr.co.sist.util.DbConnection;
import kr.co.sist.view.admin.WorkStatus;
import kr.co.sist.vo.CommuteVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkStatusDAO {

    private static WorkStatusDAO wsDAO;
    private WorkStatus workStatus;
    private CommuteVO wsVO;

    private WorkStatusDAO() {

    }

    public static WorkStatusDAO getInstance() {
        if (wsDAO == null) {
            wsDAO = new WorkStatusDAO();
        }
        return wsDAO;
    }


    public List<CommuteVO> selectWSInfo(int emp_num, String date) throws SQLException {
        List<CommuteVO> list = new ArrayList<CommuteVO>();
        wsVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DbConnection.getCon();

            String selectINFO = null;

            if (emp_num == 0) {
                if (date.equals("오늘")) {
                    selectINFO = "   select ei.EMP_NO, ei.name, c.attend_time, c.quit_time, vc.use_count, vc.assign_count, c.commute_date"
                            + "	from EMP_INFO ei, COMMUTE c,  VACATION_COUNT vc 	"
                            + "	where (ei.emp_no = c.emp_no) and (ei.emp_no = vc.emp_no) and (( to_char(c.commute_date,'yymmdd')) = ( to_char(sysdate,'yymmdd')))"
                            + " 	order by c.attend_time desc";

                }
                if (date.equals("1주일")) {
                    selectINFO = "   select ei.EMP_NO, ei.name, c.attend_time, c.quit_time, vc.use_count, vc.assign_count, c.commute_date"
                            + "	from EMP_INFO ei, COMMUTE c, VACATION_COUNT vc 	"
                            + "	where (ei.emp_no = c.emp_no) and (ei.emp_no = vc.emp_no) and (( to_char(c.commute_date,'yymmdd')) between ( to_char(sysdate,'yymmdd'))-7 and ( to_char(sysdate,'yymmdd')) )"
                            + " 	order by c.attend_time desc";
                }
                if (date.equals("1달")) {
                    selectINFO = "   select ei.EMP_NO, ei.name, c.attend_time, c.quit_time, vc.use_count, vc.assign_count, c.commute_date"
                            + "	from EMP_INFO ei, COMMUTE c, VACATION_COUNT vc 	"
                            + "	where (ei.emp_no = c.emp_no) and (ei.emp_no = vc.emp_no) and (( to_char(c.commute_date,'yymmdd')) between ( to_char(sysdate,'yymmdd'))-30 and ( to_char(sysdate,'yymmdd')) )"
                            + " 	order by c.attend_time desc";
                }

                if (date.equals("1년")) {
                    selectINFO = "   select ei.EMP_NO, ei.name, c.attend_time, c.quit_time, vc.use_count, vc.assign_count, c.commute_date"
                            + "	from EMP_INFO ei, COMMUTE c, VACATION_COUNT vc 	"
                            + "	where (ei.emp_no = c.emp_no) and (ei.emp_no = vc.emp_no) and (( to_char(c.commute_date,'yymmdd')) between ( to_char(sysdate,'yymmdd'))-365 and ( to_char(sysdate,'yymmdd')) )"
                            + " 	order by c.attend_time desc";
                }


            } else {

                if (date.equals("오늘")) {
                    selectINFO = "   select ei.EMP_NO, ei.name, c.attend_time, c.quit_time, vc.use_count, vc.assign_count, c.commute_date"
                            + "	from EMP_INFO ei, COMMUTE c, VACATION_COUNT vc 	"
                            + "	where (ei.emp_no = c.emp_no) and (ei.emp_no = vc.emp_no) and (ei.emp_no = ?) and (( to_char(c.commute_date,'yymmdd')) = ( to_char(sysdate,'yymmdd')))"
                            + " 	order by c.attend_time desc";

                }


                if (date.equals("1주일")) {
                    selectINFO = "   select ei.EMP_NO, ei.name, c.attend_time, c.quit_time, vc.use_count, vc.assign_count, c.commute_date "
                            + "	from EMP_INFO ei, COMMUTE c, VACATION_COUNT vc 	"
                            + "	where (ei.emp_no = c.emp_no) and (ei.emp_no = vc.emp_no) and (ei.emp_no = ?) and (( to_char(c.commute_date,'yymmdd')) between ( to_char(sysdate,'yymmdd'))-7 and ( to_char(sysdate,'yymmdd')) ) "
                            + " 	order by c.attend_time desc";
                }


                if (date.equals("1달")) {
                    selectINFO = "   select ei.EMP_NO, ei.name, c.attend_time, c.quit_time, vc.use_count, vc.assign_count, c.commute_date "
                            + "	from EMP_INFO ei, COMMUTE c, VACATION_COUNT vc 	"
                            + "	where (ei.emp_no = c.emp_no) and (ei.emp_no = vc.emp_no) and (ei.emp_no = ?) and (( to_char(c.commute_date,'yymmdd')) between ( to_char(sysdate,'yymmdd'))-30 and ( to_char(sysdate,'yymmdd')) ) "
                            + " 	order by c.attend_time desc";
                }

                if (date.equals("1년")) {
                    selectINFO = "   select ei.EMP_NO, ei.name, c.attend_time, c.quit_time, vc.use_count, vc.assign_count, commute_date "
                            + "	from EMP_INFO ei, COMMUTE c, VACATION_COUNT vc 	"
                            + "	where (ei.emp_no = c.emp_no) and (ei.emp_no = vc.emp_no) and (ei.emp_no = ?) and (( to_char(c.commute_date,'yymmdd')) between ( to_char(sysdate,'yymmdd'))-365 and ( to_char(sysdate,'yymmdd')) ) "
                            + " 	order by c.attend_time desc";
                }

            }
            pstmt = con.prepareStatement(selectINFO);
            if (emp_num != 0) {
                pstmt.setInt(1, emp_num);
            }
            rs = pstmt.executeQuery();

            while (rs.next()) {
                wsVO = new CommuteVO(rs.getInt("EMP_NO"), rs.getInt("use_count"),
                        rs.getInt("assign_count"), rs.getString("name"),
                        rs.getString("attend_time"), rs.getString("quit_time"),
                        rs.getDate("commute_date"), null);


                list.add(wsVO);

            }

        } finally {
            DbConnection.dbClose(null, pstmt, con);

        }

        return list;
    }


}
