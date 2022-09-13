/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJuegos;

import Vista.NivelPrincipiante;

/**
 *
 * @author Jorge
 */
public class LogicaJuegos {
    
    NivelPrincipiante nP = new NivelPrincipiante();
    
    public void asignarNumerosRandom(){
        //variables donde voy a guardar los numeros aleatorios
        int numaleatorio = 0;
        int numaleatorio1 = 0;
        int numaleatorio2 = 0;
        int numaleatorio3 = 0;
        int numaleatorio4 = 0;
        int numaleatorio5 = 0;
        int numaleatorio6 = 0;
        int numaleatorio7 = 0;
        int numaleatorio8 = 0;
        int numaleatorio9 = 0;
        int numaleatorio10 = 0;
        int numaleatorio11 = 0;
        
        numaleatorio = (int) (Math.random()*10);
        numaleatorio1 = (int) (Math.random()*10);
        numaleatorio2 = (int) (Math.random()*10);
        numaleatorio3 = (int) (Math.random()*10);
        numaleatorio4 = (int) (Math.random()*10);
        numaleatorio5 = (int) (Math.random()*10);
        numaleatorio6 = (int) (Math.random()*10);
        numaleatorio7 = (int) (Math.random()*10);
        numaleatorio8 = (int) (Math.random()*10);
        numaleatorio9 = (int) (Math.random()*10);
        numaleatorio10 = (int) (Math.random()*10);
        numaleatorio11 = (int) (Math.random()*10);
        
        //asignar  numero aleatorio a sumas
        nP.txtN1S1.setText(String.valueOf(numaleatorio));
        nP.txtN2S1.setText(String.valueOf(numaleatorio1));
        nP.txtN1S2.setText(String.valueOf(numaleatorio2));
        nP.txtN2S2.setText(String.valueOf(numaleatorio3));
        
        //asignar numero aleatorio a restas
        nP.txtN1R1.setText(String.valueOf(numaleatorio4));
        nP.txtN2R1.setText(String.valueOf(numaleatorio5));
        nP.txtN1R2.setText(String.valueOf(numaleatorio6));
        nP.txtN2R2.setText(String.valueOf(numaleatorio7));
        
        //asignar numero aleatorio multiplicacion
        nP.txtN1M1.setText(String.valueOf(numaleatorio8));
        nP.txtN2M1.setText(String.valueOf(numaleatorio9));
        
        //asignar numero aleatorio division
        nP.txtN1D1.setText(String.valueOf(numaleatorio10));
        nP.txtN2D1.setText(String.valueOf(numaleatorio11));
    }
    
}
