package sample.spring.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class MenuController {

	/**
	 * VIEW PATH
	 */
	private static final String page = "menu";


	@RequestMapping(method = RequestMethod.GET)
	public String list(Map<String, Object> model) {
		
		
		return page;
	}

	
}
