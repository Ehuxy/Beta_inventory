
package Model;

public class Access {
    private int idAccess;
    private static int countAccess;
    private String user, userType, password;

    public Access(String user, String userType, String password) {
        this.idAccess = ++Access.countAccess;
        this.user = user;
        this.userType = userType;
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString(){
        return ", ID: " + this.idAccess + ", User: " + this.user + ", Type of user: " +
                this.userType;
    }
    
}
