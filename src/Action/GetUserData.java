package Action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.LoginSuccessBean;
import Beans.UserDataBean;
import DAO.DAO;
public class GetUserData implements SessionAware{
	private Map <String, Object> sess;  
	
	
	public String execute()
	{
		DAO dao=new DAO();
		LoginSuccessBean lsb=new LoginSuccessBean();
		if( (lsb=(LoginSuccessBean)sess.get("lsb")) !=null  )
		{
		UserDataBean udb=dao.getData((lsb.getUname()));
		sess.put("data", udb);
		return "success";
		}
		else return "error";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sess=arg0;
	}

}
