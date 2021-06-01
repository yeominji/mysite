package com.douzone.mysite.web.board;



import com.douzone.web.Action;
import com.douzone.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("view".equals(actionName)) {
			action = new ViewAction();
		}else if ("viewform".equals(actionName)) {
			action = new ViewFormAction();
		}else if ("write".equals(actionName)) {
			action = new WriteAction();
		}else if ("writeform".equals(actionName)) {
			action = new WriteFormAction();
		
		
       }else if ("modify".equals(actionName)) {
			action = new ModifyAction();
       }else if ("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		} else   { // default Action
			action = new ListAction();

	
		}
		
		
		return action;
	}
 
}