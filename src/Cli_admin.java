import java.util.Scanner;

public class Cli_admin {

    Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    public void menu(){
        System.out.println("Admin menu\n0.back\n1.moshahede doros\n2.ezafe kardane zarfiat\n3.ezafe kardane daneshjoo be dars\n4.hazf kardane daneshjoo az darsi ");
        Scanner scanner=new Scanner(System.in);
        int command=scanner.nextInt();
        switch (command){
            case 0:{
                break;
            } case 1:{

            } case 2:{

            } case 3:{

            } case 4:{

            } case 5:{

            } default:{
                System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
            }
        }
    }

    public Cli_admin(Admin admin){
        setAdmin(admin);
        menu();
    }


}
