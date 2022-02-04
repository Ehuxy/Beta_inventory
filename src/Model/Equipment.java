
package Model;

public class Equipment {
    private int idEquipment;
    private static int countEquipment;
    private String serial, hardwareType, name, brand, observation;
    
    //Constructor
    public Equipment(String serial, String hardwareType, String name, String brand, String observation) {
        this.idEquipment = ++Equipment.countEquipment;
        this.serial = serial;
        this.hardwareType = hardwareType;
        this.name = name;
        this.brand = brand;
        this.observation = observation;
    }
    
    //Methods setter
    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setHardwareType(String hardwareType) {
        this.hardwareType = hardwareType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    @Override
    public String toString(){
        return ", Id: " + this.idEquipment + ", Serial: " + this.serial + ", Type of Hardware: " + 
                this.hardwareType + ", Name: " + this.name + ", Brand: " + this.brand + 
                ", Observation: " + this.observation;
    }
}
