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
public class LibroVo {
    private int idLibro;
    private String nombreLibro;
    private int paginas;
    private String generoLibro;
    private String fechaIngLibro;
    private String fechaActLibro;
    private int idAutor;

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getGeneroLibro() {
        return generoLibro;
    }

    public void setGeneroLibro(String generoLibro) {
        this.generoLibro = generoLibro;
    }

    public String getFechaIngLibro() {
        return fechaIngLibro;
    }

    public void setFechaIngLibro(String fechaIngLibro) {
        this.fechaIngLibro = fechaIngLibro;
    }

    public String getFechaActLibro() {
        return fechaActLibro;
    }

    public void setFechaActLibro(String fechaActLibro) {
        this.fechaActLibro = fechaActLibro;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    
    
}
