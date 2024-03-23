package kr.co.sist.view.user;

import com.toedter.calendar.JDateChooser;
import kr.co.sist.controller.event.RequestVacationEvent;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private JButton requestJbtn;
    private JButton cancelJbtn;
    private String startDate;
    private String endDate;
    private Date sDate;
    private Date eDate;


    /**
     * Desc : 휴가 신청 main frame 구현
     */
    public RequestVacation() {
        setTitle("휴가 신청");
        setLayout(null);

        createVacDate();
        createContentsArea();
        createConfirmButton();
        createEvent();

        setBounds(300, 100, 650, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Desc : 휴가 시작일과 종료일을 설정하는 영역 생성
     */
    public void createVacDate() {
        startDateTag = new JLabel("휴가 시작 일자");
        endDateTag = new JLabel("휴가 종료 일자");

        vacStartDate = new JDateChooser();
        vacEndDate = new JDateChooser();

        startDateTag.setBounds(50, 10, 100, 30);
        endDateTag.setBounds(50, 60, 100, 30);

        vacStartDate.setBounds(150, 10, 150, 30);
        vacEndDate.setBounds(150, 60, 150, 30);

        add(startDateTag);
        add(endDateTag);

        add(vacStartDate);
        add(vacEndDate);
    }

    /**
     * Desc : 휴가 사유를 입력하는 영역 생성
     */
    public void createContentsArea() {
        vacContents = new JTextArea();
        contentsPad = new JScrollPane(vacContents);

        contentsPad.setBounds(30, 100, 580, 300);

        add(contentsPad);
    }

    /**
     * Desc : 휴가 신청 및 취소버튼 생성
     */
    public void createConfirmButton() {
        requestJbtn = new JButton("신청");
        cancelJbtn = new JButton("취소");

        requestJbtn.setBounds(50, 430, 100, 50);
        cancelJbtn.setBounds(500, 430, 100, 50);

        add(requestJbtn);
        add(cancelJbtn);
    }

    /**
     * Desc : JDateChooser의 이벤트 처리
      */
    public void createDateEvent(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        PropertyChangeListener dateChangeListener = evt -> {
            if ("date".equals(evt.getPropertyName())) {
                if (evt.getSource() == vacStartDate.getDateEditor()) {
                    startDate = simpleDateFormat.format(vacStartDate.getDate());
                    try {
                        simpleDateFormat.parse(startDate);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                } else if (evt.getSource() == vacEndDate.getDateEditor()) {
                    endDate = simpleDateFormat.format(vacEndDate.getDate());
                    try {
                        simpleDateFormat.parse(endDate);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        vacStartDate.getDateEditor().addPropertyChangeListener(dateChangeListener);
        vacEndDate.getDateEditor().addPropertyChangeListener(dateChangeListener);

        this.add(vacStartDate);
        this.add(vacEndDate);
    }

    /**
     * Desc : Event 추가
     */
    public void createEvent() {
        RequestVacationEvent requestVacationEvent = new RequestVacationEvent(this);
        requestJbtn.addActionListener(requestVacationEvent);
        cancelJbtn.addActionListener(requestVacationEvent);
        createDateEvent();
    }

    public JButton getRequestJbtn() {
        return requestJbtn;
    }

    public JButton getCancelJbtn() {
        return cancelJbtn;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public JTextArea getVacContents() {
        return vacContents;
    }


    public Date getsDate() {
        return sDate;
    }

    public Date geteDate() {
        return eDate;
    }

    public JDateChooser getVacStartDate() {
		return vacStartDate;
	}

	public JDateChooser getVacEndDate() {
		return vacEndDate;
	}

	public static void main(String[] args) {
        new RequestVacation();
    }
}
