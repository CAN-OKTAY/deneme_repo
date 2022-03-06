package com.example.demo.servis;

import com.example.demo.model.Adres;
import com.example.demo.model.User;
import com.example.demo.repository.AdresRepository;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdresServis {

    @Autowired
    private AdresRepository adresRepository;

    public List<Adres> getAdres(){
        return adresRepository.findAll();
    }

    public List<Adres> getAdresWithPagination(int page){
        return adresRepository.findAll((Pageable) PageRequest.of(page-1,2, Sort.by("country"))).getContent();
    }

    public void saveAdres(Adres adres,int user_id){

    }

    public Adres findById(int id){
        return adresRepository.findById(id).get();
    }

    public void updateAdres(Adres adres, int id){
        Optional<Adres> adresFromDB=adresRepository.findById(id);
        if(adresFromDB.isPresent()) {
            Adres adres1 = adresFromDB.get();
            adres1.setOpenAdres(adres.getOpenAdres());
            adres1.setCountry(adres.getCountry());
            adres1.setTown(adres.getTown());
            adresRepository.save(adres1);
        }
        else{
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Adres-ID which is wanted to update not found");
        }
    }
}
