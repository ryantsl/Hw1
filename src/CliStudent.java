import java.util.Scanner;

public class CliStudent {
    Student student;
    Omoomi omoomi[];
    Ekhtesasi ekhtesasi[];

    public void menu(){
        boolean exit=true;
        while (exit){
            System.out.println("Student menu\n0.back\n1.namayeshe dars haye sabte nam shode\n2.namayeshe dorose daneshkade ha");
            Scanner scanner=new Scanner(System.in);
            int command=scanner.nextInt();
            switch(command){
                case 0:{
                    exit=false;
                    break;
                } case 1:{
                    collegeSelector();
                    break;
                } case 2:{

                } default:{
                    System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
                    menu();
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

    public void setStudent(Student student,Omoomi[] omoomi,Ekhtesasi[] ekhtesasi){
        this.student=student;
        this.ekhtesasi=ekhtesasi;
        this.omoomi=omoomi;
    }
    public CliStudent(Student student,Omoomi[] omoomi,Ekhtesasi[] ekhtesasi){
        setStudent(student,omoomi,ekhtesasi);
        menu();
    }
}
