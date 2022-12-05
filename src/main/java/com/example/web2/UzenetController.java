package com.example.web2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import javax.validation.Validation;

@Controller
public class UzenetController {
    @Autowired
    private UzenetRepo uzenetRepo;

    @GetMapping("/uzenetiras")
    public String UjUzenet(Model model) {
        model.addAttribute("uzenetek", new Uzenetek());
        return "uzenetiras";
    }
    @GetMapping("/admin/uzenetlekeres")
    public String ListaUzenet(Model model) {
        String targy = targyolvas();
        model.addAttribute("targy",targy);
        String uzenet = uzenetolvas();
        model.addAttribute("uzenet", uzenet);
        return "uzenetlekeres";
    }

    @PostMapping(value = "/uzenetkuld")
    public String KuldUzenet(@Valid @ModelAttribute Validation validation, Uzenetek uzenet , Uzenetek targy) {
        if (uzenet.getUzenet().length() < 3 || uzenet.getTargy().length() < 1){
            return "uzenethiba";
        }
        uzenetRepo.save(targy);
        uzenetRepo.save(uzenet);
        return "uzenetjo";
    }

    String targyolvas(){
        String targy="";
        for(Uzenetek uzenetek: uzenetRepo.findAll()){
            targy+= uzenetek.getTargy();
            targy+="<br>";
        }
        return targy;
    }

    String uzenetolvas(){
        String targy="";
        for(Uzenetek uzenetek: uzenetRepo.findAll()){
            targy+= uzenetek.getUzenet();
            targy+="<br>";
        }
        return targy;
    }

}
