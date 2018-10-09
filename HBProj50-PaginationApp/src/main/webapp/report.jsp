<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Report through Pagination</h1>
<c:choose>
  <c:when test="${!empty reportData}">
   <table border=1>
    <tr><th>eid</th><th>firstname</th><th>lastname</th><th>salary</th> </tr>
     <c:forEach var="emp" items="${reportData}">
       <tr>
         <td>${emp.eid}</td>
         <td>${emp.firstName}</td>
         <td>${emp.lastName}</td>
         <td>${emp.salary}</td>
       </tr>
     </c:forEach>
  </table>
  </c:when>
  <c:otherwise>
    Data not found
  </c:otherwise>
</c:choose>
<br><br>
<c:forEach var="i" begin="1" end="${pagesCount}" step="1">
   [ <a href="controller?pageNo=${i}">${i}</a>] &nbsp; &nbsp;&nbsp;
</c:forEach>


