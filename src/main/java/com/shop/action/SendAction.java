package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport {
    public String execute(){
    	System.out.println("send return");
        return "send";
    }
}
