package kr.co.sist.view.admin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.controller.event.ConfirmDocsEvent;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.DocumentVO;

/**
 * Desc : 관리자가 결재 문서를 확인하는 view<br>
 * 작성자 : 김현종<br>
 * 작성일 : ?<br>
 * 수정자 : 고한별<br>
 * 수정일 : 2024.03.24<br>
 */
public class ConfirmDocs extends JFrame {
	private static String docNum;
    private JButton jbtnShare, jbtnApproval, jbtncompanion, jbtncheck;
    private JTextField jtfdocnum, jtfempno, jtfempname, jtfdate;
    private JLabel jldocnum, jlempno, jlempname, jldate;
    private JTextArea jtaContents;

    /**
     * Desc : 관리자 문서 확인 view
     */
    public ConfirmDocs(DocumentVO dVO) {
        super("관리자문서확인");
        setLayout(null);

        createButton(dVO);
        createLabel();
        createTextField(dVO);
        jtaContents = new JTextArea();
        JFrameComponent.createPane(getContentPane(), jtaContents, 20, 80, 600, 350);
        createEvent(dVO);

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        docNum= dVO.getDocNo();
    }

    /**
     * Desc : 버튼 생성
     */
    private void createButton(DocumentVO dVO) {
        jbtnShare = JFrameComponent.createButton(getContentPane(), "공유", 30, 450, 100, 30);
        if(dVO.getCode2()==1) {
        	jbtnApproval = JFrameComponent.createButton(getContentPane(), "승인", 180, 450, 100, 30);
        	jbtncompanion = JFrameComponent.createButton(getContentPane(), "반려", 340, 450, 100, 30);
        }
        jbtncheck = JFrameComponent.createButton(getContentPane(), "확인", 500, 450, 100, 30);
    }

    /**
     * Desc : 라벨 생성
     */
    private void createLabel() {
        jldocnum = JFrameComponent.createLabel(getContentPane(), "문서번호:", 30, 30, 100, 20);
        jlempno = JFrameComponent.createLabel(getContentPane(), "사번:", 180, 30, 100, 20);
        jlempname = JFrameComponent.createLabel(getContentPane(), "사원명:", 310, 30, 100, 20);
        jldate = JFrameComponent.createLabel(getContentPane(), "신청날짜:", 440, 30, 100, 20);
    }

    /**
     * Desc : 텍스트필드 생성<br>
     * **************DB에서 값 받아와야지***********************
     */
    private void createTextField(DocumentVO dVO) {
        jtfdocnum = JFrameComponent.createTextField(getContentPane(), dVO.getDocNo(), 90, 30, 80, 20);
        jtfempno = JFrameComponent.createTextField(getContentPane(), String.valueOf(dVO.getEmpNo()), 215, 30, 80, 20);
        jtfempname = JFrameComponent.createTextField(getContentPane(), dVO.getName(), 355, 30, 80, 20);
        jtfdate = JFrameComponent.createTextField(getContentPane(), String.valueOf(dVO.getDocDate()), 500, 30, 80, 20);

        jtfdocnum.setEditable(false);
        jtfempno.setEditable(false);
        jtfempname.setEditable(false);
        jtfdate.setEditable(false);
    }

    /**
     * Desc : 이벤트 등록
     */
    private void createEvent(DocumentVO dVO) {
        ConfirmDocsEvent cfdevt = new ConfirmDocsEvent(this);

        jbtnShare.addActionListener(cfdevt);
        if(dVO.getCode2()==1) {
        	
        	jbtnApproval.addActionListener(cfdevt);
        	jbtncompanion.addActionListener(cfdevt);
        }
        jbtncheck.addActionListener(cfdevt);
    }

    public JButton getJbtnShare() {
        return jbtnShare;
    }

    public JButton getJbtnApproval() {
        return jbtnApproval;
    }

    public JButton getJbtncompanion() {
        return jbtncompanion;
    }

    public JButton getJbtncheck() {
        return jbtncheck;
    }

    public JTextField getJtfdocnum() {
        return jtfdocnum;
    }

    public JTextField getJtfempno() {
        return jtfempno;
    }

    public JTextField getJtfempname() {
        return jtfempname;
    }

    public JTextField getJtfdate() {
        return jtfdate;
    }

	public static String getDocNum() {
		return docNum;
	}

	public JLabel getJldocnum() {
		return jldocnum;
	}

	public JLabel getJlempno() {
		return jlempno;
	}

	public JLabel getJlempname() {
		return jlempname;
	}

	public JLabel getJldate() {
		return jldate;
	}

	public JTextArea getJtaContents() {
		return jtaContents;
	}
    
}
