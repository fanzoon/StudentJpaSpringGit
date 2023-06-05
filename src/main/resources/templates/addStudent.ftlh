<!DOCTYPE html>
<html>
<head>
    <title>Моя страница</title>
</head>
<body>
<h2>Введите данные о студенте</h2>
<form action="/addStudent" method="post">
    Имя студента <input type="text" name="name" > <br>
    Фамилия студента <input type="text" name="surName"> <br>
    Номер группы <select name="group">
    <#list allGroups as group1><option>${group1.numberGroup}</option>
</#list>
    </select>

    <br>
    <input type="submit" value="Добавить"/>
</form>
</body>
</html>