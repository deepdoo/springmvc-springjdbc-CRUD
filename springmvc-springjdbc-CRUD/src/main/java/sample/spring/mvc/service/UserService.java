package sample.spring.mvc.service;

import java.util.List;

import sample.spring.mvc.dto.UserDto;


public interface UserService {

	List<UserDto> list();
	
	int insert(UserDto dto);
	
	int update(UserDto dto);
	
	int delete(long id);
	
	UserDto get(long id);
}
