package com.example.demo.model;

import javax.persistence.*;
import java.nio.MappedByteBuffer;

@Entity
@Table
public class Adres {
    @Id
    @SequenceGenerator(name = "adres_sequence",sequenceName = "adres_sequence")
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "adres_sequence")
    private int id;

    @Column(name = "open_adres")
    private String openAdres;

    @Column(name = "town")
    private String town;

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

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", openAdres='" + openAdres + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
