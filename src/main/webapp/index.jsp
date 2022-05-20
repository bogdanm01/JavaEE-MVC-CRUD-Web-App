<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Courses | Home</title>
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
            <li class="selected">
              <i class="fa-solid fa-circle-plus"></i>
              <a href="">Upis polaznika</a>
            </li>
            <li>
              <i class="fa-solid fa-list-ul"></i>
              <a href="">Prikaz polaznika</a>
            </li>
          </ul>
        </nav>
      </section>
      <section id="main-content">
        <form action="StudentController" method="get">
          <div class="input-group">
            <label for="">Ime</label>
            <input type="text" name="firstName" id="" required />
          </div>
          <div class="input-group">
            <label for="">Prezime</label>
            <input type="text" name="lastName" id="" required />
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
            <span
              ><input type="radio" name="learningMethod" value="online" id="" />
              <label for="">Online</label></span
            >
            <span
              ><input
                type="radio"
                name="learningMethod"
                value="in-person"
                id=""
              />
              <label for="">Uzivo</label></span
            >
          </div>
          <div class="input-group">
            <label for="">Kursevi</label>
            <span>
              <input
                type="checkbox"
                name="courseName"
                value="Java Web Development"
                id=""
              />
              <label for="">Java Web Development</label>
            </span>
            <span>
              <input
                type="checkbox"
                name="courseName"
                value="Front End Web Development"
                id=""
              />
              <label for="">Front End Web Development</label>
            </span>
            <span>
              <input
                type="checkbox"
                name="courseName"
                value="Adobe Photoshop Fundamentals"
                id=""
              />
              <label for="">Adobe Photoshop Fundamentals</label>
            </span>
          </div>
          <button type="submit" value="insertStudent" name="action">
            Prijavi se!
          </button>
        </form>
      </section>
    </div>
  </body>
</html>
