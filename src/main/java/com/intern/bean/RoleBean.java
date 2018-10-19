/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intern.bean;

import java.util.List;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author vimukthi_r
 */
public class RoleBean {

    private int role_id;
    private String role_name;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<UserBean> users;

    public RoleBean() {
    }

    public RoleBean(int role_id) {
        this.role_id = role_id;
    }

    
    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
