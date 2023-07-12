package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")//tabela medicos
@Entity(name = "Medico")//entidade Medico
//lombok gera todos esse códigos através dessas anotations
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//gera o id
    private Long id;
    private String  nome;
    private String  email;
    private String  crm;

    @Enumerated(EnumType.STRING)//diz que é um enum
    private Especialidade  especialidade;

    @Embedded//fica em uma classe separada mas considera que pertence a mesma tabela
    private Endereco endereco;

    public Medico(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}