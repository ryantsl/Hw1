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
            System.out.println("Admin menu\n0.back\n1.moshahede doros\n2.ezafe kardane zarfiat\n3.ezafe kardane daneshjoo be dars\n4.hazf kardane daneshjoo az darsi\n5.tarif dars jadid");
            Scanner scanner=new Scanner(System.in);
            int command=scanner.nextInt();
            switch (command){
                case 0:{
                    exit=false;
                    break;
                } case 1:{
                    collegeSelector();
                    break;
                } case 2:{

                } case 3:{

                } case 4:{

                } case 5:{
                    newClass();
                    break;
                } default:{
                    System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
                }
            }
        }
    }

    public void newClass(){
        boolean exit=true;
        while (exit){
            System.out.println("ezafe kardane dars jadid\n0.back\n1.omoomi\n2.ekhtesasi");
            Scanner scanner=new Scanner(System.in);
            int command=scanner.nextInt();
            switch (command){
                case 0:{
                    exit=false;
                    break;
                } case 1:{
                    newOmoomi();
                    break;
                } case 2:{
                    newEkhtesasi();
                    break;
                }default:{
                    System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
                }
            }
        }
    }
    public boolean checkNewId(int classId){
        for (int i=0;i<Omoomi.omooomiCounter;i++){
            if(classId==omoomi[i].classId){
                System.out.println("code vared shode tekrari mibashad");
                return false;
            }
        }
        for (int i=0;i<Ekhtesasi.ekhtesasiCounter;i++){
            if(classId==omoomi[i].classId){
                System.out.println("code vared shode tekrari mibashad");
                return false;
            }
        }
        return true;
    }

    public void newOmoomi(){
        Scanner scanner=new Scanner(System.in);
        omoomi[Omoomi.omooomiCounter]=new Omoomi(1,2,30,0,"madar","ali moosavi",14030324,10,12,1,10.5,12);
        boolean exit=true;
        while (exit){
            System.out.println("code dars ra vared konid va baraye cancel kardan adade 0 ra vared konid");
            int classId=scanner.nextInt();
            int vahed;
            int capacity;
            int collegeId;
            String className;
            String teacherName;
            int examDate;
            double examStartingTime;
            double examFinishingTime;
            int classDay;
            double classStartingTime;
            double classFinishingTime;

            if(classId==0){
                break;
            }else if(checkNewId(classId)==false) {
                newOmoomi();
                break;
            }else{
                System.out.println("tedad vahed dars ra vared konid");
                vahed= scanner.nextInt();
                System.out.println("zarfiat dars ra vared konid");
                capacity= scanner.nextInt();
                collegeId=collegeSelector2();
                String garbage= scanner.nextLine();
                System.out.println("name dars ra vared konid");
                className= scanner.nextLine();
                System.out.println("name ostad ra vared konid");
                teacherName= scanner.nextLine();
                System.out.println("tarikhe emtehan ra posht sare ham vared konid\nmesal:1403/03/22-->14030322");
                examDate= scanner.nextInt();
                System.out.println("saat shoroe emtehan ra vared konid");
                examStartingTime= scanner.nextDouble();
                System.out.println("saat payan emtehan ra vared konid");
                examFinishingTime= scanner.nextDouble();
                System.out.println("rooz class ra vared konid");
                classDay=daySelector();
                System.out.println("saat shoroe class ra vared konid");
                classStartingTime= scanner.nextDouble();
                System.out.println("saat payane class ra vared konid");
                classFinishingTime= scanner.nextDouble();
                omoomi[Omoomi.omooomiCounter]=new Omoomi(classId,vahed,capacity,collegeId,className,teacherName,examDate,examStartingTime,examFinishingTime,classDay,classStartingTime,classFinishingTime);
                System.out.println("class ba movafaqiat sakhte shod");
                menu();
            }

        }
    }

    public int daySelector(){
        boolean exit=true;
        int command=0;
        while (exit){
            System.out.println("1.shanbe 2.1shanbe 3.2shanbe 4.3shanbe 5.4shanbe 6.5shanbe 7.jome");
            Scanner scanner=new Scanner(System.in);
            command=scanner.nextInt();
            if(command<=0 || command>7){
                System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
            }else {
                break;
            }
        }
        return (command-1);
    }

    public int collegeSelector2(){
        boolean exit=true;
        int command=0;
        while (exit){
            System.out.println("1.barq 2.computer 3.mechanic 4.riazi 5.fizik");
            Scanner scanner=new Scanner(System.in);
            command=scanner.nextInt();
            if(command<=0 || command>5){
                System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
            }else {
               break;
            }
        }
        return (command-1);
    }

    public void newEkhtesasi(){

    }

    public void collegeSelector(){
        boolean exit=true;
        while (exit){
            System.out.println("0.back 1.barq 2.computer 3.mechanic 4.riazi 5.fizik");
            Scanner scanner=new Scanner(System.in);
            int command=scanner.nextInt();
            if(command==0){
                exit=false;
                break;
            }else if(command>6){
                System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
            }else {
                showCourses(command-1);
            }
        }
    }

    public void showCourses(int collegeId){
        System.out.println(Omoomi.omooomiCounter+"  "+Ekhtesasi.ekhtesasiCounter);
        for (int i=0;i<Omoomi.omooomiCounter;i++){
            System.out.println(i);
            if(omoomi[i].classId!=0){
                if(omoomi[i].collegeId==collegeId){
                    omoomi[i].showCourses();
                }
            }
        }
        for (int i=0;i<Ekhtesasi.ekhtesasiCounter;i++){
            System.out.println(i);
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
