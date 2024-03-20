package dao;

import vo.EmpInfoVO;

public class CreateEmployeeInformationDAO {
	static private CreateEmployeeInformationDAO ceiDAO ;
	
	private CreateEmployeeInformationDAO() {
		
	}
	public static CreateEmployeeInformationDAO getInstance(CreateEmployeeInformationDAO ceiDAO) {
		if(ceiDAO==null) {
			ceiDAO = new CreateEmployeeInformationDAO();
		}
		return ceiDAO;
}
	/**
	 * TextField에서 입력받은 사원의 정보들을 DB내에 추가하는 매서드.
	 * @param eVO
	 * @return
	 * 작성자: 김일신
	 */
	public int addEmpInfo(EmpInfoVO eVO) {
		
		
		return 0;
		
	}
}
