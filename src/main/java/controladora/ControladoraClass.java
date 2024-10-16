package controladora;

import logica.Abogado;

public class ControladoraClass {

    ControladoraJpa controladoraPersis = new ControladoraJpa();

    public void crearAbogado(String nombre, String apellidos, String correo, String cargo, String celular, String edad, String direccion, String especialidad) {
       // creacion del objeto 
        Abogado abg = new Abogado();
        // setteo 
        abg.setNombres(nombre);
        abg.setApellidos(apellidos);
        abg.setCorreo(correo);
        abg.setCargo(cargo);
        abg.setEdad(Integer.parseInt(edad));
        abg.setDireccion(direccion);
        abg.setEspecialidad(especialidad);
        // control de persistencia 
        controladoraPersis.crearAbogado(abg);
    }

}
