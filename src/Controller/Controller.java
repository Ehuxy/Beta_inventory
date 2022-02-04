package Controller;

import Model.*;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class Controller {

    //Attributes of employe object
    private static Employee employee;
    //Attributes of position object
    private static Position position;
    //Attributes of area object
    private static Area area;
    //Attributes of equipments object array
    private static int amountEquipments = 0;
    private static Equipment equipments[];
    //Attributes of access object
    private static Access access;
    //Attributes of data object
    private static Data data[];
    private static int amountData = 0;

    ///////////LAYER ONE/////////////////
    ////VALIDATIONS
    //Method for validate the type of document
    public static boolean documentType(String documentType) {
        boolean answer;
        switch (documentType) {
            case "CC","CE","PASAPORTE","PEP","VISA":
                answer = true;
                break;
            default:
                answer = false;
        }
        return answer;
    }

    //Method for validate the email with the domain @desarrolla.co
    public static boolean email(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@desarrolla.co");
        Matcher mather = pattern.matcher(email);
        boolean answer;
        if (mather.find()) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    //Method for validate the null fields in arrays
    private static boolean nullFields(String arr[]) {
        boolean answer = true;
        for (int i = 0; i < arr.length; i++) {
            if (i == 10) {
                continue;
            }
            if (arr[i].isBlank()) {
                answer = false;
            }
        }
        return answer;
    }

    //Method for validate that the user wrote all the information in the employee object
    private static boolean dataEmployee(String arrEmployee[]) {
        boolean answer;
        if (arrEmployee.length == 11 || arrEmployee.length == 10) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    //Method for validate that the user wrote all the information in the position object
    private static boolean dataPosition(String arrPosition[]) {
        boolean answer;
        if (arrPosition.length == 4) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    //Method for validate that the user wrote all the information in the area object
    private static boolean dataArea(String arrArea[]) {
        boolean answer;
        if (arrArea.length == 3) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    //Method for validate that the user wrote all the information in the equipment object
    private static boolean dataEquipment(String arrEquipment[]) {
        boolean answer;
        if (arrEquipment.length == 5) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    //Method for validate that the user wrote all the information in the access object
    private static boolean dataAccess(String arrAccess[]) {
        boolean answer;
        if (arrAccess.length == 3) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    ////////CREATE
    //Create empployee object
    private static void employee(boolean departureDate, String arrEmployee[]) throws ParseException {
        if (departureDate) {
            //With date of departure
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            Controller.employee = new Employee(arrEmployee[0], arrEmployee[1], arrEmployee[2],
                    Integer.parseInt(arrEmployee[3]), Long.parseLong(arrEmployee[4]), arrEmployee[5],
                    arrEmployee[6], arrEmployee[7], arrEmployee[8], parser.parse(arrEmployee[9]),
                    parser.parse(arrEmployee[10]));
        } else {
            //Without date of departure
            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
            Controller.employee = new Employee(arrEmployee[0], arrEmployee[1], arrEmployee[2],
                    Integer.parseInt(arrEmployee[3]), Long.parseLong(arrEmployee[4]), arrEmployee[5],
                    arrEmployee[6], arrEmployee[7], arrEmployee[8], parser.parse(arrEmployee[9]));
        }
    }

    //Create equipment object
    private static void equipment(String arrEquipment[]) {
        Equipment equipmentObj = new Equipment(arrEquipment[0], arrEquipment[1], arrEquipment[2],
                arrEquipment[3], arrEquipment[4]);
        equipments[Controller.amountEquipments] = equipmentObj;
        Controller.amountEquipments++;
    }

    //Create the size of arrays of equipments and data
    public static void equipmentsSize(int equipmentsSize) {
        Controller.equipments = new Equipment[equipmentsSize];
    }

    //Create the size of array data
    public static void dataSize() {
        Controller.data = new Data[10];
    }

    //Data with access
    public static void data() {
        Controller.data[Controller.amountData] = new Data(Controller.employee,
                Controller.position, Controller.area, Controller.equipments, Controller.access);
        Controller.amountData++;
    }

    //Data without access
    public static void data2() {
        Controller.data[Controller.amountData] = new Data(Controller.employee,
                Controller.position, Controller.area, Controller.equipments);
        Controller.amountData++;
    }

    /////////READ
    public static String getAll() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Controller.data.length; i++) {
            if (Controller.data[i] == null) {
                break;
            } else {
                sb.append(Controller.data[i]);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String getAllById(int idData) {
        return Controller.data[idData - 1].toString();
    }

    public static String getCommon() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Controller.data.length; i++) {
            if (Controller.data[i] == null) {
                break;
            } else {
                sb.append(Controller.data[i].getCommon());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String getCommonId(int idData) {
        return Controller.data[idData - 1].getCommon();
    }

    //////////UPDATE
    public static void updateEmployee(int idData, int action, String data) throws ParseException {
        switch (action) {
            case 1://Edit the names
                Controller.data[idData - 1].setNames(data);
                break;
            case 2://Edit the last names
                Controller.data[idData - 1].setLastName(data);
                break;
            case 3://Edit the type of document
                Controller.data[idData - 1].setDocumentType(data);
                break;
            case 4://Edit the document number
                Controller.data[idData - 1].setDocumentNumber(Integer.parseInt(data));
                break;
            case 5://Edit the cell phone
                Controller.data[idData - 1].setCellPhone(Long.parseLong(data));
                break;
            case 6://Edit the email
                Controller.data[idData - 1].setEmail(data);
                break;
            case 7://Edit the city
                Controller.data[idData - 1].setCity(data);
                break;
            case 8://Edit the district
                Controller.data[idData - 1].setDistrict(data);
                break;
            case 9://Edit the address
                Controller.data[idData - 1].setAddress(data);
                break;
            case 10://Edit the admission date
                SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
                Controller.data[idData - 1].setAdmissionDate(parser.parse(data));
                break;
            case 11://Edit the departure date
                SimpleDateFormat parser2 = new SimpleDateFormat("dd/MM/yyyy");
                Controller.data[idData - 1].setDepartureDate(parser2.parse(data));
                break;
            default:
                System.out.println("You wrote a incorrect number, try again.");
        }
    }

    public static void updatePosition(int idData, int action, String data) {
        switch (action) {
            case 1://Edit the position
                Controller.data[idData - 1].setPosition(data);
                break;
            case 2://Edit the description of position
                Controller.data[idData - 1].setPositionDescription(data);
                break;
            case 3://Edit the minimum salary
                Controller.data[idData - 1].setMinSalary(Double.parseDouble(data));
                break;
            case 4://Edit the maximum salary
                Controller.data[idData - 1].setMaxSalary(Double.parseDouble(data));
                break;
            default:
                System.out.println("You wrote a incorrect number, try again.");
        }
    }

    public static void updateArea(int idData, int action, String data) {
        switch (action) {
            case 1://Edit the area
                Controller.data[idData - 1].setArea(data);
                break;
            case 2://Edit the description of area
                Controller.data[idData - 1].setDescriptionArea(data);
                break;
            case 3://Edit the leader of area
                Controller.data[idData - 1].setLeader(data);
                break;
            default:
                System.out.println("You wrote a incorrect number, try again.");
        }
    }

    public static void updateEquipment(int idData, int idEquipment, int action, String data) {
        switch (action) {
            case 1://edit the serial of equipment
                Controller.data[idData - 1].setSerial(idEquipment - 1, data);
                break;
            case 2://Edit the type of hardware
                Controller.data[idData - 1].setHardwareType(idEquipment - 1, data);
                break;
            case 3://Edit the name of equipment
                Controller.data[idData - 1].setName(idEquipment - 1, data);
                break;
            case 4://Edit the brand of equipment
                Controller.data[idData - 1].setBrand(idEquipment - 1, data);
                break;
            case 5://Edit the observation of equipment.
                Controller.data[idData - 1].setObservation(idEquipment - 1, data);
                break;
            default:
                System.out.println("You wrote a incorrect number, try again.");
        }
    }

    public static void updateAccess(int idData, int action, String data) {
        switch (action) {
            case 1://Edit the user name
                Controller.data[idData - 1].setUser(data);
                break;
            case 2://Edit the type of user
                Controller.data[idData - 1].setUserType(data);
                break;
            case 3://Edit the user password
                Controller.data[idData - 1].setPassword(data);
                break;
            default:
                System.out.println("You wrote a incorrect number, try again.");
        }
    }

    //////////////Layer 2 
    //Method for validate the credentials that wrote the user.
    public static byte checkCredentials(String userName, String password) {
        byte answer;
        if (userName.equals("common") && password.equals("common123")) {
            answer = 1;
        } else if (userName.equals("top") && password.equals("top123")) {
            answer = 2;
        } else if (userName.equals("admin") && password.equals("admin123")) {
            answer = 3;
        } else {
            answer = 0;
        }
        return answer;
    }

    //Method for create the employee object if the validations are successful.
    public static boolean createEmployee(String arrEmpleado[]) throws ParseException {
        //Validation
        boolean validation = Controller.dataEmployee(arrEmpleado) && Controller.nullFields(arrEmpleado)
                && Controller.documentType(arrEmpleado[2]) && Controller.email(arrEmpleado[5]);
        //Create
        if (validation) {
            boolean fechaSalida = (arrEmpleado.length == 11) ? true : false;
            Controller.employee(fechaSalida, arrEmpleado);
        }
        return validation;
    }

    //Method for create the position object if the validations are successful
    public static boolean createPosition(String arrPosition[]) {
        //Validation
        boolean validation = Controller.dataPosition(arrPosition) && Controller.nullFields(arrPosition);
        //Create
        if (validation) {
            Controller.position = new Position(arrPosition[0], arrPosition[1], Double.parseDouble(arrPosition[2]),
                    Double.parseDouble(arrPosition[3]));
        }
        return validation;
    }

    //Method for create the area object if the validations are successful
    public static boolean createArea(String arrArea[]) {
        //Validation
        boolean validation = Controller.dataArea(arrArea) && Controller.nullFields(arrArea);
        //Create
        if (validation) {
            Controller.area = new Area(arrArea[0], arrArea[1], arrArea[2]);
        }
        return validation;
    }

    //Method for create the equipments object if the validations are successful
    public static boolean createEquipment(String arrEquipment[]) {
        //Validation
        boolean validation = Controller.dataEquipment(arrEquipment) && Controller.nullFields(arrEquipment);
        //Create
        if (validation) {
            Controller.equipment(arrEquipment);
        }
        return validation;
    }

    //Method for create the access object if the validations are successful
    public static boolean createAccess(String arrAccess[]) {
        //Validation
        boolean validation = Controller.dataAccess(arrAccess) && Controller.nullFields(arrAccess);
        //Create
        if (validation) {
            Controller.access = new Access(arrAccess[0], arrAccess[1], arrAccess[2]);
        }
        return validation;
    }

    //Method for restart the amount of equipments
    public static void amountEquipments() {
        Controller.amountEquipments = 0;
    }

    //Method for consult the employee ID
    public static int employeID() {
        return Controller.amountData + 1;
    }

    //Method for validate the id of a log
    public static boolean validateLog(int idLog) {
        if (idLog < 1 || idLog > 10) {
            return false;
        } else if (Controller.data[idLog - 1] == null) {
            return false;
        } else {
            return true;
        }
    }
    
    //Method for validate the id of equipment
    public static boolean validateEquipment(int idLog, int idEquipment){
        return Controller.data[idLog - 1].validateEquipment(idEquipment);
    }
}
