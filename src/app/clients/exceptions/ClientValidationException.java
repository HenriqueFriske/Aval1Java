/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.clients.exceptions;

/**
 *
 * @author henriquefriske
 */
public class ClientValidationException extends RuntimeException {
    public ClientValidationException(String msg) {
        super(msg);
    }
}
