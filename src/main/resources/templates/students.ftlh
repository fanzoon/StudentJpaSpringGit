<!DOCTYPE html>
<html>
<head>
    <title>Моя страница</title>
</head>
<body>
<h2>Список Студентов</h2>
<#list allStudents as student>
<div>
    <p>
        <b>${student.name} </b> ${student.surName}
    </p>
</div>
</#list>
</body>
</html>