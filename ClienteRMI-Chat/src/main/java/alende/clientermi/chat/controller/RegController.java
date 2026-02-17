/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alende.clientermi.chat.controller;

import alende.clientermi.chat.Views.ChatView;
import alende.clientermi.chat.Views.MainView;
import alende.psp.chatrmi.interfaz.Chat;

import alende.psp.chatrmi.interfaz.ChatAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author frana
 */
public class RegController {

    public MainView view;
    Chat servidor;
    ChatAdmin chat;

    public RegController(MainView view, ChatAdmin chat, Chat servidor) {
        this.view = view;
        this.chat = chat;
        this.servidor=servidor;
        this.view.pressRegButton(this.pressRegButton());
    }

    public ActionListener pressRegButton() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Registry registry = LocateRegistry.getRegistry(1010);
                    servidor=(Chat)registry.lookup("Chat");
                    List<String> user = servidor.usuarios();
                    String nombre = view.getUser();
                    for (String name : user) {
                        if (name.equals(nombre)) {
                            JOptionPane.showMessageDialog(view,  "Usuario ya existente","Error", 0);
                            return;
                        }
                    }
                    servidor.Register(nombre, chat);
                    ChatView ch = new ChatView(view, true);
                    ChatController cc = new ChatController(ch, chat,servidor,nombre);
                  
                    
                    ch.setVisible(true);
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(RegController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(RegController.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }

        };
        return al;
    }

}
