package app.clients.controller;

import app.clients.service.ClientService;
import app.clients.validator.ClientValidator;
import app.clients.model.Client;
import app.clients.dto.ClientSummaryDTO;
import app.utils.db.DBException;
import app.utils.messages.Messages;

import javax.swing.*;
import java.util.List;

public class ClientController {

    private final ClientService service;
    private final ClientValidator validator;

    public ClientController() {
        this.service = new ClientService();
        this.validator = new ClientValidator();
    }

    public void createClient(String name, String cpf, String email, String homePhone, String cellPhone,
                              String zipCode, String address, String number, String neighborhood, String city, String uf) {
        try {
            validator.validate(name, cpf, email, cellPhone);
            service.createClient(name, cpf, email, homePhone, cellPhone, zipCode, address, number, neighborhood, city, uf);
            JOptionPane.showMessageDialog(null, Messages.CLIENT_CREATED_SUCCESS);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } catch (DBException e) {
            JOptionPane.showMessageDialog(null, Messages.DATABASE_ERROR, "Erro de Banco", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateClient(int id, String name, String cpf, String email, String homePhone, String cellPhone,
                              String zipCode, String address, String number, String neighborhood, String city, String uf) {
        try {
            validator.validate(name, cpf, email, cellPhone);
            service.updateClient(id, name, cpf, email, homePhone, cellPhone, zipCode, address, number, neighborhood, city, uf);
            JOptionPane.showMessageDialog(null, Messages.CLIENT_UPDATED_SUCCESS);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } catch (DBException e) {
            JOptionPane.showMessageDialog(null, Messages.DATABASE_ERROR, "Erro de Banco", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteClientById(String id) {
        try {
            service.deleteClientById(id);
            JOptionPane.showMessageDialog(null, Messages.CLIENT_DELETED_SUCCESS);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, Messages.INVALID_ID_FORMAT, "Erro de ID", JOptionPane.ERROR_MESSAGE);
        } catch (DBException e) {
            JOptionPane.showMessageDialog(null, Messages.DATABASE_ERROR, "Erro de Banco", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Client getById(String id) {
        try {
            return service.getById(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, Messages.INVALID_ID_FORMAT, "Erro de ID", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (DBException e) {
            JOptionPane.showMessageDialog(null, Messages.DATABASE_ERROR, "Erro de Banco", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List<ClientSummaryDTO> getAllSummarizedClient() {
        return service.getAllSummarizedClient();
    }

    public List<ClientSummaryDTO> getSummarizedClientsByName(String name) {
        return service.getSummarizedClientsByName(name);
    }
}