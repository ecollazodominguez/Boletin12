/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin12_1;

import javax.swing.JOptionPane;

/**
 *
 * @author ecollazodominguez
 */
public class Garaxe {

    private int numeroCoches;
    private String matricula;
    private int numeroPlazas = 5;
    private long inicioTiempo;
    private long finTiempo;
    private float precio;
    private float ingreso;
    private float devuelto;

    public void acceso() {
        if (numeroPlazas > 0) {
            JOptionPane.showMessageDialog(null, "Plazas dispoñibles");
            matricula = JOptionPane.showInputDialog(null, "Escriba a matrícula");
            numeroCoches++;
            numeroPlazas--;
            inicioTiempo = System.currentTimeMillis();
        } else {
            JOptionPane.showMessageDialog(null, "Completo");
        }
    }

    public void retirar() {
        String texto;
        if (numeroPlazas == 5) {
            JOptionPane.showMessageDialog(null, "Non hai coches a retirar");
        } else {
            texto = JOptionPane.showInputDialog(null, "Escriba a matrícula do coche a retirar");
            if (matricula.equals(texto) == false) {
                JOptionPane.showMessageDialog(null, "Matrícula errónea.");
            } else {
                numeroCoches--;
                numeroPlazas++;
                finTiempo = System.currentTimeMillis();

                if ((finTiempo - inicioTiempo) / 1000 / 60 / 60 <= 3) {
                    precio = 1.5f;
                } else {
                    long horas = (finTiempo - inicioTiempo) / 1000 / 60 / 60 - 3;
                    Math.floor(horas);
                    precio = (1.5f + (0.20f * horas));
                }

                ingreso = Float.parseFloat(JOptionPane.showInputDialog(null, "Debe pagar: " + precio + "€"));
                while (ingreso < precio) {
                    ingreso += Float.parseFloat(JOptionPane.showInputDialog(null, "Debe pagar: " + (precio - ingreso) + "€"));

                }
                devuelto = ingreso - precio;
                JOptionPane.showMessageDialog(null, "Retirando...");
                JOptionPane.showMessageDialog(null, "FACTURA\nMatrícula coche: " + matricula + "\nTempo: " + (finTiempo - inicioTiempo) / 1000 / 60 / 60 + " horas\nPrecio: " + precio + "€\nCartos recibidos: " + ingreso + "€\nCartos devoltos: " + devuelto + "€");
            }
        }
    }

}
