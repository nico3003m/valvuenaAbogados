package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Auxiliar extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String area;
   

    public Auxiliar() {
    }

    public Auxiliar(int id, String area, Caso caso, String nombres, String apellidos, int edad, String ceuluar, String correo, String documento, String direccion) {
        super(nombres, apellidos, edad, ceuluar, correo, documento, direccion);
        this.id = id;
        this.area = area;
      
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
