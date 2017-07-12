package entidades;

public class User {
	private int legajo; 
	private String firstName;
	private String lastName;
	private String adress;
	private String phone1;
	private String phone2;
	private String mail;
	private String password;
	private double credit;
	private boolean scholar;
	

	public User(int legajo) {
		this.legajo=legajo;
	}
	public User() {
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public boolean isScholar() {
		return scholar;
	}
	public void setScholar(boolean scholar) {
		this.scholar = scholar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void creditUpdateAdd(OrderDetail od) {
		this.credit=this.getCredit()-od.getParcialAmount();
	}
	
	public void creditUpdateCancel(OrderDetail od) {
		this.credit=this.getCredit()+od.getParcialAmount();
	}
	
	public void addCredit(Double creditToAdd) {
		this.credit=this.credit+creditToAdd;	
	}
	
	public User changePersonalData(User userNewValues) {

		this.setAdress(userNewValues.getAdress());
		this.setMail(userNewValues.getMail());
		this.setPhone1(userNewValues.getPhone1());;
		
		if(userNewValues.getPhone2()!=null){
			this.setPhone2(userNewValues.getPhone2());
		}else{
			this.setPhone2("");
		}
		
		if(userNewValues.getPassword()!=null){
			this.setPassword(userNewValues.getPassword());
		}
		
		return this;
	}
	
}
