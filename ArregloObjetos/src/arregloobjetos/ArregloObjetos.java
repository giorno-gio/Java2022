/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arregloobjetos;

import arrobj.Persona;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class ArregloObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Persona arrayPersona[] = new Persona[2];
        arrayPersona[0]= new Persona("Pedro",85975888,"pedro@gmail.com");
        arrayPersona[1]= new Persona("Marta",343434,"marta@gmail.com");
        
        for (int i = 0; i < arrayPersona.length; i++) {
            System.out.println(arrayPersona[i].toString());
        }
         */
        
        ArrayList<Persona> arrayList = new ArrayList<Persona>();
        arrayList.add(new Persona("Pedro",85975888,"pedro@gmail.com"));
        arrayList.add(new Persona("Marta",343434,"marta@gmail.com"));
        
        for(int i = 0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i).toString());
        }
    }

}
