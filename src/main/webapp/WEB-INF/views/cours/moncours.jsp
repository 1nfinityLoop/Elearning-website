<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Blank page</title>

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="<%=request.getContextPath()%>/resources/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/resources/template_cours/template_css.css" rel="stylesheet" id="bootstrap-css">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

		<%@ include file="/WEB-INF/views/menu_left/leftmenu.jsp"%>
       <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <%@ include file="/WEB-INF/views/menu_top/topmenu.jsp"%>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800 " style="font-weight:bold" >Cours : ${coursPage.getNom() }</h1>
            
            
            <!-- Enseignant -->
            <c:if test="${sessionScope.type eq 'enseignant' }"> 
            
             
			<c:if test="${empty coursPage.getQuiz() }">
			<c:url value="/ajouterQuiz" var="ajoutQuiz" />    
			<a href="${ajoutQuiz }/${coursPage.getIdCours()}" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">Ajouter un quiz</a>
			</c:if>
			
			
			
			
			<c:url value="/listEtud" var="listEtud" />   
			<a href="${listEtud }/${coursPage.getIdCours()}" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Etudiant Inscrit</a>
            
			<c:url value="/supprimerCours" var="supprimerCours" />   
			<a href="${supprimerCours }/${coursPage.getIdCours()}" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm">Supprimer Cours</a>
            
			
			
            </c:if>
            
            <!-- Etudiant -->
            <c:if test="${sessionScope.type eq 'etudiant' }">
	
					<c:if test="${inscrit eq 'oui' }">
						
					<c:url value="/desinscriptionCours" var="desinCours" />    
				<a href="${desinCours }/${coursPage.getIdCours()}" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm">Désinscriptions</a>
           
					</c:if>
					<c:if test="${inscrit eq 'non' }">
						
					<c:url value="/inscriptionCours" var="inscriCours" />    
				<a href="${inscriCours }/${coursPage.getIdCours()}" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">Inscriptions</a>
           
					</c:if>
			
			</c:if>
            
            
            
            
          </div>
          	<div class="row" >
          	<h5 style="font-weight:bold; color:black; margin-left:10px">Description : </h5><p class="col-xl-6 col-md-6 mb-6">${coursPage.getDescription() }</p>
          	</div>
			
			<c:if test="${sessionScope.type eq 'enseignant'}">
			
				<c:if test="${not empty coursPage.getQuiz() }">
			<c:url value="/quiz/${coursPage.getQuiz().getIdQuiz() }" var="quizPage" />  
			<a role="button" class="btn btn-primary btn-lg active" href="${quizPage}">${coursPage.getQuiz().getNom() }</a>
					</c:if>
          </c:if>
          
          
          <c:if test="${sessionScope.type eq 'etudiant'}">
          <c:if test="${inscrit eq 'oui'}">
			<c:if test="${empty noteEtud and  not empty coursPage.getQuiz()}" >
				
			<c:url value="/quizE/${coursPage.getQuiz().getIdQuiz() }" var="quizPage" />  
			<a role="button" class="btn btn-primary btn-lg active" href="${quizPage}">${coursPage.getQuiz().getNom() }</a>
			   </c:if>	
			   <c:if test="${not empty noteEtud }">
			  <p> Votre Note au QUIZ est : ${noteEtud }</p>
			   </c:if>      
          </c:if>
          </c:if>
          
        </div>
                             <c:if test="${sessionScope.type eq 'enseignant'}">
                              <c:url value="/uploadpdf" var="uploadpdf" />                   
            <form method="POST" action="${uploadpdf }/${coursPage.getIdCours()}" enctype="multipart/form-data">
            <div class="row" style="margin-top:30px;	margin-left:25px">  
						<input type="submit" style="margin-right:10px;" value="Ajouter fichier"  class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">  </input>
			        	 <input type="file" name="files" accept="application/pdf" /><br/>
			   </div>     		
   				</form>
   				</c:if>
        
        <c:if test="${sessionScope.type eq 'enseignant' or inscrit eq 'oui'}">
        <div class="drive-wrapper drive-list-view" style="background-color:transparent;">
                        <div class="table-responsive drive-items-table-wrapper">
                            <table class="table"  style="width: 100%">
                                <thead>
                                    <tr>
                                        <th style="width: 3%"class="type"></th>
                                        <th style="width: 87%" class="name truncate">Nom du fichier</th>
                                  <c:if test="${sessionScope.type eq 'enseignant'}"><th style="width: 10%"  >Supprimer</th></c:if>      
                                        
               
               
   				
                                    </tr>
                                </thead>
                                <tbody style="width: 100%">
                                <c:forEach items="${mesfichiers}" var="fichier">
                                    <tr >
                                        <td width="3%" valign="middle" class="type"><i class="fas fa-file-pdf" style="font-size:48px;color:red"></i></td>
                                        <td width="87%"style="vertical-align: middle" class="name truncate"><a href="${coursPage.getIdCours() }/pdf/${fichier.getIdFichier()}">${fichier.getNom()}</a></td>
                                        <c:if test="${sessionScope.type eq 'enseignant'}"><td width="10%" style="vertical-align: middle" valign="middle" class="type"><a href="${coursPage.getIdCours() }/remove/pdf/${fichier.getIdFichier()}"><i class="fas fa-times " style="font-size:30px;color:red"></i></a></td></c:if>
                                   
                                       </tr>
                                 </c:forEach>   
                                </tbody>
                            </table>
                        </div>
                    </div>
                 
            </c:if>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>



  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="<%=request.getContextPath()%>/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>

</body>

</html>
