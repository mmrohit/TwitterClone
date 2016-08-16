package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.HomeTweetBean;
import Beans.LoginSuccessBean;
import DAO.TDAO;

public class HomeTweetsAction implements SessionAware {


	private Map<String,Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}


	
	public String execute()
	{
		HomeTweetBean htb=new HomeTweetBean();
		
		TDAO tdao=new TDAO();
		
		if(((LoginSuccessBean)session.get("lsb"))==null)
			return "error";
		htb= tdao.getAllTweets(((LoginSuccessBean)session.get("lsb")).getUname());
		session.put("htb",htb);
		return "success";
	}
	
	
}
