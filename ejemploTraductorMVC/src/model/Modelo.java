/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Jorge
 */
public class Modelo {
    //pienso que quiero hacer con mi programa xd
    //hago esto hago aquello creo metodos y variables 
    
    
    public Modelo() {
    }
    //1) llenar el combo box 
    
    private int indexPalabra;

    public int getIndexPalabra() {
        return indexPalabra;
    }

    public void setIndexPalabra(int indexPalabra) {
        this.indexPalabra = indexPalabra;
    }
    
    public String traducirPalabra(){
        String en;
        
        switch(this.indexPalabra){
            case 0: 
                en = "tree";
                break;
            case 1:
                en = "house";
                break;
            case 2:
                en = "clock";
                break;
            case 3:
                en = "store";
                break;
            case 4:
                en = "ice cream";
                break;
            case 5:
                en = "house";
                break;  
            default:
                en = "No se ha elegido nada";
                break;
        }
        return en;
    }
}
