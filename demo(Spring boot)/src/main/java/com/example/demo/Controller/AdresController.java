package com.example.demo.Controller;


import com.example.demo.Model.Adres;
import com.example.demo.Servis.AdresServis;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void saveAdres(@RequestBody Adres adres){
        adresServis.saveAdres(adres);
    }
}
