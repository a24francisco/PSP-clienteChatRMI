/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package alende.clientermi.chat.main;

import alende.clientermi.chat.Views.MainView;
import alende.clientermi.chat.controller.RegController;

import alende.psp.chatrmi.interfaz.Chat;
import alende.psp.chatrmi.interfaz.ChatAdmin;
import java.rmi.RemoteException;

/**
 *
 * @author frana
 */
public class ClienteRMIChat {

    public static void main(String[] args) throws RemoteException {
        ChatAdmin chat= new ChatAdmin();
        Chat servidor = null;
        MainView view= new MainView();
        RegController rc= new RegController(view,chat,servidor);
        view.setVisible(true);
        
    }
}
