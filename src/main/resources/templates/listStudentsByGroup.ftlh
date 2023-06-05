<!DOCTYPE html>
<html>
<head>
    <title>Моя страница</title>
</head>
<body>
<h2>Список Студентов по номеру группы ${groupNumber} </h2>
<#list studentsByGroup as student>
<div>
    <p>
        <b>${student.name} </b> ${student.surName}
        <a href="/changeStudentDetails/${student.id}">Изменить </a>
    <form action="/deleteStudent/${student.id}" method="post">
        <input type="submit" value="Отчислить"/>
    </form>
    </p>
</div>
</#list>
</body>
</html>