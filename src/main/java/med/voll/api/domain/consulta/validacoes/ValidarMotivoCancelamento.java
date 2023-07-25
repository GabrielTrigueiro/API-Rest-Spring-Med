package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMotivoCancelamento implements ValidadorCancelamentoDeConsulta {
    @Autowired
    ConsultaRepository consultaRepository;

    public void validar(DadosCancelamentoConsulta dados) {
        if(dados.motivo() == null){
            throw new ValidacaoException("É obrigatório informar um motivo");
        }
    }
}
