import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Student student[] = new Student[100];
        Scanner scanner = new Scanner(System.in);
        System.out.println("password admin ra vared konid");
        int first_password=scanner.nextInt();
        Admin admin=new Admin(first_password);
        System.out.println("welcome");
        boolean exit = true;
        while (exit) {
            System.out.println("baraye log in shodan gozine morede nazar ra type konif");
            System.out.println("1.vorod be onvane admin \n2.vorod be onvane daneshjoo\n3.khoroj az barname");
            int a = scanner.nextInt();
            exit=switcher(a,admin,student);
        }
    }


    public static boolean switcher(int a,Admin admin,Student[] student) {
        boolean exit=true;
        switch (a) {
            case 1: {
                System.out.println("1");
                cliAdmin(admin);
                break;
            }
            case 2: {
                System.out.println("2");
                cliStudent(student);
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

    public static void cliAdmin(Admin admin){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("password ra vared konid va baraye bazgasht adade 0 ra vared konid");
            int password = scanner.nextInt();
            if(admin.passChecker(password)){
                Cli_admin cli_admin=new Cli_admin(admin);
            }else if(password==0) {
                break;
            }else{
                System.out.println("password eshtebah lotfan dobare vared konid");
            }
        }
    }

    public static void cliStudent(Student[] student) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("shomare daneshjooyi khod ra vared konid ya baraye bazgasht adade -1 ra vared konid");
        int student_id= scanner.nextInt();

        if(student_id!=-1) {
            if(Student.idCheckerIsNew(student_id)){
                System.out.println("name khod ra vared konid");
                String garbage= scanner.nextLine();
                String name=scanner.nextLine();
                student[Student.number_of_students]=new Student(student_id,name);
                System.out.println(name);
                System.out.println(student[Student.number_of_students-1].id);
                System.out.println(student[Student.number_of_students-1].name);
                CliStudent cliStudent=new CliStudent(student[Student.getArrayIndex(student_id)]);

            }else{
                System.out.println("vorode mojadad");
                CliStudent cliStudent=new CliStudent(student[Student.getArrayIndex(student_id)]);
            }
        }
    }
}
