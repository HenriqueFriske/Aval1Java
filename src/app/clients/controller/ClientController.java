package app.clients.controller;

import app.clients.dto.ClientSummaryDTO;
import app.clients.model.Client;
import app.clients.service.ClientService;

import java.util.List;

public class ClientController {
    private final ClientService service = new ClientService();

    public void createClient(String name, String cpf, String email,
                             String homePhone, String cellPhone,
                             String zipCode, String address, String number,
                             String neighborhood, String city, String uf) {
        service.createClient(name, cpf, email, homePhone, cellPhone,
                              zipCode, address, number, neighborhood, city, uf);
    }

    public void updateClient(int id, String name, String cpf, String email,
                             String homePhone, String cellPhone,
                             String zipCode, String address, String number,
                             String neighborhood, String city, String uf) {
        service.updateClient(id, name, cpf, email, homePhone, cellPhone,
                              zipCode, address, number, neighborhood, city, uf);
    }

    public List<ClientSummaryDTO> getAllSummarizedClient() {
        return service.getAllSummarizedClient();
    }

    public List<ClientSummaryDTO> getSummarizedClientsByName(String name) {
        return service.getSummarizedClientsByName(name);
    }

    public Client getById(String id) {
        return service.getById(id);
    }

    public void deleteClientById(String id) {
        service.deleteClientById(id);
    }
}