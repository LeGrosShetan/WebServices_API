<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>Listing des Jeux</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="/authentification/accueil" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Jeux</h2>
    <div class="container">
        <h3>Liste des Jeux</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numéro de jeu</th>
                <th class="col-md-2">Libellé de jeu</th>
                <th class="col-md-2">Mission</th>

            </tr>

            <c:forEach items="${mesJeux}" var="item">
                <tr>
                    <td>${item.getNumjeu()}</td>
                    <td>${item.getLibellejeu()}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Missions <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <c:forEach var="mission" items="${item.getMissions()}">
                                    <li><a href="../../mission/getUneMission/${mission.getNummission()}">${mission.getLibellemission()}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </td>
                    <td>
                        <a href="../../jeu/getUnJeu/${item.getNumjeu()}">
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