# phoneBook-REST-API
 REST API for working with users and their phone books

## Инструккция по запуску программы

1. Загрузить файлы из репозитория https://github.com/pasha2305/phoneBook-REST-API.git
2. Открыть в командной строке папку с проектом 
3. Перейти в командной строке /build/libs/
4. На компьютере должна быть установлена jre не ниже 11 версии
5. Выполнить команду java -jar phoneBook-0.0.1-SNAPSHOT.jar
6. Программа успешно запущена!


## Примеры вызова REST методов

1.	POST запрос на создание нового пользователя 
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%94%D0%BE%D0%B1%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F.jpg)

2.	GET запрос на получение списка всех пользователей
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA%20%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D0%B5%D0%B9.jpg)

3.	GET запрос на получение пользователя (по id)
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%9F%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%20%D0%BF%D0%BE%20id.jpg)

4.	DELETE запрос на удаление пользователя
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%A3%D0%B4%D0%B0%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F.jpg)

5.	PUT запрос на редактирование пользователя
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%9E%D0%B1%D0%BD%D0%BE%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F%20%D0%BF%D0%BE%20id.jpg)

6.  GET запрос на поиск пользователя (по имени)
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%9F%D0%BE%D0%B8%D1%81%D0%BA%20%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F%20%D0%BF%D0%BE%20%D0%B8%D0%BC%D0%B5%D0%BD%D0%B8.jpg)

7.	POST запрос на добавление записи в телефонную книжку
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%94%D0%BE%D0%B1%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%D0%BE%D0%BD%D1%82%D0%B0%D0%BA%D1%82%D0%B0%20%D0%B2%20%D1%82%D0%B5%D0%BB%D0%B5%D1%84%D0%BE%D0%BD%D0%BD%D1%83%D1%8E%20%D0%BA%D0%BD%D0%B8%D0%B6%D0%BA%D1%83%20%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F.jpg)

8.	GET запрос на получение всех записей в телефонной книжке пользователя
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5%20%D1%81%D0%BF%D0%B8%D1%81%D0%BA%D0%B0%20%D0%B7%D0%B0%D0%BF%D0%B8%D1%81%D0%B5%D0%B9%20%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8F.jpg)

9.	GET запрос на получение (по id) записи в телефонной книжке пользователя
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5%20%D1%82%D0%B5%D0%BB%D0%B5%D1%84%D0%BE%D0%BD%D0%BD%D0%BE%D0%B9%20%D0%B7%D0%B0%D0%BF%D0%B8%D1%81%D0%B8%20%D0%BF%D0%BE%20id.jpg)

10. DELETE запрос на удаление записи в телефонной книжке пользователя
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%A3%D0%B4%D0%B0%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5%20%D1%82%D0%B5%D0%BB%D0%B5%D1%84%D0%BE%D0%BD%D0%BD%D0%BE%D0%B9%20%D0%B7%D0%B0%D0%BF%D0%B8%D1%81%D0%B8.jpg)

11. PUT запрос на редактирование записи в телефонной книжке пользователя
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%9E%D0%B1%D0%BD%D0%BE%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5%20%D1%82%D0%B5%D0%BB%D0%B5%D1%84%D0%BE%D0%BD%D0%BD%D0%BE%D0%B9%20%D0%B7%D0%B0%D0%BF%D0%B8%D1%81%D0%B8.jpg)

12. GET запрос на получение телефонной записи по номеру телефона
![](https://github.com/pasha2305/phoneBook-REST-API/blob/main/screenshots/%D0%9F%D0%BE%D0%B8%D1%81%D0%BA%20%D0%B7%D0%B0%D0%BF%D0%B8%D1%81%D0%B8%20%D0%BF%D0%BE%20%D0%BD%D0%BE%D0%BC%D0%B5%D1%80%D1%83%20%D1%82%D0%B5%D0%BB%D0%B5%D1%84%D0%BE%D0%BD%D0%B0.jpg)
