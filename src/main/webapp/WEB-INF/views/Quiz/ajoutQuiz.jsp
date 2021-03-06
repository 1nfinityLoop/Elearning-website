<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Quiz</title>

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="<%=request.getContextPath()%>/resources/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css" rel="stylesheet">

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
        
        <!-- /.container-fluid -->
         <!-- /FORMULAIRE -->
        <div class="container">
        
        <div class="row justify-content-md-center">
        
        <form:form class="user col-sm-8 col-lg-8  mb-3 mb-sm-0 justify-content-md-center" modelAttribute="form_quiz" method="POST"  action="ajoutQuiz/${idcours }" >
              <h1 class="row justify-content-md-center" >Ajouter un Quiz</h1>
              <hr>
              <br>
              
              
              
              
                    <form:input type="text" class="form-control form-control-user " path="nom" placeholder="Nom du quiz"/>
                    <br>
                    <form:input type="number" class="form-control form-control-user " path="time" placeholder="temps du quiz"/>
          <br>
          
          <c:forEach var="qst" items="${form_quiz.questions}" varStatus="status">
          <p>Question ${status.index+1 }</p>
        <form:input class="form-control form-control-user " path="questions[${status.index}].ques" placeholder="Question" />
        <br>
        <div style="width: 100%">
        <form:input class="form-control form-control-user " style="width: 70%;display:inline" path="questions[${status.index}].rep1" placeholder="Reponse1" />
        <form:radiobutton  style="width: 20%" path="questions[${status.index}].bonneRep" value="1" id="radio"/>
        </div>
        <br>
        <div style="width: 100%">
        <form:input class="form-control form-control-user " style="width: 70%;display:inline" path="questions[${status.index}].rep2"  placeholder="Reponse2" />
       	<form:radiobutton  style="width: 20%" path="questions[${status.index}].bonneRep" value="2" id="radio"/>
        </div>
        <br>
        <div style="width: 100%">
        <form:input class="form-control form-control-user " style="width: 70%;display:inline" path="questions[${status.index}].rep3"  placeholder="Reponse3" />
   		<form:radiobutton  style="width: 20%" path="questions[${status.index}].bonneRep" value="3" id="radio"/>
   		
        </div>
        <hr>
         </c:forEach>
              <br>
              <br>
                <input class="btn btn-primary btn-user btn-block" type="submit" value="Ajouter"/>
                  
                
                
              </form:form>
        </div>
        </div>

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
