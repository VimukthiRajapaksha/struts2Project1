package com.intern.action;

import com.intern.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class LoginAction extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String error;
    private Map<String, Object> sessionMap;

    @Override
    public String execute() {
        setError(validate(username, password));
        if (error.equals("valid")) {
            boolean result = new LoginService().validateUser(username, password);
            if (result) {
                if (!sessionMap.containsKey("uName")) {
                    sessionMap.put("uName", username);
                }
                return "success";
            } else {
                setError("Invalid username or password !");
                return "failure";
            }
        }
        return "failure";
    }

    private String validate(String username, String password) {
        if (!username.equals("")) {
            if (!password.equals("")) {
                return "valid";
            } else {
                return "password field cannot be null !";
            }
        } else {
            return "username field cannot be null !";
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}
