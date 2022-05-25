/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomatrices;

/**
 *
 * @author Jorge
 */
public class EjercicioArray {
    public static void main(String[] args) {
        int arra[] = new int[10];
        arra[0]=0;
        for (int i = 0; i<10;i=i+5){
            System.out.println(arra[i]+i);
        }
    }
}
