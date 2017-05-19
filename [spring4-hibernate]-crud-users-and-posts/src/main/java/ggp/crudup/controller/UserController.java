package ggp.crudup.controller;
 
import ggp.crudup.entity.User;
import ggp.crudup.form.UserForm;
import ggp.crudup.services.UserService;
import ggp.crudup.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import java.util.List;
import java.util.Map;
 
/*
 * author: ggp
 * 
 */
 
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home(Model model) {
		return "home";
	}



	@RequestMapping("/users")
	public String users(Model model) {

		List<User> users = userService.getUsers();
		model.addAttribute("users",users);

		return "users";
	}

	@RequestMapping(value = "/user-new" , method = RequestMethod.GET)
	public String newUserGET(Model model){
		model.addAttribute("userForm",new UserForm());
		return "user-form";
	}

	@RequestMapping(value = "/user-new" , method = RequestMethod.POST)
	public String newUserPOST(
			Model model,
			@ModelAttribute("userForm") UserForm userForm){

		String username  = userForm.getName();
		String email  = userForm.getEmail();
		String phone = userForm.getPhone();

		System.out.println("username: " + username + "  ,email: "+ email + "  ,phone: " + phone);
		if(username != null && email != null && phone != null)
			userService.saveUser(Converter.convertTo(userForm));

		System.out.println("username: " + username + "  ,email: "+ email);

		return "users";
	}

}

