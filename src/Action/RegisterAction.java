package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.LoginSuccessBean;
import Beans.RegisterBean;
import DAO.DAO;
import DAO.LDAO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.validators.EmailValidator;



@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport implements ModelDriven<RegisterBean>, SessionAware {
	private Map<String,Object> sess;
	RegisterBean rb=new RegisterBean();
	DAO dao=null;
	void start()
	{
		
		dao=new DAO();
	}
	
	
	
	public void validate()
	{
		
		
		if(rb.getUname().isEmpty())
			addFieldError("uname","Enter Username");
		
		if(rb.getFname().isEmpty())
			addFieldError("fname","Enter First Name");
		
		if(rb.getPass().isEmpty())
			addFieldError("pass","Enter Password");
		
		if( rb.getMail().isEmpty() )
			addFieldError("mail","Enter Email");
		else
		if(!(rb.getMail().matches(EmailValidator.emailAddressPattern)))
				addFieldError("mail","Enter Proper Email Address");
				
		
	}
	
	public String execute()
	
	{
		start();
		String status=dao.insert(rb);
		if(status.equals("success"))
		{	LoginSuccessBean lsb=new LoginSuccessBean();	
			LDAO ldao=new LDAO();
			lsb=ldao.prepareLoginSuccessBean(rb.getUname());
				sess.put("lsb", lsb);
				return status; 
		}
		return status;
	}
	
	
	@Override
	public RegisterBean getModel() {
		// TODO Auto-generated method stub
		return rb;
	}



	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sess=arg0;
		
	}

}
