/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Estudiante;
import Entidades.Nota;
import ViewModel.NotaVM;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class Notas {
    
      ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Nota> ListadoEstudiantes() {
        ArrayList<Nota> listado = null;

        try {
            listado = new ArrayList<Nota>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARNOTAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Nota es = new Nota();
                es.setNota(resultado.getString("nota"));
                es.setNombreMateria(resultado.getString("NombreMateria"));
                es.setNombre(resultado.getString("Nombre"));
          
                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
     public ArrayList<NotaVM> ListadoEstudiantesConNotas() {
        ArrayList<NotaVM> listado = null;

        try {
            listado = new ArrayList<NotaVM>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARNOTAS()}");
            ResultSet resultado = cb.executeQuery();
            
            
            while (resultado.next()) {    
                //Llamar al objeto de entidades (tabla) este debe estar dentro del bucle
                //porque se va particionando
                NotaVM es = new NotaVM();
                es.setNota(resultado.getString("nota"));
                es.setNombremateria(resultado.getString("NombreMateria"));
                es.setNombre(resultado.getString("Nombre"));
                
                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
     
     
         public void AddNota(Nota not){
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_NOTA(?,?,?)}");
            cb.setString("PNota", not.getNota());
            cb.setInt("PIdMateria", not.getIddMateria());
            cb.setInt("PIdEstudiante", not.getIddEstudiante());

            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Nota agregada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error"+ex);
            
        }}
//    public void ex(){
//    
//    String inicio = null;
//    String fin = null;
//    
//    inicio = "";
//    if (inicio.isEmpty()== inicio.equals("")){
//    
//    }
//        
//    }
    
}
