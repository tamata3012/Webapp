package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.User;

public class LoginDAO extends DAO{

	//データベース接続用
	//private Connection con;

	/*public LoginDAO(Connection con) {
		this.con=con;
	}*/

	public User search(String name,String password) throws Exception {
		
//		String url = "jdbc:postgresql://127.0.0.1:5432/testdb1";
//        String username = "postgres";
//        String dbpassword = "0413";
		
		User user=null;
		String sql="select * from users where name=? and password=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			System.out.println("接続完了");
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
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return user;
		
	}
	
}
