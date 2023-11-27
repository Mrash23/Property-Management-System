package tableview;

public class TraineeBean {
       int RollNo;
       String Name;
       float Percentage;
       String Branch;
       String Date;
	public int getRollNo() {
		return RollNo;
	}
	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getPercentage() {
		return Percentage;
	}
	public void setPercentage(float percentage) {
		Percentage = percentage;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public TraineeBean(int rollNo, String name, float percentage, String branch, String date) {
		super();
		RollNo = rollNo;
		Name = name;
		Percentage = percentage;
		Branch = branch;
		Date = date;
	}
       
}
