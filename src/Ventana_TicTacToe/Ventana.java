/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana_TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author pequesillo
 */
public class Ventana extends javax.swing.JFrame implements  ActionListener{

    /**
     * Creates new form Ventana
     */
    Casilla[][]TABLERO;
    int Contador;
    public Ventana() {
        initComponents();
        TABLERO = new Casilla[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TABLERO[i][j] = new Casilla();
                TABLERO[i][j].A.setBounds((i*100)+10,(j*100)+10,100,100);
                TABLERO[i][j].A.addActionListener(this);
                this.add(TABLERO[i][j].A);
            }
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic  Tac  Toe");
        setPreferredSize(new java.awt.Dimension(335, 355));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
                new Ventana().setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
    void Tiro(Casilla X){
        ImageIcon ICONO=null;
        if (Contador%2==0) {
            ICONO = new ImageIcon(this.getClass().getResource("o.jpg"));
            X.B=1;
        }else{
            ICONO = new ImageIcon(this.getClass().getResource("x.png"));
            X.B=4;
        }
        
        ICONO = new ImageIcon(ICONO.getImage().getScaledInstance(90,-1,java.awt.Image.SCALE_DEFAULT));
        X.A.setIcon(ICONO);
        X.A.removeActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() ==  TABLERO[i][j].A){
                    Tiro(TABLERO[i][j]);
                    if (Revisar()) {
                        JOptionPane.showMessageDialog(null, "HAS GANADO");
                        //System.out.println("Elemento "+i+"-"+j);
                    }
                    Contador++;
                   //System.out.println("Elemento "+i+"-"+j);
            
                }
            }
        }
    }
    
    public boolean Revisar(){
        boolean Gano = false;
        int Suma = 0;
        for (int i = 0; i < 3; i++) {
            Suma = TABLERO[i][0].B+TABLERO[i][1].B+TABLERO[i][2].B;
            //System.out.println(Suma+" - "+TABLERO[i][0].B+" - "+TABLERO[i][2].B);
            if (Suma == 3 || Suma == 12 ) {
                Gano = true;
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            Suma = TABLERO[0][i].B+TABLERO[i][1].B+TABLERO[2][i].B;
             if (Suma == 3 || Suma == 12 ) {
                Gano = true;
                break;
            }
        }
        Suma = TABLERO[0][2].B + TABLERO[1][1].B + TABLERO[2][0].B;
        if (Suma == 3 || Suma == 12 ) {
                Gano = true;
        }
        Suma = 0;
        
        for (int i = 0; i < 3; i++) {
             Suma += TABLERO[i][i].B;
        }
        
        if (Suma == 3 || Suma == 12 ) {
                Gano = true;
        }
        return Gano;
    }
}
