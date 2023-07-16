package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosEditarPaciente(
        @NotNull
        long id,
        String nome,
        String telefone,
        DadosEndereco endereco

) {
}
