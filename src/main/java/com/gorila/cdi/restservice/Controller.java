package com.gorila.cdi.restservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("cdiList")
    public Response cdiList(@RequestParam(value = "dtIni") String dtIni, @RequestParam(value = "currDt") String currDt){
        return CDIRetriver.get(dtIni, currDt);
    }
}
