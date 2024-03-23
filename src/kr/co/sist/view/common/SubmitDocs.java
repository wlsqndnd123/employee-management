package kr.co.sist.view.common;

import kr.co.sist.controller.event.SubmitDocsEvent;

import javax.swing.*;

/**
 * Desc : 업무 관련 문서를 작성하기 위해 사용되는 view
 * 작성자 : 양수민
 * 작성일 : ?
 * 수정자 : 고한별
 * 수정일 : 2024.03.23
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

        btn_regist = createButton("등록", 120, 430, 80, 30);
        btn_cancel = createButton("취소", 430, 430, 80, 30);

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
     * Desc : textField를 생성
     *
     * @param text   textField 내부에 기록될 초기값
     * @param x      x 좌표
     * @param y      y 좌표
     * @param width  가로 픽셀
     * @param height 세로 픽셀
     * @return 생성된 textField
     */
    private JTextField createTextField(String text, int x, int y, int width, int height) {
        JTextField textField = new JTextField();

        textField.setText(text);
        textField.setBounds(x, y, width, height);
        add(textField);

        return textField;
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
     * Desc : 버튼을 생성하는 기능
     *
     * @param text   버튼에 표시될 내용
     * @param x      버튼의 x 좌표
     * @param y      버튼의 y 좌표
     * @param width  버튼의 가로 픽셀
     * @param height 버튼의 세로 픽셀
     * @return 생성된 JButton
     */
    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);

        button.setBounds(x, y, width, height);
        add(button);

        return button;
    }

    /**
     * Desc : frame 상단에 표시할 내용 생성
     */
    private void createUpperComponents() {
        jtfTitle = createTextField("제목을 입력하세요", 140, 35, 200, 30);
        jtfFileNm = createTextField("첨부파일명", 350, 35, 100, 30);

        attAdd = createButton("추가", 470, 35, 60, 30);
        attRemove = createButton("취소", 540, 35, 60, 30);
    }

    /**
     * Desc : 업무의 종류를 선택하는 comboBox 생성<br>
     * ******** 내용은 DB에서 받는 것이 맞지..?********
     */
    public void createComboBox() {
        jcb = new JComboBox<>(new String[]{"업무일지", "휴가신청", "보고서"});
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

    public static void main(String[] args) {
        new SubmitDocs();
    }

}