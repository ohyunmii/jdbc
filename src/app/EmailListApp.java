package app;

import java.util.List;
import java.util.Scanner;

import dao.EmailListDao;
import vo.EmailListVo;

public class EmailListApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Insert > ");
			String line = scanner.nextLine();
			if("quit".equals(line)) break;
			
			String[] tokens = line.split(" ");

			EmailListVo vo = new EmailListVo();
			vo.setFirstName(tokens[0]);
			vo.setLastName(tokens[1]);
			vo.setEmail(tokens[2]);

			EmailListDao dao = new EmailListDao();
			dao.insert(vo);

			System.out.println("============= Email List ==============");
			List<EmailListVo> list = dao.findAll();
			for (EmailListVo v : list) {
				System.out.println(v);
			}
			System.out.println("=======================================");
		}
		scanner.close();
		System.exit(0);
	}
}
