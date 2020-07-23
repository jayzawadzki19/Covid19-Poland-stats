package pl.zawadzki.polandcovidinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zawadzki.polandcovidinfo.pojo.Infections;
import pl.zawadzki.polandcovidinfo.service.InfectionsParser;

@RestController("/")
public class InfectionsController {

    private InfectionsParser infectionsParser;
    
    @Autowired
    public InfectionsController(InfectionsParser infectionsParser) {
        this.infectionsParser = infectionsParser;
    }

    @GetMapping("/get")
    public Infections getInfections(){
        Infections infections = infectionsParser.getInfections();
        if (infections != null) {
            return infections;
        }
        else
            return new Infections();
    }

}
