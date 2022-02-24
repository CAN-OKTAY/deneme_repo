package com.example.demo.Servis;

import com.example.demo.Model.Adres;
import com.example.demo.Repository.AdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresServis {

    @Autowired
    private AdresRepository adresRepository;

    public List<Adres> getAdres(){
        return adresRepository.findAll();
    }
    public void saveAdres(Adres adres){
        adresRepository.save(adres);
    }
    public Adres getAdresById(int id){
        return adresRepository.getById(id);
    }
}
