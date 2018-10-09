<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
  if(request.getAttribute("projDetails")!=null){
 %>
<h1 style="color:green;text-align:center">Porject Details</h1>
 project Id ::  ${projDetails.projId } <br>
 project Name ::  ${projDetails.projName } <br>
 Team Size  ::  ${projDetails.teamSize } <br>
 Period :: ${projDetails.period } <br>
 <%
  }
  else{ %>
     <h1> Record not found</h1>  
 <% } %>
 
 <br><br>
 <a href="form.html">home</a>
 
