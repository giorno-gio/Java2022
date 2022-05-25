/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos2;

/**
 *
 * @author Jorge
 */
public class Arreglos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero;
        int numeros [] = {10,20,30,40,50,60,70,80,90};//creacion de arreglo con datos
        //int numeros[] = new int[10]; //creacion de arreglo vacio
        int suma;   
        numero = 10;
        numeros[0]=20;
        System.out.println(numero);
        System.out.println(numeros[0]);
        suma = numero + numeros[0];
        System.out.println("La suma es = " + suma);
        for (int i = 0; i < 10; i++) {
            //numeros[i]=i+1;
            System.out.println(numeros[i]);
        }
    }
    
}
