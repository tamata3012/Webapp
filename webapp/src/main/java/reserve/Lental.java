package reserve;

import java.sql.Date;

public class Lental {
	
	private int id;
	private String productName;
	private String userName;
	private int number;
	private int lentalNumber;
	private Date lentalDate;
	private Date returnDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getLentalNumber() {
		return lentalNumber;
	}
	public void setLentalNumber(int lentalNumber) {
		this.lentalNumber = lentalNumber;
	}
	public Date getLentalDate() {
		return lentalDate;
	}
	public void setLentalDate(Date lentalDate) {
		this.lentalDate = lentalDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date return_Date) {
		this.returnDate = return_Date;
	}
	
	

}
