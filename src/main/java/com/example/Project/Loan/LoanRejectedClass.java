package com.example.Project.Loan;

import java.util.Date;

import javax.persistence.*;    

 @Entity
 @Table(name="loannreject")                           //LoanClass is the data class modelling the data storage in the database
 public class LoanRejectedClass {
	@Id
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "loancapital")
	private long loancapital;
	@Column(name = "period")
	private int period;
	@Column(name = "employ")
	private boolean employ;
	@Column(name = "credscore")
	private long credscore;
	@Column(name = "empolyexp")
	private long empolyexp;
	@Column(name = "emistat")
	private boolean emistat;
	@Column(name = "dob")
	private String dob;
	@Column(name = "def_days")
	private int def_days;
	@Column(name = "public_sector")
	private boolean public_sector;
	@Column(name = "profit_proj")
	private int profit_proj;
	@Column(name = "crim_bg")
	private boolean crim_bg;
	@Column(name = "ec_off")
	private boolean ec_off;
	@Column(name = "collateral_type")
	private String collateral_type;
	@Column(name = "ltype")
	private String ltype;
	
	

    public LoanRejectedClass() {}   
	
	public LoanRejectedClass(long id, String name, long loancapital, int period, boolean employ, long credscore, long empolyexp,
			boolean emistat, String dob, int def_days, boolean public_sector, int profit_proj, boolean crim_bg,
			boolean ec_off, String collateral_type, String ltype) 
	{
		this.id = id;
		this.name = name;
		this.loancapital = loancapital;
		this.period = period;
		this.employ = employ;                                             //Constructor which will instantiate the created objects
		this.credscore = credscore;
		this.empolyexp = empolyexp;
		this.emistat = emistat;
		this.dob = dob;
		this.def_days = def_days;
		this.public_sector = public_sector;
		this.profit_proj = profit_proj;
		this.crim_bg = crim_bg;
		this.ec_off = ec_off;
		this.collateral_type = collateral_type;
		this.ltype = ltype;
	}
	
	public LoanRejectedClass(LoanClass object) 
	{
		this.id = object.getId();
		this.name = object.getName();
		this.loancapital = object.getLoancapital();
		this.period = object.getPeriod();
		this.employ = object.isEmploy();                                             //Constructor which will instantiate the created objects
		this.credscore = object.getCredscore();
		this.empolyexp = object.getEmpolyexp();
		this.emistat = object.isEmistat();
		this.dob = object.getDob();
		this.def_days = object.getDef_days();
		this.public_sector = object.isPublic_sector();
		this.profit_proj = object.getProfit_proj();
		this.crim_bg = object.isCrim_bg();
		this.ec_off = object.isEc_off();
		this.collateral_type = object.getCollateral_type();
		this.ltype = object.getLtype();
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

	public long getLoancapital() {
		return loancapital;
	}

	public void setLoancapital(long loancapital) {
		this.loancapital = loancapital;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public boolean isEmploy() {
		return employ;
	}

	public void setEmploy(boolean employ) {
		this.employ = employ;
	}

	public long getCredscore() {
		return credscore;
	}

	public void setCredscore(long credscore) {
		this.credscore = credscore;
	}

	public long getEmpolyexp() {
		return empolyexp;
	}

	public void setEmpolyexp(long empolyexp) {
		this.empolyexp = empolyexp;
	}

	public boolean isEmistat() {
		return emistat;
	}

	public void setEmistat(boolean emistat) {
		this.emistat = emistat;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getDef_days() {
		return def_days;
	}

	public void setDef_days(int def_days) {
		this.def_days = def_days;
	}

	public boolean isPublic_sector() {
		return public_sector;
	}

	public void setPublic_sector(boolean public_sector) {
		this.public_sector = public_sector;
	}

	public int getProfit_proj() {
		return profit_proj;
	}

	public void setProfit_proj(int profit_proj) {
		this.profit_proj = profit_proj;
	}

	public boolean isCrim_bg() {
		return crim_bg;
	}

	public void setCrim_bg(boolean crim_bg) {
		this.crim_bg = crim_bg;
	}

	public boolean isEc_off() {
		return ec_off;
	}

	public void setEc_off(boolean ec_off) {
		this.ec_off = ec_off;
	}

	public String getCollateral_type() {
		return collateral_type;
	}

	public void setCollateral_type(String collateral_type) {
		this.collateral_type = collateral_type;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	
	

}
