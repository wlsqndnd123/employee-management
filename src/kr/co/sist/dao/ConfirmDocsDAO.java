package kr.co.sist.dao;

public class ConfirmDocsDAO {
	private ConfirmDocsDAO cfDAO;
	private ConfirmDocsDAO() {
		
	}
	public ConfirmDocsDAO getInstance() {
		if(cfDAO ==null) {
			cfDAO = new ConfirmDocsDAO();
		}
		return cfDAO;
	}
	
	public void updateConfirmDoc() {
		
	}
}
