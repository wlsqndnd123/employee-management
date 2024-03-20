package view.user;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

/**
 * Desc : 사원의 휴가 신청서 입력을 위한 view<br>
 * 작성자 : 고한별<br>
 * 작성일 : 2024.03.15
 */
public class RequestVacation extends JFrame {
    private JLabel startDateTag;
    private JLabel endDateTag;
    private JDateChooser vacStartDate;
    private JDateChooser vacEndDate;
    private JTextArea vacContents;
    private JScrollPane contentsPad;
    private JButton request;
    private JButton cancel;

    /**
     * Desc : 휴가 신청 main frame 구현
     */
    public RequestVacation() {
        setTitle("휴가 신청");
        setLayout(null);

        createVacDate();
        createContentsArea();
        createConfirmButton();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Desc : 휴가 시작일과 종료일을 설정하는 영역 생성
     */
    public void createVacDate(){
        startDateTag = new JLabel("휴가 시작 일자");
        endDateTag = new JLabel("휴가 종료 일자");

        vacStartDate = new JDateChooser();
        vacEndDate = new JDateChooser();

        startDateTag.setBounds(50,10,100,30);
        endDateTag.setBounds(50,60,100,30);

        vacStartDate.setBounds(150,10,150,30);
        vacEndDate.setBounds(150,60,150,30);

        add(startDateTag);
        add(endDateTag);

        add(vacStartDate);
        add(vacEndDate);
    }

    /**
     * Desc : 휴가 사유를 입력하는 영역 생성
     */
    public void createContentsArea(){
        vacContents = new JTextArea();
        contentsPad = new JScrollPane(vacContents);

        contentsPad.setBounds(30, 100, 580,300);

        add(contentsPad);
    }

    /**
     * Desc : 휴가 신청 및 취소버튼 생성
     */
    public void createConfirmButton(){
        request = new JButton("신청");
        cancel = new JButton("취소");

        request.setBounds(50,430,100,50);
        cancel.setBounds(500,430,100,50);

        add(request);
        add(cancel);
    }

    public static void main(String[] args) {
        new RequestVacation();
    }
}
