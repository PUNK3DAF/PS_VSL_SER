/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import model.Slovo;

/**
 *
 * @author vldmrk
 */
public class Controller {

    private static Controller instance;
    private List<String> reci = new ArrayList<>();
    private List<Slovo> pokusanaSlova = new ArrayList<>();

    private Controller() {
        reci.add("PETAR");
        reci.add("VLADA");
        reci.add("VANJA");
        reci.add("PAPAK");
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<String> getReci() {
        return reci;
    }

    public void setReci(List<String> reci) {
        this.reci = reci;
    }

    public List<Slovo> getPokusanaSlova() {
        return pokusanaSlova;
    }

    public void setPokusanaSlova(List<Slovo> pokusanaSlova) {
        this.pokusanaSlova = pokusanaSlova;
    }

}
