package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.LoginSuccessBean;
import DAO.DAO;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	@Override
	
	public String execute()
	{
		DAO dao=new DAO();
		if(session.get("lsb")==null)
			return "error";
		return dao.delete(  ((LoginSuccessBean) session.get("lsb")).getUname());
		
	}
	
	public void setSession(Map<String, Object> arg0) {
		
		this.session=arg0;
	}

	
}
