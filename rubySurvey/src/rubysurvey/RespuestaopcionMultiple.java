/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubysurvey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static rubysurvey.Inicio.pregunta;
import static rubysurvey.Inicio.resMultiple;
import static rubysurvey.PreguntasSiNo.idEncuesta;
import static rubysurvey.RespuestaAbiertas.idEncuesta;
import static rubysurvey.RespuestaAbiertas.lista;

/**
 *
 * @author USER1
 */

public class RespuestaopcionMultiple extends javax.swing.JFrame {

    /**
     * Creates new form multiplesDosCuatro
     */
    public static int idUsuarioEncuesta;
    public static String nombreEncuesta;
    public static int idEncuesta;
    public static int idPreguntas;
    public static int idRespuestaOpcion;
    
    public static ArrayList<Integer> lista = new ArrayList<>();
    public static int screenCount;
    
    public RespuestaopcionMultiple() {
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

        res1 = new javax.swing.JRadioButton();
        res2 = new javax.swing.JRadioButton();
        res3 = new javax.swing.JRadioButton();
        res4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        res1.setText("respuesta1");
        res1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res1ActionPerformed(evt);
            }
        });

        res2.setText("respuesta2");
        res2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res2ActionPerformed(evt);
            }
        });

        res3.setText("respuesta3");
        res3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res3ActionPerformed(evt);
            }
        });

        res4.setText("respuesta4");
        res4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                res4ActionPerformed(evt);
            }
        });

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Pregunta opcion Multiple?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(res2)
                        .addComponent(res3))
                    .addComponent(res4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(res1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel4)
                .addGap(0, 386, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addComponent(res1)
                .addGap(18, 18, 18)
                .addComponent(res2)
                .addGap(25, 25, 25)
                .addComponent(res3)
                .addGap(12, 12, 12)
                .addComponent(res4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void res1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res1ActionPerformed
        
        // TODO add your handling code here:
        
        try{
            
                Connection con = Conection.getConexion();
                String query = "SELECT * FROM Preguntas where Tipo='"+jLabel4.getText()+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    int val = rs.getInt("idPreguntas");
                    idPreguntas = val;
                    int val2 = rs.getInt("fkEncuesta");
                    idEncuesta = val2;
                    
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
                
                String temp = res1.getText();
                Connection con = Conection.getConexion();
                String query = "SELECT idRespuestaOpcion FROM RespuestaOpcion where TextoRespuesta='"+temp+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    
                    int val = rs.getInt("idRespuestaOpcion");
                    idRespuestaOpcion = val;
                    
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            
                Connection con = Conection.getConexion();
                String query = "INSERT INTO RespuestaUsuarioOpcion(fkEncuesta,fkPreguntas,fkRespuestaOpcion) VALUES (?,?,?)";
                
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setInt(1, idEncuesta);
                psmt.setInt(2, idPreguntas);
                psmt.setInt(2, idRespuestaOpcion);
                
                
                psmt.execute();
                System.out.println("sql success");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        
    }//GEN-LAST:event_res1ActionPerformed

    private void res3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res3ActionPerformed
        // TODO add your handling code here:
        
        try{
            
                Connection con = Conection.getConexion();
                String query = "SELECT * FROM Preguntas where Tipo='"+jLabel4.getText()+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    int val = rs.getInt("idPreguntas");
                    idPreguntas = val;
                    int val2 = rs.getInt("fkEncuesta");
                    idEncuesta = val2;
                    
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
                
                String temp = res3.getText();
                Connection con = Conection.getConexion();
                String query = "SELECT idRespuestaOpcion FROM RespuestaOpcion where TextoRespuesta='"+temp+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    
                    int val = rs.getInt("idRespuestaOpcion");
                    idRespuestaOpcion = val;
                    
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            
                Connection con = Conection.getConexion();
                String query = "INSERT INTO RespuestaUsuarioOpcion(fkEncuesta,fkPreguntas,fkRespuestaOpcion) VALUES (?,?,?)";
                
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setInt(1, idEncuesta);
                psmt.setInt(2, idPreguntas);
                psmt.setInt(2, idRespuestaOpcion);
                
                
                psmt.execute();
                System.out.println("sql success");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_res3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{
        if(lista.get(screenCount-1) == 1)
        {
            RespuestaAbiertas newFrame= new RespuestaAbiertas();
            newFrame.setVisible(true);
            this.dispose();
            RespuestaAbiertas.lista = lista;
            RespuestaAbiertas.screenCount = RespuestaAbiertas.screenCount +1; 
            System.out.println(pregunta.get(screenCount-1));
            RespuestaAbiertas.jLabel2.setText(pregunta.get(screenCount-1));
        }
        else if(lista.get(screenCount-1) == 2)
        {
            RespuestaSiNo newFrame= new RespuestaSiNo();
            newFrame.setVisible(true);
            this.dispose();
            RespuestaSiNo.lista = lista;
            RespuestaSiNo.screenCount = RespuestaSiNo.screenCount +1; 
            RespuestaSiNo.preguntaP.setText(pregunta.get(screenCount-1));
        }
        else if(lista.get(screenCount-1) == 3)
        {
            
            RespuestaopcionMultiple newFrame= new RespuestaopcionMultiple();
            newFrame.setVisible(true);
            this.dispose();
            RespuestaopcionMultiple.lista = lista;
            RespuestaopcionMultiple.screenCount = RespuestaopcionMultiple.screenCount +1; 
            RespuestaopcionMultiple.jLabel4.setText(pregunta.get(screenCount-1));
            
            
            try{
            
                // se obtiene el id del tipo de pregunta para elegir siguiente pantalla
                Connection con = Conection.getConexion();
                String query = "SELECT idPreguntas FROM Preguntas where fkEncuesta='"+idEncuesta+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                while(rs.next())
                {
                    int val = rs.getInt("idPreguntas");
                    String temps = Integer.toString(val);
                    resMultiple.add(temps);
                }
                
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            RespuestaopcionMultiple.res1.setText(resMultiple.get(0));
            RespuestaopcionMultiple.res2.setText(resMultiple.get(1));
            RespuestaopcionMultiple.res3.setText(resMultiple.get(2));
            RespuestaopcionMultiple.res4.setText(resMultiple.get(3));
            
            
        }
        }
        catch (Exception e){
            Finalizar newFrame= new Finalizar();
            newFrame.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void res2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res2ActionPerformed
        // TODO add your handling code here:
        
        try{
            
                Connection con = Conection.getConexion();
                String query = "SELECT * FROM Preguntas where Tipo='"+jLabel4.getText()+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    int val = rs.getInt("idPreguntas");
                    idPreguntas = val;
                    int val2 = rs.getInt("fkEncuesta");
                    idEncuesta = val2;
                    
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
                
                String temp = res2.getText();
                Connection con = Conection.getConexion();
                String query = "SELECT idRespuestaOpcion FROM RespuestaOpcion where TextoRespuesta='"+temp+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    
                    int val = rs.getInt("idRespuestaOpcion");
                    idRespuestaOpcion = val;
                    
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            
                Connection con = Conection.getConexion();
                String query = "INSERT INTO RespuestaUsuarioOpcion(fkEncuesta,fkPreguntas,fkRespuestaOpcion) VALUES (?,?,?)";
                
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setInt(1, idEncuesta);
                psmt.setInt(2, idPreguntas);
                psmt.setInt(2, idRespuestaOpcion);
                
                
                psmt.execute();
                System.out.println("sql success");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_res2ActionPerformed

    private void res4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_res4ActionPerformed
        // TODO add your handling code here:
        
        try{
            
                Connection con = Conection.getConexion();
                String query = "SELECT * FROM Preguntas where Tipo='"+jLabel4.getText()+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    int val = rs.getInt("idPreguntas");
                    idPreguntas = val;
                    int val2 = rs.getInt("fkEncuesta");
                    idEncuesta = val2;
                    
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
                
                String temp = res4.getText();
                Connection con = Conection.getConexion();
                String query = "SELECT idRespuestaOpcion FROM RespuestaOpcion where TextoRespuesta='"+temp+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    
                    int val = rs.getInt("idRespuestaOpcion");
                    idRespuestaOpcion = val;
                    
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            
                Connection con = Conection.getConexion();
                String query = "INSERT INTO RespuestaUsuarioOpcion(fkEncuesta,fkPreguntas,fkRespuestaOpcion) VALUES (?,?,?)";
                
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setInt(1, idEncuesta);
                psmt.setInt(2, idPreguntas);
                psmt.setInt(2, idRespuestaOpcion);
                
                
                psmt.execute();
                System.out.println("sql success");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_res4ActionPerformed

    
    /*public void getPreguntaid()
    {
        try{
            
                
                Connection con = Conection.getConexion();
                String temp = textPregunta.getText();
                String query = "SELECT idPreguntas FROM Preguntas where Tipo='"+temp+"' ";
                PreparedStatement psmt = con.prepareStatement(query);
                ResultSet rs;
                rs = psmt.executeQuery();
                
                
                
                if(rs.next())
                {
                    int val = rs.getInt("idPreguntas");
                    idPreguntas = val;
                    System.out.println("sql, se obtuvo idPreguntas");
                }
                
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }*/
    
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
            java.util.logging.Logger.getLogger(RespuestaopcionMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RespuestaopcionMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RespuestaopcionMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RespuestaopcionMultiple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RespuestaopcionMultiple().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JRadioButton res1;
    public static javax.swing.JRadioButton res2;
    public static javax.swing.JRadioButton res3;
    public static javax.swing.JRadioButton res4;
    // End of variables declaration//GEN-END:variables
}
