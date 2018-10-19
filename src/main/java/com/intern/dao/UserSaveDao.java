/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intern.dao;

import com.intern.bean.UserBean;
import com.intern.mapping.Role;
import com.intern.mapping.User;
import com.intern.util.connection.Connection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vimukthi_r
 */
public class UserSaveDao {

    public boolean saveUser(UserBean ub, String roleId) {
        Session session = new Connection().getSession();
        User user = new User();
        Transaction tx = null;

        try {
            Role rb = (Role) session.get(Role.class, Integer.parseInt(roleId));

            user.setEmail(ub.getEmail());
            user.setPhone(ub.getPhone());
            user.setPassword(ub.getPassword());
            user.setRole(rb);
            user.setUsername(ub.getUsername());

            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }
}
