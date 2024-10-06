
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file='layouts/header.jsp'%>
    <body>
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="image-container"><img src="img/logo.jpg" alt="logo" class="image-responsive"/></div>
                                    <div id="card-header" class="card-header"><h3 class="text-center font-weight-light my-4">Recuperación de Contraseña</h3></div>
                                    <div class="card-body">
                                        <div class="small mb-3 text-muted">Ingrese su dirección de correo electrónico y nosotros le enviaremos un link para restaurar su contraseña</div>
                                        <form>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputEmail" type="email" placeholder="name@example.com" required/>
                                                <label for="inputEmail">Correo electrónico</label>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a id="return-login" class="small" href="login.jsp">Regresar a inicio de sesión</a>
                                                <input type="submit" id="ingresar" class="btn btn-primary" href="login.jsp" value="Restaurar contraseña">
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <%@include file='layouts/footer.jsp' %>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
