<!DOCTYPE html>
<html>
<head>
    <title>Student confirmation Form</title>
</head>
<body>
    Student is confirmed : ${student.firstName} ${student.lastName}
    <br><br>
    Country is : ${student.country}
    <br><br>
    Favourite Language : ${student.favLanguage}
    <br><br>
    Operating System :
    <ul>
    <c:forEach var = "temp" items = "${student.operatingSystem}">
    <li> ${temp} </li>
    </c:forEach>
    </ul>
</body>
</html>