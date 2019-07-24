package craft.test;

import java.io.IOException;
import java.io.InputStream;

import craft.io.Resources;
import craft.session.SqlSessionFactory;
import craft.session.SqlSessionFactoryBuilder;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConTest {

	public static void main(String[] args) {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			/*SqlSession session = sqlSessionFactory.openSession();
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			Blog blog = mapper.selectBlog(101);
			System.out.println(blog.toString());
			Blog blog2 = mapper.selectBlog(101);
			System.out.println(blog2.toString());*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
