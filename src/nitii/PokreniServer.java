/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nitii;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vldmrk
 */
public class PokreniServer extends Thread {

    private List<Socket> klijenti = new ArrayList<>();

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            while (true) {
                Socket s = ss.accept();
                klijenti.add(s);
                System.out.println("KLIJENT SE POVEZAO");
                if (klijenti.size() == 2) {
                    System.out.println("OBA KLIJENTA SU POVEZANA");
                    ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                    okz.start();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
