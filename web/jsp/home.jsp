<%-- 
    Document   : home
    Created on : Apr 2, 2021, 12:43:16 AM
    Author     : MR TU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <script language="javascript" type="text/javascript">
            function hide(elements) {
                elements = elements.length ? elements : [elements];
                for (var index = 0; index < elements.length; index++) {
                    elements[index].style.display = 'none';
                }
            }
        </script>
    </head>
    <body >

        <c:if test="${alert != null}">
            <div class="alert" id="alert" onclick="hide(document.getElementById('alert'));">
                <span id="alert">${alert}</span>
            </div>
        </c:if>
        <h2>Employee Management</h2>
        <div class="form">
            <form action="HomeController" method="post">
                <label><span>ID </span><input type="text" class="input-field" name="id" value="" /></label>
                <label><span>Name </span><input type="text" class="input-field firstName" name="firstName" placeholder="First Name" value="" /><input type="text" class="input-field lastName" name="lastName" placeholder="Last Name" value="" /></label>
                <label><span>Gender </span>
                    <select name="gender" class="select-field">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </label>
                <label><span>Image </span><input type="text" class="input-field" name="image" placeholder="Image Link" value="" /></label>
                <input type="submit" name="add" value="Add" />
                <input type="submit" name="update" value="Update" />
                <input type="submit" name="delete" value="Delete" />
                <input type="submit" name="search" value="Search" />
                <input type="submit" name="list" value="List" />
            </form>
        </div>

        <div style="height: 30px"></div>

        <div class="list">
            <c:forEach var="i" items="${list}">
                <div class="employee">
                    <img src="image/${i.image}" alt="image/${i.image}">
                    <h2>${i.name.firstName} ${i.name.lastName}</h2>
                    <p class="gender ${i.gender=="Male"?"male":"female"}">${i.gender}</p>
                    <p class="id">ID: ${i.id}</p>
                </div>
            </c:forEach>
        </div>

    </body>
</html>
