package com.example.demo.servis;

import com.example.demo.model.Adres;
import com.example.demo.repository.AdresRepository;
import org.jetbrains.annotations.NotNull;
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

    public List<Adres> getAdresWithPagination(int beginPage){
        int skipRows=(beginPage-1)*2; //each page has to be only 2 json object(Adres).
        return adresRepository.getAdresWithPagination(skipRows);
    }

    public void saveAdres(Adres adres){
        adresRepository.save(adres);
    }

    public Optional<Adres> findById(int id){
        return adresRepository.findById(id);
    }

    public void updateAdres(@NotNull Adres adres, int id){
        Optional<Adres> adresFromDB=adresRepository.findById(id);
        Adres adres1=adresFromDB.get();
        adres1.setOpenAdres(adres.getOpenAdres());
        adres1.setCountry(adres.getCountry());
        adres1.setTown(adres.getTown());
        adresRepository.save(adres1);
    }
}
