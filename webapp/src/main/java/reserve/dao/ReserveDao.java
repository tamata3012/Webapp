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
import tool.RentalException;
import tool.RentalRuntimeException;

public class ReserveDao extends Dao {

	public ReserveDao() {
		
	}
	
	public List<Rental> select() throws RentalException, RentalRuntimeException {
		
		List<Rental> rentalList=new ArrayList<>();
		String sql="with rental as(select rentals.*,codes.value "
				+ "from rentals left join codes on rentals.status_code=codes.id where rentals.status_code not in(3,4)),"
				+ "product as(select id,name from products),"
				+ "loginuser as(select id,name from users) "
				+ "select rental.id,rental.product_id,rental.rentalnumber,rental.rental_date,rental.return_date,rental.value,product.name,loginuser.name "
				+ "from rental left join product on rental.product_id=product.id "
				+ "left join loginuser on rental.user_id=loginuser.id";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				Rental rental=new Rental();
				rental.setId(rs.getInt(1));
				rental.setProductId(rs.getInt(2));
				rental.setRentalNumber(rs.getInt(3));
				rental.setRentalDate(rs.getDate(4));
				rental.setReturnDate(rs.getDate(5));
				rental.setRentalStatus(rs.getString(6));;
				rental.setProductName(rs.getString(7));
				rental.setuserName(rs.getString(8));
				rentalList.add(rental);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		
		return rentalList;
		
	}
	
	public Rental selectById(int id) throws RentalException, RentalRuntimeException {
		
		Rental rental=null;
		String sql="with rental as(select rentals.*,codes.value "
				+ "from rentals left join codes on rentals.status_code=codes.id),"
				+ "product as(select id,name from products),"
				+ "loginuser as(select id,name,phonenumber  from users) "
				+ "select rental.id,rental.product_id,rental.rentalnumber,rental.rental_date,rental.return_date,rental.status_code,rental.value,product.name,loginuser.name,loginuser.phonenumber  "
				+ "from rental left join product on rental.product_id=product.id "
				+ "left join loginuser on rental.user_id=loginuser.id "
				+ "where rental.id=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				rental=new Rental();
				rental.setId(rs.getInt(1));
				rental.setProductId(rs.getInt(2));
				rental.setRentalNumber(rs.getInt(3));
				rental.setRentalDate(rs.getDate(4));
				rental.setReturnDate(rs.getDate(5));
				rental.setRentalCode(rs.getInt(6));
				rental.setRentalStatus(rs.getString(7));
				rental.setProductName(rs.getString(8));
				rental.setuserName(rs.getString(9));
				rental.setUserPhone(rs.getString(10));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		return rental;
	}
	
	public Rental selectByReturn(int id) throws RentalException, RentalRuntimeException {
		
		Rental rental=null;
		String sql="with rental as(select rentals.*,codes.value "
				+ "from rentals left join codes on rentals.status_code=codes.id where rentals.id=?),"
				+ "product as(select id,name from products),"
				+ "loginuser as(select id,name,phonenumber from users),"
				+ "rentalreturn as(select * from rental_return) "
				+ "select rental.id,rental.product_id,rental.rentalnumber,rental.rental_date,rentalreturn.return_date,rental.status_code,rental.value,product.name,loginuser.name,loginuser.phonenumber "
				+ "from rental left join product on rental.product_id=product.id "
				+ "left join loginuser on rental.user_id=loginuser.id "
				+ "left join rentalreturn on rental.id=rentalreturn.rental_id ";
		
		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				rental=new Rental();
				rental.setId(rs.getInt(1));
				rental.setProductId(rs.getInt(2));
				rental.setRentalNumber(rs.getInt(3));
				rental.setRentalDate(rs.getDate(4));
				rental.setReturnDate(rs.getDate(5));
				rental.setRentalCode(rs.getInt(6));
				rental.setRentalStatus(rs.getString(7));
				rental.setProductName(rs.getString(8));
				rental.setuserName(rs.getString(9));
				rental.setUserPhone(rs.getString(10));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		return rental;
	}
	
	
	public List<Rental> selectByUserId(int id) throws RentalException, RentalRuntimeException {
		
		List<Rental> rentalList=new ArrayList<>();
		String sql="with rental as(select rentals.*,codes.value "
				+ "from rentals left join codes on rentals.status_code=codes.id where user_id=?),"
				+ "product as(select id,name from products),"
				+ "loginuser as(select id,name from users where id=?) "
				+ "select rental.id,rental.product_id,rental.rentalnumber,rental.rental_date,rental.return_date,rental.value,product.name,loginuser.name "
				+ "from rental left join product on rental.product_id=product.id "
				+ "left join loginuser on rental.user_id=loginuser.id "
				+ "order by rental.id,rental.status_code";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.setInt(2, id);
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				
				Rental rental=new Rental();
				rental.setId(rs.getInt(1));
				rental.setProductId(rs.getInt(2));
				rental.setRentalNumber(rs.getInt(3));
				rental.setRentalDate(rs.getDate(4));
				rental.setReturnDate(rs.getDate(5));
				rental.setRentalStatus(rs.getString(6));
				rental.setProductName(rs.getString(7));
				rental.setuserName(rs.getString(8));
				rentalList.add(rental);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		
		return rentalList;
		
	}
	
	public List<Rental> selectReturn() throws RentalException, RentalRuntimeException {
		
		List<Rental> returnList=new ArrayList<>();
		String sql="with rental as(select rentals.*,codes.value "
				+ "from rentals left join codes on rentals.status_code=codes.id where rentals.status_code=3),"
				+ "product as(select id,name from products),"
				+ "loginuser as(select id,name,phonenumber  from users),"
				+ "rentalreturn as(select * from rental_return)"
				+ "select rental.id,rental.product_id,rental.rentalnumber,rental.rental_date,rentalreturn.return_date,rental.value,product.name,loginuser.name "
				+ "from rental left join product on rental.product_id=product.id "
				+ "left join loginuser on rental.user_id=loginuser.id "
				+ "left join rentalreturn on rental.id=rentalreturn.rental_id";
		

		try(Connection con=getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				Rental rental=new Rental();
				rental.setId(rs.getInt(1));
				rental.setProductId(rs.getInt(2));
				rental.setRentalNumber(rs.getInt(3));
				rental.setRentalDate(rs.getDate(4));
				rental.setReturnDate(rs.getDate(5));
				rental.setRentalStatus(rs.getString(6));;
				rental.setProductName(rs.getString(7));
				rental.setuserName(rs.getString(8));
				returnList.add(rental);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		
		return returnList;
	}
		

	public int register(int id,int number,int userId,String returnDate) throws RentalException, RentalRuntimeException {
		
		String sql="insert into rentals(product_id,rentalnumber,rental_date,return_date,status_code,user_id) values(?,?,current_date,?,1,?)";
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setInt(1,id);
			stmt.setInt(2, number);
			stmt.setDate(3,Date.valueOf(returnDate));
			stmt.setInt(4,userId);
			
			int count=stmt.executeUpdate();   
        	
        	return count;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
	}
	
	public int registerReturn(int id) throws RentalException, RentalRuntimeException {
		
		String sql="insert into rental_return(rental_id,return_date) values(?,current_date)";
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setInt(1,id);
			
			int count=stmt.executeUpdate();
        	
        	return count;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
	}
	
	public int updateStatus(int id,int status) throws RentalException, RentalRuntimeException{
		
		String sql="update rentals set status_code=? where id=?";
		int count=0;
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setInt(1,status);
			stmt.setInt(2,id);
			
			count=stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
		return count;
	}
	
	public int delete(int id) throws RentalException, RentalRuntimeException {
		String sql="delete from rentals where id=?";
		
		try(Connection con=getConnection();
				PreparedStatement stmt=con.prepareStatement(sql)){
			
			stmt.setInt(1,id);
			
			int count=stmt.executeUpdate();   
			return count;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RentalException("システムエラーが発生しました。");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalRuntimeException("エラーが発生しました。");
		}
	}
}
