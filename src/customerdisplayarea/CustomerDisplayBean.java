package customerdisplayarea;

public class CustomerDisplayBean {
	String name;
	String address;
	String city;
	String contact;
	String picpath;
	String utype;
	String IDproof;
	String proofnum;
	
	String DOR;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getIdproof() {
		return IDproof;
	}
	public void setIdproof(String IDproof) {
		this.IDproof = IDproof;
	}
	public String getIdproofno() {
		return proofnum;
	}
	public void setIdproofno(String idproofno) {
		this.proofnum = idproofno;
	}
	public String getContactno() {
		return contact;
	}
	public void setContactno(String contact) {
		this.contact = contact;
	}
	public String getDor() {
		return DOR;
	}
	public void setDor(String DOR) {
		this.DOR = DOR;
	}
	public String getUtyper() {
		return utype;
	}
	public void setUtyper(String utype) {
		this.utype = utype;
	}
	public CustomerDisplayBean(String name, String address, String city, String picpath, String IDproof,
			String proofnum, String contact, String DOR) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.picpath = picpath;
		this.IDproof = IDproof;
		this.proofnum = proofnum;
		this.contact = contact;
		this.DOR = DOR;
		
	}
	public CustomerDisplayBean(String name, String address, String picpath, String IDproof,
			String proofnum, String contact, String DOR, String utype,int num) {
		super();
		this.name = name;
		this.address = address;
		this.picpath = picpath;
		this.IDproof = IDproof;
		this.proofnum = proofnum;
		this.contact = contact;
		this.DOR = DOR;
		this.utype = utype;
	}
	public CustomerDisplayBean(String name, String address, String city, String picpath, String IDproof,
			String proofnum, String contact, String DOR, String utype) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.picpath = picpath;
		this.IDproof = IDproof;
		this.proofnum = proofnum;
		this.contact = contact;
		this.DOR = DOR;
		this.utype = utype;
	}

}
