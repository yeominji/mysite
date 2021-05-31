package com.douzone.mysite.web.board;



import com.douzone.web.Action;
import com.douzone.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("view".equals(actionName)) {
			action = new ViewAction();
		
		}else if ("write".equals(actionName)) {
			action = new WriteAction();
		
		
       }else if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else   { // default Action
			action = new ListAction();

	
		}
		
		
		return action;
	}
 
}