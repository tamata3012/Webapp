package reserve.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reserve.Rental;
import tool.Dao;

public class ReserveDao extends Dao {

	public ReserveDao() {
		
	}
	
	
	public Rental selectById(int id) throws Exception{
		
		Rental rental=new Rental();
		String sql="select rental.id,rental.product_id,rental.rentalnumber,rental.user_name,rental.rental_date,rental.return_date,product.name "
				+ "from rentals as rental left join products as product on rental.product_id=product.id where rental.id=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				rental.setId(rs.getInt(1));
				rental.setProductId(rs.getInt(2));
				rental.setRentalNumber(rs.getInt(3));
				rental.setuserName(rs.getString(4));
				rental.setRentalDate(rs.getDate(5));
				rental.setReturnDate(rs.getDate(6));
				rental.setProductName(rs.getString(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rental;
	}
	
	public List<Rental> select() throws Exception {
		
		List<Rental> rentalList=new ArrayList<>();
		String sql="with rental as(select * from rentals),"
				+ "product as(select * from products) "
				+ "select rental.id,rental.product_id,rental.rentalnumber,rental.user_name,rental.rental_date,rental.return_date,product.name "
				+ "from rental left join product on rental.product_id=product.id";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				Rental rental=new Rental();
				rental.setId(rs.getInt(1));
				rental.setProductId(rs.getInt(2));
				rental.setRentalNumber(rs.getInt(3));
				rental.setuserName(rs.getString(4));
				rental.setRentalDate(rs.getDate(5));
				rental.setReturnDate(rs.getDate(6));
				rental.setProductName(rs.getString(7));
				rentalList.add(rental);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rentalList;
		
	}

	
	public List<Rental> selectByUser(String name) throws Exception {
		
		List<Rental> rentalList=new ArrayList<>();
		String sql="with rental as(select * from rentals where user_name=?),"
				+ "product as(select * from products) "
				+ "select rental.id,rental.product_id,rental.rentalnumber,rental.user_name,rental.rental_date,rental.return_date,product.name "
				+ "from rental left join product on rental.product_id=product.id";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				Rental rental=new Rental();
				rental.setId(rs.getInt(1));
				rental.setProductId(rs.getInt(2));
				rental.setRentalNumber(rs.getInt(3));
				rental.setuserName(rs.getString(4));
				rental.setRentalDate(rs.getDate(5));
				rental.setReturnDate(rs.getDate(6));
				rental.setProductName(rs.getString(7));
				rentalList.add(rental);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rentalList;
		
	}

	public int register(int id,int number,String name,String returnDate) throws Exception {
		
		String sql="insert into rentals(product_id,rentalnumber,user_name,rental_date,return_date,status) values(?,?,?,current_date,?,0)";
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setInt(1,id);
			stmt.setInt(2, number);
			stmt.setString(3,name);
			stmt.setDate(4,Date.valueOf(returnDate));
			
			int count=stmt.executeUpdate();   
        	
        	return count;
		}
	}
	
	public int updateStatus(int id,int status){
		
		String sql="update rentals set status=? where id=?";
		int count=0;
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setInt(1,status);
			stmt.setInt(2,id);
			
			count=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		return count;
	}
	
	public int delete(int id) throws Exception {
		String sql="delete from rentals where id=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setInt(1,id);
			
			int count=stmt.executeUpdate();   
			return count;
		}
	}
}
