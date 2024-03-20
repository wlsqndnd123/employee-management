package dao;

import java.util.List;

import vo.EmpInfoVO;

public class CheckEmployeeInformationDAO {
	private static CheckEmployeeInformationDAO checkEmpDAO;
	private CheckEmployeeInformationDAO() {
		
	}
	
	public static CheckEmployeeInformationDAO getInstance(CheckEmployeeInformationDAO checkEmpDAO) {
		if(checkEmpDAO==null) {
			checkEmpDAO = new CheckEmployeeInformationDAO();
		}
		
		return checkEmpDAO;
		
	}
	
	/**
	 * 각각의 선택 창(TextFiled, ComboBox,)에서 입력받은 값들로 DB 내의 사원정보를 찾아 
	 * list에 출력하는 method.
	 * 
	 * @param enpno : textFiled로 입력받은 값
	 * @param dept
	 * @param hiredate
	 * @param position
	 * @return
	 * 작성자: 김일신
	 */
	public List<EmpInfoVO> searchselectEmpInfo(String enpno,Object dept,Object hiredate ,Object position){
		
		
		
		return null;
		
	}
}
