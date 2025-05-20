package app.clients.service;

import app.clients.dao.ClientDAO;
import app.clients.dto.ClientSummaryDTO;
import app.clients.exceptions.ClientValidationException;
import app.clients.model.Client;
import app.clients.validators.ClientValidator;

import java.util.List;

public class ClientService {
    private final ClientDAO dao = new ClientDAO();
    private final ClientValidator validator = new ClientValidator();

    public void createClient(String name, String cpf, String email,
                             String homePhone, String cellPhone,
                             String zipCode, String address, String number,
                             String neighborhood, String city, String uf) {
        Client c = new Client(0, name, cpf, email, homePhone, cellPhone,
                              zipCode, address, number, neighborhood, city, uf);
        validator.validate(c);
        dao.create(c);
    }

    public void updateClient(int id, String name, String cpf, String email,
                             String homePhone, String cellPhone,
                             String zipCode, String address, String number,
                             String neighborhood, String city, String uf) {
        Client c = new Client(id, name, cpf, email, homePhone, cellPhone,
                              zipCode, address, number, neighborhood, city, uf);
        validator.validate(c);
        dao.update(c);
    }

    public List<ClientSummaryDTO> getAllSummarizedClient() {
        return dao.getAllSummarized();
    }

    public List<ClientSummaryDTO> getSummarizedClientsByName(String name) {
        return dao.getSummarizedByName(name);
    }

    public Client getById(String id) {
        try {
            int i = Integer.parseInt(id);
            return dao.getById(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void deleteClientById(String id) {
        try {
            int i = Integer.parseInt(id);
            dao.deleteById(i);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido");
        }
    }
}