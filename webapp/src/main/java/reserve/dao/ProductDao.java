package reserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reserve.Product;
import tool.Dao;

public class ProductDao extends Dao {

	public List<Product> select(String keyword) throws Exception {
		
		List<Product> productList=new ArrayList<>();
		String sql="select * from products where name like ? ORDER BY id";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, "%"+keyword+"%");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				Product product=new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNumber(rs.getInt(3));
				product.setRentalNumber(rs.getInt(4));
				productList.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}
		
	public Product selectById(int id) throws Exception {
			
			Product product=new Product();
			String sql="select * from products where id=?";
			
	
			try(Connection con=getConnection();
					PreparedStatement stmt =con.prepareStatement(sql)){
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				
				while(rs.next()) {
					product.setId(rs.getInt(1));
					product.setName(rs.getString(2));
					product.setNumber(rs.getInt(3));
					product.setRentalNumber(rs.getInt(4));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return product;
	}
	
	public int updateNumber(int id,int rentalnumber) throws SQLException, Exception {
		String sql="update products set rental_number=?,number=number+?-rental_number where id = ? ";
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){	
			stmt.setInt(1, rentalnumber);
			stmt.setInt(2, rentalnumber);
			stmt.setInt(3, id);
			int count=stmt.executeUpdate();
			
			return count;
		}
	}
	
	public void changeNumber(int id,int rentalnum) throws Exception {
		
		String sql="update products set rental_number=rental_number+? where id=?";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){	
			stmt.setInt(1, rentalnum);
			stmt.setInt(2, id);
			stmt.executeUpdate(); 
		}
	}
}
