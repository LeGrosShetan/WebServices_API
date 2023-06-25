<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>${uneMission.getLibellemission()}</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="/authentification/accueil" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Objectifs</h2>
    <div class="container">
        <h3>Liste des Objectifs de la mission ${uneMission.getLibellemission()}</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numéro d'objectif</th>
                <th class="col-md-2">Libellé d'objectif</th>
                <th class="col-md-2">Actions</th>

            </tr>

            <c:forEach items="${uneMission.getObjectifs()}" var="item">
                <tr>
                    <td>${item.getNumobjectif()}</td>
                    <td>${item.getLibobjectif()}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Actions <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <c:forEach var="action" items="${item.getActions()}">
                                    <li><a href="../../action/getUneAction/${action.getNumaction()}">${action.getLibaction()}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </td>
                    <td>
                        <a href="../../objectif/getUnObjectif/${item.getNumobjectif()}">
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
