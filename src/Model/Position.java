
package Model;

public class Position {
    private int idPosition;
    private static int countPosition;
    private String position, description;
    private double minSalary, maxSalary;

    public Position(String position, String description, double minSalary, double maxSalary) {
        this.idPosition = ++Position.countPosition;
        this.position = position;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }
    
    public String getCommon(){//Query for common users.
        return " ID: " + this.idPosition + " Position: " + this.position + " Description: " + this.description;
    }

    @Override
    public String toString() {//Query for top and admin users.
        return "ID: " + this.idPosition + ", Position: " + this.position + ", "
                + "Description: " + this.description + ", Minimum Salary: " + this.minSalary + 
                ", Maximum Salary: " + this.maxSalary;
    }
}
