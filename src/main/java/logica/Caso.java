package logica;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Caso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String radicado;
    private String fechaInicio;
    private String fechaFinalizacion;
    private String juzgado;
    private String tipoCaso;
    private String estado;
    private String tipoSolicitud;

    @ManyToOne
    @JoinColumn(name = "abogado_id")
    private Abogado abogado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "caso")
    private List<Archivo> archivos;

    public Caso() {
    }

    public Caso(Long id, String radicado, String fechaInicio, String fechaFinalizacion, String juzgado, String tipoCaso, String estado, String tipoSolicitud, Abogado abogado, Cliente cliente, List<Archivo> archivos) {
        this.id = id;
        this.radicado = radicado;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.juzgado = juzgado;
        this.tipoCaso = tipoCaso;
        this.estado = estado;
        this.tipoSolicitud = tipoSolicitud;
        this.abogado = abogado;
        this.cliente = cliente;
        this.archivos = archivos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRadicado() {
        return radicado;
    }

    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    public String getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(String tipoCaso) {
        this.tipoCaso = tipoCaso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Abogado getAbogado() {
        return abogado;
    }

    public void setAbogado(Abogado abogado) {
        this.abogado = abogado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) {
        this.archivos = archivos;
    }

    
}
