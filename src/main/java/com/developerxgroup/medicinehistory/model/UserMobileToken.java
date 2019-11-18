package com.developerxgroup.medicinehistory.model;

import javax.persistence.*;
import java.sql.*;
import java.util.*;

@Entity
@Table(name = "UserMobileToken")
public class UserMobileToken {
    private Integer id;
    private Timestamp creationDate;
    private String token;
//    private Users usersByUid;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "creationDate", nullable = true)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "token", nullable = true, length = 500)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMobileToken that = (UserMobileToken) o;
        return id == that.id &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, token);
    }

//    @ManyToOne
//    @JoinColumn(name = "uid", referencedColumnName = "id")
//    public Users getUsersByUid() {
//        return usersByUid;
//    }
//
//    public void setUsersByUid(Users usersByUid) {
//        this.usersByUid = usersByUid;
//    }
}
