package ggp.crudup.controller;
 
import ggp.crudup.dao.IUserDAO;
import ggp.crudup.entity.User;
import ggp.crudup.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
 
/*
 * author: ggp
 * 
 */
 
@Controller
public class MainController {

	@Autowired
	private IUserDAO UserDAO;

	@RequestMapping("/")
	public String home(Model model) {
		return "home";
	}



	@RequestMapping("/users")
	public String users(Model model) {

		List<User> users = UserDAO.getAllUser();
		model.addAttribute("users",users);

		return "users";
	}

	@RequestMapping(value = "/user-new" , method = RequestMethod.GET)
	public String newUserGET(Model model){
		model.addAttribute("userForm",new UserForm());
		return "user-form";
	}

	@RequestMapping(value = "/user-new" , method = RequestMethod.POST)
	public String newUserPOST(@ModelAttribute("userForm") UserForm userForm){

		String username  = userForm.getName();
		String email  = userForm.getEmail();

		System.out.println("username: " + username + "  ,email: "+ email);

		return "users";
	}
}