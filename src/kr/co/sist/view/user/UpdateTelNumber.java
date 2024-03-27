package kr.co.sist.view.user;

import kr.co.sist.controller.event.UpdateTelNumberEvent;
import kr.co.sist.view.util.JFrameComponent;
import kr.co.sist.vo.EmpInfoVO;

import javax.swing.*;

public class UpdateTelNumber extends JFrame {
    private JTextField tfEmpno, tfName, tfPosition, tfJob, tfTel, tfDep;
    private JTextField inputJtTel;
    private JButton goHome, jbtnsave, jbtnexcPw;
    private JLabel jlNewTel, jlEmpno, jlName, jlPosition, jlJob, jlTel, jlDept;
    private EmpInfoVO eVO;

    public UpdateTelNumber(EmpInfoVO eVO) {
        super("사원창(정보변경)");
        setLayout(null);
        this.eVO = eVO;

        createLabel();
        createTextField();
        createButton();
        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
    }

    private void createButton(){
        goHome = JFrameComponent.createButton(getContentPane(),"돌아가기",250, 350, 150, 30);
        jbtnsave = JFrameComponent.createButton(getContentPane(),"저장",80, 350, 150, 30);
        jbtnexcPw = JFrameComponent.createButton(getContentPane(),"비밀번호 변경",420, 350, 150, 30);
    }

    private void createTextField(){
        tfEmpno = JFrameComponent.createTextField(getContentPane(),String.valueOf(eVO.getEmpno()),175, 65, 100, 30,false);
        tfName = JFrameComponent.createTextField(getContentPane(),eVO.getName(),175, 120, 100, 30,false);
        tfPosition = JFrameComponent.createTextField(getContentPane(),eVO.getPosition(),175, 175, 100, 30,false);
        tfJob = JFrameComponent.createTextField(getContentPane(),eVO.getJob(),370, 65, 100, 30,false);
        tfTel = JFrameComponent.createTextField(getContentPane(),eVO.getTel(),370, 120, 100, 30,false);
        tfDep = JFrameComponent.createTextField(getContentPane(),eVO.getDept(),370, 175, 100, 30,false);
        inputJtTel = JFrameComponent.createTextField(getContentPane(),250, 280, 100, 30);
    }

    private void createLabel(){
        jlEmpno = JFrameComponent.createLabel(getContentPane(),"사원번호",100, 65, 60, 30);
        jlName = JFrameComponent.createLabel(getContentPane(),"사원이름",100, 120, 60, 30);
        jlPosition = JFrameComponent.createLabel(getContentPane(),"직급",100, 175, 60, 30);
        jlJob = JFrameComponent.createLabel(getContentPane(),"직무",300, 65, 60, 30);
        jlTel = JFrameComponent.createLabel(getContentPane(),"내선번호",300, 120, 60, 30);
        jlDept = JFrameComponent.createLabel(getContentPane(),"부서",300, 175, 60, 30);
        jlNewTel = JFrameComponent.createLabel(getContentPane(),"변경 할 내선번호",250, 250, 100, 30);
    }

    private void createEvent(){
        UpdateTelNumberEvent evt = new UpdateTelNumberEvent(this);

        addWindowListener(evt);
        jbtnsave.addActionListener(evt);
        goHome.addActionListener(evt);
        jbtnexcPw.addActionListener(evt);
    }

    /**
     * @return the goHome
     */
    public JButton getGoHome() {
        return goHome;
    }

    public JTextField getInputJtTel() {
        return inputJtTel;
    }

    public JButton getJbtnexcPw() {
        return jbtnexcPw;
    }

    public JButton getJbtnsave() {
        return jbtnsave;
    }

}
