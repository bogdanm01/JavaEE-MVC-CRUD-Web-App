<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
      integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="style.css" />
<title>KURSEVI | Izmena</title>
</head>
<body>
	<% Student currentStudent = (Student) request.getAttribute("student");%>
	<div class="flex-container">
      <section id="sidebar">
        <div class="logo">
          <i class="fa-solid fa-graduation-cap"></i>
          <h1>Kursevi</h1>
        </div>
        <nav id="navigation">
          <ul>
            <a href="StudentController?action=showStudentInsert">
              <li><i class="fa-solid fa-circle-plus"></i> Upis polaznika</li>
            </a>
            <a href="StudentController?action=showStudentList">
              <li class="selected">
                <i class="fa-solid fa-list-ul"></i> Prikaz polaznika
              </li>
            </a>
          </ul>
        </nav>
      </section>
      <section class="main-content" id="insert-students">
      	<a href="StudentController?action=showStudentList" class="btn back"><i class="fa-solid fa-circle-chevron-left"></i> Nazad</a>
        <div class="form-wrap">
          <h1>Izmena detalja polaznika</h1>
          <form action="" method="get">
            <div class="input-group">
              <label for="">Ime</label>
              <input type="text" name="firstName" id="firstName" value=<%= currentStudent.getFirstName() %> required/>
            </div>
            <div class="input-group">
              <label for="">Prezime</label>
              <input type="text" name="lastName" id="" value=<%= currentStudent.getLastName() %> required/>
            </div>
  
            <div class="input-group">
              <label for="">Telefon</label>
              <input type="tel" name="phone" id="" value="<%= currentStudent.getPhone() %>" required />
            </div>
            <div class="input-group">
              <label for="">Email</label>
              <input type="email" name="email" id="" value=<%= currentStudent.getEmail() %> required />
            </div>
            <div class="input-group">
              <label for="">Grad</label>
              <input type="text" name="city" id="" value=<%= currentStudent.getCity() %> required />
            </div>
            <div class="input-group">
              <label for="">Metod slusanja nastave</label>
              <span>
                <input 
                type="radio" 
                name="learningMethod" 
                value="online" 
                <% if(currentStudent.getLearningMethod().equalsIgnoreCase("onlajn")) { out.print("checked"); }  %>
                />
                <label for="">Online - putem Skype-a</label>
              </span>
              <span><input
                  type="radio"
                  name="learningMethod"
                  value="in-person"
                  <% if(currentStudent.getLearningMethod().equalsIgnoreCase("uživo")) { out.print("checked"); }  %>
                />
                <label for="">Uzivo - u ucionici</label></span
              >
            </div>
            
            <button value="editStudent" name="action">Izmeni</button>
          </form>
        </div>       
      </section>
    </div>
</body>
</html>