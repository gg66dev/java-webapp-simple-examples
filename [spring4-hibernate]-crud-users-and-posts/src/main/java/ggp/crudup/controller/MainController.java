package ggp.crudup.controller;
 
import ggp.crudup.dao.IUserDAO;
import ggp.crudup.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
 
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
}