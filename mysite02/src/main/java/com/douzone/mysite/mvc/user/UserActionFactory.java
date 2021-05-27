package com.douzone.mysite.mvc.user;

import com.douzone.mvc.Action;
import com.douzone.mvc.ActionFactory;
import com.douzone.mysite.mvc.main.MainAction;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("joinform".equals(actionName)) {
			action = new JoinFormAction();
		} else if("joinsuccess".equals(actionName)) {
			action = new JoinSuccessAction();
		} else if("join".equals(actionName)) {
			action = new JoinAction();
		} else {
			action = new MainAction();
		}
		
		return action;
	}

}