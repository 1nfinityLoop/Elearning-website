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
  <link href="<%=request.getContextPath()%>/resources/template_quiz/template_css.css" rel="stylesheet" id="bootstrap-css">

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
            <h1 class="h3 mb-0 text-gray-800">Quiz : ${Quizpage.getNom() }</h1>
            <c:url value="/supprimerQuiz" var="supprimerQuiz" />   
			<a href="${supprimerQuiz }/${Quizpage.getIdQuiz()}" class="d-none d-sm-inline-block btn btn-sm btn-danger shadow-sm">Supprimer le QUIZ</a>
			<a href="notes/${Quizpage.getIdQuiz()}" class="d-none d-sm-inline-block btn btn-sm btn-success shadow-sm">Notes</a>
            
          </div>
       
			<c:forEach items="${mesQuestions}" var="question" varStatus="status">
			
          
          
    <div class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
            <h3><span class="label label-warning" id="qid">${status.index+1 }</span> ${question.getQues() }</h3>
        </div>
        <div class="modal-body">
        
        	<div class="quiz" id="quiz" data-toggle="buttons">
         <label class="element-animation1 btn btn-lg btn-primary btn-block "><span class="btn-label"></span>${question.getRep1() }</label>
         <label class="element-animation1 btn btn-lg btn-primary btn-block "><span class="btn-label"></span>${question.getRep2() }</label>
         <label class="element-animation1 btn btn-lg btn-primary btn-block "><span class="btn-label"></span>${question.getRep3() }</label>
         </div>
         <div class="modal-footer ">
    <span id="answer">Bonne reponse : ${question.getBonneRep() }</span>
		</div>
         
         </div>
         </div>
		</div>
		
         
         
          </c:forEach>
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
