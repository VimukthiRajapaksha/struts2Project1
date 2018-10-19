package com.intern.mapping;
// Generated Oct 19, 2018 9:31:09 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="demo"
)
public class User  implements java.io.Serializable {


     private Integer userId;
     private Role role;
     private String username;
     private String password;
     private String email;
     private String phone;
     private Set<Page> pages = new HashSet<Page>(0);

    public User() {
    }

	
    public User(Role role, String username, String password, String email, String phone) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public User(Role role, String username, String password, String email, String phone, Set<Page> pages) {
       this.role = role;
       this.username = username;
       this.password = password;
       this.email = email;
       this.phone = phone;
       this.pages = pages;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="user_id", unique=true, nullable=false)
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role_id", nullable=false)
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }

    
    @Column(name="username", nullable=false, length=100)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=100)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email", nullable=false, length=30)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="phone", nullable=false, length=11)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="role_pages", catalog="demo", joinColumns = { 
        @JoinColumn(name="role_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="page_id", nullable=false, updatable=false) })
    public Set<Page> getPages() {
        return this.pages;
    }
    
    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }




}


