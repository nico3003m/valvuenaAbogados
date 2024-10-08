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
                        <i class="fas fa-file-lines"></i>
                        Plantillas
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Funcion </th>
                                    <th>Tipo</th>
                                    <th>Visualizar</th>
                                    <th>Eliminar</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Funcion </th>
                                    <th>Tipo</th>
                                    <th>Visualizar</th>
                                    <th>Eliminar</th>

                                </tr>
                            </tfoot>
                            <tbody>
                                <tr>         
                                    <td>Tutela </td>
                                    <td>Ejecutar una accion de tutela</td>
                                    <td>Pdf</td>
                                    <td><button  id="buttonEditar"style="text-align: center"><i class="fas fa-eye"></button></i></td>
                                    <td> <button id="buttonEliminar" style="text-align: center"><i class="fas fa-trash"></button></i></td>
                                    
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
