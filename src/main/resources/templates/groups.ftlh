<!DOCTYPE html>
<html>
<head>
    <title>Моя страница</title>
</head>
<body>
<h2>Список групп</h2>
<#list allGroups as group>
<div>
    <p>
        <b>${group.numberGroup} </b> <a href="/groups/${group.id}">Список студентов</a>
    </p>
</div>
</#list>
</body>
</html>