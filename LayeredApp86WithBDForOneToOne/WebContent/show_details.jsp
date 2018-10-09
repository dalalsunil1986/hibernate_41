<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red;text-align:center">Student and LibraryMembership Details </h1>

 <c:choose>
  <c:when test="${!empty reportDetails}">
     <c:forEach var="stud" items="${reportDetails}">
     <span style="color:red">   ${stud.sid} &nbsp;&nbsp; ${stud.sname} &nbsp;&nbsp; ${stud.sadd} &nbsp;&nbsp; </span> <a href="controller?link=delete1&sno=${stud.sid}">delete Only Student </a> &nbsp;&nbsp; <a href="controller?link=delete2&sno=${stud.sid}">delete Student With Library Details </a> <br>
     <span style="color:blue">   ${stud.libraryDetails.lid} &nbsp;&nbsp; ${stud.libraryDetails.type} &nbsp;&nbsp; ${stud.libraryDetails.doj} &nbsp;&nbsp; </span><a href="controller?link=delete3&lno=${stud.libraryDetails.lid}">delete Only LibraryDetails </a> &nbsp;&nbsp; <a href="controller?link=delete4&lno=${stud.libraryDetails.lid}">delete Library with student Details </a> <br><br>
     </c:forEach>
  </c:when>
  <c:otherwise>
     <h1 style="color:red;text-align:center"> Records not found </h1>
  </c:otherwise>
 </c:choose> <br><br>
   &nbsp;&nbsp;&nbsp; <a href="register.html">Register new Student with Library Details</a>


 <br><br><br><br>
   <h2 style='color:red;text-align:center'> ${msg} </h2>




    
    
