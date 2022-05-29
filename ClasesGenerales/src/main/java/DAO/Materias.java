/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entidades.Materia;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vkaiido
 */
public class Materias {
    
       ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Materia> ListaMateria() {
        ArrayList<Materia> listado = null;

        try {
            listado = new ArrayList<Materia>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MATERIAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Materia mt = new Materia();
                mt.setIdMateria(resultado.getInt("idMateria"));
                mt.setNombreMateria(resultado.getString("NombreMateria"));
                listado.add(mt);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
    
    
    public void addMateria(Materia es){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_MATERIAS(?)}");
            cb.setString("PMateria", es.getNombreMateria());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "materia agregada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","Mensje sistems",1);
            
        }}
    
    
    
   
    
}
