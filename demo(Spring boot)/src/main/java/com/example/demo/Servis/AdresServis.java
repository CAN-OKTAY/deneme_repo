package com.example.demo.Servis;

import com.example.demo.Model.Adres;
import com.example.demo.Repository.AdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Adres> findById(int id){
        return adresRepository.findById(id);
    }
}
