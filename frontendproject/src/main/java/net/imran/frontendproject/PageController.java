package net.imran.frontendproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.imran.backendproject.dao.CategoryDAO;
import net.imran.backendproject.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}

	@RequestMapping(value ="/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value ="/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping(value ="/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "signup");
		mv.addObject("userClickSignup",true);
		return mv;
	}
	
	@RequestMapping(value ="/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "login");
		mv.addObject("userClickLogin",true);
		return mv;
	}
	
	/*
	 * method to load all the products
	 */

	@RequestMapping(value ="/show/all/products")
	public ModelAndView ShowALlProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		//passing the list of category
		
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;				
	}
	
	@RequestMapping(value ="/product")
	public ModelAndView product() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "product");
		mv.addObject("userClickProduct",true);
		return mv;
	}
}
