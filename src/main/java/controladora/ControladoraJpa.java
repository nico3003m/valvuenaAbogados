
package controladora;


import logica.Abogado;
import persistence.AbogadoJpaController;
import persistence.ArchivoJpaController;
import persistence.AuxiliarJpaController;
import persistence.CasoJpaController;
import persistence.ClienteJpaController;
import persistence.ComentarioJpaController;
import persistence.PersonaJpaController;

/**
 *
 * @author Nicolas Moreno
 */
public class ControladoraJpa {
    AbogadoJpaController abogadoJpa = new AbogadoJpaController();
    ArchivoJpaController archivoJap = new ArchivoJpaController();
    AuxiliarJpaController auxiliarJpa = new AuxiliarJpaController();
    CasoJpaController casoJpa = new CasoJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    ComentarioJpaController comentarioJpa= new ComentarioJpaController();
    PersonaJpaController personaJpa = new PersonaJpaController();
    
    public void crearAbogado (Abogado abg){
        abogadoJpa.create(abg);
        
    }
}
