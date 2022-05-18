package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class DAO {
	private static DbManager dbManager = new DbManager();
	
	private static String INSERT_STUDENT = "INSERT INTO students VALUES (null, ?, ?, ?, ?, ?, ?)";
	private static String SELECT_ALL_STUDENTS = "SELECT * FROM students";
	private static String GET_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?";
	private static String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
	
	private static String INSERT_COURSE = "INSERT INTO courses VALUES(?, ?)";
	
	public static int insertStudent (Student student) {
		// TRY-WITH-RESOURCES -> Automatski zatvara konekciju i statement
		
		try (Connection sqlConnection = dbManager.getConnection();
			PreparedStatement prepStatement = sqlConnection.prepareStatement(INSERT_STUDENT);) {
			
			prepStatement.setString(1, student.getFirstName());
			prepStatement.setString(2, student.getLastName());
			prepStatement.setString(3, student.getPhone());
			prepStatement.setString(4, student.getEmail());
			prepStatement.setString(5, student.getCity());
			prepStatement.setString(6, student.getLearningMethod());
			
			prepStatement.execute();
			return 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<Student> getAllStudents() {
		ResultSet resultSet;
		ArrayList<Student> students;
		
		try (Connection sqlConnection = dbManager.getConnection();
			PreparedStatement prepStatement = sqlConnection.prepareStatement(SELECT_ALL_STUDENTS);) {
			
				resultSet = prepStatement.executeQuery();
				students = new ArrayList<Student>();
				
				while (resultSet.next()) {
					Student tmp = new Student();
					
					tmp.setId(resultSet.getInt("id"));
					tmp.setFirstName(resultSet.getString("first_name"));
					tmp.setLastName(resultSet.getString("last_name"));
					tmp.setPhone(resultSet.getString("phone"));
					tmp.setEmail(resultSet.getString("email"));
					tmp.setCity(resultSet.getString("city"));
					tmp.setLearningMethod(resultSet.getString("learningMethod"));
					
					students.add(tmp);
				}
				
				prepStatement.execute();
				return students;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	public static int deleteStudent (int id) {
		try (Connection sqlConnection = dbManager.getConnection();
			PreparedStatement prepStatement = sqlConnection.prepareStatement(DELETE_STUDENT);) {
			
				prepStatement.setInt(1, id);
				prepStatement.execute();
				
				return 1;		
				
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
	}
	
	public static Student getStudentById (int id) {
		ResultSet resultSet;
		
		try (Connection sqlConnection = dbManager.getConnection();
			PreparedStatement prepStatement = sqlConnection.prepareStatement(GET_STUDENT_BY_ID);) {
			
			resultSet = prepStatement.executeQuery();
			resultSet.next();
			
			Student tmp = new Student();
			tmp.setId(resultSet.getInt("id"));
			tmp.setFirstName(resultSet.getString("first_name"));
			tmp.setLastName(resultSet.getString("last_name"));
			tmp.setPhone(resultSet.getString("phone"));
			tmp.setEmail(resultSet.getString("email"));
			tmp.setCity(resultSet.getString("city"));
			tmp.setLearningMethod(resultSet.getString("learningMethod"));
			
			return tmp;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}