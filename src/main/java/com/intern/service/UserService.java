package com.intern.service;

import com.intern.bean.RoleBean;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.intern.bean.UserBean;
import com.intern.mapping.Role;
import com.intern.mapping.User;
import com.intern.util.connection.Connection;
import java.util.ArrayList;

public class UserService {

    public List<UserBean> getUsers() {
        Session session = new Connection().getSession();
        List<User > users = new ArrayList<User>();
        List<UserBean> userBeanList = new ArrayList<UserBean>();
        try {
            String query = "from User";
            Query<User> q = session.createQuery(query);
            users = q.setMaxResults(10).setFirstResult(25).list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        for(User u : users){
            UserBean userBean = new UserBean();
            userBean.setUser_id(u.getUserId()+"");
            userBean.setUsername(u.getUsername());
            userBean.setEmail(u.getEmail());
            userBean.setPhone(u.getPhone());
            userBean.setRole_id(u.getRole().getRoleId()+"");
            userBean.setRole_name(u.getRole().getRoleName());
            
            userBeanList.add(userBean);
        }
        return userBeanList;
    }
    public List<RoleBean> getRoles() {
        Session session = new Connection().getSession();
        List<RoleBean> roleList = new ArrayList<RoleBean>();
        List<Role> roles = new ArrayList<Role>();
        try {
            String query = "from Role";
            Query<Role> q = session.createQuery(query);
            roles = q.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        for(Role r : roles){
            RoleBean roleBean = new RoleBean();
            roleBean.setRole_id(r.getRoleId());
            roleBean.setRole_name(r.getRoleName());
            
            roleList.add(roleBean);
        }
        return roleList;
    }
}
