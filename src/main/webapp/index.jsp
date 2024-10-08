<!DOCTYPE html>
<html lang="en">
    <%@include file='layouts/header.jsp'%>
    <body class="sb-nav-fixed">
        <%@include file='layouts/nav.jsp'%>
        <div id="layoutSidenav">
            <%@include file='layouts/nav_menu.jsp' %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="image-container"><img src="img/logo.jpg" alt="logo" class="image-responsive"/></div>
                    <!-- Service 4 - Bootstrap Brain Component -->
                    <section class="bg-light py-5 py-xl-8">
                        <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col-12 col-md-10 col-lg-8 col-xl-7">
                                    <h2 class="fs-8 mb-4 text-secondary text-center text-uppercase">Bienvenido</h2>
                                    <h4 class="display-8 mb-2 text-center">A continuación, encontrarás las opciones que tienes disponibles</h4>
                                    <hr class="w-50 mx-auto mb-5 mb-xl-9 border-dark-subtle">
                                </div>
                            </div>
                        </div>

                        <div class="container overflow-hidden">
                            <div class="row gy-4 gy-xl-0">
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Ver Casos</h4>
                                            <p class="mb-4 text-secondary">En esta opción, encontrarás el listado de casos registrados.</p>
                                            <a id="btn-actions" href="#">Ingresar</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Crear Caso</h4>
                                            <p class="mb-4 text-secondary">En esta opción, podrás registrar un nuevo caso.</p>
                                            <a id="btn-actions" href="#">Ingresar</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Ver Abogados</h4>
                                            <p class="mb-4 text-secondary">En esta opción, podrás visualizar los abogados disponibles con los respectivos procesos que realizan.</p>
                                            <a id="btn-actions" href="#">Ingresar</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Asignar Abogados</h4>
                                            <p class="mb-4 text-secondary">En esta opción, podrás asignar abogados a un caso específico.</p>
                                            <a id="btn-actions" href="#">Ingresar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Service 4 - Bootstrap Brain Component -->
                    <section class="bg-light py-5 py-xl-8">
                        

                        <div class="container overflow-hidden">
                            <div class="row gy-4 gy-xl-0">
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Archivos</h4>
                                            <p class="mb-4 text-secondary">En esta opción, podrás revisar los archivos adjuntos a los casos registrados.</p>
                                            <a id="btn-actions" href="#">Ingresar</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Plantillas</h4>
                                            <p class="mb-4 text-secondary">En esta opción, podrás visualizar las plantillas y formatos respectivos a los procesos.</p>
                                            <a id="btn-actions" href="#">Ingresar</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Ver Clientes</h4>
                                            <p class="mb-4 text-secondary">En esta opción, podras visualizar los clientes y sus procesos.</p>
                                            <a id="btn-actions" href="#">Ingresar</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6 col-xl-3">
                                    <div class="card border-0 border-bottom border-golden shadow-sm">
                                        <div class="card-body text-center p-4 p-xxl-5">
                                            <h4 class="mb-4">Crear Clientes</h4>
                                            <p class="mb-4 text-secondary">En esta opción, podrás añadir nuevos clientes.</p>
                                            <a id="btn-actions" href="#">Ingresar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </section>

                </main>
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
