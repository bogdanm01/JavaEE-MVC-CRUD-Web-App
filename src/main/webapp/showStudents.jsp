<%@page import="model.Student" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
      integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="style.css" />
    <title>Kursevi | Prikaz Polaznika</title>
</head>
 <body>
 <%
 ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("studentList");
 if (students != null) {
 %>
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
      <section class="main-content" id="show-students">
        <h1>Prikaz svih polaznika</h1>
        <div class="table-wrap">
          <table>
            <thead>
              <tr>
              <th>Ime</th>
              <th>Prezime</th>
              <th>Telefon</th>
              <th>Email</th>
              <th>Grad</th>
              <th>Nacin učenja</th>
              <th>Akcije</th>
              </tr>
            </thead>
            <tbody>
            <% for(Student s : students) { %>
              <tr>
                <td><%= s.getFirstName() %></td>
                <td><%= s.getLastName() %></td>
                <td><%= s.getPhone() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getCity() %></td>
                <td><%= s.getLearningMethod() %></td>
                <td>
                  <span class="action-buttons">
                    <a href="StudentController?action=showStudentEditForm&id=<%= s.getId() %>" id="editButton"
                      ><i class="fa-solid fa-2x fa-square-pen"></i
                    ></a>
                    <a href="StudentController?action=deleteStudent&id=<%= s.getId() %>" id="deleteButton"
                      ><i class="fa-solid fa-2x fa-square-minus"></i
                    ></a>
                  </span>
                </td>
              </tr>
              <% } %>
            </tbody>
          </table>
          <% } %>
        </div>
      </section>
    </div>
  </body>
</html>