    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciomatrices;

import java.util.Scanner;

/**
 *
 * @author Jorge
 */
public class EjercicioMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner consola = new Scanner(System.in);
        int mat[][] = new int[3][5];
        
        for (int i = 0; i<mat.length;i++){
            for (int j = 0;j<mat[0].length;j++){
                System.out.println("Ingresa un numero: ");
                mat[i][j]=consola.nextInt();
            }
        }
        
        for (int i = 0; i<mat.length;i++){
            for (int j = 0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
    
}
