/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intern.action;

import com.intern.bean.RoleBean;
import com.intern.bean.UserBean;
import com.intern.dao.UserDao;
import com.intern.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author vimukthi_r
 */
public class UserSaveAction extends ActionSupport {

    private UserBean userBean;
    private String roleId;
    private String resultMsg;

    @Override
    public String execute() throws Exception {
        setResultMsg(validateUser(userBean, roleId));
        if (resultMsg.equals("valid")) {
            if (new UserDao().saveUser(userBean, roleId)) {
                resultMsg = "user saved successfully !";
                return "success";
            } else {
                resultMsg = "sorry something went wrong !";
                return "failure";
            }
        }
        return "failure";
    }

    private String validateUser(UserBean ub, String role_id) {
        List<RoleBean> roleList = new UserService().getRoles();
        if (!ub.getUsername().equals("")) {
            if (!ub.getPassword().equals("")) {
                if (!ub.getEmail().equals("")) {
                    if (!ub.getPhone().equals("")) {
                        if (!role_id.equals("-1")) {
                            for (RoleBean rb : roleList) {
                                if (role_id.equals(rb.getRole_id() + "")) {
                                    return "valid";
                                }
                            }
                            return "invalid role !";
                        } else {
                            return "please select a role !";
                        }
                    } else {
                        return "phone number field is empty !";
                    }
                } else {
                    return "email field is empty !";
                }
            } else {
                return "password field is empty !";
            }
        } else {
            return "username field is empty !";
        }
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
