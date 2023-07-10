package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    //*método-http* + Mapping
    //para receber o json é preciso uma classe com os mesmos atributos
    @PostMapping
    public void cadastrar(@RequestBody String json){
        System.out.println(json);
    }
}
