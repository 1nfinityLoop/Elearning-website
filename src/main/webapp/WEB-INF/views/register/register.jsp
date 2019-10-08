<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Inscription</title>

  <!-- Custom fonts for this template-->
  <link href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="<%=request.getContextPath()%>/resources/https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Creer un compte<h1>
              </div>
              <form:form class="user" modelAttribute="PersonneForm" method="POST"  action="CreationUser" >
              <div class="form-group row">
                  <div class="col-sm-3 mb-3 mb-sm-0" style="text-align: center">
                  Enseignant
                  </div>
                  <div class="col-sm-3 mb-3 mb-sm-0">
                    <form:radiobutton class="form-control form-control-user" path="profession" value="Enseignant" id="radio1" checked = "checked" />
                  </div>
                  <div class="col-sm-3 mb-3 mb-sm-0" style="text-align: center">
                  Etudiant
                  </div>
                  <div class="col-sm-3 mb-3 mb-sm-0">
                     <form:radiobutton  class="form-control form-control-user" path="profession" value="Etudiant" id="radio2"/>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <form:input type="text" class="form-control form-control-user" path="nom" placeholder="Nom"/>
                  </div>
                  <div class="col-sm-6">
                    <form:input type="text" class="form-control form-control-user" path="prenom" placeholder="Prenom"/>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <form:input type="text" class="form-control form-control-user" path="adress" placeholder="Adress"/>
                  </div>
                  <div class="col-sm-6">
                    <form:input type="number" class="form-control form-control-user" path="tel" placeholder="Telephone"/>
                  </div>
                </div>
                 <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <form:input type="text" class="form-control form-control-user" path="grade" placeholder="Grade/Niveau"/>
                  </div>
                  <div class="col-sm-6">
                    <form:input type="number" class="form-control form-control-user" path="age" placeholder="Age"/>
                  </div>
                </div>
                
                <div class="form-group">
                  <form:input type="email" class="form-control form-control-user" path="email" placeholder="Email Address"/>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <form:input type="text" class="form-control form-control-user" path="userName" placeholder="Username"/>
                  </div>
                  <div class="col-sm-6">
                    <form:input type="password" class="form-control form-control-user" path="password" placeholder="Mot de passe"/>
                  </div>
                </div>
                <p style="color:red" align="center">${error }</p>
                <input class="btn btn-primary btn-user btn-block" type="submit" />
                  
                
                
                
              </form:form>
              <hr>
             
              <c:url value="/login/" var="login" />
              <div class="text-center">
                   <a class="small" href="${login}">Avez vous deja un compte ? Connection</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="<%=request.getContextPath()%>/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>

</body>

</html>
