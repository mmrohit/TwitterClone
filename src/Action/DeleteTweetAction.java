package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.LoginSuccessBean;
import DAO.DAO;
import DAO.TDAO;

public class DeleteTweetAction implements SessionAware{

	private String tid;
	private Map<String,Object> session;
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
	
	public String execute()
	{
		if(session.get("lsb")==null)
			return "error";
		TDAO tdao=new TDAO();
		DAO dao=new DAO();
		session.put("pass",dao.getPass(((LoginSuccessBean)session.get("lsb")).getUname()) );
		return tdao.deleteTweet(tid);
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}
	
}
