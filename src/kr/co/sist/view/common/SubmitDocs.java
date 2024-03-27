package kr.co.sist.view.common;

import kr.co.sist.controller.event.SubmitDocsEvent;
import kr.co.sist.dao.DocsManagementDAO;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.DocumentVO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Desc : 업무 관련 문서를 작성하기 위해 사용되는 view<br>
 * 작성자 : 양수민<br>
 * 작성일 : ?<br>
 * 수정자 : 고한별<br>
 * 수정일 : 2024.03.23<br>
 */
public class SubmitDocs extends JFrame {

    private JButton btn_regist, btn_cancel, attAdd, attRemove;
    private JTextField jtfTitle, jtfFileNm;
    private JComboBox<String> jcb;
    private JTextArea jta;
    private SubmitDocsEvent smde;

    /**
     * Desc : 문서등록 창의 view
     */
    public SubmitDocs() {
        super("문서등록");
        setLayout(null);

        btn_regist = JFrameComponent.createButton(getContentPane(), "등록", 120, 430, 80, 30);
        btn_cancel = JFrameComponent.createButton(getContentPane(), "취소", 430, 430, 80, 30);

        jta = new JTextArea();
        jta.setBounds(50, 100, 540, 300);
        add(jta);

        createComboBox();
        createUpperComponents();
        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Desc : 이벤트 등록
     */
    public void createEvent() {
        smde = new SubmitDocsEvent(this);

        attAdd.addActionListener(smde);
        attRemove.addActionListener(smde);
        jcb.addItemListener(smde);
        btn_regist.addActionListener(smde);
        btn_cancel.addActionListener(smde);
        jtfTitle.addActionListener(smde);
    }

    /**
     * Desc : frame 상단에 표시할 내용 생성
     */
    private void createUpperComponents() {
        jtfTitle = JFrameComponent.createTextField(getContentPane(), "제목을 입력하세요", 140, 35, 200, 30);
        jtfFileNm = JFrameComponent.createTextField(getContentPane(), "첨부파일명", 350, 35, 100, 30);

        attAdd = JFrameComponent.createButton(getContentPane(), "추가", 470, 35, 60, 30);
        attRemove = JFrameComponent.createButton(getContentPane(), "취소", 540, 35, 60, 30);
    }

    /**
     * Desc : 업무의 종류를 선택하는 comboBox 생성<br>
     * ******** 내용은 DB에서 받는 것이 맞지..?********
     */
    public void createComboBox() {
        jcb = new JComboBox<>();

        List<DocumentVO> paperType = null;
        try {
            paperType = DocsManagementDAO.getInstance().selectInfo("paperType");

            for (DocumentVO dVO : paperType) {
                jcb.addItem(dVO.getPaperType());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        jcb.setBounds(20, 35, 110, 30);
        add(jcb);
    }

    /**
     * @return the btn_regist
     */
    public JButton getBtn_regist() {
        return btn_regist;
    }

    /**
     * @return the btn_cancel
     */
    public JButton getBtn_cancel() {
        return btn_cancel;
    }

    /**
     * @return the attAdd
     */
    public JButton getAttAdd() {
        return attAdd;
    }

    /**
     * @return the attRemove
     */
    public JButton getAttRemove() {
        return attRemove;
    }

    /**
     * @return the jtfTitle
     */
    public JTextField getJtfTitle() {
        return jtfTitle;
    }

    /**
     * @return the jtfFileNm
     */
    public JTextField getJtfFileNm() {
        return jtfFileNm;
    }

    /**
     * @return the jta
     */
    public JTextArea getJta() {
        return jta;
    }

    /**
     * @return the jcb
     */
    public JComboBox<String> getJcb() {
        return jcb;
    }
}
