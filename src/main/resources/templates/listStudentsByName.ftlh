<!DOCTYPE html>
<html>
<head>
    <title>Моя страница</title>
</head>
<body>
<h2>Список Студентов по имени ${nameStudent}</h2>
<#list studentByName as student>
<div>
    <p>
        <b>${student.name} </b> ${student.surName} ${student.groups.numberGroup}
    </p>
</div>
</#list>
</body>
</html>