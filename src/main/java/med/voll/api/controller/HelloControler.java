package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")//se cair req nessa url ativa o HelloControler
public class HelloControler {

    @GetMapping
    public String olaMundo() {
        return "hello spring";
    }

}
