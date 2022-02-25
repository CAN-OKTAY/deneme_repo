package com.example.demo.Controller;


import com.example.demo.Model.Adres;
import com.example.demo.Servis.AdresServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/adres")
public class AdresController {
    @Autowired
    private AdresServis adresServis;

    @GetMapping(path ="adresAll")
    public List<Adres> getAdres(){
        return adresServis.getAdres();
    }

    @GetMapping(path = "")
    public Optional<Adres> getAdresById(@RequestParam(name = "id") int id){
        return adresServis.findById(id);
    }

    @PostMapping
    public void saveAdres(@RequestBody Adres adres){
        adresServis.saveAdres(adres);
    }
    
}
