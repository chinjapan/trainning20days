package com.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookstore")
public class bookinfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "bookname")
	private String bookname;
	
	@Column(name = "companyname")
	private String companyname;
	
	@Column(name = "createdate")
	private String createdate;
	
	@Column(name = "cost")
	private long cost;
	
	@Column(name = "pagenumber")
	private long pagenumber;
	
	public bookinfo() {
		
	}
	public bookinfo(String bookname, String companyname, String createdate, long cost, long pagenumber) {
		super();
		this.bookname = bookname;
		this.companyname = companyname;
		this.createdate = createdate;
		this.cost = cost;
		this.pagenumber = pagenumber;
	}
	public long getId() {
		return Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getcreatedate() {
		return createdate;
	}
	public void createdate(String createdate) {
		this.createdate = createdate;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public long getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(long pagenumber) {
		this.pagenumber = pagenumber;
	}
}
