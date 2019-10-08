 <%@ include file="/WEB-INF/views/includes/includes.jsp"%>
 <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand --> 
      <c:url value="/home" var="home" />
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${home }">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-book"></i>
        </div>
        <div class="sidebar-brand-text mx-3">E<sup>learning.com</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
    
      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Cours
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
      <c:url value="/home" var="home" />
        <a class="nav-link" href="${home }">
          <i class="fas fa-fw fa-book"></i>
          <span>Mes cours</span></a>
          <c:if test="${sessionScope.type eq 'etudiant'}">
           <c:url value="/AllCours" var="allCours" />
          
          <a class="nav-link" href="${allCours }">
          <i class="fas fa-fw fa-book"></i>
          <span>Tous les cours</span></a>
          
          <c:url value="/mesNotes" var="mesNotes" />
          <a class="nav-link" href="${mesNotes }">
          <i class="fas fa-fw fa-table"></i>
          <span>Mes notes</span></a>
          </c:if>
      </li>

     

      <!-- Divider -->
      <hr class="sidebar-divider">

      

     
      

      <!-- Nav Item - Tables -->
      <c:url value="/monprofile" var="user" />
      <li class="nav-item">
        <a class="nav-link" href="${user }">
          <i class="fas fa-fw fa-user"></i>
          <span>Mon profile</span></a>
      </li>
       <!-- Divider -->
      <hr class="sidebar-divider">

      

     
      

      <!-- Nav Item - Tables -->
      <c:url value="/logout" var="logout" />
      <li class="nav-item">
        <a class="nav-link" href="${logout }">
          <i class="fas fa-fw fa-sign-out-alt"></i>
          <span>Deconnection</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>