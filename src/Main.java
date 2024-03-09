import java.util.Scanner;
public class Main {
    public static Student[] student;
    public static Admin admin;

    public static Omoomi omoomi[]=new Omoomi[30];
    public static Ekhtesasi ekhtesasi[]=new Ekhtesasi[30];

    public static int amountOfStudents;

    public static void main(String[] args) {
        init();
        run();
    }

    public static void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("password admin ra vared konid");
        int first_password=scanner.nextInt();
        admin=new Admin(first_password);
        System.out.println("hadeaksar tedad daneshjooyan ra vared konid");
        amountOfStudents= scanner.nextInt();
        student= new Student[amountOfStudents];
        initClasses();
        System.out.println("welcome");
    }

    public static void initClasses(){
        omoomi[Omoomi.omooomiCounter]=new Omoomi(1,2,30,0,"madar","ali moosavi",14030324,10,12,1,10.5,12);
        omoomi[Omoomi.omooomiCounter]=new Omoomi(2,2,30,1,"AP","majid hosseini",14030324,10.5,12.5,2,9,10.5);
        omoomi[Omoomi.omooomiCounter]=new Omoomi(3,2,30,2,"static","navid saatdat",14030325,10,12,1,11.5,13);
        omoomi[Omoomi.omooomiCounter]=new Omoomi(4,2,30,3,"riazi","reza akbari",14030326,10,12,2,10.5,12);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(5,3,30,0,"mokhaberat","reza akbari",14030326,10,12,2,4,7.5,9);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(6,3,30,0,"madar manteghi","reza akbari",14030326,10.5,12.5,2,4,8.5,10);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(7,3,30,0,"mabani bargh","reza akbari",14030327,10,12,0,2,7.5,9);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(8,3,30,1,"hoshe masnooi","reza akbari",14030328,10,12,2,4,13.5,15);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(9,3,30,1,"system amel","reza akbari",14030326,13,15,1,3,7.5,9);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(10,3,30,1,"BP","reza akbari",14030322,10,12,1,3,15,16.5);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(11,3,30,2,"dynamic","reza akbari",14030327,10,12,3,5,7.5,9);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(12,3,30,2,"vibration","reza akbari",14030326,10,12,0,4,10.5,12);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(13,3,30,2,"control","reza akbari",14030328,10,12,2,4,7.5,9);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(14,3,30,3,"PDE","reza akbari",14030326,10,12,0,2,13.5,15);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(15,3,30,3,"ehtemal","reza akbari",14030326,10,12,2,4,7.5,9);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(16,3,30,3,"amar","reza akbari",14030324,13,15,1,3,15,16.3);
    }

    public static void run(){
        Scanner scanner=new Scanner(System.in);
        boolean exit = true;
        while (exit){
            System.out.println("baraye log in shodan gozine morede nazar ra type konid");
            System.out.println("1.vorod be onvane admin \n2.vorod be onvane daneshjoo\n3.khoroj az barname");
            int a = scanner.nextInt();
            exit=switcher(a);
        }

    }

    public static boolean switcher(int a) {
        boolean exit=true;
        switch (a) {
            case 1: {
                cliAdmin();
                break;
            }
            case 2: {
                cliStudent();
                break;
            }
            case 3: {
                exit = false;
                return exit;
//                break;
            }
            default:
                System.out.println("dastoore tarif nashode\nlotfan dobare dastoore morede nazar ra vared konid");
        }
        return exit;
    }

    public static void cliAdmin(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("password ra vared konid va baraye bazgasht adade 0 ra vared konid");
            int password = scanner.nextInt();
            if(admin.passChecker(password)){
                Cli_admin cli_admin=new Cli_admin(admin,omoomi,ekhtesasi,student);
            }else if(password==0) {
                break;
            }else{
                System.out.println("password eshtebah lotfan dobare vared konid");
            }
        }
    }

    public static void cliStudent() {

        Scanner scanner=new Scanner(System.in);
        System.out.println("shomare daneshjooyi khod ra vared konid ya baraye bazgasht adade -1 ra vared konid");
        int student_id= scanner.nextInt();

        if(student_id!=-1) {
            if(Student.idCheckerIsNew(student_id)){
                if(Student.number_of_students==amountOfStudents){
                    System.out.println("emkan sabte nam daneshjoo jadid vojod nadarad");
                }
                else {
                    System.out.println("name khod ra vared konid");
                    String garbage= scanner.nextLine();
                    String name=scanner.nextLine();
                    System.out.println("password khod ra vared konid");
                    int password= scanner.nextInt();
                    student[Student.number_of_students]=new Student(student_id,name,password);
//                    System.out.println(name);
//                    System.out.println(student[Student.number_of_students-1].id);
//                    System.out.println(student[Student.number_of_students-1].name);
//                    System.out.println("account jadid sakhte shod");
                    CliStudent cliStudent=new CliStudent(student[Student.getArrayIndex(student_id)],omoomi,ekhtesasi);
                }

            }else{
                while (true){
                    System.out.println("password khod ra vared konid ya baraye bazgasht adade -1 ra vared konid");
                    int password=scanner.nextInt();
                    if(password==-1){
                        break;
                    }else {
                        if(password==student[Student.getArrayIndex(student_id)].password){
                            CliStudent cliStudent=new CliStudent(student[Student.getArrayIndex(student_id)],omoomi,ekhtesasi);
                            break;
                        }else {
                            System.out.println("password eshtebah");
                        }
                    }
                }
            }
        }
    }
}
