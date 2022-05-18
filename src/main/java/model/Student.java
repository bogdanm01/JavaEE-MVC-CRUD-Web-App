package model;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String city;
	private String learningMethod;
	
	public Student(String firstName, String lastName, String phone, String email, String city, String learningMethod) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.learningMethod = learningMethod;
	}

	public Student(int id, String firstName, String lastName, String phone, String email, String city,
			String learningMethod) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.learningMethod = learningMethod;
	}
	
	public Student() {}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLearningMethod() {
		return learningMethod;
	}

	public void setLearningMethod(String learningMethod) {
		this.learningMethod = learningMethod;
	}
	
	@Override
	public String toString() {
		return "First name: " + firstName + "\n" +
				"Last name: " + lastName + "\n" + 
				"Phone: " + phone + "\n" +
				"Email: " + email + "\n" +
				"City: " + city + "\n" +
				"Learning method: " + learningMethod;
	}
}
