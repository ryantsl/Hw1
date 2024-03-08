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
            System.out.println("Admin menu\n0.back\n1.moshahede doros\n2.ezafe kardane zarfiat\n3.ezafe kardane daneshjoo be dars\n4.hazf kardane daneshjoo az darsi\n5.tarif dars jadid\n 6.hazf dars");
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
                    addingCapacity();
                    break;
                } case 3:{

                } case 4:{

                } case 5:{
                    newClass();
                    break;
                } case 6:{
                    hazfDars();
                    break;
                } default:{
                    System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
                }
            }
        }
    }
    public void hazfOmoomi(int classId){
        for (int i=0;i<omoomi[getOmoomiArrayIndex(classId)].tedadeSabteNami;i++){
            student[Student.getArrayIndex(omoomi[getOmoomiArrayIndex(classId)].studentIds[0])].deleteingOmoomiCourse(omoomi[getOmoomiArrayIndex(classId)],classId);
        }
        omoomi[getOmoomiArrayIndex(classId)].classId=0;
    }
    public void hazfEkhtesasi(int classId){
        for (int i=0;i<ekhtesasi[getEkhtesasiArrayIndex(classId)].tedadeSabteNami;i++){
            student[Student.getArrayIndex(ekhtesasi[getEkhtesasiArrayIndex(classId)].studentIds[0])].deleteigEkhtesasiCourse(ekhtesasi[getEkhtesasiArrayIndex(classId)],classId);
        }
        ekhtesasi[getEkhtesasiArrayIndex(classId)].classId=0;
    }
    public void hazfDars(){
        System.out.println("code darse morede nazar ra vared konid va baraye bargasht be menu ghabl -1 ra vared konid");
        Scanner scanner=new Scanner(System.in);
        int classId= scanner.nextInt();
        if(classId!=-1){
            switch (omoomiOrEkhtesasi(classId)){
                case 0:{
                    hazfOmoomi(classId);
                    break;
                } case 1:{
                    hazfEkhtesasi(classId);
                    break;
                } case 2:{
                    System.out.println("darsi ba code morede nazar vojod nadare,lotfan dobare vared konid");
                    hazfDars();
                    break;
                }
            }
        }
    }
    public int omoomiOrEkhtesasi(int classId){
        for(int i=0;i<Omoomi.omooomiCounter;i++){
            if(classId==omoomi[i].classId){
                return 0;
            }
        }
        for (int i=0;i<Ekhtesasi.ekhtesasiCounter;i++){
            if (classId==ekhtesasi[i].classId){
                return 1;
            }
        }
        return 2;
    }
    public int getOmoomiArrayIndex(int classId){
        for(int i=0;i<Omoomi.omooomiCounter;i++){
            if(classId==omoomi[i].classId){
                return i;
            }
        }
        return -1;
    }
    public int getEkhtesasiArrayIndex(int classId){
        for(int i=0;i<Ekhtesasi.ekhtesasiCounter;i++){
            if(classId==ekhtesasi[i].classId){
                return i;
            }
        }
        return -1;
    }

    public void addingCapacity(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("code darsi ra vared konid va baraye bargasht be menu ghabl -1 ra vared konid");
        int classId=scanner.nextInt();
        int newCapacity;
        if(classId!=-1){
            switch (omoomiOrEkhtesasi(classId)){
                case 0:{
                    while (true){
                        System.out.println("zarfiat feli:"+omoomi[getOmoomiArrayIndex(classId)].capacity+"\nzarfiat jadid ra vared konid");
                        newCapacity= scanner.nextInt();
                        if(newCapacity>omoomi[getOmoomiArrayIndex(classId)].capacity){
                            omoomi[getOmoomiArrayIndex(classId)].addingCapacity(newCapacity);
                            System.out.println("zariat ba movafaqiat ezafe shod");
                            break;
                        }
                        else {
                            System.out.println("zarfiat kamtar az zarfiate ghabli,lotfan dobare vared konid");
                        }
                    }
                    break;
                } case 1:{
                    while (true){
                        System.out.println("zarfiat feli:"+ekhtesasi[getEkhtesasiArrayIndex(classId)].capacity+"\nzarfiat jadid ra vared konid");
                        newCapacity= scanner.nextInt();
                        if(newCapacity>ekhtesasi[getEkhtesasiArrayIndex(classId)].capacity){
                            ekhtesasi[getEkhtesasiArrayIndex(classId)].addingCapacity(newCapacity);
                            System.out.println("zariat ba movafaqiat ezafe shod");
                            break;
                        }
                        else {
                            System.out.println("zarfiat kamtar az zarfiate ghabli,lotfan dobare vared konid");
                        }
                    }
                    break;
                } case 2:{
                    System.out.println("darsi ba code morede nazar vojod nadare,lotfan dobare vared konid");
                    addingCapacity();
                    break;
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
            if(classId==ekhtesasi[i].classId){
                System.out.println("code vared shode tekrari mibashad");
                return false;
            }
        }
        return true;
    }

    public void newOmoomi(){
        Scanner scanner=new Scanner(System.in);
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
        ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(5,3,30,0,"mokhaberat","reza akbari",14030326,10,12,2,4,7.5,9);
        Scanner scanner=new Scanner(System.in);
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
            int classDay1;
            int classDay2;
            double classStartingTime;
            double classFinishingTime;

            if(classId==0){
                break;
            }else if(checkNewId(classId)==false) {
                newEkhtesasi();
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
                System.out.println("rooz class aval ra vared konid");
                classDay1=daySelector();
                System.out.println("rooz class dovom ra vared konid");
                classDay2=daySelector();
                System.out.println("saat shoroe class ra vared konid");
                classStartingTime= scanner.nextDouble();
                System.out.println("saat payane class ra vared konid");
                classFinishingTime= scanner.nextDouble();
                ekhtesasi[Ekhtesasi.ekhtesasiCounter]=new Ekhtesasi(classId,vahed,capacity,collegeId,className,teacherName,examDate,examStartingTime,examFinishingTime,classDay1,classDay2,classStartingTime,classFinishingTime);
                System.out.println("class ba movafaqiat sakhte shod");
                menu();
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
//        System.out.println(Omoomi.omooomiCounter+"  "+Ekhtesasi.ekhtesasiCounter);
        for (int i=0;i<Omoomi.omooomiCounter;i++){
//            System.out.println(i);
            if(omoomi[i].classId!=0){
                if(omoomi[i].collegeId==collegeId){
                    omoomi[i].showCourses();
                }
            }
        }
        for (int i=0;i<Ekhtesasi.ekhtesasiCounter;i++){
//            System.out.println(i);
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
