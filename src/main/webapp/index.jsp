<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <!-- PROMENJEN ENCODING NA UTF-8 -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" /> <!-- PROMENJEN ENCODING NA UTF-8 -->
    <title>Kursevi | Prijava</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
      integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div class="flex-container">
      <section id="sidebar">
        <div class="logo">
          <i class="fa-solid fa-graduation-cap"></i>
          <h1>Kursevi</h1>
        </div>
        <nav id="navigation">
          <ul>
            <a href="StudentController?action=showStudentInsert">
              <li class="selected"><i class="fa-solid fa-circle-plus"></i> Upis polaznika</li>
            </a>
            
            <a href="StudentController?action=showStudentList">
              <li><i class="fa-solid fa-list-ul"></i> Prikaz polaznika</li>
            </a>
            
          </ul>
        </nav>
      </section>
      <section class="main-content" id="insert-students">
        <div class="form-wrap">
          <h1>Aplikacioni formular za prijavu na kurseve
          </h1>
          <form action="StudentController" method="get" id="form">
            <div class="input-group">
              <label for="">Ime</label>
              <input type="text" name="firstName" id="firstName" required/>
            </div>
            <div class="input-group">
              <label for="">Prezime</label>
              <input type="text" name="lastName" id="" required/>
            </div>
  
            <div class="input-group">
              <label for="">Telefon</label>
              <input type="tel" name="phone" id="" required />
            </div>
            <div class="input-group">
              <label for="">Email</label>
              <input type="email" name="email" id="" required />
            </div>
            <div class="input-group">
              <label for="">Grad</label>
              <input type="text" name="city" id="" required />
            </div>
            <div class="input-group">
              <label for="">Metod slušanja nastave</label>
              <span>
                <input type="radio" name="learningMethod" value="Onlajn" id="" />
                <label for="">Onlajn - putem Skype-a</label>
              </span>
              <span><input
                  type="radio"
                  name="learningMethod"
                  value="Uživo"
                  id=""
                />
                <label for="">Uživo - u učionici</label></span
              >
            </div>
            <div class="input-group">
              <label for="">Kursevi</label>
              <span>
                <input
                  type="checkbox"
                  name="courseName"
                  value="Java Web Development"
                  id="check1"
                />
                <label for="">Java Web Development</label>
              </span>
              <span>
                <input
                  type="checkbox"
                  name="courseName"
                  value="Front End Web Development"
                  id="check2"
                />
                <label for="">Front End Web Development</label>
              </span>
              <span>
                <input
                  type="checkbox"
                  name="courseName"
                  value="Adobe Photoshop Fundamentals"
                  id="check3"
                />
                <label for="">Adobe Photoshop Fundamentals</label>
              </span>
            </div>
            <button id="submitFormButton" value="insertStudent" type="submit" name="action">Prijavi se!</button>
          </form>
        </div>       
      </section>
    </div>
  </body>
</html>
