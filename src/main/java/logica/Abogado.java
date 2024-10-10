package logica;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Abogado extends Persona {
    private String cargo;
    private String ntarjetaProfesional;
    private String especialidad;

    @OneToMany(mappedBy = "abogado")
    private List<Caso> casos;

    public Abogado() {
    }

    public Abogado(String cargo, String ntarjetaProfesional, String especialidad, List<Caso> casos, int id, String nombres, String apellidos, int edad, String ceuluar, String correo, String documento, String direccion) {
        super(id, nombres, apellidos, edad, ceuluar, correo, documento, direccion);
        this.cargo = cargo;
        this.ntarjetaProfesional = ntarjetaProfesional;
        this.especialidad = especialidad;
        this.casos = casos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNtarjetaProfesional() {
        return ntarjetaProfesional;
    }

    public void setNtarjetaProfesional(String ntarjetaProfesional) {
        this.ntarjetaProfesional = ntarjetaProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Caso> getCasos() {
        return casos;
    }

    public void setCasos(List<Caso> casos) {
        this.casos = casos;
    }

  
}
