package pl.zawadzki.polandcovidinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zawadzki.polandcovidinfo.pojo.Infections;
import pl.zawadzki.polandcovidinfo.service.InfectionsParser;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InfectionsController {

    private InfectionsParser infectionsParser;

    @Autowired
    public InfectionsController(InfectionsParser infectionsParser) {
        this.infectionsParser = infectionsParser;
    }

    @GetMapping("/getInfo")
    public Infections getInfections(){
        Infections infections = infectionsParser.getInfections();
        if (infections != null) {
            return infections;
        }
        else
            return new Infections();
    }

}
