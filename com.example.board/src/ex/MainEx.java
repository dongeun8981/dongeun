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
			System.out.println("그린컴퓨터 게시판입니다.");
			System.out.println("1.목록 |2.등록 |3.수정|4.삭제| 5.상세보기");
			System.out.println("선택 >> ");
			int ch = s.nextInt();
			s.nextLine();

			switch (ch) {
			
			case 1:
				int total = dao.selectCount();
				List<Board> list = dao.selectAll();
				System.out.println("등록된 게시물은 [ " + total + "]개 입니다.");
				
				if(list.size()==0 ) {
					System.out.println("등록된 게시물이 없습니다.");
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
				System.out.println("게시물 제목 >> ");
				board.setSubject(s.next());
				
				System.out.println("게시물 작성자 >> ");
				board.setWriter(s.next());
				
				System.out.println("게시물 내용 >> ");
				board.setContent(s.next());
				
				dao.insertMember(board);
				System.out.println("게시물이 등록되었습니다.");
				
				break;

			case 3:				
				System.out.println("수정할 기본키를 입력 : ");
				board.setBid(s.nextInt());
				s.nextLine();
				
				System.out.println("게시물 제목 >> ");
				board.setSubject(s.next());
				
				System.out.println("게시물 작성자 >> ");
				board.setWriter(s.next());
				
				System.out.println("게시물 내용 >> ");
				board.setContent(s.next());				
				dao.updateMember(board);
				
				System.out.println("게시물이 수정되었습니다.");
				
				break;

			case 4:
				System.out.print("삭제할 기본키를 입력 (중복x) : ");
				board.setBid(s.nextInt());
				s.nextLine();
				
				if(board.getBid() == 0) {
					System.out.println("기본키를 입력하세요.");
					
				}else {
					dao.deleteMember(board.getBid());
					System.out.println("게시물이 삭제되었습니다.");
				}
				break;
				
			case 5:
				System.out.println("상세보기 할 기본키를 입력 : ");
				board.setBid(s.nextInt());
				s.nextLine();
				
				dao.visitUp(board.getBid());
				board = dao.selectOne(board.getBid());
								
				System.out.println("상세보기 내용을 출력합니다.");
				System.out.println("게시물 제목 : " + board.getSubject());
				System.out.println("게시물 작성자  : " + board.getWriter());
				System.out.println("게시물 내용  : " + board.getContent());
				System.out.println("게시물 조회수 : " + board.getVisit());
				break;
			}
			System.out.println();
		}
	}
}
