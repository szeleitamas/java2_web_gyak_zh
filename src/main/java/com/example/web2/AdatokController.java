package com.example.web2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdatokController {
    @Autowired
    private GepRepo gepRepo;
    @Autowired
    private SzoftverRepo szoftverRepo;
    @Autowired
    private TelepitesRepo telepitesRepo;

    @GetMapping("/adatok")
    public String adatok(Model model, String uzenet) {
        String str = A();
        model.addAttribute("str", str);
        return "adatok";
    }

    String A() {
        String str = "";
        for (Gep gep : gepRepo.findAll()) {
            str += gep.getId() + "; " + gep.getHely() + "; " + gep.getTipus() + "; " + gep.getIpcim();
            str += "<br>";
        }
        str += "<br>";
        for (Szoftver szoftver : szoftverRepo.findAll()) {
            str += szoftver.getId() + "; " + szoftver.getNev() + "; " + szoftver.getKategoria();
            str += "<br>";
        }
        str += "<br>";
        for (Telepites telepites : telepitesRepo.findAll()) {
            str += telepites.getId() + "; " + telepites.getVerzio();
            str += "<br>";
        }
        return str;
    }
}


