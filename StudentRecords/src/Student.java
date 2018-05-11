/**
 * This class is a student object.
 * Each instance of this class is a student
 *
 * @author Rishab Bhatt
 */
public class Student implements Comparable<Student> {

    private String firstName, lastName, middleInitials, studentNumber, grade, phoneNumber, email, streetAddress, city, province, postalCode;

    public Student() {

    }

    public Student(String firstName, String lastName, String middleInitials, String studentNumber, String grade, String phoneNumber, String email, String streetAddress, String city, String province, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitials = middleInitials;
        this.studentNumber = studentNumber;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    /**
     * Get the student's full name
     *
     * @return Full name
     */
    public String getFullName() {
        if (getMiddleInitials().length() > 0) {
            return String.format("%s %s %s", getFirstName(), getMiddleInitials(), getLastName());
        }
        return String.format("%s %s", getFirstName(), getLastName());
    }

    /**
     * Get the formatted address
     *
     * @return student address
     */
    public String getFormattedAddress() {
        return String.format("%s %s, %s, %s", getStreetAddress(), getCity(), getProvince(), getPostalCode());
    }

    /**
     * Get student's first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set student's first name
     *
     * @param firstName first name
     */
    public void setFirstName(String firstName) {
        this.firstName = capitalizeFirstLetter(firstName);
    }

    /**
     * Get student's last name
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set student's last name
     *
     * @param lastName last name
     */
    public void setLastName(String lastName) {
        this.lastName = capitalizeFirstLetter(lastName);
        ;
    }

    /**
     * Get student's initials
     *
     * @return initails
     */
    public String getMiddleInitials() {
        return middleInitials;
    }

    /**
     * Set student's initials
     *
     * @param middleInitials initials
     */
    public void setMiddleInitials(String middleInitials) {
        this.middleInitials = capitalizeFirstLetter(middleInitials);
    }

    /**
     * Get student number
     *
     * @return student number
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * Set student number
     *
     * @param studentNumber student number
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * Get student's grade
     *
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Set student's grade
     *
     * @param grade grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Get student's phone number
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set phone number
     *
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get student's email
     *
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set student's email
     *
     * @param email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get student's address
     *
     * @return address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Get student's street address
     *
     * @param streetAddress street address
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Get student's city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set student's city
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get student's province (short-hand)
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Set student's province (Short-hand)
     *
     * @param province province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Get student's postal code
     *
     * @return postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Set student's postal code
     *
     * @param postalCode postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Capitalize the first letter of a string
     *
     * @param string string to capitalize
     * @return capitalized string
     */
    private String capitalizeFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    /**
     * Output object to string
     *
     * @return student as string
     */
    public String toString() {
        Messages.showStudent(this);
        return "";
    }


    /**
     * Compare student by last and first them and sort
     *
     * @param student student object
     * @return
     */
    @Override
    public int compareTo(Student student) {
        if (this.getLastName().compareTo(student.getLastName()) == 0) {
            return this.getFirstName().compareTo(student.getFirstName());
        }
        return this.getLastName().compareTo(student.getLastName());
    }

}
