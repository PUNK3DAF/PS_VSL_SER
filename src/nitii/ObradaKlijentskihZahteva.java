/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nitii;

import controller.Controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Slovo;
import operacija.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author vldmrk
 */
public class ObradaKlijentskihZahteva extends Thread {

    private final Socket s;

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            ServerskiOdgovor so = new ServerskiOdgovor();
            KlijentskiZahtev kz = primiZahtev();
            switch (kz.getOperacija()) {
                case Operacije.POKRENI_IGRU -> {
                    so.setOdgovor(Controller.getInstance().isPokrenuto());
                }
                case Operacije.POGODI_SLOVO -> {
                    char slovo = (char) kz.getParam();
                    System.out.println("Pre pogodi: " + Controller.getInstance().getBrPogodj());
                    List<Slovo> slova = Controller.getInstance().pogodi(slovo);
                    System.out.println("Posle pogodi: " + Controller.getInstance().getBrPogodj());
                    if (Controller.getInstance().getBrPogodj() >= 5) {
                        JOptionPane.showMessageDialog(null, "POBEDA", "POGODILI STE", JOptionPane.INFORMATION_MESSAGE);
                    }

                    so.setOdgovor(slova);
                }
                default ->
                    throw new AssertionError();
            }
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
