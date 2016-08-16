package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class GetTweetMessage implements SessionAware{

	
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
		session.put("et_id", tid);
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}
	
	
	
	
}
