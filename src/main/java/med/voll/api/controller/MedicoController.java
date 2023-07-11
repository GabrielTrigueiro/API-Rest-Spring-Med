package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedicos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    //400 algum campo recebido foi enviado errado
    //*método-http* + Mapping
    //para receber o json é preciso uma classe com os mesmos atributos (padrão DTO)
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedicos dados){
        System.out.println(dados);
    }
}
