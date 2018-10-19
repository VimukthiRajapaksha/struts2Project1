/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intern.action;

import com.intern.bean.RoleBean;
import com.intern.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author vimukthi_r
 */
public class SetRolesAction extends ActionSupport{
    private List<RoleBean> roles = null;
    
    @Override
    public String execute() throws Exception {
        UserService us = new UserService();
        setRoles(us.getRoles());
        if (roles != null) {
            return "success";
        }
        else {
            return "failure";
        }
    }
    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }
}
