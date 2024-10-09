
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file='layouts/header.jsp'%>
    <body class="sb-nav-fixed">
        <%@include file='layouts/nav.jsp'%>
        <div id="layoutSidenav">
            <%@include file='layouts/nav_menu.jsp' %>
            <div id="layoutSidenav_content">
                <div id="card-form-principal" class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-business-time"></i>
                        Crear Casos
                    </div>
                    <div id="form-container" class="card-body">
                        <h4 class="mb-2 text-center">Formulario para el Registro de un Caso Nuevo</h4>

                        <form action="" method="POST">

                            <table class="table">

                                <tbody>
                                    <tr>
                                        <td>
                                            <label for="name" class="form-label">Nombre del Cliente</label>
                                            <input type="text" name="name" class="form-control"  placeholder="Nombre" required>
                                        </td>
                                        <td>
                                            <label for="radicado" class="form-label">Número del radicado</label>
                                            <input type="text" name="radicado" class="form-control"  placeholder="Escriba el radicado del caso" required>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="estadoCaso" class="form-label">Estado del caso</label>
                                            <select class="form-select" name="estadoCaso" required>
                                                <option selected>Elige una opción</option>
                                                <option value="abierto">Abierto</option>
                                                <option value="progreso">En progreso</option>
                                                <option value="cerrado">Cerrado</option>
                                            </select>
                                        </td>
                                        <td>
                                            <label for="juzgado" class="form-label">Juzgado</label>
                                            <input type="text" name="juzgado" class="form-control"  placeholder="Juzgado" required>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="dateInicial" class="form-label">Fecha de inicio</label>
                                            <input type="date" name="dateInicial" class="form-control" required>

                                        </td>
                                        <td>
                                            <label for="dateFinal" class="form-label">Fecha de finalización</label>
                                            <input type="date" name="dateFinal" class="form-control"  required>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="dateInicial" class="form-label">Abogado Encargado</label>
                                            <input type="text" name="abogado" class="form-control" required>

                                        </td>
                                        
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="formFile" class="form-label">Archivos Adjuntos</label>
                                            <input class="form-control" type="file" name="formFile" multiple>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="comentarios" class="form-label">Comentarios del Caso</label>
                                            <textarea class="form-control" name="comentarios"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input id="ingresar" class="btn btn-primary" type="submit" value="Registrar Caso">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>

                    </div>
                </div>
                <%@include file='layouts/footer.jsp' %>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>

