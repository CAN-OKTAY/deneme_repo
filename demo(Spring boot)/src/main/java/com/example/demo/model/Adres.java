package com.example.demo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table
public class Adres {
    @Id
    @SequenceGenerator(name = "adres_sequence",sequenceName = "adres_sequence")
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "adres_sequence")
    private int id;

    @NotNull
    @Column(name = "openAdres")
    private String openAdres;

    @NotNull
    @Column(name = "town")
    private String town;

    @NotNull
    @Column(name = "country")
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    public Adres(){
        this.id=0;
        this.openAdres="";
        this.openAdres="";
        this.user_id=null;
    }

    public Adres(int id, String openAdres, String country,User user_id) {
        this.id = id;
        this.openAdres = openAdres;
        this.country = country;
        this.user_id=user_id;
    }

    public void setOpenAdres(String openAdres) {
        this.openAdres = openAdres;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getOpenAdres() {
        return openAdres;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user) {
        this.user_id = user;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", openAdres='" + openAdres + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
