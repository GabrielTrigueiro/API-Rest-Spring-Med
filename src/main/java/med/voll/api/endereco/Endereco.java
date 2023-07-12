package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco endereco) {
        this.bairro = endereco.bairro();
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.complemento = endereco.complemento();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.cidade = endereco.cidade();
    }
}