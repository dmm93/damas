/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import damas.Ficha;
import damas.Tablero;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Observable;

/**
 *
 * @author Zeko
 */
public class VistaJuego extends JFrame implements java.util.Observer {
    JLabel contador; JButton botonInc, botonDec, botonInit;
    JPanel panelJuego;
    int filas, columnas;
    TableroSwing tableroSwing;
    static final String DEC = "Dec", INC = "Inc", INICIO = "Inicio";
     
    public VistaJuego(String titulo) {
        super(titulo);
        addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) { System.exit(0); }
        });  
        
        getContentPane().setLayout(new BorderLayout());
        
        
        panelJuego = new JPanel();
        panelJuego.setLayout(new FlowLayout());
        getContentPane().add(panelJuego,BorderLayout.CENTER);
        

         
        setResizable(false);
    }

    public void update(Observable obs, Object obj) {
      
    }

    public void addControlador(ActionListener controlador){	
    }
    
    public void crearTableroSwing(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        tableroSwing = new TableroSwing(filas, columnas);
        panelJuego.add(tableroSwing);
        setBounds(0, 0, tableroSwing.getAnchura(),
                tableroSwing.getAltura()); 
        setVisible(true); 
    }
    
    public void actualizarTableroSwing(Tablero tablero){
        
        for(int cuentaFilas = 0; cuentaFilas<filas; cuentaFilas++){
            for(int cuentaColumnas = 0; cuentaColumnas<columnas; cuentaColumnas++){
                if(tablero.estaLaCasillaVacia(cuentaFilas, cuentaColumnas)){
                    tableroSwing.textoEnCasilla(cuentaFilas, cuentaColumnas, "");
                }
                else if(tablero.fichaDelMismoColor(cuentaFilas, cuentaColumnas, Ficha.BLANCO)){
                    tableroSwing.textoEnCasilla(cuentaFilas, cuentaColumnas, "BLANCO");
                }
                else if(tablero.fichaDelMismoColor(cuentaFilas, cuentaColumnas, Ficha.NEGRO)){
                    tableroSwing.textoEnCasilla(cuentaFilas, cuentaColumnas, "NEGRO");
                }
                
            }
        }
    }
}
