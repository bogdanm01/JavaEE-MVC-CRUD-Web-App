package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Course;
import model.Student;

public class DAO {
	private static DbManager dbManager = new DbManager();
	
	private static String INSERT_STUDENT = "INSERT INTO students VALUES (null, ?, ?, ?, ?, ?, ?)";
	private static String SELECT_ALL_STUDENTS = "SELECT * FROM students";
	private static String GET_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?";
	private static String UPDATE_STUDENT = "UPDATE students SET first_name = ?, last_name = ?, phone = ?, email = ?, city = ?, learning_method = ? WHERE id = ?";
	private static String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
	
	private static String INSERT_COURSE = "INSERT INTO courses VALUES(null, ?, ?)";
	
	public int updateStudent (Student updatedStudent) {
		try (Connection sqlConnection = dbManager.getConnection();
			PreparedStatement prepStatement = sqlConnection.prepareStatement(UPDATE_STUDENT);) {
			
			prepStatement.setString(1, updatedStudent.getFirstName());
			prepStatement.setString(2, updatedStudent.getLastName());
			prepStatement.setString(3, updatedStudent.getPhone());
			prepStatement.setString(4, updatedStudent.getEmail());
			prepStatement.setString(5, updatedStudent.getCity());
			prepStatement.setString(6, updatedStudent.getLearningMethod());
			prepStatement.setInt(7, updatedStudent.getId());
			
			prepStatement.execute();
			
			return 1;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public int insertStudent (Student student) {
		// TRY-WITH-RESOURCES -> Automatski zatvara konekciju i statement
		// returns id of last inserted student
		
		ResultSet resultSet;
		int lastInsStudentId;
		
		try (Connection sqlConnection = dbManager.getConnection();
			PreparedStatement prepStatement = sqlConnection.prepareStatement(INSERT_STUDENT, Statement.RETURN_GENERATED_KEYS);) {
			
			prepStatement.setString(1, student.getFirstName());
			prepStatement.setString(2, student.getLastName());
			prepStatement.setString(3, student.getPhone());
			prepStatement.setString(4, student.getEmail());
			prepStatement.setString(5, student.getCity());
			prepStatement.setString(6, student.getLearningMethod());
			
			prepStatement.executeUpdate();
			resultSet = prepStatement.getGeneratedKeys();
			resultSet.last(); // moves resultset pointer to last row
			
			lastInsStudentId = resultSet.getInt(1);
			return lastInsStudentId;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public ArrayList<Student> getAllStudents() {
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
					tmp.setLearningMethod(resultSet.getString("learning_method"));
					
					students.add(tmp);
				}
				
				prepStatement.execute();
				return students;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	public int deleteStudent (int id) {
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
	
	public Student getStudentById (int id) {
		ResultSet resultSet;
		
		try (Connection sqlConnection = dbManager.getConnection();
			PreparedStatement prepStatement = sqlConnection.prepareStatement(GET_STUDENT_BY_ID);) {
			
			prepStatement.setInt(1, id);
			prepStatement.execute();
			
			resultSet = prepStatement.getResultSet();
			resultSet.next();
			
			Student tmp = new Student();
			tmp.setId(resultSet.getInt("id"));
			tmp.setFirstName(resultSet.getString("first_name"));
			tmp.setLastName(resultSet.getString("last_name"));
			tmp.setPhone(resultSet.getString("phone"));
			tmp.setEmail(resultSet.getString("email"));
			tmp.setCity(resultSet.getString("city"));
			tmp.setLearningMethod(resultSet.getString("learning_method"));
			
			return tmp;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insertCourses(Course course) {
		try (Connection sqlConnection = dbManager.getConnection();
			PreparedStatement prepStatement = sqlConnection.prepareStatement(INSERT_COURSE);) {
			
				prepStatement.setInt(1, course.getId());
				prepStatement.setString(2, course.getName());
				
				prepStatement.executeUpdate();
				return 1;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
