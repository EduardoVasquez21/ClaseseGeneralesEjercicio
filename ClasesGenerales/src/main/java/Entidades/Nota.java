/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author William
 */
public class Nota  {
    String nota;
    int iddMateria;
    int iddEstudiante;

    public Nota() {
    }

    public Nota(String nota, int iddMateria, int iddEstudiante) {
        this.nota = nota;
        this.iddMateria = iddMateria;
        this.iddEstudiante = iddEstudiante;
    }
    
    

    public int getIddMateria() {
        return iddMateria;
    }

    public void setIddMateria(int iddMateria) {
        this.iddMateria = iddMateria;
    }

    public int getIddEstudiante() {
        return iddEstudiante;
    }

    public void setIddEstudiante(int iddEstudiante) {
        this.iddEstudiante = iddEstudiante;
    }
    
    
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
}
