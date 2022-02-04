
package Model;

import java.util.Date;

public class Employee {
    private int idEmployee, documentNumber;
    private long cellPhone;
    private static int countEmployee;
    private String names, lastName, documentType, email, city, district, address;
    private Date admissionDate;
    private Date departureDate; 
    
    //Constructor with departureDate
    public Employee(String names, String lastName, String documentType, int documentNumber, 
            Long cellPhone, String email, String city, String district, String address, Date admissionDate,
            Date departureDate) {
        this.idEmployee = ++Employee.countEmployee;
        this.documentNumber = documentNumber;
        this.cellPhone = cellPhone;
        this.names = names;
        this.lastName = lastName;
        this.documentType = documentType;
        this.email = email;
        this.city = city;
        this.district = district;
        this.address = address;
        this.admissionDate = admissionDate;
        this.departureDate = departureDate;
    }
    
    //Constructor without departureDate
    public Employee(String names, String lastName, String documentType, int documentNumber, 
            Long cellPhone, String email, String city, String district, String address, Date admissionDate) {
        this.idEmployee = ++Employee.countEmployee;
        this.documentNumber = documentNumber;
        this.cellPhone = cellPhone;
        this.names = names;
        this.lastName = lastName;
        this.documentType = documentType;
        this.email = email;
        this.city = city;
        this.district = district;
        this.address = address;
        this.admissionDate = admissionDate;
    }
    
    //Methods
    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setCellPhone(long cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    //toString()
    @Override
    public String toString(){
        return "ID: " + this.idEmployee + ", Names: " + this.names + 
                ", Last Name: " + this.lastName + ", Type of document: " + this.documentType +
                ", Document number: " + this.documentNumber + ", Cell Phone: " + this.cellPhone +
                ", Email: " + this.email + ", City: " + this.city + ", District: " + this.district +
                ", Address: " + this.address + ", Date of admission: " + this.admissionDate +
                ", Date of departure: " + this.departureDate;
    }
}
