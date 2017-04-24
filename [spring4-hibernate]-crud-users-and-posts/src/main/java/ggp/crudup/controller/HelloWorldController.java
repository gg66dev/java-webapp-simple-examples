package ggp.crudup.controller;
 
import ggp.crudup.dao.IUserDAO;
import ggp.crudup.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
 
/*
 * author: ggp
 * 
 */
 
@Controller
public class HelloWorldController  {

	@Autowired
	private IUserDAO UserDAO;



	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		List<User> users = UserDAO.getAllUser();

		String message = users.get(0).getName();

		//String message = "<br><div style='text-align:center;'>"
		//		+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from HelloWorldController.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}