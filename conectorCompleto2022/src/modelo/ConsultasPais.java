/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public interface ConsultasPais {
    public boolean insertar(PaisVo p); //el parametro de tipo clase contiene todos los metodos de la clase PaisVo
    //aqui solo declaro
    public ArrayList<PaisVo> consultar();
    public boolean actualizar(PaisVo p);
    public boolean eliminar(PaisVo p);
    
}
