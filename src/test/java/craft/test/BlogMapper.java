package craft.test;

import org.apache.ibatis.annotations.Select;

public interface BlogMapper {
	@Select("select * from blog where id=#{id}")
	Blog selectBlog(int id);
}
