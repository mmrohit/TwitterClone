package Action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import Beans.MyTweetsBean;
import DAO.TDAO;
import Beans.LoginSuccessBean;

public class MyTweetsAction implements SessionAware{
	Map<String,Object> session;
	MyTweetsBean mtb=new MyTweetsBean();
	
	public String execute()
	{
		
		MyTweetsBean mtb=new MyTweetsBean();
		TDAO tdao=new TDAO();
	    if(session.get("lsb")==null)
	    	return "error";
		mtb=tdao.getMyTweets(((LoginSuccessBean)session.get("lsb")).getUname());
	    session.put("mytweets",mtb);
	    return "success";
	}
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}
	
}
