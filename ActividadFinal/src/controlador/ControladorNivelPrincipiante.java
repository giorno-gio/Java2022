/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vista.NivelPrincipiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import logicaJuegos.LogicaJuegos;

/**
 *
 * @author Jorge
 */
public class ControladorNivelPrincipiante implements ActionListener, WindowListener {

    LogicaJuegos lj = new LogicaJuegos();
    NivelPrincipiante np = new NivelPrincipiante();

    public ControladorNivelPrincipiante(NivelPrincipiante np, LogicaJuegos lj) {
        this.np = np;
        this.lj = lj;
        this.np.btnVerificarSumas.addActionListener(this);
        this.np.addWindowListener(this);
    }


    private void operaciones() {
       
        String n1Suma1 = np.txtN1S1.getText();
        String n2Suma1 = np.txtN2S1.getText();
        String n1Suma2 = np.txtN1S2.getText();
        String n2Suma2 = np.txtN2S2.getText();
        String n1Resta1 = np.txtN1R1.getText();
        String n2Resta1 = np.txtN2R1.getText();
        String n1Resta2 = np.txtN1R2.getText();
        String n2Resta2 = np.txtN2R2.getText();
        String n1Multi1 = np.txtN1M1.getText();
        String n2Multi1 = np.txtN2M1.getText();
        String n1Div1 = np.txtN1D1.getText();
        String n2Div1 = np.txtN2D1.getText();
        String resultadoS1 = np.txtNRS1.getText();
        String resultadoS2 = np.txtNRS2.getText();
        String resultadoR1 = np.txtNRR1.getText();
        String resultadoR2 = np.txtNRR2.getText();
        String resultadoMulti = np.txtNRM1.getText();
        String resultadoDivi  = np .txtNRD1.getText();
        
        if(!resultadoS1.isEmpty() && !resultadoS2.isEmpty() && !resultadoR1.isEmpty()
           && !resultadoR2.isEmpty() && !resultadoMulti.isEmpty() && !resultadoDivi.isEmpty()){
            int suma1 = (Integer.parseInt(n1Suma1)+Integer.parseInt(n2Suma1));
            int suma2 = (Integer.parseInt(n1Suma2)+Integer.parseInt(n2Suma2));
            int resta1 = (Integer.parseInt(n1Resta1)-Integer.parseInt(n2Resta1));
            int resta2 = (Integer.parseInt(n1Resta2)-Integer.parseInt(n2Resta2));
            int multi = (Integer.parseInt(n1Multi1)-Integer.parseInt(n2Multi1));
            int divi = (Integer.parseInt(n1Div1)-Integer.parseInt(n2Div1));
            
            int resps1 = Integer.parseInt(resultadoS1);
            int resps2 = Integer.parseInt(resultadoS2);
            int respr1 = Integer.parseInt(resultadoR1);
            int respr2 = Integer.parseInt(resultadoR2);
            int respm1 = Integer.parseInt(resultadoMulti);
            int respd1 = Integer.parseInt(resultadoDivi);
            
            if(suma1 == resps1 && suma2 == resps2 && resta1 == respr1
              && resta2 == respr2 && multi == respm1 && divi == respd1){
                this.np.jOptionPane1.showMessageDialog(np, "CORRECTO BIEN JUGADO");
            }
            else{
                this.np.jOptionPane1.showMessageDialog(np, "ERROR DEBES COMENZAR DE NUEVO");
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == np.btnVerificarSumas){
            this.operaciones();
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
      
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.lj.asignarNumerosRandom();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
