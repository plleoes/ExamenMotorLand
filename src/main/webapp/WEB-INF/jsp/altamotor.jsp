<%-- 
    Document   : altamotor
    Created on : 13-ene-2020, 16:35:34
    Author     : plleo
--%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Motor</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/index.htm" />">Listado de motores</a></li>
                <li class="active">Alta motor</li>
            </ol>
                              
                        <form:form method="post" commandName="motores">
                              <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            <h1>Complete el formulario</h1>
                            
                                                       
                            <p>
                                <form:label path="modelo">Modelo:</form:label>
                                <form:input path="modelo" cssClass="form-control"/>
                                
                            </p>
                            
                            <p>
                                <form:label path="fabricante">Fabricante</form:label>
                                <form:input path="fabricante" cssClass="form-control" />
                            </p>
                            <p>
                                <form:label path="potencia">Potencia</form:label>
                                <form:input path="potencia" cssClass="form-control" />
                            </p>
                            <p>
                                <form:label path="peso">Peso</form:label>
                                <form:input path="peso" cssClass="form-control" />
                            </p>
                            <p>
                                <form:label path="cantidad">Cantidad</form:label>
                                <form:input path="cantidad" cssClass="form-control" />
                            </p>
                            
                               <br/>
                            <input type="submit" value="Enviar" class="btn btn-danger" />
                        </form:form>
                </div>
        </body>
</html>
