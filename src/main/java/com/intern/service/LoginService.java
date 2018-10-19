package com.intern.service;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.intern.mapping.User;
import com.intern.util.connection.Connection;
import org.hibernate.HibernateException;

public class LoginService {

    public boolean validateUser(String username, String password) {
        Session session = new Connection().getSession();
        User ub = null;

        try {
            String query = "from User where username = :username and password = :password";
            Query q = session.createQuery(query)
                    .setParameter("username", username)
                    .setParameter("password", password);
            ub = (User) q.uniqueResult();
        }catch(HibernateException e){
            throw e;
        }finally{
            if(session!=null){
                session.close();
            }
        }
        return ub != null;
    }
}
