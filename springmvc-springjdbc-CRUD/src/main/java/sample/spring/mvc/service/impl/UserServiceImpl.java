package sample.spring.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.spring.mvc.dao.UserDao;
import sample.spring.mvc.dao.entity.User;
import sample.spring.mvc.dto.UserDto;
import sample.spring.mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Transactional
	@Override
	public List<UserDto> list() {
		List<UserDto> l = new ArrayList<UserDto>();
		for (User u : userDao.list()) {
			UserDto ud = new UserDto();
			ud.setId(u.getId());
			ud.setUserName(u.getUserName());
			ud.setPassWord(u.getPassWord());
			ud.setEmail(u.getEmail());
			l.add(ud);
		}
		return l;
	}

	@Override
	public int insert(UserDto dto) {
		User user = new User();
		user.setUserName(dto.getUserName());
		user.setPassWord(dto.getPassWord());
		user.setEmail(dto.getEmail());
		return this.userDao.insert(user);
	}

	@Override
	public int update(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setUserName(dto.getUserName());
		user.setPassWord(dto.getPassWord());
		user.setEmail(dto.getEmail());
		return this.userDao.update(user);
	}

	@Override
	public int delete(long id) {
		return this.userDao.delete(id);
	}

	@Override
	public UserDto get(long id) {
		User user = this.userDao.get(id);
		if (user == null) {
			return null;
		}
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUserName(user.getUserName());
		dto.setPassWord(user.getPassWord());
		dto.setEmail(user.getEmail());
		return dto;
	}
}
