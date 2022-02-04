
package Model;

import Controller.Controller;
import Model.Access;
import java.util.Date;

public class Data {
    private Employee employee;
    private Position position;
    private Area area;
    private Equipment equipments[];
    private Access access;
    
    //Constructor with access object
    public Data(Employee employee, Position position, Area area, Equipment equipments[], Access access){
        this.employee = employee;
        this.position = position;
        this.area = area;
        this.equipments = equipments;
        this.access = access;
    }
    //Constructor without access object
    public Data(Employee employee, Position position, Area area, Equipment equipments[]){
        this.employee = employee;
        this.position = position;
        this.area = area;
        this.equipments = equipments;
    }
    
    //Method for validate the id of equipment
    public boolean validateEquipment(int idEquipment){
        if(idEquipment >= 1 && idEquipment <= this.equipments.length){
            return true;
        } else {
            return false;
        }
    }
    
    //Methods "set" of employe object
    public void setNames(String names){
        this.employee.setNames(names);
    }
    
    public void setLastName(String lastName){
        this.employee.setLastName(lastName);
    }
    
    public void setDocumentType(String documentType){
        this.employee.setDocumentType(documentType);
    }
    
    public void setDocumentNumber(int documentNumber){
        this.employee.setDocumentNumber(documentNumber);
    }
    
    public void setCellPhone(long cellPhone){
        this.employee.setCellPhone(cellPhone);
    }
    
    public void setEmail(String email){
        this.employee.setEmail(email);
    }
    
    public void setCity(String city){
        this.employee.setCity(city);
    }
    
    public void setDistrict(String district){
        this.employee.setDistrict(district);
    }
    
    public void setAddress(String address){
        this.employee.setAddress(address);
    }
    
    public void setAdmissionDate(Date admissionDate){
        this.employee.setAdmissionDate(admissionDate);
    }
    
    public void setDepartureDate(Date departureDate){
        this.employee.setDepartureDate(departureDate);
    }
    
    //Methods "set" of position object
    public void setPosition(String position){
        this.position.setPosition(position);
    }
    
    public void setPositionDescription(String positionDescription) {
        this.position.setPosition(positionDescription);
    }
    
    public void setMinSalary(double minSalary) {
        this.position.setMinSalary(minSalary);
    }
    
    public void setMaxSalary(double maxSalary) {
        this.position.setMaxSalary(maxSalary);
    }
    
    //Methods "set" of area object
    public void setArea(String area) {
        this.area.setArea(area);
    }
    
    public void setDescriptionArea(String description) {
        this.area.setDescription(description);
    }
    
    public void setLeader(String leader) {
        this.area.setLeader(leader);
    }
    
    //Methods "set" of area equipments
    public void setSerial(int equipment, String serial) {
        this.equipments[equipment].setSerial(serial);
    }
    
    public void setHardwareType(int equipment, String hardwareType) {
        this.equipments[equipment].setHardwareType(hardwareType);
    }
    
    public void setName(int equipment, String name) {
        this.equipments[equipment].setName(name);
    }
    
    public void setBrand(int equipment, String brand) {
        this.equipments[equipment].setBrand(brand);
    }
    
    public void setObservation(int equipment, String observation) {
        this.equipments[equipment].setObservation(observation);
    }
    
    //Methods "set" of access object
    public void setUser(String user) {
        this.access.setUser(user);
    }
    
    public void setUserType(String userType) {
        this.access.setUserType(userType);
    }
    
    public void setPassword(String password) {
        this.access.setPassword(password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("employee=").append(employee);
        sb.append(", position=").append(position);
        sb.append(", area=").append(area);
        sb.append(", equipments=");
        for (int i = 0; i < equipments.length; i++) {
            sb.append(equipments[i]);
        }
        sb.append(", acceso=").append(access);
        sb.append('}');
        return sb.toString();
    }
    
    public String getCommon() {
        StringBuilder sb = new StringBuilder();
        sb.append("employee=").append(employee);
        sb.append(", position=").append(position.getCommon());
        sb.append(", area=").append(area);
        sb.append(", equipments=");
        for (int i = 0; i < equipments.length; i++) {
            sb.append(equipments[i]);
        }
        sb.append('}');
        return sb.toString();
    }
}
