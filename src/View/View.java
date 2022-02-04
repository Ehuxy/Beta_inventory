package View;

import Controller.Controller;
import java.text.ParseException;
import java.util.Scanner;

public class View {

    public static void main(String[] args) throws ParseException {
        Scanner read = new Scanner(System.in);

        //AUTENTICATION PHASE
        boolean answer = true;
        System.out.println("!!!WELCOME TO THE INVENTORY OF DESARROLLA.INC!!!");
        System.out.println("For continue, please enter the username: ");
        String userName = read.nextLine();
        System.out.println("Now, please enter the password: ");
        String password = read.nextLine();
        byte checkCredentials = Controller.checkCredentials(userName, password);
        if (checkCredentials == 0) {
            System.out.println("You entered a wrong credentials, try again!!");
            answer = false;
        }
        ////////////////Create logs
        if (answer) {
            System.out.println("This project is a beta and only ten logs can be create at most");
            Controller.dataSize();
            System.out.println("For continue, you must create at least one log");
            System.out.println("How many logs are you going to create?: ");
            int dataSize = Integer.parseInt(read.nextLine());
            for (int i = 0; i < dataSize; i++) {
                //Create employee object
                System.out.println("Enter the names, last name, type of document, document number, "
                        + "cell phone, email, city, district, address, date of admission in format (dd-MM-yyyy), date of departure in format (dd-MM-yyyy)"
                        + " (OPTIONAL) of the employee " + Controller.employeID() + ", separated by comma: ");
                String strEmployee = read.nextLine();
                String arrEmployee[] = strEmployee.split(", ");
                boolean bolEmployee = Controller.createEmployee(arrEmployee);
                if (bolEmployee == false) {
                    System.out.println("You entered incorrect information, try again.");
                    answer = false;
                    break;
                }
                //Create position object
                System.out.println("Enter the position, a description of the position, "
                        + "minimum salary and maximum salary, separated by comma: ");
                String strPosition = read.nextLine();
                String arrPosition[] = strPosition.split(", ");
                boolean bolPosition = Controller.createPosition(arrPosition);
                if (bolPosition == false) {
                    System.out.println("You entered incorrect information, try again.");
                    answer = false;
                    break;
                }
                //Create area object
                System.out.println("Enter the area, a description of the area and the leader of the area, "
                        + "separated by comma: ");
                String strArea = read.nextLine();
                String arrArea[] = strArea.split(", ");
                boolean bolArea = Controller.createArea(arrArea);
                if (bolArea == false) {
                    System.out.println("You entered incorrect information, try again.");
                    answer = false;
                    break;
                }
                //Create equipments object
                System.out.println("How many equipments are you going to enter?: ");
                int equipmentsSize = Integer.parseInt(read.nextLine());
                Controller.equipmentsSize(equipmentsSize);
                boolean bolEquipment = true;
                for (int j = 0; j < equipmentsSize; j++) {
                    System.out.println("Enter the serial, type of hardware, "
                            + "name, brand and observation of the equipment, separated by comma: ");
                    String strEquipment = read.nextLine();
                    String arrEquipment[] = strEquipment.split(", ");
                    bolEquipment = Controller.createEquipment(arrEquipment);
                    if (bolEquipment == false) {
                        break;
                    }
                }
                if (bolEquipment == false) {
                    System.out.println("You entered incorrect information, try again.");
                    answer = false;
                    break;
                }
                Controller.amountEquipments();
                //Create data object with access
                if (checkCredentials == 2 || checkCredentials == 3) {
                    //Create access object
                    System.out.println("Enter de username, type of user and password, separated by comma: ");
                    String strAccess = read.nextLine();
                    String arrAccess[] = strAccess.split(", ");
                    boolean bolAccess = Controller.createAccess(arrAccess);
                    if (bolAccess == false) {
                        System.out.println("You entered incorrect information, try again.");
                        answer = false;
                        break;
                    }
                    //Create data object
                    Controller.data();
                } else {
                    Controller.data2();
                }
            }
        }
        //Profiles 
        while (answer) {
            System.out.println("Enter the action number: 1(view), 2(create), 3(edit), 4(exit)");
            int action = Integer.parseInt(read.nextLine());
            if (action == 4) {
                System.out.println("Good bye, come back soon!");
                break;
            }
            switch (action) {
                //View
                case 1:
                    if (checkCredentials == 1) {
                        System.out.println("View all data (1) or search by ID (2)?: ");
                        byte view = Byte.parseByte(read.nextLine());
                        switch (view) {
                            case 1://all data
                                System.out.println(Controller.getCommon());
                                break;
                            case 2:// search by ID
                                System.out.println("Enter the id of the employee you want to consult: ");
                                int idEmployee = Integer.parseInt(read.nextLine());
                                if (Controller.validateLog(idEmployee) == false) {
                                    System.out.println("You entered an id incorrect, try again!");
                                } else {
                                    System.out.println(Controller.getCommonId(idEmployee));
                                }
                                break;
                            default:
                                System.out.println("You entered an incorrect id, try again!");
                        }
                    } else {
                        System.out.println("View all data (1) or search by ID (2)?");
                        byte view = Byte.parseByte(read.nextLine());
                        if (view == 1) {
                            System.out.println(Controller.getAll());
                        } else if (view == 2) {
                            System.out.println("Enter the id of the employee you want to consult: ");
                            int idEmployee = Integer.parseInt(read.nextLine());
                            System.out.println(Controller.getAllById(idEmployee));
                        } else {
                            System.out.println("You entered an incorrect id, try again!");
                        }
                    }
                    break;
                //Create
                case 2:
                    //Create employee object
                    System.out.println("Enter the names, last name, type of document, document number, "
                            + "cell phone, email, city, district, address, date of admission in format (dd-MM-yyyy), date of departure in format (dd-MM-yyyy) "
                            + "(OPTIONAL) of the employee " + Controller.employeID() + ", separated by comma: ");
                    String strEmployee = read.nextLine();
                    String arrEmployee[] = strEmployee.split(", ");
                    boolean bolEmployee = Controller.createEmployee(arrEmployee);
                    if (bolEmployee == false) {
                        System.out.println("You entered incorrect information, try again.");
                        break;
                    }
                    //Create position object
                    System.out.println("Enter the position, a description of the position, "
                            + "minimum salary and maximum salary, separated by comma: ");
                    String strPosition = read.nextLine();
                    String arrPosition[] = strPosition.split(", ");
                    boolean bolPosition = Controller.createPosition(arrPosition);
                    if (bolPosition == false) {
                        System.out.println("You entered incorrect information, try again.");
                        break;
                    }
                    //Create area object
                    System.out.println("Enter the area, a description of the area and the leader of the area, "
                            + "separated by comma: ");
                    String strArea = read.nextLine();
                    String arrArea[] = strArea.split(", ");
                    boolean bolArea = Controller.createArea(arrArea);
                    if (bolArea == false) {
                        System.out.println("You entered incorrect information, try again.");
                        break;
                    }
                    //Create equipments object
                    System.out.println("How many equipments are you going to enter?: ");
                    int equipmentsSize = Integer.parseInt(read.nextLine());
                    Controller.equipmentsSize(equipmentsSize);
                    boolean bolEquipment = true;
                    for (int j = 0; j < equipmentsSize; j++) {
                        System.out.println("Enter the serial, type of hardware, "
                                + "name, brand and observation of the equipment, separated by comma: ");
                        String strEquipment = read.nextLine();
                        String arrEquipment[] = strEquipment.split(", ");
                        bolEquipment = Controller.createEquipment(arrEquipment);
                        if (bolEquipment == false) {
                            break;
                        }
                    }
                    if (bolEquipment == false) {
                        System.out.println("You entered incorrect information, try again.");
                        break;
                    }
                    Controller.amountEquipments();
                    //Create data object with access
                    if (checkCredentials == 2 || checkCredentials == 3) {
                        //Create access object
                        System.out.println("Enter the username, type of user and password, separated by comma: ");
                        String strAccess = read.nextLine();
                        String arrAccess[] = strAccess.split(", ");
                        boolean bolAccess = Controller.createAccess(arrAccess);
                        if (bolAccess == false) {
                            System.out.println("You entered incorrect information, try again.");
                            break;
                        }
                        //Create data object
                        Controller.data();
                    } else {
                        Controller.data2();
                    }
                    break;
                //Update
                case 3:
                    System.out.println("Enter the id of the employee you want to update: ");
                    int idEmployee = Integer.parseInt(read.nextLine());
                    if (Controller.validateLog(idEmployee) == false) {
                        System.out.println("You entered an id that doesn't exist");
                        break;
                    }
                    System.out.println("Enter the number of field you are going to update: ");
                    System.out.println("""
                                       names (1), last name (2), document type (3), document number (4),
                                       cell phone (5), email (6), city (7), district (8), address (9), date of admission (10),
                                       date of departure (11), position (12), description of the position (13), minimum salary (14),
                                       maximum salary (15), area (16), description of the area (17), leader (18), serial (19),
                                       hardware type (20), equipment name (21), brand (22), Observations (23), username (24), 
                                       type of user (25), password(26), cancel (27)""");
                    int field = Integer.parseInt(read.nextLine());
                    switch (field) {
                        case 1://update names
                            System.out.println("Enter the new names: ");
                            String names = read.nextLine();
                            if (names.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 1, names);
                                System.out.println("Names updated successfully!");
                            }
                            break;
                        case 2://update last name
                            System.out.println("Enter the new last name: ");
                            String lastName = read.nextLine();
                            if (lastName.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 2, lastName);
                                System.out.println("Last name updated successfully!");
                            }
                            break;
                        case 3: //update document type
                            System.out.println("Enter the new document type: ");
                            String documentType = read.nextLine();
                            if (Controller.documentType(documentType)) {
                                Controller.updateEmployee(idEmployee, 3, documentType);
                                System.out.println("Document type updated successfully!");
                            } else {
                                System.out.println("You didn't enter a correct document type");
                                break;
                            }
                            break;
                        case 4: //update document number
                            System.out.println("Enter the new document number: ");
                            String documentNumber = read.nextLine();
                            if (documentNumber.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 4, documentNumber);
                                System.out.println("Document number updated successfully!");
                            }
                            break;
                        case 5://Update cell phone
                            System.out.println("Enter the new cell phone: ");
                            String cellPhone = read.nextLine();
                            if (cellPhone.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 5, cellPhone);
                                System.out.println("cell phone updated successfully!");
                            }
                            break;
                        case 6://update email
                            System.out.println("Enter the new email: ");
                            String email = read.nextLine();
                            if (email.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else if (Controller.email(email)){
                                Controller.updateEmployee(idEmployee, 6, email);
                                System.out.println("email updated successfully!");
                            } else {
                                System.out.println("You entered an email with incorrect domain, try again");
                            }
                            break;
                        case 7://update city
                            System.out.println("Enter the new city: ");
                            String city = read.nextLine();
                            if (city.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 7, city);
                                System.out.println("City updated successfully!");
                            }
                            break;
                        case 8://update district
                            System.out.println("Enter the new district: ");
                            String district = read.nextLine();
                            if (district.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 8, district);
                                System.out.println("District updated successfully!");
                            }
                            break;
                        case 9://Update address
                            System.out.println("Enter the new address: ");
                            String address = read.nextLine();
                            if (address.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 9, address);
                                System.out.println("Address updated successfully!");
                            }
                            break;
                        case 10://update date of admission
                            System.out.println("Enter the new date of admission in format (dd/MM/yyyy): ");
                            String admissionDate = read.nextLine();
                            if (admissionDate.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 10, admissionDate);
                                System.out.println("Date of admission updated successfully!");
                            }
                            break;
                        case 11: //update date of departure
                            System.out.println("Enter the new date of departure in format (dd/MM/yyyy): ");
                            String departureDate = read.nextLine();
                            if (departureDate.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEmployee(idEmployee, 11, departureDate);
                                System.out.println("Date of departure updated successfully!");
                            }
                            break;
                        case 12://update position
                            System.out.println("Enter the new position: ");
                            String position = read.nextLine();
                            if (position.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updatePosition(idEmployee, 1, position);
                                System.out.println("Position updated successfully!");
                            }
                            break;
                        case 13://update job description
                            System.out.println("Enter the new description: ");
                            String description = read.nextLine();
                            if (description.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updatePosition(idEmployee, 2, description);
                                System.out.println("Description updated successfully!");
                            }
                            break;
                        case 14: //update minimum salary
                            if (checkCredentials == 1) {
                                System.out.println("You don't have permissions for update this field!!");
                                break;
                            } else {
                                System.out.println("Enter the new minimum salary: ");
                                String minSalary = read.nextLine();
                                if (minSalary.isBlank()) {
                                    System.out.println("You didn't enter anything!");
                                    break;
                                } else {
                                    Controller.updatePosition(idEmployee, 3, minSalary);
                                    System.out.println("Minimum salary updated successfully!");
                                }
                            }
                            break;
                        case 15: //update maximum salary
                            if (checkCredentials == 1) {
                                System.out.println("You don't have permissions for update this field!!");
                                break;
                            } else {
                                System.out.println("Enter the new maximum salary: ");
                                String maxSalary = read.nextLine();
                                if (maxSalary.isBlank()) {
                                    System.out.println("You didn't enter anything!");
                                    break;
                                } else {
                                    Controller.updatePosition(idEmployee, 4, maxSalary);
                                    System.out.println("Maximum salary updated successfully!");
                                }
                            }
                            break;
                        case 16://update area 
                            System.out.println("Enter the new area: ");
                            String area = read.nextLine();
                            if (area.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateArea(idEmployee, 1, area);
                                System.out.println("Area updated successfully!");
                            }
                            break;
                        case 17://update area description
                            System.out.println("Enter the new description of the area: ");
                            String areaDescription = read.nextLine();
                            if (areaDescription.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateArea(idEmployee, 2, areaDescription);
                                System.out.println("Description of the area updated successfully!");
                            }
                            break;
                        case 18://update leader
                            System.out.println("Enter the new leader: ");
                            String leader = read.nextLine();
                            if (leader.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateArea(idEmployee, 3, leader);
                                System.out.println("Leader updated successfully!");
                            }
                            break;
                        case 19://update serial
                            System.out.println("Enter the equipment id you are going to update: ");
                            int idEquipment = Integer.parseInt(read.nextLine());
                            if (Controller.validateEquipment(idEmployee, idEquipment) == false){
                                System.out.println("You entered an incorrect id, try again.");
                                break;
                            }
                            System.out.println("Enter the new serial: ");
                            String serial = read.nextLine();
                            if (serial.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEquipment(idEmployee, idEquipment, 1, serial);
                                System.out.println("Serial updated successfully!");
                            }
                            break;
                        case 20://update hardware type
                            System.out.println("Enter the equipment id you are going to update: ");
                            int idEquipment2 = Integer.parseInt(read.nextLine());
                            if (Controller.validateEquipment(idEmployee, idEquipment2) == false){
                                System.out.println("You entered an incorrect id, try again.");
                                break;
                            }
                            System.out.println("Enter the new hardware type: ");
                            String hardwareType = read.nextLine();
                            if (hardwareType.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEquipment(idEmployee, idEquipment2, 2, hardwareType);
                                System.out.println("Hardware type updated successfully!");
                            }
                            break;
                        case 21://update equipment name
                            System.out.println("Enter the equipment id you are going to update: ");
                            int idEquipment3 = Integer.parseInt(read.nextLine());
                            if (Controller.validateEquipment(idEmployee, idEquipment3) == false){
                                System.out.println("You entered an incorrect id, try again.");
                                break;
                            }
                            System.out.println("Enter the new equipment name: ");
                            String name = read.nextLine();
                            if (name.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEquipment(idEmployee, idEquipment3, 3, name);
                                System.out.println("Equipment name updated successfully!");
                            }
                            break;
                        case 22://update brand
                            System.out.println("Enter the equipment id you are going to update: ");
                            int idEquipment4 = Integer.parseInt(read.nextLine());
                            if (Controller.validateEquipment(idEmployee, idEquipment4) == false){
                                System.out.println("You entered an incorrect id, try again.");
                                break;
                            }
                            System.out.println("Enter the new brand: ");
                            String brand = read.nextLine();
                            if (brand.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEquipment(idEmployee, idEquipment4, 4, brand);
                                System.out.println("Brand updated successfully!");
                            }
                            break;
                        case 23://update observation
                            System.out.println("Enter the equipment id you are going to update: ");
                            int idEquipment5 = Integer.parseInt(read.nextLine());
                            if (Controller.validateEquipment(idEmployee, idEquipment5) == false){
                                System.out.println("You entered an incorrect id, try again.");
                                break;
                            }
                            System.out.println("Enter the new observation: ");
                            String observation = read.nextLine();
                            if (observation.isBlank()) {
                                System.out.println("You didn't enter anything!");
                                break;
                            } else {
                                Controller.updateEquipment(idEmployee, idEquipment5, 5, observation);
                                System.out.println("Observation updated successfully!");
                            }
                            break;
                        case 24://update user
                            if (checkCredentials == 3) {
                                System.out.println("Enter the new user: ");
                                String user = read.nextLine();
                                if (user.isBlank()) {
                                    System.out.println("You didn't enter anything!");
                                    break;
                                } else {
                                    Controller.updateAccess(idEmployee, 1, user);
                                    System.out.println("User updated successfully!");
                                }
                            } else {
                                System.out.println("You don't have permissions for update this field!!");
                                break;
                            }
                            break;
                        case 25://update user type
                            if (checkCredentials == 3) {
                                System.out.println("Enter the new user type: ");
                                String userType = read.nextLine();
                                if (userType.isBlank()) {
                                    System.out.println("You didn't enter anything!");
                                    break;
                                } else {
                                    Controller.updateAccess(idEmployee, 2, userType);
                                    System.out.println("User type updated successfully!");
                                }
                            } else {
                                System.out.println("You don't have permissions for update this field!!");
                                break;
                            }
                            break;
                        case 26://update password
                            if (checkCredentials == 3) {
                                System.out.println("Enter the new password: ");
                                String password2 = read.nextLine();
                                if (password2.isBlank()) {
                                    System.out.println("You didn't enter anything!");
                                    break;
                                } else {
                                    Controller.updateAccess(idEmployee, 3, password2);
                                    System.out.println("Password updated successfully!");
                                }
                            } else {
                                System.out.println("You don't have permissions for update this field!!");
                                break;
                            }
                            break;
                        case 27://cancel
                            break;
                        default:
                            System.out.println("You entered a invalid number, try again!");
                    }
                    break;
                default:
                    System.out.println("You entered a invalid number, try again!");
            }
        }
    }
}
