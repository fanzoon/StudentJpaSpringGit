<!DOCTYPE html>
<html>
<head>
    <title>Моя страница</title>
</head>
<body>
<h2>Список Студентов по фамилии ${surNameStudent}</h2>
<#list studentBySurName as student>
<div>
    <p>
        ${student.name} <b>${student.surName}</b> ${student.groups.numberGroup}
    </p>
</div>
</#list>
</body>
</html>