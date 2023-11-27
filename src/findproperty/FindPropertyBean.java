package findproperty;

import java.sql.Date;

public class FindPropertyBean {
    String buyer;
    String seller;
    String pid;
    String tamount;
    String adv;
    String bal;
    Date doreg;
	public String getBuyerid() {
		return buyer;
	}
	public void setBuyerid(String buyerid) {
		this.buyer = buyerid;
	}
	public String getSellerid() {
		return seller;
	}
	public void setSellerid(String sellerid) {
		this.seller = sellerid;
	}
	public String getPropertyid() {
		return pid;
	}
	public void setPropertyid(String propertyid) {
		this.pid = propertyid;
	}
	public String getTotalamount() {
		return tamount;
	}
	public void setTotalamount(String totalamount) {
		this.tamount = totalamount;
	}
	public String getAdvamount() {
		return adv;
	}
	public void setAdvamount(String advamount) {
		this.adv = advamount;
	}
	public String getBalamount() {
		return bal;
	}
	public void setBalamount(String balamount) {
		this.bal = balamount;
	}
	public Date getOwnershiptransfer() {
		return doreg;
	}
	public void setOwnershiptransfer(Date ownershiptransfer) {
		this.doreg = ownershiptransfer;
	}
	public FindPropertyBean(String buyerid, String sellerid, String propertyid, String totalamount, String advamount,
			String balamount, Date ownershiptransfer) {
		super();
		this.buyer = buyerid;
		this.seller = sellerid;
		this.pid = propertyid;
		this.tamount = totalamount;
		this.adv = advamount;
		this.bal = balamount;
		this.doreg = ownershiptransfer;
	}
    
}
