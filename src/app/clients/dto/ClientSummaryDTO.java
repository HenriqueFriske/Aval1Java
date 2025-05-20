/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.clients.dto;

/**
 *
 * @author henriquefriske
 */
public record ClientSummaryDTO(
    int id,
    String name,
    String cpf,
    String email,
    String homePhone,
    String cellPhone
) {}