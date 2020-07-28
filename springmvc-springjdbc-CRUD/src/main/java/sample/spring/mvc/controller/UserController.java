package sample.spring.mvc.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sample.spring.mvc.form.UserForm;
import sample.spring.mvc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * VIEW PATH
	 */
	private static final String PATH_PREFIX = "user/";

	@Resource
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		
		UserForm userForm = new UserForm(); 
		
		userForm.setList(this.userService.list());

		model.put("userForm", userForm);
		
		return PATH_PREFIX + "list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Map<String, Object> model) {
		
		return PATH_PREFIX + "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(UserForm userForm,
			BindingResult result, Map<String, Object> model) {
		
		if (result.hasErrors()) {
			
			return new ModelAndView("add");
		}
		
		userService.insert(userForm.getUserDto());
		return new ModelAndView("redirect:../user?t="+new Date().getTime());
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String getUpdateCustomerPage(@PathVariable long id, ModelMap model) {
		
		UserForm userForm = new UserForm(); 
		
		userForm.setUserDto(userService.get(id));
		
		model.put("userForm", userForm);
		return PATH_PREFIX + "update";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(UserForm userForm,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return new ModelAndView("update");
		}
		
		userService.update(userForm.getUserDto());
		
		// return to list
		return new ModelAndView("redirect:/user?t="+new Date().getTime());
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable long id,
			HttpServletRequest request, ModelMap model) {
		
		userService.delete(id);
		// return to list
		return new ModelAndView("redirect:/user?t="+new Date().getTime());

	}
	
}
