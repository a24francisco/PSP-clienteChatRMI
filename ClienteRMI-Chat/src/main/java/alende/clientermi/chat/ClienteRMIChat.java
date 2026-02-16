/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package alende.clientermi.chat;

import alende.clientermi.chat.Views.MainView;
import controller.RegController;

/**
 *
 * @author frana
 */
public class ClienteRMIChat {

    public static void main(String[] args) {
        MainView view= new MainView();
        RegController rc= new RegController(view);
        view.setVisible(true);
        
    }
}
