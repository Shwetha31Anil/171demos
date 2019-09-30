package com.mphasis.training.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Product;
import com.mphasis.training.services.ProductService;
import com.mphasis.training.services.ProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ProductService productService=new ProductServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Product p=new Product();
		p.setPid(Integer.parseInt(request.getParameter("pid")));
		p.setPname(request.getParameter("pname"));
		p.setCost(Integer.parseInt(request.getParameter("cost")));
		p.setQty(Integer.parseInt(request.getParameter("qty")));
		p.setBrand(request.getParameter("brand"));
		try {
		productService.addProduct(p);
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		}catch(BuisnessException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("add.jsp");
			rd.include(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
