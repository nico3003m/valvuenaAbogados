<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">

                <a class="nav-link" href="index.jsp">
                    <div class="sb-nav-link-icon"><i style="color: #000000c9" class="fas fa-house"></i></div>
                    Inicio
                </a>

                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCasos" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i style="color: #000000c9"class="fas fa-gavel"></i></div>
                    Casos
                    <div class="sb-sidenav-collapse-arrow"> <i style="color: #000000c9" class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseCasos" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                   
                    <nav class="sb-sidenav-menu-nested nav" style="color: #000000c9;">
                        
                        <a class="nav-link" href="viewCasos.jsp">Ver Casos</a>
                        <a class="nav-link" href="createCasos.jsp">Crear Casos</a>
                    </nav>
                </div>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAbogados" aria-expanded="false" aria-controls="collapsePages">
                    <div class="sb-nav-link-icon"><i style="color: #000000c9" class="fas fa-briefcase"></i></div>
                    Abogados
                    <div class="sb-sidenav-collapse-arrow"><i style="color: #000000c9" class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseAbogados" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="viewAbogados.jsp">Ver Abogados</a>
                        <a class="nav-link" href="createAbogados.jsp">Crear Abogados</a>
                    </nav>
                </div>



               <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseArchivos" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i  style="color: #000000c9" class="far fa-folder-open"></i></div>
                    Archivos
                    <div class="sb-sidenav-collapse-arrow"><i style="color: #000000c9" class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseArchivos" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="viewPlantillas.jsp">Plantillas</a>
                        <a class="nav-link" href="layout-sidenav-light.html">Archivos casos </a>
                    </nav>
                </div>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCliente" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i style="color: #000000c9" class="fas fa-person"></i></div>
                    Clientes
                    <div class="sb-sidenav-collapse-arrow"><i style="color: #000000c9" class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseCliente" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="viewClientes.jsp">Ver clientes</a>
                        <a class="nav-link" href="createClientes.jsp">Crear Clientes</a>
                    </nav>
                </div>
               
            </div>
        </div>
        <div style="color:#4e4e4e " class="sb-sidenav-footer">
            <div class="small">Logged in as:</div>
            Start Bootstrap
        </div>
    </nav>
</div>