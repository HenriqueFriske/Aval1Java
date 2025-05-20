
package app.clients.validators;

/**
 *
 * @author henriquefriske
 */
import app.clients.model.Client;
import app.clients.exceptions.ClientValidationException;

public class ClientValidator {
    public void validate(Client c) {
        if (c.getName() == null || c.getName().isBlank())
            throw new ClientValidationException("Nome é obrigatório");
        if (c.getEmail() == null || !c.getEmail().contains("@"))
            throw new ClientValidationException("E-mail inválido");
        if (c.getCpf() == null || c.getCpf().isBlank())
            throw new ClientValidationException("CPF é obrigatório");
        if (c.getCellPhone() == null || c.getCellPhone().isBlank())
            throw new ClientValidationException("Celular é obrigatório");
        // demais validações conforme regras de negócio
    }
}