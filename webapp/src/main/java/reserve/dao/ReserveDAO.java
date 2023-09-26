package reserve.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import tool.DAO;

public class ReserveDAO extends DAO {

	public ReserveDAO() {
		
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
