package controllers;

import java.io.IOException;

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
	private static String NAME_REGEX = "[a-zšŠđĐčČćĆžŽ]+$";
	private static String PHONE_REGEX = "[0-9 -\\\\+]+$";
	private static String CITY_REGEX = "[a-z šŠđĐčČćĆžŽ]+$";

    public StudentController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); 
		
		if(action != null && !action.equals("")) {
	
			if (action.equals("insertStudent")) {
				insertStudent(request);
				response.sendRedirect("index.jsp");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void insertStudent(HttpServletRequest request) {
		int lastStudentId;
		
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		String city = request.getParameter("city").trim();
		String learningMethod = request.getParameter("learningMethod");
		
		String[] coursesArray = request.getParameterValues("courseName");
		
		// perform validation
		
		if ((firstName != null && firstName.length() >= 3 && firstName.matches(NAME_REGEX)) ||
			(lastName != null && lastName.length() >= 3 && lastName.matches(NAME_REGEX)) ||
			(phone != null && phone.length() > 0 && lastName.matches(PHONE_REGEX)) ||
			(email != null && email.matches(EMAIL_REGEX)) ||
			(city != null && city.length() > 0 && city.matches(CITY_REGEX))) {
			
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
			// TODO: Implement this
		}
			
			
	}

}
