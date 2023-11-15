
  <h3 align="center">Дипломная работа <br> Задание 3: тесты UI</h3>

## О работе

![product-screenshot](https://i.ibb.co/PNpSXrv/Stellar-1.png)

Есть приложение (учебное) <a href="https://stellarburgers.nomoreparties.site/">Stellar Burgers</a> - это космический фастфуд: можно собрать и заказать бургер из необычных ингредиентов.
Задание: протестировать функциональность приложения в Google Chrome и Яндекс Браузере.
Что конкретно протестировать:
#### Регистрация:
  <ul>
    <li>Успешную регистрацию</li> 
    <li>Ошибку для некорректного пароля. Минимальный пароль — шесть символов</li>
    <li>создать пользователя и не заполнить одно из обязательных полей</li>
  </ul>
<h4>Вход:</h4>
  <ul>
    <li>вход по кнопке «Войти в аккаунт» на главной</li> 
    <li>вход через кнопку «Личный кабинет»</li> 
    <li>вход через кнопку в форме регистрации</li> 
    <li>вход через кнопку в форме восстановления пароля</li> 
  </ul>
<h4>Переход в личный кабинет:</h4>
  <ul>
    <li>Проверить переход по клику на «Личный кабинет»</li> 
  </ul>
<h4>Переход из личного кабинета в конструктор:</h4>
  <ul>
    <li>Проверить переход по клику на «Конструктор» и на логотип Stellar Burgers</li> 
  </ul>
<h4>Выход из аккаунта:</h4>
  <ul>
    <li>Проверить выход по кнопке «Выйти» в личном кабинете</li> 
  </ul>
<h4>Раздел «Конструктор»:</h4>
<ul>
  <li>Проверить, что работают переходы к разделам:</li>
  <ul>
    <li>«Булки»</li>
    <li>«Соусы»</li>
    <li>«Начинки»</li>
  </ul>
</ul>
<h2>Использованы библиотеки:</h3>
  <ul>
    <li>Selenium</li> 
    <li>JUnit4</li> 
    <li>RestAssured</li>
    <li>Gson</li>
    <li>Allure</li>
  </ul>
