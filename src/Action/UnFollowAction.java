package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.LoginSuccessBean;
import DAO.DAO;
import DAO.TDAO;

public class UnFollowAction implements SessionAware {

	
	private String fname;
	private Map<String, Object> session;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String execute()
	{
		TDAO tdao=new TDAO();
		DAO dao=new DAO();
		if(session.get("lsb")==null)
		return "error";
		
		session.put("pass",dao.getPass(((LoginSuccessBean)session.get("lsb")).getUname()) );
		session.put("flag","unfollow" );
		return tdao.unfollow(((LoginSuccessBean)session.get("lsb")).getUname(), fname);
		
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}

	
	
}
