package com.intern.action;

import java.util.List;

import com.intern.bean.UserBean;
import com.intern.dao.UserDao;
import com.intern.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage(value = "default")
public class UserViewAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<UserBean> users;
    private int userCount;
    //get how many rows we want to have into the grid - rowNum attribute in the grid
    private Integer rows = 0;

    //Get the requested page. By default grid sets this to 1.
    private Integer page = 0;

    // sorting order - asc or desc
    private String sord;

    // get index row - i.e. user click to sort.
    private String sidx;

    // Search Field
    private String searchField;

    // The Search String
    private String searchString;

    // he Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
    private String searchOper;

    // Your Total Pages
    private Integer total = 0;

    // All Record
    private Integer records = 0;

    @Override
    @Actions({
	@Action(value = "/jsontable", results = {
	  @Result(name = "success", type = "json")
	})
  })
    public String execute() {
        UserService us = new UserService();
        int to = (rows * page);
	int from = to - rows;
        
        records = new UserDao().countUser();
        total =(int) Math.ceil((double)records / (double)rows);
        setUsers(us.getUsers(from, to));
        
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

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchOper() {
        return searchOper;
    }

    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
    
}
