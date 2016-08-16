package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.LoginSuccessBean;
import DAO.DAO;
import DAO.TDAO;

public class FollowAction implements SessionAware {
	private Map<String, Object> session;
	private String uname;
	private String fname;
	
	public String execute()
	{
		if(session.get("lsb")==null)
			return "error";
		TDAO tdao=new TDAO();
		DAO dao=new DAO();
		session.put("pass",dao.getPass(((LoginSuccessBean)session.get("lsb")).getUname()) );
		return tdao.follow(this.uname, this.fname);
		
	}
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
		
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
		
	}


	@Override
	public void setSession(java.util.Map<String, Object> arg0) {
		this.session=arg0;
		
	}


}
