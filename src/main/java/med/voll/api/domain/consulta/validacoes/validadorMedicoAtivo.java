package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;

public class validadorMedicoAtivo {
    private MedicoRepository repository;
    public void validar(DadosAgendamentoConsulta dados){
        //médico não especificado
        if (dados.idMedico() == null) {
            return;
        }
        var medicoAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoAtivo){
            throw new ValidacaoException("O médico especificado não está prestando serviço.");
        }
    }
}
