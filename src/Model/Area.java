
package Model;

public class Area {
    private int idArea;
    private static int countArea;
    private String area, description, leader;

    public Area(String area, String description, String leader) {
        this.idArea = ++Area.countArea;
        this.area = area;
        this.description = description;
        this.leader = leader;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
    
    @Override
    public String toString(){
        return " ID: " + this.idArea + ", Area: " + this.area + ", Description: " +
                this.description + ", Leader: " + this.leader;
    }
}
