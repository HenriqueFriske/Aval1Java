/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package app.clients.model;

/**
 *
 * @author henriquefriske
 */
public class Client {
    private int id;
    private String name;
    private String cpf;
    private String email;
    private String homePhone;
    private String cellPhone;
    private String zipCode;
    private String address;
    private String number;
    private String neighborhood;
    private String city;
    private String uf;

    public Client() {}

    public Client(int id, String name, String cpf, String email,
                  String homePhone, String cellPhone, String zipCode,
                  String address, String number, String neighborhood,
                  String city, String uf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.zipCode = zipCode;
        this.address = address;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.uf = uf;
    }

    // Getters e setters para todos os campos
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }
    public String getCellPhone() { return cellPhone; }
    public void setCellPhone(String cellPhone) { this.cellPhone = cellPhone; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
}