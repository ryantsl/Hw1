public class Admin {
    public int password;

    public void setPassword(int password){
        this.password=password;
    }
    public Admin(){

    }
    public boolean passChecker(int password){
        if(this.password==password){
            return true;
        }else {
            return false;
        }
    }
    public Admin(int password){
        setPassword(password);
    }
}
