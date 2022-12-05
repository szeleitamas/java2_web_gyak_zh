package com.example.web2;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
public class OprendszerekController {
    private final OprendszerekRepo repo;
    OprendszerekController(OprendszerekRepo repo) {
        this.repo = repo;
    }
    @GetMapping("/oprendszerek")
    Iterable<Oprendszerek> olvasMind() {
        return repo.findAll();
    }

    @GetMapping("/oprendszerek/{id}")
    Oprendszerek olvasEgy(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new OprendszerekNotFoundException(id));
    }

    @PostMapping("/oprendszerek")
    Oprendszerek szoftverFeltolt(@RequestBody Oprendszerek ujSzoftver) {
        return repo.save(ujSzoftver);
    }

    @PutMapping("/oprendszerek/{id}")
    Oprendszerek szoftverModosit(@RequestBody Oprendszerek adatSzoftver, @PathVariable Long id) {
        return repo.findById(id)
                .map(a -> {
                    a.setNev(adatSzoftver.getNev());
                    a.setDarab(adatSzoftver.getDarab());
                    return repo.save(a);
                })
                .orElseGet(() -> {
                    adatSzoftver.setId(id);
                    return repo.save(adatSzoftver);
                });
    }

    @DeleteMapping("/oprendszerek/{id}")
    void torolSzoftver(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
