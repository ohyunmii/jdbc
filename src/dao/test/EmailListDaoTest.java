package dao.test;

import java.util.List;

import dao.EmailListDao;
import vo.EmailListVo;

public class EmailListDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}
	
	public static void findAllTest() {
		List<EmailListVo> list = new EmailListDao().findAll();
		for(EmailListVo vo:list) {
			System.out.println(vo);
		}
	}
	
	public static void insertTest(){
		
		EmailListVo vo = new EmailListVo();
		vo.setFirstName("Mingu");
		vo.setLastName("Lee");
		vo.setEmail("mingumingu@gmail.com");
		
		
		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
	}

}
