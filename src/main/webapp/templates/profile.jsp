<%@ page import="com.techblog.entities.User" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page errorPage="common/errorPage.jsp" %>
<%
    User user = (User) session.getAttribute("currentUser");
    if(Objects.isNull(user)){
        response.sendRedirect("login.jsp");
    }
%>
<html>
    <head>
        <title>Profile</title>
        <%@include file="common/headerLinks.jsp"%>
    </head>
    <body>
        <%@include file="common/loginNavbar.jsp"%>

        <main>
            <div class="container">
                <div class="row">
                    <%--Categories--%>
                    <div class="col-md-4">
                        <div class="list-group mt-4">
                            <a href="#" class="list-group-item list-group-item-action active">
                                Categories
                            </a>
                            <%
                                for(Category category : categories) {
                            %>
                            <a href="#" class="list-group-item list-group-item-action"><%= category.getCategoryName() %></a>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <%--Posts--%>
                    <div class="col-md-*"></div>
                </div>
            </div>
        </main>

        <%@include file="common/scriptLinks.jsp"%>
    </body>
</html>