package br.com.triersistemas.andromeda.model;

import br.com.triersistemas.andromeda.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ClienteModel {

    private UUID id;

    @NotNull
    @NotBlank
    @Length(min = 2, max = 30)
    private String nome;

    @NotNull(message = "A data de aniversário não pode ser nula")
    private LocalDate niver;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String cpf;

    public ClienteModel(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.niver = cliente.getNiver();
        this.email = cliente.getEmail();
        this.cpf = cliente.getDocumento();
    }
}
