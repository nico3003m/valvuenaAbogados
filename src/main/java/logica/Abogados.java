
package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Abogados extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cargo;
    private String nTarjetaProf;
    private String especialidad;
    @OneToMany
    private Cliente cliente;
    @OneToMany
    private Caso caso;
    @OneToMany
    private Auxiliar auxiliar;

    public Abogados() {
    }

    public Abogados(int id, String cargo, String nTarjetaProf, String especialidad, Cliente cliente, Caso caso, Auxiliar auxiliar, String nombres, String apellidos, int edad, String ceuluar, String correo, String documento, String direccion) {
        super(id,nombres, apellidos, edad, ceuluar, correo, documento, direccion);
        this.id = id;
        this.cargo = cargo;
        this.nTarjetaProf = nTarjetaProf;
        this.especialidad = especialidad;
        this.cliente = cliente;
        this.caso = caso;
        this.auxiliar = auxiliar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getnTarjetaProf() {
        return nTarjetaProf;
    }

    public void setnTarjetaProf(String nTarjetaProf) {
        this.nTarjetaProf = nTarjetaProf;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public Auxiliar getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Auxiliar auxiliar) {
        this.auxiliar = auxiliar;
    }


    
}
