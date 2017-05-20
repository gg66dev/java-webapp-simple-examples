package ggp.crudup.controller;
 
import ggp.crudup.entity.User;
import ggp.crudup.form.UserForm;
import ggp.crudup.services.UserService;
import ggp.crudup.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import javax.websocket.server.PathParam;
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
		model.addAttribute("errorMessage",false);
		return "user-form";
	}

	@RequestMapping(value = "/user-new" , method = RequestMethod.POST)
	public String newUserPOST(
			Model model,
			@ModelAttribute("userForm") UserForm userForm){

		if(userForm.isValid()){
			userService.saveUser(Converter.convertTo(userForm));
			List<User> users = userService.getUsers();
			model.addAttribute("users",users);
			return "users";
		}


		model.addAttribute("errorMessage",true);
		model.addAttribute("userForm",userForm);
		return "user-form";
	}

	@RequestMapping(value = "/validate/{field}", method = RequestMethod.GET)
	public @ResponseBody
	boolean validateField(
			@PathVariable(value="field") String field,
			@RequestParam(value = "value", required = true) String value
	){
		if(field != null && field.length() > 0 && value != null && value.length() > 0 ){
			User user = null;
			if(field.equals("name")){
				user = userService.getUserByName(value);
			}else if(field.equals("email")){
				user = userService.getUserByEmail(value);
			}
			if(user != null)
				return true;
		}
		return false;
	}
}

