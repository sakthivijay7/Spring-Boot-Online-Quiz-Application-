# Spring-Boot-Online-Quiz-Application
#### Date:Aug09- 2025

- Model:
  
Model contains user information like Name,Gender,Email,Password,Phone and execute automatic ``Entity`` to assign  table in database.

- Repository :
  
JpaRepository to set the query findByEmail this will check email id if exist in database or not and also save the user information in the database with default Model class name(table name).

- Controller:
  
1.Register controller :
- Control the registration form and it's path ``GetMapping("/register")``  it return the register.html.
- Name,Gender,Email,Password,Phone values ``PostMapping("/register")`` to pass in the ``"/register"`` page. 
- Values to be stored in the MySQL database using JpaRepository it automatically creates a SQL queries.
- Condition to Check if email already exists , if not exists registration success else map to login page.
- Register controller had return register.html and ``thymeleaf`` to pass the values ``Java to html`` and ``html to Java`` 
- Java to pass values help with ``Model`` like model.addAttribute("messagekey","java messagevalue")

2.Login controller :
- control the login page and it's path ``GetMapping("/login")`` it return the login.html.
- Email id and password enter to login and ``PostMapping("/login")`` to request parameter through the ``"/login"`` page.
- Conditions if email not exists like not registered  navigate to the registration page and also check password.
- Login controller had  return login.html and navigate to the ``main page`` with user information.

3.Test controller :
- control the main page and  "GetMapping("/test") it return the main.html
- Main page had login succeed user only allow and it contains their details with Quiz pages like select Quiz language - ``Python or Java``
- ``GetMapping("/python")`` and ``"GetMapping("/java")`` this will return the python and java quiz pages.
- Main page had return main.html and quiz pages. 

- Main Spring Boot Application to scanpackages and execute the Spring Boot Application

- Front End :
  
- html to create the form registeration ,login  and main , quiz pages
- Animation and coloring done by css
- Java script done the crucial rule to help the java application navigation process like if java pass the messages to html then js getelements to alert if click ``window.location.href="/javapath"`` this model to done by the all navigation process with alert .
- Navigation and user information locally save in the web it help retake like quiz page to back to the main page with default details.
- All the java messages are window.onload function to execute the alert.

- Tools and Techniques 
Java,
Spring Boot,
HTML & CSS and JS ,
VS code.


REGISTRATION PAGE :
<img width="955" height="601" alt="register" src="https://github.com/user-attachments/assets/35a97c8a-ce74-4c2f-a62c-20f8c6bc2532" />

LOGIN PAGE :
<img width="848" height="576" alt="login" src="https://github.com/user-attachments/assets/484ae8fd-0550-4914-9e2c-2ff80cd06bc0" />

MAIN PAGE :
<img width="804" height="538" alt="userinfo" src="https://github.com/user-attachments/assets/5b195be6-133c-412b-9100-ecb622f3eb20" />

QUIZ PAGE :
<img width="857" height="515" alt="quizpage" src="https://github.com/user-attachments/assets/f084297a-ea92-424d-9c3b-e1754bddd46d" />







