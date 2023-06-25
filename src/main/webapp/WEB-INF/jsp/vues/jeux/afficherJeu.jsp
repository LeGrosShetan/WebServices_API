<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>${unJeu.getLibellejeu()}</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="/authentification/accueil" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Missions</h2>
    <div class="container">
        <h3>Liste des Missions du jeu ${unJeu.getLibellejeu()}</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numéro de mission</th>
                <th class="col-md-2">Libellé de mission</th>
                <th class="col-md-2">Objectifs</th>

            </tr>

            <c:forEach items="${unJeu.getMissions()}" var="item">
                <tr>
                    <td>${item.getNummission()}</td>
                    <td>${item.getLibellemission()}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Objectifs <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <c:forEach var="objectif" items="${item.getObjectifs()}">
                                    <li><a href="../../objectif/getUnObjectif/${objectif.getNumobjectif()}">${objectif.getLibobjectif()}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </td>
                    <td>
                        <a href="../../mission/getUneMission/${item.getNummission()}">
                            <span class="glyphicon glyphicon-eye-open"></span>
                        </a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</div>
<%@include file="../footer.jsp"%>
</body>

</html>
