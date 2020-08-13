package repository;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSesseionFactory { //config.xml 연결 객체 생성
	 
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "mybatis/mybatis-config.xml";		
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			
			if(sqlSessionFactory == null) 
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		}catch (IOException e) {
			e.printStackTrace();
		}		
		}
		public static SqlSessionFactory getsqlSessionFactory() {
			return sqlSessionFactory;
			
		}
	}