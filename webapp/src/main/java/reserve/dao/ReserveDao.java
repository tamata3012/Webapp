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
	
	public List<Lental> selectByUser(String name) throws Exception {
		
		List<Lental> lentalList=new ArrayList<>();
		String sql="with lental as(select * from lentals where user_name=?),"
				+ "product as(select * from products) "
				+ "select lental.id,product.name,lental.user_name,lental.lental_date,lental.return_date "
				+ "from lental left join product on lental.product_id=product.id";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				Lental lental=new Lental();
				lental.setId(rs.getInt(1));
				lental.setProductName(rs.getString(2));
				lental.setuserName(rs.getString(3));
				lental.setLentalDate(rs.getDate(4));
				lental.setReturnDate(rs.getDate(5));
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
}
