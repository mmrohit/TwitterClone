package Action;





import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import Beans.TweetBean;
import DAO.DAO;
import DAO.TDAO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class TweetAction extends ActionSupport implements ModelDriven<TweetBean>, SessionAware{

private Map<String, Object> session;
TweetBean tb=new TweetBean();



public String execute()
{
	TDAO tdao=new TDAO();
	DAO dao=new DAO();
	session.put("pass",dao.getPass(tb.getUname()) );
	return tdao.insertTweet(tb);
}

@Override
public TweetBean getModel() {
	// TODO Auto-generated method stub
	return tb;
}

@Override
public void setSession(Map<String, Object> arg0) {
	this.session=arg0;
	
}


	
	
}
