package Action;

import java.util.Map;




import org.apache.struts2.interceptor.SessionAware;

import Beans.HomeTweetBean;
import Beans.LoginBean;
import Beans.LoginSuccessBean;
import DAO.DAO;
import DAO.LDAO;
import DAO.TDAO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<LoginBean>, SessionAware {
	private Map<String, Object> userMap;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginBean lb=new LoginBean();
	DAO dao=null;
	LoginSuccessBean lsb=new LoginSuccessBean();
	LDAO ldao=new LDAO();
	
	
	 void start()
	{
		
		dao= new DAO();
	}
	
	public void validate()
	{
		
		if(lb.getUname().isEmpty())
			addFieldError("uname","Username Can Not Be Empty");
		if(lb.getPass().isEmpty())
			addFieldError("pass","Password can not be empty");
		
	}
	
	
	public String execute()
	{
		start();
		String result;
		result= dao.authenticate(lb);
		if(result=="success")
		{
			this.lsb=ldao.prepareLoginSuccessBean(lb.getUname());
			userMap.put("lsb",this.lsb);
			HomeTweetBean htb=new HomeTweetBean();
			TDAO tdao=new TDAO();
			htb= tdao.getAllTweets(((LoginSuccessBean)userMap.get("lsb")).getUname());
			userMap.put("htb",htb);
			return result;
		}
		return result;
	}
	
	
	@Override
	public LoginBean getModel() {
		
		return lb;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.userMap = arg0;
		
	}

	
	
	
	
	

	
	
	
}
