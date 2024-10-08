<!DOCTYPE html>
<html lang="en">
    <%@include file='layouts/header.jsp'%>
    <body class="sb-nav-fixed">
        <%@include file='layouts/nav.jsp'%>
        <div id="layoutSidenav">
            <%@include file='layouts/nav_menu.jsp' %>
            <div id="layoutSidenav_content">
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        Casos
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Apellidos</th>
                                    <th>Cargo</th>
                                    <th>Correo</th>
                                    <th>Celular</th>
                                    <th>Documento</th>
                                    <th>Direccion</th>
                                    <th>Edad</th>
                                    <th>Especialidad</th>
                                    <th>Editar</th>
                                    <th>Eliminar</th>





                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Apellidos</th>
                                    <th>Cargo</th>
                                    <th>Correo</th>
                                    <th>Celular</th>
                                    <th>Documento</th>
                                    <th>Direccion</th>
                                    <th>Edad</th>
                                    <th>Especialidad</th>
                                    <th>Editar</th>
                                    <th>Eliminar</th>
                                </tr>
                            </tfoot>
                            <tbody>
                                <tr>         
                                    <td>Armando </td>
                                    <td>casas</td>
                                    <td>Abogado</td>
                                    <td>ArmandoCasas@valvuenaAbogados.com</td>
                                    <td>30002022021</td>
                                    <td>21025110</td>
                                    <td>Penal</td>
                                    <td>Editar</td>
                                    <td>Eliminar</td>
                                    <td>Armando</td>
                                    <td>Armando</td>
                                </tr>
                            </tbody>
                        </table>
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
