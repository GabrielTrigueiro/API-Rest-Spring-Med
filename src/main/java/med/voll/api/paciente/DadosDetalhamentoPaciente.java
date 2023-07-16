package med.voll.api.paciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone, String cpf) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getEmail());
    }
}
