/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tddxp;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author limbert y marcial
 */
public class GuiReservar extends JFrame{
       
    
    
    public GuiReservar(){
	super("Título de la ventana");
        setLayout(new FlowLayout());
        //cuando necesitamos el cuadro de dialogo
        Reservar pd = new Reservar();
        if(JOptionPane.showConfirmDialog(this, pd, "Introduzca datos",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
        }
        
        int seleccionada = JOptionPane.showConfirmDialog(this, "Lo aceptas?", "Aviso",
        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        switch(seleccionada) {
            case JOptionPane.YES_OPTION: pd.GuardarReserva("1","confirmado");
            case JOptionPane.NO_OPTION: JOptionPane.showMessageDialog(this, // La ventana padre.
" Presionaste no!", //El mensaje.
"Error", // El título de la ventana de diálogo.
JOptionPane.ERROR_MESSAGE);
            break;//case JOptionPane.CLOSED_OPTION: .. // tratar ventana cerrada
        }
        
    }
    
    public static void main(String[] args){
            GuiReservar f = new GuiReservar();
    }        
  
}
