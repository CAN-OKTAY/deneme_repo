package com.example.demo.Controller;


import com.example.demo.Model.Adres;
import com.example.demo.Servis.AdresServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/adres")
public class AdresController {
    @Autowired
    private AdresServis adresServis;

    @GetMapping
    public List<Adres> getAdres(){
        return adresServis.getAdres();
    }

    @GetMapping(path = "/{id}")
    public Adres getAdresById(@RequestParam int id){
        return adresServis.getAdresById(id);
    }

    @PostMapping
    public void saveAdres(@RequestBody Adres adres){
        adresServis.saveAdres(adres);
    }
    
}
