package beans;

public class User {
	private String uid,pwd,fname,lname,email,contact;
	private Address address;
	private int age;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uid, String pwd, String fname, String lname, String email, String contact, int age, String area,String city, String pincode) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.age = age;
		this.address = new Address(area,city,pincode);
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	

}
