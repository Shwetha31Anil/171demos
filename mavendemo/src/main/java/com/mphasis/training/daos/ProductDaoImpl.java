package com.mphasis.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Product;
import com.mphasis.training.util.DbUtil;

public class ProductDaoImpl implements ProductDao {

	Connection con=null;
	public ProductDaoImpl() {
		con=DbUtil.openConnection();
	}
	
	
	public void insertProduct(Product p)throws BuisnessException {
		try {
		PreparedStatement pst=con.prepareStatement("insert into product values(?,?,?,?,?)");
		pst.setInt(1, p.getPid());
		pst.setString(2, p.getPname());
		pst.setInt(3, p.getCost());
		pst.setInt(4, p.getQty());
		pst.setString(5, p.getBrand());
		pst.executeUpdate();
		}catch(SQLException e) {
		throw new BuisnessException("SQL error");	
		}
	}

	public void updateProduct(int pid, int price, int qty)throws BuisnessException {
		try {
			PreparedStatement pst=con.prepareStatement(
				"update product set cost=?,qty=? where pid=?");
			pst.setInt(1, price);
			pst.setInt(2,qty);
			pst.setInt(3, pid);
			pst.executeUpdate();
		}catch(SQLException e) {
			throw new BuisnessException("SQL error");
		}

	}

	public void deleteProduct(int pid)throws BuisnessException {
		try {
			PreparedStatement pst=con.prepareStatement
					("delete from product where pid=?");
			pst.setInt(1, pid);
			pst.executeUpdate();
		}catch(SQLException e) {
			throw new BuisnessException("SQL error");
		}
	}

	public List<Product> getAll()throws BuisnessException {
		List<Product> products=new ArrayList<>();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from product");
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setCost(rs.getInt(3));
				p.setQty(rs.getInt(4));
				p.setBrand(rs.getString(5));
				products.add(p);
			}
			if(products.isEmpty()) {
				throw new BuisnessException("products are not availabe");
			}
		}catch(SQLException e) {
			throw new BuisnessException("Sql Error");
		}
		return products;
	}

	public Product getProductById(int pid)throws BuisnessException {
		Product p=new Product();
		try {
			PreparedStatement pst=con.prepareStatement
					("select * from product where pid=?");
			pst.setInt(1, pid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setCost(rs.getInt(3));
				p.setQty(rs.getInt(4));
				p.setBrand(rs.getString(5));
			}
		}catch(SQLException e) {
			throw new BuisnessException("Sql error");
		}
		return p;
	}

}
