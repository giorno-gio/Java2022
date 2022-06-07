/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Jorge
 */
public class PaisVo {
    private int idPais;
    private String nombrePais;
    private String capitalPais;
    private long poblacionPais;
    private String fechaIngPais;
    private String fechaActPais;

    public PaisVo() {
        
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getCapitalPais() {
        return capitalPais;
    }

    public void setCapitalPais(String capitalPais) {
        this.capitalPais = capitalPais;
    }

    public long getPoblacionPais() {
        return poblacionPais;
    }

    public void setPoblacionPais(long poblacionPais) {
        this.poblacionPais = poblacionPais;
    }

    public String getFechaIngPais() {
        return fechaIngPais;
    }

    public void setFechaIngPais(String fechaIngPais) {
        this.fechaIngPais = fechaIngPais;
    }

    public String getFechaActPais() {
        return fechaActPais;
    }

    public void setFechaActPais(String fechaActPais) {
        this.fechaActPais = fechaActPais;
    }

 
    
    
}
