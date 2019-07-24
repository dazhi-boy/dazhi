package craft.test;

public interface BlogMapper {
//	@Select("select * from blog where id=#{id}")
	Blog selectBlog(int id);
}
