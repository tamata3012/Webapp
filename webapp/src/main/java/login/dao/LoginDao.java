package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.User;
import tool.Dao;

public class LoginDao extends Dao {

	public User search(String name,String password) throws Exception {
		
		User user=new User();
		String sql="select * from users where name=? and password=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	public int register(String name,String password,String phoneNumber) throws SQLException, Exception {
		
		String sql="insert into users(name,password,phonenumber) values(?,?,?)";
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setString(1, name);
			stmt.setString(2,password);
			stmt.setString(3, phoneNumber);
			
			int count=stmt.executeUpdate();   
        	
        	return count;
		}
	}
}
