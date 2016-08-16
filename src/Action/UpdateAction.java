package Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.UpdateBean;
import DAO.DAO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.validators.EmailValidator;

@SuppressWarnings("serial")
public class UpdateAction extends ActionSupport implements ModelDriven<UpdateBean> , SessionAware{

	UpdateBean ub=new UpdateBean();
	
	Map <String, Object> session;
	public void validate()
	{
		if(ub.getCpass().isEmpty())
			addFieldError("cpass","Enter Current Password");
		if(ub.getNpass().isEmpty())
			addFieldError("npass","Enter New Password");
		if(!ub.getRpass().equals(ub.getNpass()))
			addFieldError("rpass","Password Didn't Match");
		if( ub.getMail().isEmpty() )
			addFieldError("mail","Enter Email");
		else
		if(!(ub.getMail().matches(EmailValidator.emailAddressPattern)))
				addFieldError("mail","Enter Proper Email Address");
		if(ub.getFname().isEmpty())
			addFieldError("fname","Enter First Name");
		
	}
	
	public String execute()
	{
		DAO dao=new DAO();
		if(dao.passCheck(ub.getUname(),ub.getCpass()))
		{
			
			
			session.put("pass",ub.getNpass() );
			return dao.update(ub);
			
		}
			
		else return "input";
			
	}
	
	
	
	@Override
	public UpdateBean getModel() {
		// TODO Auto-generated method stub
		return ub;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
		
	}
	
	
	

}