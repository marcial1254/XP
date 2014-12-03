/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tddxp;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author limbert y marcial
 */
public class Reservar extends JPanel{
    
    String driver = "org.postgresql.Driver";
    String ruta = "jdbc:postgresql://localhost:5432/conferencia";
    String user = "postgres";
    String password = "postgres";    
//    JButton botonConfirmar;
    // creando botones 
    public Reservar(){
        setLayout(new GridLayout(5, 2));
        JLabel etiquetaNombre = new JLabel("Nombre: ", JLabel.RIGHT);
        JTextField campoNombre = new JTextField();
        add(etiquetaNombre);
        add(campoNombre);
        JLabel etiquetaFecha = new JLabel("Fecha:", JLabel.RIGHT);
        JTextField campoFecha = new JTextField();
        add(etiquetaFecha);
        add(campoFecha);
        JLabel etiquetaReservar = new JLabel("Reservado:", JLabel.RIGHT);
        JTextField campoReservar = new JTextField();
        add(etiquetaReservar);
        add(campoReservar);
        JLabel etiquetaTipoPago = new JLabel("Tipo de Pago:", JLabel.RIGHT);
        add(etiquetaTipoPago);
        ButtonGroup grupoBotones = new ButtonGroup();
        JRadioButton visa = new JRadioButton("Visa", true);
        JRadioButton mastercard = new JRadioButton("MasterCard");
        JRadioButton paypal = new JRadioButton("PayPal");
        grupoBotones.add(visa);
        grupoBotones.add(mastercard);
        grupoBotones.add(paypal);
        add(visa);
        add(mastercard);
        add(paypal);
        
        
        
        
        
    }
    
/*para explicar algo que es fundamental sobre la base de datos Ejemplo es que esta tiene tres (3) campos que son:
codusuarios: de tipo biginteger serial (lo quiere decir que es un campo auto incremento en postgre).
nombre: de tipo text.
identificacion: de tipo text.

Ahora seguimos con el codigo para insertar datos.

Esta es la funcion correspondiente:
*/
    public void GuardarReserva(String id, String estado){

        // Insertar datos a la bd:
        try{
            Class.forName(driver);
            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
            Statement consulta=(Statement) conne.createStatement();
//            consulta.executeUpdate("update into reserva(estado) values('"+estado+"') where id_participante = '1'");
//            consulta.executeUpdate("update reserva set estado = 'confirmado' where id_participante = '1'");
            consulta.executeUpdate("update reserva set estado = '"+estado+"' where id_participante = '"+id+"'");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"El usuario ya existe");

        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error inesperado");
        } 
    }

//    public int idReserva(){
//        try{
//            Class.forName(driver);
//            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
//            Statement consulta=(Statement) conne.createStatement();
////            consulta.executeUpdate("update into reserva(estado) values('"+estado+"') where id_participante = '1'");
////            consulta.executeUpdate("update reserva set estado = 'confirmado' where id_participante = '1'");
//            ids = consulta.executeUpdate("select id_participante from reserva");
//        } catch(SQLException e){
//            JOptionPane.showMessageDialog(null,"El usuario ya existe");
//
//        } catch(ClassNotFoundException e){
//            JOptionPane.showMessageDialog(null,"Error inesperado");
//        } 
//    }
//La forma de llamar esta funcion desde el botón es la siguiente:

//    private void JButton1 ActionPerformed(java.awt.event.ActionEvent evt) {
//        Guardarusuario(campoNombre.getText, campoFecha.getText);
//        //return null;
//    }
/*Donde JTextField1.getText corresponde al nombre y JTextField2.getText corresponde al número de identificación. 

Al final dentro del visor de datos de postgre podemos ver los datos:
*/

}

