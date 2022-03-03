package com.example.demo.servis;

import com.example.demo.model.Adres;
import com.example.demo.model.User;
import com.example.demo.repository.AdresRepository;
<<<<<<< HEAD
=======
import com.example.demo.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
>>>>>>> 5a8cde5a3a445faeb9bec0655bd613ccdd7b304a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdresServis {

    @Autowired
    private AdresRepository adresRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Adres> getAdres(){
        return adresRepository.findAll();
    }

    public List<Adres> getAdresWithPagination(int page){
        int skipRows=(page-1)*2; //each page has to be only 2 json object(Adres).
        return adresRepository.getAdresWithPagination(skipRows);
    }

    public void saveAdres(Adres adres,int user_id){
        Optional<User> user=userRepository.findById(user_id);
        if(user.isPresent()) {
            adres.setUser_id(user.get());
            adresRepository.save(adres);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"user_id do not mach with user(id)");
        }
    }

    public Optional<Adres> findById(int id){
        return adresRepository.findById(id);
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
