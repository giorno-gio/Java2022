/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jorge
 */
public class Extras {
    public static String fechaHoy(){
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        fechaHoy = sdf.format(fecha.getTime());    
        return fechaHoy;
    }
    
}
