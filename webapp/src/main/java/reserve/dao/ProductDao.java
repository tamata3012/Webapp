package reserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reserve.Product;
import tool.Dao;
import tool.RentalException;
import tool.RentalRuntimeException;

public class ProductDao extends Dao {

	public List<Product> select(String keyword) throws RentalException, RentalRuntimeException {
		
		List<Product> productList=new ArrayList<>();
		String sql="select * from products where name like ? ORDER BY id";
		
		Product product=null;

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, "%"+keyword+"%");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				product=new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setNumber(rs.getInt(3));
				product.setRentalNumber(rs.getInt(4));
				productList.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		
		return productList;
	}
	
	public Product selectByName(String name) throws RentalException, RentalRuntimeException {
		
		Product product=null;
		String sql="select name from products where name=?";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				product=new Product();
				product.setName(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		
		return product;
}
		
	public Product selectById(int id) throws RentalException, RentalRuntimeException{
			
			Product product=null;
			String sql="select * from products where id=?";
			
	
			try(Connection con=getConnection();
					PreparedStatement stmt =con.prepareStatement(sql)){
				stmt.setInt(1, id);
				ResultSet rs=stmt.executeQuery();
				
				while(rs.next()) {
					product=new Product();
					product.setId(rs.getInt(1));
					product.setName(rs.getString(2));
					product.setNumber(rs.getInt(3));
					product.setRentalNumber(rs.getInt(4));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RentalException("システムエラーが発生しました。");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RentalRuntimeException("エラーが発生しました。");
			}
			return product;
	}
	
	public void register(String name,int number) throws RentalException, RentalRuntimeException {
		
		String sql="insert into products(name,number,rental_number) values(?,?,?)";
		
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){	
			stmt.setString(1, name);
			stmt.setInt(2, number);
			stmt.setInt(3, number);
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
	}
	
	public int updateNumber(int id,int rentalnumber) throws RentalException, RentalRuntimeException {
		
		String sql="update products set rental_number=?,number=number+?-rental_number where id = ? ";
		int count;
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){	
			stmt.setInt(1, rentalnumber);
			stmt.setInt(2, rentalnumber);
			stmt.setInt(3, id);
			count=stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		return count;
	}
	
	public void changeNumber(int id,int rentalnum) throws RentalException, RentalRuntimeException{
		
		String sql="update products set rental_number=rental_number+? where id=?";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){	
			stmt.setInt(1, rentalnum);
			stmt.setInt(2, id);
			stmt.executeUpdate(); 
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
	}
}
