<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ include file="./init.jsp" %>

<portlet:actionURL name="addEscritor" var="addEscritorUrl"/>

<aui:form action="${addEscritorUrl}">
    <aui:input name="nombreEscritor" type="textarea" label="Escribe aquí el nombre del escritor:"/>
    <aui:button name="addEscritorButton" type="submit" value="Crear escritor"/>
</aui:form>
