package ex;

import java.util.List;
import java.util.Scanner;

import model.Board;
import persistence.BoardDao;
import repository.MybatisSesseionFactory;

public class MainEx {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Board board = new Board();

		BoardDao dao = new BoardDao(MybatisSesseionFactory.getsqlSessionFactory());
		
		while (true) {
			System.out.println("�׸���ǻ�� �Խ����Դϴ�.");
			System.out.println("1.��� |2.��� |3.����|4.����| 5.�󼼺���");
			System.out.println("���� >> ");
			int ch = s.nextInt();
			s.nextLine();

			switch (ch) {
			
			case 1:
				int total = dao.selectCount();
				List<Board> list = dao.selectAll();
				System.out.println("��ϵ� �Խù��� [ " + total + "]�� �Դϴ�.");
				
				if(list.size()==0 ) {
					System.out.println("��ϵ� �Խù��� �����ϴ�.");
				}else {
//					for(int i = 0; i < list.size(); i++) {
//						System.out.println(list.get(i).toString());
//					}	
					for(Board b : list) {
						System.out.println(b.toString());
					}
				}
				break;

			case 2:
				System.out.println("�Խù� ���� >> ");
				board.setSubject(s.next());
				
				System.out.println("�Խù� �ۼ��� >> ");
				board.setWriter(s.next());
				
				System.out.println("�Խù� ���� >> ");
				board.setContent(s.next());
				
				dao.insertMember(board);
				System.out.println("�Խù��� ��ϵǾ����ϴ�.");
				
				break;

			case 3:				
				System.out.println("������ �⺻Ű�� �Է� : ");
				board.setBid(s.nextInt());
				s.nextLine();
				
				System.out.println("�Խù� ���� >> ");
				board.setSubject(s.next());
				
				System.out.println("�Խù� �ۼ��� >> ");
				board.setWriter(s.next());
				
				System.out.println("�Խù� ���� >> ");
				board.setContent(s.next());				
				dao.updateMember(board);
				
				System.out.println("�Խù��� �����Ǿ����ϴ�.");
				
				break;

			case 4:
				System.out.print("������ �⺻Ű�� �Է� (�ߺ�x) : ");
				board.setBid(s.nextInt());
				s.nextLine();
				
				if(board.getBid() == 0) {
					System.out.println("�⺻Ű�� �Է��ϼ���.");
					
				}else {
					dao.deleteMember(board.getBid());
					System.out.println("�Խù��� �����Ǿ����ϴ�.");
				}
				break;
				
			case 5:
				System.out.println("�󼼺��� �� �⺻Ű�� �Է� : ");
				board.setBid(s.nextInt());
				s.nextLine();
				
				dao.visitUp(board.getBid());
				board = dao.selectOne(board.getBid());
								
				System.out.println("�󼼺��� ������ ����մϴ�.");
				System.out.println("�Խù� ���� : " + board.getSubject());
				System.out.println("�Խù� �ۼ���  : " + board.getWriter());
				System.out.println("�Խù� ����  : " + board.getContent());
				System.out.println("�Խù� ��ȸ�� : " + board.getVisit());
				break;
			}
			System.out.println();
		}
	}
}
