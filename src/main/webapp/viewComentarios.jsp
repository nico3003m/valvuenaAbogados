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
                        Gestión de Archivos Casos 
                    </div>
                    <div class="card-body">
                        <h3 style="text-align: center">Cargar Nuevos Comentarios</h3>
                        <table class="table">

                            <tbody>
                                <tr>
                                    <td>
                                        <label for="name" class="form-label">Titulo del Comentario</label>
                                        <input type="text" name="name" class="form-control"  placeholder="Titulo" required autofocus>
                                    </td>
                                </tr>


                                <tr>
                                    <td>
                                        <label for="estadoCaso" class="form-label">Abogado Asignado</label>
                                        <select class="form-select" name="estadoCaso" required>
                                            <option selected>Elige una opción</option>
                                            <option value="abierto">Juan Duque</option>
                                            <option value="progreso">Jose Sierra</option>
                                            <option value="cerrado">Romulo Caicedo</option>
                                        </select>

                                    </td>

                                </tr>

                                <tr>
                                    <td>
                                        <input id="ingresar" class="btn btn-primary" type="submit" value="Cargar Comentario ">
                                    </td>
                                </tr>
                            </tbody>
                        </table>

                    </div>
                    <section class="bg-light py-5 py-xl-8">
                        <div class="container overflow-hidden">
                            <div class="row gy-4 gy-xl-0">
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Inicio caso </h4>
                                            <p class="mb-4 text-secondary">Abogado: Jose Sierra </p>
                                            <p class="mb-4 text-secondary">Se inicia la accion de tutela en dia 28/05/2024 </p>

                                            <a id="btn-actions" href="#">Editar</a>
                                        </div>
                                    </div>
                                </div>

                                </section>

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
