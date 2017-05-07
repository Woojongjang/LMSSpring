package com.gcit.lms;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcit.lms.entity.Author;
import com.gcit.lms.service.AdminService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "welcome";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) {
		return "admin";
	}
	
	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public String author(Locale locale, Model model) {
		return "author";
	}
	
	@RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
	public String addAuthor(Locale locale, Model model) {
		return "addauthor";
	}
	
	@RequestMapping(value = "/viewAuthors", method = RequestMethod.GET)
	public String viewAuthors(Locale locale, Model model) {
		List<Author> authors = adminService.getAllAuthors(1);
		model.addAttribute("authors", authors);
		return "viewauthors";
	}
	
}
