package pl.zawadzki.polandcovidinfo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.zawadzki.polandcovidinfo.pojo.Infections;

@Service
public class InfectionsParser {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String apiUrl = "https://api.apify.com/v2/key-value-stores/3Po6TV7wTht4vIEid/records/LATEST?disableRedirect=true";

    public Infections getInfections(){
        Infections infections = restTemplate.getForObject(apiUrl, Infections.class);
        return infections;
    }
}
