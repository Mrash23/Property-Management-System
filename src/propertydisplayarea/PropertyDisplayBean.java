package propertydisplayarea;

public class PropertyDisplayBean {
    String contact;
    String proptype;
    String size;
    String width;
    String depth;
    String lenleft;
    String lenright;
    String location;
    String city;
    String amount;
    String direction;
    String details;
    String filepath;
    String date;
    int pid;
	private int x;
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getProptype() {
		return proptype;
	}
	public void setProptype(String proptype) {
		this.proptype = proptype;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getLeftside() {
		return lenleft;
	}
	public void setLeftside(String leftside) {
		this.lenleft = leftside;
	}
	public String getRightside() {
		return lenright;
	}
	public void setRightside(String rightside) {
		this.lenright = rightside;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getOtherdetails() {
		return direction;
	}
	public void setOtherdetails(String otherdetails) {
		this.direction = otherdetails;
	}
	public String getPicpath() {
		return filepath;
	}
	public void setPicpath(String picpath) {
		this.filepath = picpath;
	}
	public String getDor() {
		return date;
	}
	public void setDor(String dor) {
		this.date = dor;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public PropertyDisplayBean(String contact, String proptype, String size, String width, String depth,
			String leftside, String rightside, String location, String city, String amount, String direction,
			String otherdetails, String picpath, String dor, int pid) {
		super();
		this.contact = contact;
		this.proptype = proptype;
		this.size = size;
		this.width = width;
		this.depth = depth;
		this.lenleft = leftside;
		this.lenright = rightside;
		this.location = location;
		this.city = city;
		this.amount = amount;
		this.direction = direction;
		this.direction = otherdetails;
		this.filepath = picpath;
		this.date = dor;
		this.pid = pid;
	}
	
	
	
}
