package reserve;

import java.sql.Date;

public class Rental {
	
	private int id;
	private int productId;
	private String productName;
	private String userName;
	private int number;
	private int rentalNumber;
	private Date rentalDate;
	private Date returnDate;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getRentalNumber() {
		return rentalNumber;
	}
	public void setRentalNumber(int lentalNumber) {
		this.rentalNumber = lentalNumber;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date lentalDate) {
		this.rentalDate = lentalDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date return_Date) {
		this.returnDate = return_Date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
