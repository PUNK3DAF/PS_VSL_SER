/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.ServerskaForma;
import java.util.List;
import java.util.ArrayList;
import model.Slovo;

/**
 *
 * @author vldmrk
 */
public class Controller {

    private static Controller instance;
    private List<String> reci = new ArrayList<>();
    private List<Character> pokusanaSlova = new ArrayList<>();
    private List<Slovo> pogodjenaSlova = new ArrayList<>();
    private String odabranaRec;
    private int brPogodj = 0;
    private ServerskaForma sf;
    private boolean pokrenuto;

    public boolean isPokrenuto() {
        return pokrenuto;
    }

    public void setPokrenuto(boolean pokrenuto) {
        this.pokrenuto = pokrenuto;
    }

    public ServerskaForma getSf() {
        return sf;
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }

    public List<Slovo> getPogodjenaSlova() {
        return pogodjenaSlova;
    }

    public void setPogodjenaSlova(List<Slovo> pogodjenaSlova) {
        this.pogodjenaSlova = pogodjenaSlova;
    }

    public int getBrPogodj() {
        return brPogodj;
    }

    public void setBrPogodj(int brPogodj) {
        this.brPogodj = brPogodj;
    }

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

    public String getOdabranaRec() {
        return odabranaRec;
    }

    public void setOdabranaRec(String odabranaRec) {
        this.odabranaRec = odabranaRec;
    }

    public List<String> getReci() {
        return reci;
    }

    public void setReci(List<String> reci) {
        this.reci = reci;
    }

    public List<Character> getPokusanaSlova() {
        return pokusanaSlova;
    }

    public void setPokusanaSlova(List<Character> pokusanaSlova) {
        this.pokusanaSlova = pokusanaSlova;
    }

    public List<Slovo> pogodi(char slovo) {

        Slovo s;

        for (int i = 0; i <= 4; i++) {
            if (odabranaRec.charAt(i) == slovo) {
                brPogodj++;
                s = new Slovo();
                s.setKarakter(slovo);
                s.setPozicija(i + 1);
                pogodjenaSlova.add(s);
                sf.pogodjeno(s);
            }
        }
        return pogodjenaSlova;
    }

}
