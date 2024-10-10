
package logica;

import javax.persistence.Entity;

@Entity
public class Auxiliar extends Persona {
    private String area;

    public Auxiliar() {
    }

    public Auxiliar(String area, int id, String nombres, String apellidos, int edad, String ceuluar, String correo, String documento, String direccion) {
        super(id, nombres, apellidos, edad, ceuluar, correo, documento, direccion);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

   

   
}
