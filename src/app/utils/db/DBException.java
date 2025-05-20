/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.utils.db;

/**
 *
 * @author henriquefriske
 */
public class DBException extends RuntimeException {
    public DBException(String m, Throwable c){ super(m,c);
    }
}