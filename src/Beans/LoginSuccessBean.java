package Beans;

public class LoginSuccessBean {   //The bean that stores all the required information when login is success

	private int nfr,nfg,tcount;
	private String uname;
	private String[] followers;
	private String[] following;
	
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getNfr() {
		return nfr;
	}
	public void setNfr(int nfr) {
		this.nfr = nfr;
	}
	public int getNfg() {
		return nfg;
	}
	public void setNfg(int nfg) {
		this.nfg = nfg;
	}
	public int getTcount() {
		return tcount;
	}
	public void setTcount(int tcount) {
		this.tcount = tcount;
	}
	public String[] getFollowers() {
		
		return this.followers;
	}
	public void setFollowers(String[] followers) {
		this.followers = followers;
	}
	public String[] getFollowing() {
		return following;
	}
	public void setFollowing(String[] following) {
		this.following=following;

	}
	
	
	
	
	
}
