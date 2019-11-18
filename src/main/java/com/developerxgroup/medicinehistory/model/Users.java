package com.developerxgroup.medicinehistory.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "Users")
public class Users {
    private Integer id;
    private String fname;
    private String lname;
    private Date dob;
    private String email;
    private String password;
    private Boolean active;
//    private List<UserMobileToken> userMobileTokensById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fname", nullable = true, length = 350)
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Basic
    @Column(name = "lname", nullable = true, length = 350)
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Basic
    @Column(name = "dob", nullable = true)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 350)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "active", nullable = true)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users that = (Users) o;
        return id == that.id &&
                Objects.equals(fname, that.fname) &&
                Objects.equals(lname, that.lname) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, lname, dob, email, password, active);
    }

//    @OneToMany(mappedBy = "usersByUid")
//    public List<UserMobileToken> getUserMobileTokensById() {
//        return userMobileTokensById;
//    }
//
//    public void setUserMobileTokensById(List<UserMobileToken> userMobileTokensById) {
//        this.userMobileTokensById = userMobileTokensById;
//    }
}
