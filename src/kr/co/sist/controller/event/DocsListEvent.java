package kr.co.sist.controller.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.dao.DocsListDAO;
import kr.co.sist.dao.VacationStatusDAO;
import kr.co.sist.view.admin.UpdateEmployeeInformation;
import kr.co.sist.view.admin.VacationStatus;
import kr.co.sist.view.admin.reject;
import kr.co.sist.view.common.SubmitDocs;
import kr.co.sist.view.user.DocsList;
import kr.co.sist.vo.DocumentVO;
import kr.co.sist.view.admin.reject;

public class DocsListEvent implements ActionListener, ItemListener, MouseListener{
	private DocsList dclist;
	private JButton jbtnAddDoc;
	private JButton jbtnGoMain;
	private JCheckBox cbcheck;
	  private JTable jtaDob;
	    private DefaultTableModel dtmjtabResult;
	private DocumentVO dVO;
	private List<DocumentVO> dVOList;
	private VacationStatus vs;
	
	public DocsListEvent(DocsList dclist) {
		this.dclist = dclist;
		this.dtmjtabResult = dclist.getDtmjtabResult();

	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==dclist.getJbtnAddDoc()) {
			System.out.println("문서등록");
		}
		if(ae.getSource()==dclist.getJbtnGoMain()) {
			System.out.println("메인으로");
		}

	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==dclist.getCbcheck()) {
			System.out.println("체크");
			try {
				selectDocInfo();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public void searchDocInfo() throws SQLException {
	    Object[] content = new Object[7];
	    DocsListDAO dlDAO = DocsListDAO.getInstance();
	    dVOList = dlDAO.selectAllDocument();
	    
	    dtmjtabResult.setRowCount(0);
	    
	    // 문서 목록이 비어 있는 경우
	    if (dVOList.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
	    } else {
	        for (DocumentVO dVO : dVOList) {
	            content[0] = dVO.getDocNo();
	            content[1] = dVO.getTitle();
	            content[2] = dVO.getDept();
	            content[3] = dVO.getDocDate();
	            content[4] = dVO.getApprDesc();
	            if(dVO.getCode2()==1) {
	            	content[5] = "대기";
	            }
	            else if(dVO.getCode2() == 2) {
					content[5] = "승인";
				}
				else if(dVO.getCode2() == 3) {
					content[5] = "반려";
				}
	          
	            content[6] = dVO.getDocDate();
	            
	           dclist.getDtmjtabResult().addRow(content);
	        }
	    }
	}

	
	public void selectDocInfo()throws SQLException{
		   Object[] content = new Object[7];
		    DocsListDAO dlDAO = DocsListDAO.getInstance();
		    dVOList = dlDAO.selectDocinfo();
		    
		    dtmjtabResult.setRowCount(0);
		    
		    // 문서 목록이 비어 있는 경우
		    if (dVOList.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "해당 문서가 없습니다");
		    } else {
		        for (DocumentVO dVO : dVOList) {
		            content[0] = dVO.getDocNo();
		            content[1] = dVO.getTitle();
		            content[2] = dVO.getDept();
		            content[3] = dVO.getDocDate();
		            content[4] = dVO.getApprDesc();
		            content[5] = dVO.getEmpNo();
		            content[6] = dVO.getDocDate();
		            
		            dtmjtabResult.addRow(content);
		        }
		    }
	}


	@Override
	public void mouseClicked(MouseEvent me) {
        int row = dclist.getJtaDob().rowAtPoint(me.getPoint());
        int col = dclist.getJtaDob().columnAtPoint(me.getPoint());
        String item = dclist.getJtaDob().getValueAt(row, col).toString();

        if (me.getSource() == dclist.getJtaDob()) {
            if (col == 0) {
                new SubmitDocs(); // 여기에 연결될 창
                dclist.dispose();
            }
            if (col == 5) {
                String doc_no = dclist.getJtaDob().getValueAt(row, 0).toString().trim();
                if (item.equals("반려")) {
                    try {
                    	Rejet(doc_no);
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                }
            }

        }
    }


	
	
	
	
	public void Rejet(String doc_no) throws SQLException {
		VacationStatusDAO vsDAO = VacationStatusDAO.getInstance();
		String regetDetail = vsDAO.selectRejetDetail(doc_no).toString();
		new reject(vs,regetDetail);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}