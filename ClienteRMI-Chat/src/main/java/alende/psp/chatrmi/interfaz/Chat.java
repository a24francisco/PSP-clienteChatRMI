/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package alende.psp.chatrmi.interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author frana
 */
public interface Chat extends Remote {

    public void receiveMessage(String from, String message) throws RemoteException;

    public void sendMessage(String from, String to, String message) throws RemoteException;

    public void Register(String name, Chat chat) throws RemoteException;

    public void Unregister(String name) throws RemoteException;

    public List<String> usuarios() throws RemoteException;

}
