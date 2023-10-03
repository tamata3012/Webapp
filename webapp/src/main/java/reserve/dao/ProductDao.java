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
				product.setLentalNumber(rs.getInt(4));
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
					product.setLentalNumber(rs.getInt(4));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return product;
	}
	
	public void changeNumber(int id,int lentalnum) throws Exception {
		
		String sql="update products set lental_number=lental_number+? where id=?";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){	
			stmt.setInt(1, lentalnum);
			stmt.setInt(2, id);
			stmt.executeUpdate(); 
		}
	}
}
