package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;

import kr.co.sist.dao.ShareDeptDAO;
import kr.co.sist.view.admin.ConfirmDocs;
import kr.co.sist.view.admin.DocsManagement;
import kr.co.sist.view.admin.ShareDept;
import kr.co.sist.vo.DocumentVO;

public class ShareDeptEvent extends WindowAdapter implements ActionListener, MouseListener {
   
	ShareDept dept;
    ConfirmDocs cd;

    public ShareDeptEvent(ShareDept dept) {
        this.dept = dept;
    }


    @Override
    public void mouseClicked(MouseEvent me) {
    	
        if (me.getSource() == dept.getJlDept()) {

            int index = dept.getJlDept().getSelectedIndex();
            if (index != 1) {
                String strdept = (String) dept.getDlmDept().getElementAt(index);
                dept.getDlmSelectedDept().addElement(strdept);
                dept.getDlmDept().remove(index);
            }
        }//end if
        if (me.getSource() == dept.getJlSelectedDept()) {
            int index = dept.getJlSelectedDept().getSelectedIndex();
            if (index != 1) {
                String strdept = (String) dept.getDlmSelectedDept().getElementAt(index);
                dept.getDlmDept().addElement(strdept);
                dept.getDlmSelectedDept().remove(index);
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == dept.getJbtncancel()) {
            dept.dispose();
            new DocsManagement();
        }
        if (ae.getSource() == dept.getJbtncheck()) {
            try {
                addSharedDoc();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//    public void remvodSelectedDept(String[] selected) {
//    
//    	//DB에서 해당 DOC_num에 저장된 모든 DEPT들을 가져옴(String 배열)
//    	ShareDeptDAO sdDAO = ShareDeptDAO.getInstance();
//    	try {
//			String[] deptArr = (String[]) sdDAO.getSharedDepts(Integer.parseInt(ConfirmDocs.getDocNum())).toArray();
//		if(deptArr !=null) {
//			
//		}
//    	} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	//값이 있을 때
//    	
//    	//창이 열리면 해당 DEPT들을 제거한 채로 보여준다.
//    }
    public void addSharedDoc() throws NumberFormatException, SQLException {
        String docNum = ConfirmDocs.getDocNum();
//        int index = dept.getJlDept().getSelectedIndex();
        String strdept = (String) dept.getDlmSelectedDept().get(0);
        System.out.println(strdept);
        try {
            ShareDeptDAO sdDAO = ShareDeptDAO.getInstance();
            DocumentVO dVO = new DocumentVO(docNum, null, null, null, null, null, strdept, 0, null, null);
            sdDAO.shareDoc(dVO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
