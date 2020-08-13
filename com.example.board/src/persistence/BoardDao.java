package persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Board;

public class BoardDao { // session + mapper => 메소드 형태로 만드는 작업
	// 생성자 -> 연결(opensession) -> xml 사용하면

	private static SqlSessionFactory sqlSessionFactory;

	public BoardDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Board> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Board> list = null;

		try {
			list = session.selectList("mybatis.BoardMapper.selectAll");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}

		return list;
	}

	public int selectCount() {

		SqlSession session = sqlSessionFactory.openSession();

		int sum = 0;

		try {
			sum = session.selectOne("mybatis.BoardMapper.selectCount");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return sum;
	}

	public Board selectOne(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		Board b = null;

		try {
			b = session.selectOne("mybatis.BoardMapper.selectOne", num);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return b;
	}

	// 테이블에 데이터 변화가 일어나면 commit() - rollback
	public void insertMember(Board b) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("mybatis.BoardMapper.insertMember", b);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.commit();
			session.close();
		}
	}

	public void deleteMember(int num) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.delete("mybatis.BoardMapper.deleteMember", num);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.commit();
			session.close();
		}
	}

	public void updateMember(Board b) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("mybatis.BoardMapper.updateMember", b);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.commit();
			session.close();
		}

	}

	public void visitUp(int num) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.insert("mybatis.BoardMapper.visitUp", num);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.commit();
			session.close();
		}
	}
}
