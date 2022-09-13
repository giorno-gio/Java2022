/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Jorge
 */
public class AutorVo {
    private int idAutor;
    private String nombreAutor;
    private String apellidoAutor;
    private String nacionalidadAutor;
    private String fechaIngAutor;
    private String fechaActActor;

  
    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    public String getNacionalidadAutor() {
        return nacionalidadAutor;
    }

    public void setNacionalidadAutor(String nacionalidadAutor) {
        this.nacionalidadAutor = nacionalidadAutor;
    }

    public String getFechaIngAutor() {
        return fechaIngAutor;
    }

    public void setFechaIngAutor(String fechaIngAutor) {
        this.fechaIngAutor = fechaIngAutor;
    }

    public String getFechaActActor() {
        return fechaActActor;
    }

    public void setFechaActActor(String fechaActActor) {
        this.fechaActActor = fechaActActor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

}
