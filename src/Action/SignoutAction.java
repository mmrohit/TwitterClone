package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class SignoutAction implements SessionAware {

	private Map<String,Object> session;
	
	
	public String execute()
	{
		if(session.get("lsb")!=null)
		session.remove("lsb");
		if(session.get("mytweets")!=null)
			session.remove("mytweets");
		return "success";
		
	}
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}

	
	
	
	
}
