<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="./init.jsp" %>

<jsp:useBean id="escritor" type="tutoriales.liferay.crud.libro.model.Escritor" scope="request"/>

<portlet:actionURL name="editEscritor" var="editEscritorUrl"/>

<aui:form action="${editEscritorUrl}">
    <aui:input name="nombreEscritor" label="Modifica aquí el nombre del escritor:" value="<%=escritor.getNombre() %>"/>
    <aui:input name="idEscritor" type="hidden" value="<%=String.valueOf(escritor.getEscritorId()) %>"/>
    <aui:button name="editEscritorButton" type="submit" value="Editar escritor"/>
</aui:form>
