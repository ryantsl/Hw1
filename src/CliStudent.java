import java.util.Scanner;

public class CliStudent {
    Student student;
    Omoomi omoomi[];
    Ekhtesasi ekhtesasi[];

    public void menu(){
        System.out.println("Student menu\n0.back\n1.namayeshe dars haye sabte nam shode\n2.namayeshe dorose daneshkade ha");
        Scanner scanner=new Scanner(System.in);
        int command=scanner.nextInt();
        switch(command){
            case 0:{
                break;
            } case 1:{

            } case 2:{

            } default:{
                System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
                menu();
            }
        }
    }
    public void setStudent(Student student){
        this.student=student;
    }
    public CliStudent(Student student){
        setStudent(student);
        menu();
    }
}
