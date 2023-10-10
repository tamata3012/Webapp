package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.Admin;
import tool.Dao;
import tool.RentalException;
import tool.RentalRuntimeException;

public class LoginAdminDao extends Dao {

public Admin search(String name,String password) throws RentalException, RentalRuntimeException{
		
		Admin admin=new Admin();
		String sql="select name,password from admin where name=? and password=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				admin.setUsername(name);
				admin.setPassword(password);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		
		return admin;
		
	}

}
