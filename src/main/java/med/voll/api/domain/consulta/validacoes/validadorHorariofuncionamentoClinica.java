package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class validadorHorariofuncionamentoClinica implements ValidadorAgendamentoDeConsulta {
    //horario de funcionamento de segunda á sabado de 7 as 19
    public void validar(DadosAgendamentoConsulta dados){
        var dataDaConulta = dados.data();
        //se for no domingo o boolean é true
        var domingo = dataDaConulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var atesDaAberturaDaClinica = dataDaConulta.getHour() < 7;
        var depoisDoFechamentoDaClininca = dataDaConulta.getHour() > 18;
        if(domingo || atesDaAberturaDaClinica | depoisDoFechamentoDaClininca){
            throw new ValidacaoException("Horário não disponivel");
        }
    }
}
