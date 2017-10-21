package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Account;
import com.shop.service.AccountService;

@Controller("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	
	public String query(){
		jsonList = accountService.query();
		return "jsonList";
	}
}
