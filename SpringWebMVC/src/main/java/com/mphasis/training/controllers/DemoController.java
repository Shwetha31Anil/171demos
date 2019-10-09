package com.mphasis.training.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.training.entities.Muser;
import com.mphasis.training.entities.Product;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.services.MuserService;
import com.mphasis.training.services.ProductService;

@Controller
public class DemoController {
	
	@Autowired
	MuserService muserService;
	@Autowired
	ProductService productService;
	
	
	@RequestMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String getSignupPage() {
		return "signup";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView getregister(@RequestParam("lname")String uname,
			@RequestParam("pass")String pass) {
		ModelAndView mv=new ModelAndView();
		Muser muser=new Muser();
		
		try {
			muser.setUsername(uname);
			muser.setPass(pass);
			System.out.println("values");
			int i=muserService.registerUser(muser);
			mv.setViewName("welcome");	
			mv.addObject("rname",muser.getUsername());
			
		} catch (Exception e) {
			mv.setViewName("signup");
			mv.addObject("error",e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public ModelAndView getLogin(@RequestParam("lname")String uname,
			@RequestParam("pass")String pass, HttpSession session) {
		ModelAndView mv=new ModelAndView();
		Muser muser;
		try {
			System.out.println("values");
			muser=muserService.login(uname, pass);
			mv.addObject("rname",muser.getUsername());
			session.setAttribute("sname", muser.getUsername());
		if(muser.getRole().equals("admin")) {
			mv.setViewName("adminview");		
		}else if(muser.getRole().equals("customer")) {
			mv.setViewName("customerview");	
		}
		} catch (Exception e) {
			mv.setViewName("login");
			mv.addObject("error",e.getMessage());
			
		}
		return mv;
	}
	
	@RequestMapping("/products")
	public ModelAndView getProducts() {
		ModelAndView mv=new ModelAndView();
		try {
			mv.addObject("listproduct",productService.getAll());
			mv.setViewName("products");
		} catch (BuisnessException e) {
			mv.addObject("error", e.getMessage());
			mv.setViewName("products");
		}
		return mv;
	}
	
	@RequestMapping("/aproducts")
	public ModelAndView getAdminProducts() {
		ModelAndView mv=new ModelAndView();
		try {
			mv.addObject("listproduct",productService.getAll());
			mv.setViewName("aproducts");
		} catch (BuisnessException e) {
			mv.addObject("error", e.getMessage());
			mv.setViewName("aproducts");
		}
		return mv;
	}
	
	@RequestMapping("/delete/{pid}")
	public String getdelete(@PathVariable("pid")int pid) {
		try {
			productService.removeProduct(pid);
		} catch (BuisnessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/aproducts";
	}
	
	@RequestMapping("/addproduct")
	public String addProductPage(Model model) {
		
		model.addAttribute("product",new Product());
		
		return "addproduct";
	}
	
	@RequestMapping(value="/add/Product",
			method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Product p,
			Model model) {
		try {
			if(p.getPid()==0) {
				System.out.println(p.getPid()+"ading");
			productService.addProduct(p);
			}
			else {
				System.out.println(p.getPid()+"editing");
				productService.updateProduct(p);
			}
			return "redirect:/aproducts";
		} catch (BuisnessException e) {
		model.addAttribute("error", e.getMessage());
		return "addproduct";
		}
		
	}
		
	
	@RequestMapping("/edit/{pid}")
    public String editPerson(@PathVariable("pid") int id,
    		Model model){
		try {
    	System.out.println("edit called"+model.getClass());
    	Product cu=this.productService.getProductById(id);
        model.addAttribute("product",cu );
       // model.addAttribute("customers", this.productService.getAll());
		}catch(BuisnessException e) {
			e.printStackTrace();
		}
		return "addproduct";
    }

	@RequestMapping("/logout")
	public String getLogout(HttpSession session) {
		session.removeAttribute("sname");
		session.invalidate();
		return "login";
	}

}
