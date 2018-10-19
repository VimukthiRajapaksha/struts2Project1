/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intern.util.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author vimukthi_r
 */
public class Connection {

    public Session getSession() {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        return session;
    }
}
