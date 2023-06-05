<!DOCTYPE html>
<html>
<head>
    <title>Моя страница</title>
</head>
<body>
<h2>Введите новые данные о студенте</h2>
<form action="/changeStudent" method="post">
    <input type="hidden" name="id" value=${student.id}> <br>
    Имя студента <input type="text" name="name" value=${student.name}> <br>
    Фамилия студента <input type="text" name="surName" value=${student.surName}> <br>
    Оплата <select name="paid">
    <option>true</option>
    <option>false</option>
</select> <br>
    Номер группы <select name="groups">
    <#list allGroups as group1><option>${group1.numberGroup}</option>
</#list>
    </select>

    <br>
    <input type="submit" value="Изменить данные"/>
</form>
</body>
</html>