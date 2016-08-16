package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.LoginSuccessBean;
import DAO.DAO;
import DAO.TDAO;

public class EditTweetAction implements SessionAware{

	private String message;
	private Map<String,Object> session;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute()
	{
		if(session.get("lsb")==null)
			return "error";
		TDAO tdao=new TDAO();
		DAO dao=new DAO();
		session.put("pass",dao.getPass(((LoginSuccessBean)session.get("lsb")).getUname()));
		return tdao.editTweet((String)session.get("et_id"),message);
		
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
this.session=arg0;		
	}
	
}
