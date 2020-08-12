package repository;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//query, sql, 질의어 : 데이터베이스
public class MybatisSessionFactory { //config + jdbc = 연결
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resouce = "mybatis/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resouce); //읽어오는거
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory sqlsessionfaFactory() {
		return sqlSessionFactory;
	}

}
