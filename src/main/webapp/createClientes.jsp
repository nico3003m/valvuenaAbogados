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
                        Crear Clientes
                    </div>
                    <div id="form-container" class="card-body">
                        <h4 class="mb-2 text-center">Formulario para el Registro de Clientes</h4>

                        <form action="" method="POST">

                            <table class="table">

                                <tbody>
                                    <tr>
                                        <td>
                                            <label for="name" class="form-label">Nombre del Cliente</label>
                                            <input type="text" name="name" class="form-control"  placeholder="Nombres del Cliente" required>
                                        </td>
                                        <td>
                                            <label for="apellidos" class="form-label">Apellidos del Cliente</label>
                                            <input type="text" name="apellidos" class="form-control"  placeholder="Apellidos del Cliente" required>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="documento" class="form-label">Documento de identificación</label>
                                            <input type="text" name="documento" class="form-control" placeholder="Número de identificación" required>
                                        </td>
                                        <td>
                                            <label for="edad" class="form-label">Edad</label>
                                            <input class="form-control" type="text" name="edad" placeholder="Edad" required>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="correo" class="form-label">Correo electrónico</label>
                                            <input type="email" name="correo" class="form-control"  placeholder="correo@example.com" required>
                                        </td>

                                        <td>
                                            <label for="celular" class="form-label">Celular</label>
                                            <input type="tel" name="celular" class="form-control" placeholder="3000000000" required>

                                        </td>

                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="dateNacimiento" class="form-label">Fecha de Nacimiento</label>
                                            <input type="date" name="dateNacimiento" class="form-control" required>
                                        </td>

                                        <td>
                                            <label for="direccion" class="form-label">Dirección</label>
                                            <input class="form-control" type="text" name="direccion" placeholder="Dirección de residencia" required>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td>
                                            <input id="ingresar" class="btn btn-primary" type="submit" value="Registrar Cliente">
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