/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alende.clientermi.chat.controller;

import alende.clientermi.chat.Views.ChatView;
import alende.psp.chatrmi.interfaz.Chat;

import alende.psp.chatrmi.interfaz.ChatAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frana
 */
public class ChatController {
    ChatView view;
     ChatAdmin chat;
     Chat servidor;
     String user;

    public ChatController(ChatView view, ChatAdmin chat, Chat servidor, String user) throws RemoteException {
        this.view = view;
        this.chat = chat;
        this.servidor= servidor;
        this.user=user;
        this.view.mostrarUsuarios(servidor.usuarios());
        this.view.pressEnviarButton(this.pressEnviarButton());
        Thread hilo= new Thread(()->{
            while(true){
            try {
                List<String> usuarios=servidor.usuarios();
                javax.swing.SwingUtilities.invokeLater(()->{
               view.mostrarUsuarios(usuarios);});
                Thread.sleep(1000);
               
                
            } catch (RemoteException ex) {
                Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (InterruptedException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
        });
        hilo.start();
        view.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                try {
                    servidor.Unregister(user);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
    }
    public ActionListener pressEnviarButton(){
        ActionListener al= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje=view.getMensaje();
                String destino=view.getUser();
                try {
                    servidor.sendMessage(user, destino, mensaje);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return al;
    }

    
    
    
    
    
}
