package reserve.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reserve.Lental;
import tool.Dao;

public class ReserveDao extends Dao {

	public ReserveDao() {
		
	}
	
	
	public Lental selectById(int id) throws Exception{
		
		Lental lental=new Lental();
		String sql="select lental.id,lental.product_id,lental.lentalnumber,lental.user_name,lental.lental_date,lental.return_date,product.name "
				+ "from lentals as lental left join products as product on lental.product_id=product.id where lental.id=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				lental.setId(rs.getInt(1));
				lental.setProductId(rs.getInt(2));
				lental.setLentalNumber(rs.getInt(3));
				lental.setuserName(rs.getString(4));
				lental.setLentalDate(rs.getDate(5));
				lental.setReturnDate(rs.getDate(6));
				lental.setProductName(rs.getString(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lental;
	}
	
	public List<Lental> select() throws Exception {
		
		List<Lental> lentalList=new ArrayList<>();
		String sql="with lental as(select * from lentals),"
				+ "product as(select * from products) "
				+ "select lental.id,lental.product_id,lental.lentalnumber,lental.user_name,lental.lental_date,lental.return_date,product.name "
				+ "from lental left join product on lental.product_id=product.id";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				Lental lental=new Lental();
				lental.setId(rs.getInt(1));
				lental.setProductId(rs.getInt(2));
				lental.setLentalNumber(rs.getInt(3));
				lental.setuserName(rs.getString(4));
				lental.setLentalDate(rs.getDate(5));
				lental.setReturnDate(rs.getDate(6));
				lental.setProductName(rs.getString(7));
				lentalList.add(lental);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lentalList;
		
	}

	
	public List<Lental> selectByUser(String name) throws Exception {
		
		List<Lental> lentalList=new ArrayList<>();
		String sql="with lental as(select * from lentals where user_name=?),"
				+ "product as(select * from products) "
				+ "select lental.id,lental.product_id,lental.lentalnumber,lental.user_name,lental.lental_date,lental.return_date,product.name "
				+ "from lental left join product on lental.product_id=product.id";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				Lental lental=new Lental();
				lental.setId(rs.getInt(1));
				lental.setProductId(rs.getInt(2));
				lental.setLentalNumber(rs.getInt(3));
				lental.setuserName(rs.getString(4));
				lental.setLentalDate(rs.getDate(5));
				lental.setReturnDate(rs.getDate(6));
				lental.setProductName(rs.getString(7));
				lentalList.add(lental);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lentalList;
		
	}

	public int register(int id,int number,String name,String returnDate) throws Exception {
		
		String sql="insert into lentals(product_id,lentalnumber,user_name,lental_date,return_date) values(?,?,?,current_date,?)";
		
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
	
	public int delete(int id) throws Exception {
		String sql="delete from lentals where id=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setInt(1,id);
			
			int count=stmt.executeUpdate();   
			return count;
		}
	}
}
