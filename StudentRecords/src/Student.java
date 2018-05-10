import java.util.Scanner;

public class Student implements Comparable {

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

    public String getFullName() {
        if (getMiddleInitials().length() > 0) {
            return String.format("%s %s %s", getFirstName(), getMiddleInitials(), getLastName());
        }
        return String.format("%s %s", getFirstName(), getLastName());
    }

    public String getFormattedAddress() {
        return String.format("%s %s, %s, %s", getStreetAddress(), getCity(), getProvince(), getPostalCode());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = capitalizeFirstLetter(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = capitalizeFirstLetter(lastName);
        ;
    }

    public String getMiddleInitials() {
        return middleInitials;
    }

    public void setMiddleInitials(String middleInitials) {
        this.middleInitials = capitalizeFirstLetter(middleInitials);
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String capitalizeFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public String toString() {
        Messages.showStudent(this);
        return "";
    }



    @Override
    public int compareTo(Object o) {
        return 0;
    }
    //Last Name
//First Name
//Middle Initials
//Student Number (9 digits)
//Grade (9-12)
//Phone Number (10 digits)
//Email
//Street Address
//City
//Province (2 characters)
//Postal Code (6 characters)

}
