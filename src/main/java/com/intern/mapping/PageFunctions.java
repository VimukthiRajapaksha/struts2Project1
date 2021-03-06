package com.intern.mapping;
// Generated Oct 19, 2018 9:31:09 AM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PageFunctions generated by hbm2java
 */
@Entity
@Table(name="page_functions"
    ,catalog="demo"
)
public class PageFunctions  implements java.io.Serializable {


     private PageFunctionsId id;
     private Function function;
     private Page page;
     private Role role;

    public PageFunctions() {
    }

    public PageFunctions(PageFunctionsId id, Function function, Page page, Role role) {
       this.id = id;
       this.function = function;
       this.page = page;
       this.role = role;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="roleId", column=@Column(name="role_id", nullable=false) ), 
        @AttributeOverride(name="pageId", column=@Column(name="page_id", nullable=false) ), 
        @AttributeOverride(name="funId", column=@Column(name="fun_id", nullable=false) ) } )
    public PageFunctionsId getId() {
        return this.id;
    }
    
    public void setId(PageFunctionsId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fun_id", nullable=false, insertable=false, updatable=false)
    public Function getFunction() {
        return this.function;
    }
    
    public void setFunction(Function function) {
        this.function = function;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="page_id", nullable=false, insertable=false, updatable=false)
    public Page getPage() {
        return this.page;
    }
    
    public void setPage(Page page) {
        this.page = page;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role_id", nullable=false, insertable=false, updatable=false)
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }




}


