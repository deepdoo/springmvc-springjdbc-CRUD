package sample.spring.mvc.dao;

import java.util.List;

import sample.spring.mvc.dao.entity.User;


public interface UserDao {

	List<User> list();
	
	int insert(User u);
	
	int update(User u);
	
	int delete(long id);
	
	User get(long id);
}
