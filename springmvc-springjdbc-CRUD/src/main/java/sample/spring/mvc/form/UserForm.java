
package sample.spring.mvc.form;

import java.util.List;

import sample.spring.mvc.dto.UserDto;

/**
 * 
 */
public class UserForm {

	private UserDto userDto;

	private List<UserDto> list;

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public List<UserDto> getList() {
		return list;
	}

	public void setList(List<UserDto> list) {
		this.list = list;
	}

}
