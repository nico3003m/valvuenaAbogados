package logica;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ClienteEntidad")
public class Cliente extends Persona {
    @OneToMany(mappedBy = "cliente")
    private List<Caso> casos;

    public Cliente() {
    }

    public Cliente(List<Caso> casos, int id, String nombres, String apellidos, int edad, String ceuluar, String correo, String documento, String direccion) {
        super(id, nombres, apellidos, edad, ceuluar, correo, documento, direccion);
        this.casos = casos;
    }

    public List<Caso> getCasos() {
        return casos;
    }

    public void setCasos(List<Caso> casos) {
        this.casos = casos;
    }

   
}
