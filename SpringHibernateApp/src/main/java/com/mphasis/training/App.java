package com.mphasis.training;


import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mphasis.training.conf.AppConfig;
import com.mphasis.training.daos.ProductDao;
import com.mphasis.training.enities.Product;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.services.ProductService;
import com.mphasis.training.services.ProductServiceImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=
        new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner sc=new Scanner(System.in);
    ProductService productService=
        		context.getBean("productServiceImpl",ProductServiceImpl.class);
      do {
        System.out.println("List of Products available");
      try {
      List<Product> products=productService.getAll();
      System.out.println("Pid \t pname \t cost \t qty \t brand");
      for(Product p:products)
      System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getPcost()+"\t"+p.getQty()+"\t"+p.getBrand());
      }catch(BuisnessException e) {
    	  System.out.println(e.getMessage());
      }
      System.out.println("1. Retrive ById\n "
      		+ "2.AddProduct\n 3.Edit Product"
      		+ "\n 4. Delete Product \n 5. Exit");
      int choice=sc.nextInt();
      switch(choice) {
      case 1:System.out.println("enter id to retirve");
		try {
			Product p=productService.getProductById(sc.nextInt());
			 System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getPcost()+"\t"+p.getQty()+"\t"+p.getBrand());
		} catch (BuisnessException e) {
			System.out.println(e.getMessage());
		}
		break;
      case 2:System.out.println("enter pid,name,cost and qty");
		try {
			Product product=new Product();
			product.setPid(sc.nextInt());
			product.setPname(sc.next());
			product.setPcost(sc.nextDouble());
			product.setQty(sc.nextInt());
			System.out.println("do you want to enter brand");
			char c=sc.next().charAt(0);
			if(c=='y')
				product.setBrand(sc.next());
			productService.addProduct(product);
		} catch (BuisnessException e) {
			System.out.println(e.getMessage());
		}
		break;
      case 3: System.out.println("enter cost and qty to update pid");
		try {
			Product p=productService.getProductById(sc.nextInt());
			p.setPcost(sc.nextDouble());
			p.setQty(sc.nextInt());
			productService.updateProduct(p);
			System.out.println("product updated");
		} catch (BuisnessException e) {
			System.out.println(e.getMessage());
		}
		break;
      case 4: System.out.println("enter pid to delete");
		try {
			productService.removeProduct(sc.nextInt());
			System.out.println("product deleted");
		} catch (BuisnessException e) {
			System.out.println(e.getMessage());
		}
		break;
      case 5: System.out.println("Thank you");
      			System.exit(0);
      default:System.out.println("invalid option");			
      }
      }while(true);
    }
}
