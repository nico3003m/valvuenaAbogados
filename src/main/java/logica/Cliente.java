package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private Caso caso;

    public Cliente() {
    }

    public Cliente(int id, Caso caso, String nombres, String apellidos, int edad, String ceuluar, String correo, String documento, String direccion) {
        super(id,nombres, apellidos, edad, ceuluar, correo, documento, direccion);
        this.id = id;
        this.caso = caso;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
