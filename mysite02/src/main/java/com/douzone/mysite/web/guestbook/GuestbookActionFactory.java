package com.douzone.mysite.web.guestbook;

import com.douzone.web.Action;
import com.douzone.web.ActionFactory;


public class GuestbookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
Action action = null;
		
		if("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		} else if("add".equals(actionName)) {
			//System.out.println("ㅎㅇ");
			action = new AddAction();
		} else {
			action = new ListAction();
		}
		
		return action;
		
	
	 
		}
	

}