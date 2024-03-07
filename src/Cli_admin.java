import java.util.Scanner;

public class Cli_admin {

    public Admin admin;
    public Omoomi[] omoomi;
    public Ekhtesasi[] ekhtesasi;

    public Student[] student;

    public void setAdmin(Admin admin,Omoomi[] omoomi,Ekhtesasi[] ekhtesasi,Student[] student) {
        this.admin = admin;
        this.ekhtesasi=ekhtesasi;
        this.omoomi=omoomi;
        this.student=student;
    }


    public void menu(){
        boolean exit=true;
        while (exit){
            System.out.println("Admin menu\n0.back\n1.moshahede doros\n2.ezafe kardane zarfiat\n3.ezafe kardane daneshjoo be dars\n4.hazf kardane daneshjoo az darsi ");
            Scanner scanner=new Scanner(System.in);
            int command=scanner.nextInt();
            switch (command){
                case 0:{
                    exit=false;
                    break;
                } case 1:{
                    collegeSelector();
                } case 2:{

                } case 3:{

                } case 4:{

                } case 5:{

                } default:{
                    System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
                }
            }
        }
    }

    public void collegeSelector(){
        boolean exit=true;
        while (exit){
            System.out.println("0.back 1.barq 2.computer 3.mechanic 4.riazi 5.fizik");
            Scanner scanner=new Scanner(System.in);
            int command=scanner.nextInt();
            if(command==0){
                break;
            }else if(command>6){
                System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
            }else {
                showCourses(command-1);
            }
        }
    }

    public void showCourses(int collegeId){
        for (int i=0;i<30;i++){
            if(omoomi[i].classId!=0){
                if(omoomi[i].collegeId==collegeId){
                    omoomi[i].showCourses();
                }
            }
        }
        for (int i=0;i<30;i++){
            if(ekhtesasi[i].classId!=0){
                if(ekhtesasi[i].collegeId==collegeId){
                    ekhtesasi[i].showCourses();
                }
            }
        }
//        Omoomi.showCourses();
//        Ekhtesasi.showCourses();
    }


    public Cli_admin(Admin admin,Omoomi[] omoomi,Ekhtesasi[] ekhtesasi,Student[] student){
        setAdmin(admin,omoomi,ekhtesasi,student);
        menu();
    }


}
