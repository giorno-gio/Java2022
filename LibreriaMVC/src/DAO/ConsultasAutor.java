/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.AutorVo;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public interface ConsultasAutor {
    
    public boolean insertarAutor(AutorVo a);
    public ArrayList<AutorVo> consulta();
}
