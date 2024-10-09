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
                        Gestión de Comentarios de Casos 
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
                                            <label for="comentarios" class="form-label">Comentarios del Caso</label>
                                            <textarea class="form-control" name="comentarios"></textarea>
                                        </td>
                                    </tr>

                                <tr>
                                    <td>
                                        <input id="ingresar" class="btn btn-primary" type="submit" value="Cargar Comentario">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row row-cols-1 row-cols-md-2 g-4">
                            <div class="col">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Inicio de Proceso</h5>
                                        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                        <input id="ingresar" class="btn btn-primary" type="submit" value="Editar">
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                        <input id="ingresar" class="btn btn-primary" type="submit" value="Editar">

                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                                        <input id="ingresar" class="btn btn-primary" type="submit" value="Editar">

                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Card title</h5>
                                        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                        <input id="ingresar" class="btn btn-primary" type="submit" value="Editar">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <section class="bg-light py-5 py-xl-8">

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
