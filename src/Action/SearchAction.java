package Action;


import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import Beans.LoginSuccessBean;
import Beans.SearchBean;
import DAO.DAO;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private String searchkey;
	
	
	
	
	public String getSearchkey() {
		return searchkey;
	}
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	public void validate()
	{
		if(this.searchkey.isEmpty() || this.searchkey.equals("") || this.searchkey.equals(" "))
		{
			addFieldError("searchkey","Enter a name or email or userid to search");
		}
			
	}
	public String execute()
	{
		DAO dao=new DAO();
		SearchBean sb=new SearchBean();
		sb.setResult((dao.search(searchkey)));
		
		sb.getResult().remove(((LoginSuccessBean) session.get("lsb")).getUname());
		String[] sss= new String[((LoginSuccessBean) session.get("lsb")).getFollowing().length];
		sss=((LoginSuccessBean) session.get("lsb")).getFollowing();
		for(int r=0;r<((LoginSuccessBean) session.get("lsb")).getFollowing().length;r++)
		{
		if(sb.getResult().contains(sss[r]))
		{
			sb.getResult().remove(sss[r]);
		}
		}
		session.put("sb", sb);
		return "success";
		
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}
	
	
}
