package controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DAO;
import model.Course;
import model.Student;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DAO dao = new DAO();
	
	private static String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	private static String NAME_REGEX = "[a-zA-ZšŠđĐčČćĆžŽ]+$";
	private static String PHONE_REGEX = "[0-9 \\-+]+$";
	private static String CITY_REGEX = "[a-zA-Z šŠđĐčČćĆžŽ]+$";

    public StudentController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); 
		
		if(action != null && !action.equals("")) {
	
			if (action.equals("insertStudent")) {
				insertStudent(request);
				response.sendRedirect("index.jsp");
			}
			
			else if (action.equals("deleteStudent")) {
				deleteStudent(request, response);
			}
			
			else if (action.equals("showStudentInsert")) {
				response.sendRedirect("index.jsp");
			}
			
			else if (action.equals("showStudentList")) {
				redirectToShowStudents(request, response);
			
			}
			
			else if (action.equals("showStudentEditForm")) {
				showStudentEditForm(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void showStudentEditForm(HttpServletRequest request, HttpServletResponse response) {
		String str_studentId = request.getParameter("id");
		
		try {
			int studentId = Integer.parseInt(str_studentId);
			request.setAttribute("student", dao.getStudentById(studentId));
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		String str_studentId = request.getParameter("id");
		try {
			int studentId = Integer.parseInt(str_studentId);
			dao.deleteStudent(studentId);
			redirectToShowStudents(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void redirectToShowStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Student> studentList = dao.getAllStudents();
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("showStudents.jsp").forward(request, response);
	}
	
	private void insertStudent(HttpServletRequest request) {
		
		int lastStudentId;
		 try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		String city = request.getParameter("city").trim();
		String learningMethod = request.getParameter("learningMethod");
		
		String[] coursesArray = request.getParameterValues("courseName");
		
		// perform validation
		
		if ((firstName != null && firstName.length() >= 3 && firstName.matches(NAME_REGEX)) &&
			(lastName != null && lastName.length() >= 3 && lastName.matches(NAME_REGEX)) &&
			(phone != null && phone.length() > 0 && phone.matches(PHONE_REGEX)) &&
			(email != null && email.matches(EMAIL_REGEX)) &&
			(city != null && city.length() > 0 && city.matches(CITY_REGEX)) && 
			coursesArray != null) {
			
			Student s = new Student();
			
			s.setFirstName(firstName);
			s.setLastName(lastName);
			s.setPhone(phone);
			s.setEmail(email);
			s.setCity(city);
			s.setLearningMethod(learningMethod);
						
			lastStudentId = dao.insertStudent(s);
			
			if (lastStudentId != -1) {
				for (String courseName : coursesArray) {
					Course course = new Course(lastStudentId, courseName);
					dao.insertCourses(course);
				}
			}
			
		} else {
			System.out.println("Erorr: Invalid input!");
			System.out.println("FirstName: " + firstName.matches(NAME_REGEX));
			System.out.println("LastName: " + lastName.matches(NAME_REGEX));
			System.out.println("Email: " + email.matches(EMAIL_REGEX));
			System.out.println("City: " + city.matches(CITY_REGEX));
			System.out.println("Phone: " + phone.matches(PHONE_REGEX));
		}
			
	}
}
