package com.example.Project.Loan;

import java.util.Date;

import javax.persistence.*;    

 @Entity
 @Table(name="loans")                           //LoanClass is the data class modelling the data storage in the database
 public class LoanClass {
	@Id
	private long id;
	private String name;
	private long loancapital;

    public LoanClass() {}
	
	public LoanClass(long id, String name, long capital) {        //Constructor which will instantiate the created objects
		super();
		this.id = id;
		this.name = name;
		this.loancapital = capital;
	}

	public long getId() {
		return id;
	}	

	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public long getCapital() {
		return loancapital;
	}
	public void setCapital(long capital) {
		this.loancapital = capital;
	}
	

}
