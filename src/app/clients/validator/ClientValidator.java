
package app.clients.validator;

import app.clients.model.Client;

/**
 *
 * @author henriquefriske
 */

public class ClientValidator {

    public void validate(String name, String cpf, String email, String cellPhone) {
        validateRequired(name, "Nome");
        validateRequired(cpf, "CPF");
        validateRequired(email, "Email");
        validateRequired(cellPhone, "Celular");

        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email inválido.");
        }
    }

    private void validateRequired(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo obrigatório: " + field);
        }
    }

    public void validate(Client c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
