package kr.co.sist.view.admin;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
	
public class ShareDept extends JFrame {
	private JButton jbtncheck,jbtncancel;
	private JCheckBox jcbdevCeo,jcbdeMthq,jcbdevMtps,jcbdevMtqp,jcbdevSmtp,jcbdevMtst
	,jcbdevMtct,jcbdevIpt,jcbdevTteam,jcbdevPmtt,jcbdevhvmt,jcbdevIfmt;
	private JLabel jldevCeo,jldevMthq,jldevMtps,jldevMtqp,jldevSmtp,jldevMtst
	,jldevMtct,jldevIpt,jldevTteam,jldevPmtt,jldevhvmt,jldevIfmt;

	public ShareDept(){
		super("공유부서설정");
        setLayout(null);
        
        jbtncheck=new JButton("확인");
		jbtncancel=new JButton("취소");
		
		
		jcbdevCeo=new JCheckBox();
		jldevCeo=new JLabel("대표이사");
		
		
		jcbdeMthq=new JCheckBox();
		jldevMthq=new JLabel("정비본부");


		jcbdevMtps=new JCheckBox();
		jldevMtps=new JLabel("정비기획부분");

		
		jcbdevMtqp=new JCheckBox();
		jldevMtqp=new JLabel("정비품질부분");

		jcbdevSmtp=new JCheckBox();
		jldevSmtp=new JLabel("안전정비부분");
		
		jcbdevMtst=new JCheckBox();
		jldevMtst=new JLabel("정비지원팀");
		
		jcbdevMtct=new JCheckBox();
		jldevMtct=new JLabel("정비통제팀");
		
		jcbdevIpt=new JCheckBox();
		jldevIpt=new JLabel("검사팀");
		
		jcbdevTteam=new JCheckBox();
		jldevTteam=new JLabel("기술팀");
		
		jcbdevPmtt=new JCheckBox();
		jldevPmtt=new JLabel("예방정비팀");
		
		jcbdevhvmt=new JCheckBox();
		jldevhvmt=new JLabel("중정비팀");
		
		jcbdevIfmt=new JCheckBox();
		jldevIfmt=new JLabel("인천운항정비팀");
		
		
		
		jbtncheck.setBounds(150, 450, 100, 30);
		jbtncancel.setBounds(400, 450, 100, 30);
		jcbdevCeo.setBounds(30, 50, 50, 50);
		jcbdeMthq.setBounds(160, 50, 50, 50);
		jcbdevMtps.setBounds(300, 50, 50, 50);
		jcbdevMtqp.setBounds(450, 50, 50, 50);
		
		jcbdevSmtp.setBounds(30, 170, 50, 50);
		jcbdevMtst.setBounds(160, 170, 50, 50);
		jcbdevMtct.setBounds(300, 170, 50, 50);
		jcbdevIpt.setBounds(450, 170, 50, 50);
		
		jcbdevTteam.setBounds(30, 300, 50, 50);
		jcbdevPmtt.setBounds(160, 300, 50, 50);
		jcbdevhvmt.setBounds(300, 300, 50, 50);
		jcbdevIfmt.setBounds(450, 300, 50, 50);
		
		
		jldevCeo.setBounds(80, 60, 50, 30);
		jldevMthq.setBounds(210, 60, 50, 30);
		jldevMtps.setBounds(350, 60, 80, 30);
		jldevMtqp.setBounds(500, 60, 80, 30);
		jldevSmtp.setBounds(80, 180, 80, 30);
		jldevMtst.setBounds(210, 180, 80, 30);
		jldevMtct.setBounds(350, 180, 80, 30);
		jldevIpt.setBounds(500, 180, 80, 30);
		jldevTteam.setBounds(80, 310, 80, 30);
		jldevPmtt.setBounds(210, 310, 80, 30);
		jldevhvmt.setBounds(350, 310, 80, 30);
		jldevIfmt.setBounds(500, 310, 90, 30);
		
		
		add(jbtncheck);
		add(jbtncancel);
		add(jcbdevCeo);
		add(jcbdeMthq);
		add(jcbdevMtps);
		add(jcbdevMtqp);
		add(jcbdevSmtp);
		add(jcbdevMtst);
		add(jcbdevMtct);
		add(jcbdevIpt);
		add(jcbdevTteam);
		add(jcbdevPmtt);
		add(jcbdevhvmt);
		add(jcbdevIfmt);
		
		add(jldevCeo);
		add(jldevMthq);
		add(jldevMtps);
		add(jldevMtqp);
		add(jldevSmtp);
		add(jldevMtst);
		add(jldevMtct);
		add(jldevIpt);
		add(jldevTteam);
		add(jldevPmtt);
		add(jldevhvmt);
		add(jldevIfmt);
        
        setBounds(300,100,650,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public static void main(String[] args) {
        
		new ShareDept();
        
    }
}
