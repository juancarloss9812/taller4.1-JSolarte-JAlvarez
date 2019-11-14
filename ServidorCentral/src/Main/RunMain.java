/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Servicio.ServidorCentralServer;

public class RunMain {
    public static void main(String[] args){
        ServidorCentralServer scs = new ServidorCentralServer();
        scs.iniciar();
    }
    
}
