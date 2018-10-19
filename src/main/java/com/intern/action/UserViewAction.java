package com.intern.action;

import java.util.List;

import com.intern.bean.UserBean;
import com.intern.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserViewAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<UserBean> users;

    @Override
    public String execute() {
        UserService us = new UserService();
        setUsers(us.getUsers());
        if (users != null) {
            return "success";
        } else {
            return "failure";
        }
    }
    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }
}
