package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.LocalDateTime;

public class validadorMedicoComOutraConsultaNoMesmoHorario {
    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsulta dados){
        var consultaMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(consultaMesmoHorario){
            throw new ValidacaoException("O medico já possui outra consulta neste horário.");
        }
    }
}
