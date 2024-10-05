package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Caso implements Serializable {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String radicado;
    private String fecha_inicio;
    private String fecha_final;
    private String juzgado;
    private String tipo_caso;
    @OneToMany
    private List<Archivo> archivo;
    private List<String> comentarios;

    public Caso() {
    }

    public Caso(int id, String radicado, String fecha_inicio, String fecha_final, String juzgado, String tipo_caso, List<Archivo> archivo, List<String> comentarios) {
        this.id = id;
        this.radicado = radicado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.juzgado = juzgado;
        this.tipo_caso = tipo_caso;
        this.archivo = archivo;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRadicado() {
        return radicado;
    }

    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    public String getTipo_caso() {
        return tipo_caso;
    }

    public void setTipo_caso(String tipo_caso) {
        this.tipo_caso = tipo_caso;
    }

    public List<Archivo> getArchivo() {
        return archivo;
    }

    public void setArchivo(List<Archivo> archivo) {
        this.archivo = archivo;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }
    
    

}
