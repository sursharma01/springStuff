<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <form:form action = "processForm" modelAttribute = "student">
    First name : <form:input path = "firstName" />
        <br><br>
    Last name : <form:input path = "lastName" />
        <br><br>
        Country:
        <form:select path = "country">
        <form:options items = "${student.countryMap}"/>
        <%--For passing drop-down from jsp page
        <form:option value = "Argentina" label = "Argentina"/>
        <form:option value = "Brazil" label = "Brazil"/>
        <form:option value = "India" label = "India"/>
        <form:option value = "Japan" label = "Japan"/>--%>
        </form:select>

        <br><br>

        Favourite Programming language :
        <form:radiobuttons path="favLanguage" items="${student.favLanguageOptions}"  />

        <%-- For passing radio buttons from jsp page
        Java <form:radiobutton path = "favLanguage" value = "Java"/>
        Python <form:radiobutton path = "favLanguage" value = "Python"/>
        C++ <form:radiobutton path = "favLanguage" value = "C++"/>--%>

        <br><br>
        Operating system :
        Windows <form:checkbox path = "operatingSystem" value = "Windows"/>
        Linux <form:checkbox path = "operatingSystem" value = "Linux"/>
        MacOs <form:checkbox path = "operatingSystem" value = "MacOs"/>
        <br><br>
    <input type = "submit" value= "Submit" />
    </form:form>
</body>
</html>