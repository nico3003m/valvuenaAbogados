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
                        <i class="fas fa-business-time"></i>
                        Casos
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr>
                                    <th>Cliente</th>
                                    <th>Radicado</th>
                                    <th>Estado</th>
                                    <th>Fecha Inicio</th>
                                    <th>Juzgado</th>
                                    <th>Fecha Finalización</th>
                                    <th>Archivos</th>
                                    <th>Tipo Caso</th>
                                    <th>Comentarios</th>


                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Cliente</th>
                                    <th>Radicado</th>
                                    <th>Estado</th>
                                    <th>Fecha Inicio</th>
                                    <th>Juzgado</th>
                                    <th>Tipo Caso</th>
                                    <th>Archivos</th>
                                    <th>Tipo Caso</th>
                                    <th>Comentarios</th>
                                </tr>
                            </tfoot>
                            <tbody>
                                <tr>         
                                    <td>Armando casas</td>
                                    <td>7523982555</td>
                                    <td>Activo </td>
                                    <td>13/02/2023</td>
                                    <td>61</td>
                                    <td>2011/04/25</td>
                                    <td><button  id="buttonEditar"style="text-align: center"><a href="viewArchivos.jsp"> <i class="fas fa-eye"></a></button></i></td>
                                    <td>Judicial</td>
                                    <td><button  id="buttonEditar"style="text-align: center"><a href="viewComentarios.jsp"><i class="fas fa-comments"></a></button></i></td>
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
