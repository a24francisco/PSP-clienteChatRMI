/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alende.psp.chatrmi.interfaz;

import alende.clientermi.chat.Views.ChatView;
import alende.clientermi.chat.controller.ChatController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frana
 */
public class ChatAdmin extends UnicastRemoteObject implements Chat {

    private ChatView chat;

    public ChatAdmin() throws RemoteException {

    }

    public void setVista(ChatView chat) {
        this.chat = chat;
    }

    @Override
    public void receiveMessage(String from, String message) throws RemoteException {

        javax.swing.SwingUtilities.invokeLater(() -> {
            chat.addMessage(from + ":" + message);
        });

    }

    @Override
    public void sendMessage(String from, String to, String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Register(String name, Chat chat) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<String> usuarios() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Unregister(String name) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
