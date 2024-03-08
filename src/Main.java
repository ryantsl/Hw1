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
        omoomi[Omoomi.omooomiCounter]=new Omoomi(3,2,30,0,"static","navid saatdat",14030325,10,12,1,11.5,13);
        omoomi[Omoomi.omooomiCounter]=new Omoomi(4,2,30,3,"riazi","reza akbari",14030326,10,12,2,10.5,12);
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(5,3,30,0,"mokhaberat","reza akbari",14030326,10,12,2,4,7.5,9);
    }

    public static void run(){
        Scanner scanner=new Scanner(System.in);
        boolean exit = true;
        while (exit){
            System.out.println("baraye log in shodan gozine morede nazar ra type konif");
            System.out.println("1.vorod be onvane admin \n2.vorod be onvane daneshjoo\n3.khoroj az barname");
            int a = scanner.nextInt();
            exit=switcher(a);
        }

    }

    public static boolean switcher(int a) {
        boolean exit=true;
        switch (a) {
            case 1: {
                System.out.println("1");
                cliAdmin();
                break;
            }
            case 2: {
                System.out.println("2");
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
                    System.out.println(name);
                    System.out.println(student[Student.number_of_students-1].id);
                    System.out.println(student[Student.number_of_students-1].name);
                    System.out.println("account jadid sakhte shod");
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
