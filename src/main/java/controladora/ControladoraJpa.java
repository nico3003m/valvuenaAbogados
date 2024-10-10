
package controladora;


import persistencia.AbogadoJpaController;
import persistencia.ArchivoJpaController;
import persistencia.AuxiliarJpaController;
import persistencia.CasoJpaController;
import persistencia.ClienteJpaController;
import persistencia.ComentarioJpaController;
import persistencia.PersonaJpaController;

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
}
