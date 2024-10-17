package controladora;

import logica.Abogado;

public class ControladoraClass {

    ControladoraJpa controladoraPersis = new ControladoraJpa();

    public void crearAbogado(String nombre, String apellidos, String correo, String documento, String celular, String edad, String direccion, String especialidad, String cargo,String nTarjetaProfesional) {
       // creacion del objeto 
        Abogado abg = new Abogado();
        // setteo 
        abg.setNombres(nombre);
        abg.setApellidos(apellidos);
        abg.setCorreo(correo);
        abg.setCargo(cargo);
        abg.setCeuluar(celular);
        abg.setDocumento(documento);
        abg.setEdad(Integer.parseInt(edad));
        abg.setDireccion(direccion);
        abg.setEspecialidad(especialidad);
        abg.setNtarjetaProfesional(nTarjetaProfesional);
        // control de persistencia 
        controladoraPersis.crearAbogado(abg);
    }

}
