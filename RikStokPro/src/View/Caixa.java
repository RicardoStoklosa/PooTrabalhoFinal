/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import EDA.*;
import DAO.*;
import Exceção.ProdNotExist;
import Exceção.QuantInvalida;
import Negocio.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class Caixa extends javax.swing.JFrame {
    JFrame close = new JFrame();
    DefaultListModel mod = new DefaultListModel();
    static Double valorfinal = 0.0;
    int iddd=0;
    int quantt=0;

    /**
     * Creates new form Caixa
     */
    public Caixa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList<>();
        nada1 = new javax.swing.JLabel();
        valorTotal = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FinalizarCompra = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logoutButton = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Caixa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("FreeSans", 1, 24)); // NOI18N
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons8-carrinho-de-compras-26.png"))); // NOI18N
        titulo.setText("- MEU CARRINHO");

        Lista.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(Lista);

        nada1.setText("Valor total:");

        valorTotal.setText("R$ 0.0");

        id.setText("ID");
        id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                idFocusLost(evt);
            }
        });
        id.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                idComponentShown(evt);
            }
        });
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jButton1.setText("Adicionar ao Carrinho");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText(":");

        FinalizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-checkout-26.png"))); // NOI18N
        FinalizarCompra.setText("Finalizar Compra");
        FinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarCompraActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-sign-out-15.png"))); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        jMenu1.add(logoutButton);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-shutdown-15.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nada1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(FinalizarCompra))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1)
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(titulo)
                                .addComponent(jButton1)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nada1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed

    }//GEN-LAST:event_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{                                         
            int idd = Integer.parseInt(id.getText());
            int quant = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantos itens deseja?", "Quantidade", JOptionPane.QUESTION_MESSAGE));
            Produto add = Main.negocio.getProdutosId(idd);
            iddd=idd;
            quantt=quant;
            for (int i = 0; i < quant; i++) {
                    valorfinal = valorfinal + add.getValor();
                }
                
                mod.addElement("Nome: " + add.getNome() + " -- Quantia: " + quant + " -- Valor: R$" + add.getValor());
                
                Lista.setModel(mod);
                id.setText("ID");
                valorTotal.setText("R$ " + valorfinal);
            
            
            
        } catch (ProdNotExist ex) {
            JOptionPane.showMessageDialog(this, "Produto nao existe", "ERRO", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void idComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_idComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_idComponentShown

    private void idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusGained
        if (id.getText().equals("ID")) {
            id.setText("");
        }
    }//GEN-LAST:event_idFocusGained

    private void idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusLost
        if (id.getText().equals("")) {
            id.setText("ID");
        }
    }//GEN-LAST:event_idFocusLost

    private void FinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarCompraActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar a compra?", "Finalizar compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
            //main estoque...
            //this.dispose();
            try{
                Main.negocio.retiradaEstoque(iddd, quantt);
            } catch (QuantInvalida ex) {
                JOptionPane.showMessageDialog(this, "Quantidade excede o máximo no estoque", "ERRO", JOptionPane.ERROR_MESSAGE);
            }catch(ProdNotExist e){
                JOptionPane.showMessageDialog(this, "Produto não existe!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            Lista.setListData(new String[0]);
            mod.clear();
            valorTotal.setText("R$ "+ 0.0);
            //new Login().setVisible(true);
        }
            
    }//GEN-LAST:event_FinalizarCompraActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
       
        try {
            this.dispose();
            Main.negocio.exit();
            new Login().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja fechar o programa?", "Fechar Programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            try {
                Main.negocio.exit();
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
            
    }//GEN-LAST:event_formWindowClosed


   
    
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
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caixa().setVisible(true);
            }

        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FinalizarCompra;
    private javax.swing.JList<String> Lista;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem logoutButton;
    private javax.swing.JLabel nada1;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel valorTotal;
    // End of variables declaration//GEN-END:variables
}
