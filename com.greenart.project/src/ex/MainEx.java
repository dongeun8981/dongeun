package ex;

import java.util.List;
import java.util.Scanner;

import model.Register;
import persistence.RegisterDao;
import repository.MybatisSessionFactory;

public class MainEx {

	public static void main(String[] args) {
		
		RegisterDao dao = new RegisterDao(MybatisSessionFactory.sqlsessionfaFactory());
		
		Scanner s = new Scanner(System.in);
		
		Register r = new Register();
		
		while(true) {
			System.out.println("mybatis ����");
			System.out.println("1.���|2.�߰�|3.����|4.����");
			System.out.println("���� >> ");
			int choice = s.nextInt();
			s.nextLine();
			
			switch(choice) {
			
			case 1:
				int cnt = dao.memberCount();
				List<Register> list = dao.memberList();
				System.out.println("���Ե� ȸ���� " + cnt + "�� �Դϴ�.");
				for(int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
				System.out.println();
				break;
				
			case 2:
				System.out.println("���̵� >> ");
				r.setUserid(s.next());
				System.out.println("��й�ȣ >> ");
				r.setPasswd(s.next());
				System.out.println("�̸� >> ");
				r.setName(s.next());
				System.out.println("�ּ� >> ");
				r.setAddr(s.next());
				System.out.println("�̸��� >> ");
				r.setEmail(s.next());
				System.out.println("���� >>");
				r.setAge(s.nextInt());
				
				s.nextLine();
				dao.memberInsert(r);
				System.out.println("ȸ���� ��ϵǾ����ϴ�.");
				System.out.println();
				break;
				
			case 3:
				break;
				
			case 4:
				break;
				
			case 5:
				return;
			}
		}
	}
}
