package com.example.demo.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence",sequenceName = "user_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    private  int id;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @OneToMany(mappedBy ="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @NotNull
    private List<Adres> adres;

    public User() {
        this.id=0;
        this.username="";
        this.password="";
        this.adres=null;
    }
    public User(int id, String username, String password, List<Adres> adres){
        this.id=id;
        this.username=username;
        this.password=password;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
