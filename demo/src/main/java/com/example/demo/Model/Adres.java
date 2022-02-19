package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table
public class Adres {
    @Id
    @SequenceGenerator(name = "adres_sequence",sequenceName = "adres_sequence",allocationSize = 1)
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "adres_sequence")
    private int id;

    @Column(name = "openAdres")
    private String openAdres;

    @Column(name = "country")
    private String country;

    public Adres(){
        this.id=0;
        this.openAdres="";
        this.openAdres="";
    }

    public Adres(int id, String openAdres, String country) {
        this.id = id;
        this.openAdres = openAdres;
        this.country = country;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenAdres() {
        return openAdres;
    }

    public void setOpenAdres(String openAdres) {
        this.openAdres = openAdres;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
