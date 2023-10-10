package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.User;
import tool.Dao;
import tool.RentalException;
import tool.RentalRuntimeException;

public class LoginDao extends Dao {

	public User search(String name,String password) throws RentalException, RentalRuntimeException {
		
		User user=null;
		String sql="select * from users where name=? and password=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
			
		} catch (SQLException e) {
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e1) {
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		
		return user;
		
	}
	
	public int register(String name,String password,String phoneNumber) throws RentalException, RentalRuntimeException{
		
		String sql="insert into users(name,password,phonenumber) values(?,?,?)";
		int count;
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setString(1, name);
			stmt.setString(2,password);
			stmt.setString(3, phoneNumber);
			
			count=stmt.executeUpdate();   
		}catch (SQLException e) {
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e1) {
			throw new RentalRuntimeException("エラーが発生しました。");
		}
    	return count;
	}
}
