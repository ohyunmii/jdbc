package dao.test;

import dao.EmailListDao;
import vo.EmailListVo;

public class EmailListDaoTest {

	public static void main(String[] args) {
		insertTest();
	}
	
	public static void insertTest(){
		
		EmailListVo vo = new EmailListVo();
		vo.setFirstName("Minsu");
		vo.setLastName("Lee");
		vo.setEmail("vsat123@gmail.com");
		
		
		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
	}

}
