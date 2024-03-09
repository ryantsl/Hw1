import java.util.Scanner;

public class CliStudent {
    Student student;
    Omoomi omoomi[];
    Ekhtesasi ekhtesasi[];

    public void menu(){
        boolean exit=true;
        while (exit){
            System.out.println("Student menu\n0.back\n1.namayeshe dars haye sabte nam shode\n2.namayeshe dorose daneshkade ha\n3.akhz dars\n4.hazf dars");
            Scanner scanner=new Scanner(System.in);
            int command=scanner.nextInt();
            switch(command){
                case 0:{
                    exit=false;
                    break;
                } case 1:{
                    showMyCourses();
                    break;
                } case 2:{
                    collegeSelector();
                    break;
                } case 3:{
                    registeringCourse();
                    break;
                } case 4:{
                    deleteingCourse();
                    break;
                } default:{
                    System.out.println("dastoore tarif nashode,lotfan dobare vared konid");
                    menu();
                }
            }
        }
    }
    public void checkHavingOmoomi(int courseId){
        boolean temp=true;
        for (int i=0;i<student.tedadOmoomi;i++){
            if(courseId== student.omoomiIds[i]){
                temp=false;
                student.deleteingOmoomiCourse(omoomi[getOmoomiArrayIndex(courseId)],courseId);
            }
        }
        if(temp){
            System.out.println("shoma in dars na nadarid,lotfan dobare code ra vared konid");
            deleteingCourse();
        }

    }
    public void checkHavingEkhtesasi(int courseId){
        boolean temp=true;
        for (int i=0;i<student.tedadEkhtesasi;i++){
            if(courseId== student.ekhtesasiIds[i]){
                temp=false;
                student.deleteigEkhtesasiCourse(ekhtesasi[getEkhtesasiArrayIndex(courseId)],courseId);
            }
        }
        if(temp){
            System.out.println("shoma in dars na nadarid,lotfan dobare code ra vared konid");
            deleteingCourse();
        }

    }
    public void deleteingCourse(){
        System.out.println("code dars morede nazar ra vared konid va baraye bargashtan be menu ghabli adade -1 ra vared konid");
        Scanner scanner=new Scanner(System.in);
        int courseId= scanner.nextInt();
        if(courseId!=-1){
            switch (omoomiOrEkhtesasi(courseId)){
                case 0:{
                    checkHavingOmoomi(courseId);
                    break;
                } case 1:{
                    checkHavingEkhtesasi(courseId);
                    break;
                } case 2:{
                    System.out.println("darsi ba code morede nazar vojod nadare,lotfan dobare vared konid");
                    deleteingCourse();
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

    public boolean checkExamOO(Omoomi omoomi1,Omoomi omoomi2){
        if(omoomi1.examDatee==omoomi2.examDatee){
            if((omoomi1.examDate[0]>omoomi2.examDate[0]  &&   omoomi1.examDate[0]<omoomi2.examDate[1]) ||
                    (omoomi1.examDate[1]>omoomi2.examDate[0]  &&   omoomi1.examDate[1]<omoomi2.examDate[1])){
                System.out.println("tadakhol zaman emtehan ba dars "+omoomi2.className);
                return false;
            }
        }
        return true;
    }

    public boolean checkExamOE(Omoomi omoomi1,Ekhtesasi ekhtesasi1){
        if(omoomi1.examDatee==ekhtesasi1.examDatee){
            if((omoomi1.examDate[0]>ekhtesasi1.examDate[0]  &&   omoomi1.examDate[0]<ekhtesasi1.examDate[1]) ||
                    (omoomi1.examDate[1]>ekhtesasi1.examDate[0]  &&   omoomi1.examDate[1]<ekhtesasi1.examDate[1])){
                System.out.println("tadakhol zaman emtehan ba dars "+ekhtesasi1.className);
                return false;
            }
        }
        return true;
    }


    public boolean checkClassTimeOO(Omoomi omoomi1,Omoomi omoomi2){
        if(omoomi1.classDay==omoomi2.classDay){
            if((omoomi1.classTime[0]>omoomi2.classTime[0]  &&   omoomi1.classTime[0]<omoomi2.classTime[1]) ||
                    (omoomi1.classTime[1]>omoomi2.classTime[0]  &&   omoomi1.classTime[1]<omoomi2.classTime[1])){
                System.out.println("tadakhol zaman class ba dars "+omoomi2.className);
                return false;
            }
        }
        return true;
    }
    public boolean checkClassTimeOE(Omoomi omoomi1,Ekhtesasi ekhtesasi1){
        if(omoomi1.classDay==ekhtesasi1.classDay1 || omoomi1.classDay==ekhtesasi1.classDay2){
            if((omoomi1.classTime[0]>ekhtesasi1.classTime[0]  &&   omoomi1.classTime[0]<ekhtesasi1.classTime[1]) ||
                    (omoomi1.classTime[1]>ekhtesasi1.classTime[0]  &&   omoomi1.classTime[1]<ekhtesasi1.classTime[1])){
                System.out.println("tadakhol zaman class ba dars "+ekhtesasi1.className);
                return false;
            }
        }
        return true;
    }
    public boolean checkOmoomiCapacity(Omoomi omoomi1){
        if(omoomi1.capacity==omoomi1.tedadeSabteNami){
            System.out.println("zarfiate dars takmil ast");
            return false;
        }
        return true;
    }
    public boolean checkEkhtesasiCapacity(Ekhtesasi ekhtesasi1){
        if (ekhtesasi1.capacity==ekhtesasi1.tedadeSabteNami){
            System.out.println("zarfiate dars takmil ast");
            return false;
        }
        return true;
    }

    public boolean checkOmooomi(Omoomi omoomi1){
        if(!checkOmoomiCapacity(omoomi1)){
            return false;
        }
        if(omoomi1.vahed+ student.vahedOmomi>5){
            System.out.println("emkan akhz bishtar az 5 vahed omoomi vojod nadarad");
            return false;
        }
        if(omoomi1.vahed+ student.vahedOmomi+student.vahedTakhasosi>20){
            System.out.println("emkan akhz bishtar az 20 vahed vojod nadarad");
            return false;
        }
//        boolean check=true;
        for (int i=0;i<student.tedadOmoomi;i++){
            if(omoomi1.classId==omoomi[getOmoomiArrayIndex(student.omoomiIds[i])].classId){
                System.out.println("dars ghablan akhz shode ast");
                return false;
            }if(!checkExamOO(omoomi1, omoomi[getOmoomiArrayIndex(student.omoomiIds[i])])){
                return false;
            }
            if(!checkClassTimeOO(omoomi1, omoomi[getOmoomiArrayIndex(student.omoomiIds[i])])){
                return false;
            }
        }
        for (int i=0;i<student.tedadEkhtesasi;i++){
            if(!checkExamOE(omoomi1,ekhtesasi[getEkhtesasiArrayIndex(student.ekhtesasiIds[i])])){
                return false;
            }if(!checkClassTimeOE(omoomi1,ekhtesasi[getEkhtesasiArrayIndex(student.ekhtesasiIds[i])])){
                return false;
            }
        }
        return true;
    }

    public boolean checkExamEO(Ekhtesasi ekhtesasi1,Omoomi omoomi1){
        if(omoomi1.examDatee==ekhtesasi1.examDatee){
            if((omoomi1.examDate[0]>ekhtesasi1.examDate[0]  &&   omoomi1.examDate[0]<ekhtesasi1.examDate[1]) ||
                    (omoomi1.examDate[1]>ekhtesasi1.examDate[0]  &&   omoomi1.examDate[1]<ekhtesasi1.examDate[1])){
                System.out.println("tadakhol zaman emtehan ba dars "+omoomi1.className);
                return false;
            }
        }
        return true;
    }

    public boolean checkExamEE(Ekhtesasi ekhtesasi1,Ekhtesasi ekhtesasi2){
        if(ekhtesasi1.examDatee==ekhtesasi2.examDatee){
            if((ekhtesasi2.examDate[0]>ekhtesasi1.examDate[0]  &&   ekhtesasi2.examDate[0]<ekhtesasi1.examDate[1]) ||
                    (ekhtesasi2.examDate[1]>ekhtesasi1.examDate[0]  &&   ekhtesasi2.examDate[1]<ekhtesasi1.examDate[1])){
                System.out.println("tadakhol zaman emtehan ba dars "+ekhtesasi2.className);
                return false;
            }
        }
        return true;
    }

    public boolean checkClassTimeEO(Ekhtesasi ekhtesasi1,Omoomi omoomi1){
        if(omoomi1.classDay==ekhtesasi1.classDay1 || omoomi1.classDay==ekhtesasi1.classDay2){
            if((omoomi1.classTime[0]>ekhtesasi1.classTime[0]  &&   omoomi1.classTime[0]<ekhtesasi1.classTime[1]) ||
                    (omoomi1.classTime[1]>ekhtesasi1.classTime[0]  &&   omoomi1.classTime[1]<ekhtesasi1.classTime[1])){
                System.out.println("tadakhol zaman class ba dars "+omoomi1.className);
                return false;
            }
        }
        return true;
    }

    public boolean checkClassTimeEE(Ekhtesasi ekhtesasi1,Ekhtesasi ekhtesasi2){
        if(ekhtesasi1.classDay1==ekhtesasi2.classDay1 || ekhtesasi1.classDay2==ekhtesasi2.classDay1 ||
                ekhtesasi1.classDay1==ekhtesasi2.classDay2 || ekhtesasi1.classDay2==ekhtesasi2.classDay2){
            if((ekhtesasi2.classTime[0]>ekhtesasi1.classTime[0]  &&   ekhtesasi2.classTime[0]<ekhtesasi1.classTime[1]) ||
                    (ekhtesasi2.classTime[1]>ekhtesasi1.classTime[0]  &&   ekhtesasi2.classTime[1]<ekhtesasi1.classTime[1])){
                System.out.println("tadakhol zaman class ba dars "+ekhtesasi2.className);
                return false;
            }
        }
        return true;
    }


    public boolean checkEkhtesasi(Ekhtesasi ekhtesasi1){
        if(!checkEkhtesasiCapacity(ekhtesasi1)){
            return false;
        }
        if(ekhtesasi1.vahed+ student.vahedOmomi+student.vahedTakhasosi>20){
            System.out.println("emkan akhz bishtar az 20 vahed vojod nadarad");
            return false;
        }
        for (int i=0;i<student.tedadOmoomi;i++){
            if(!checkExamEO(ekhtesasi1, omoomi[getOmoomiArrayIndex(student.omoomiIds[i])])){
                return false;
            }
            if(!checkClassTimeEO(ekhtesasi1, omoomi[getOmoomiArrayIndex(student.omoomiIds[i])])){
                return false;
            }
        }
        for (int i=0;i<student.tedadEkhtesasi;i++){
            if(ekhtesasi1.classId==ekhtesasi[getEkhtesasiArrayIndex(student.ekhtesasiIds[i])].classId){
                System.out.println("dars ghablan akhz shode ast");
                return false;
            } if(!checkExamEE(ekhtesasi1,ekhtesasi[getEkhtesasiArrayIndex(student.ekhtesasiIds[i])])){
                return false;
            }if(!checkClassTimeEE(ekhtesasi1,ekhtesasi[getEkhtesasiArrayIndex(student.ekhtesasiIds[i])])){
                return false;
            }
        }
        return true;



    }
    public void registeringCourse(){
        System.out.println("code dars morede nazar ra vared konid va baraye bargashtan be menu ghabli adade -1 ra vared konid");
        Scanner scanner=new Scanner(System.in);
        int courseId= scanner.nextInt();
        if(courseId!=-1){
            switch (omoomiOrEkhtesasi(courseId)){
                case 0:{
                    if(student.vahedOmomi==0 && student.vahedTakhasosi==0){
                        if(checkOmoomiCapacity(omoomi[getOmoomiArrayIndex(courseId)])){
                            student.addingOmoomiCourse(omoomi[getOmoomiArrayIndex(courseId)]);
                        }else {
                            registeringCourse();
                        }
                    }else if(checkOmooomi(omoomi[getOmoomiArrayIndex(courseId)])){
                        student.addingOmoomiCourse(omoomi[getOmoomiArrayIndex(courseId)]);
                    }else {
                        registeringCourse();
                    }
                    break;
                } case 1:{
                    if(student.vahedOmomi==0 && student.vahedTakhasosi==0){
                        if(checkEkhtesasiCapacity(ekhtesasi[getEkhtesasiArrayIndex(courseId)])){
                            student.addingEkhtesasiCourse(ekhtesasi[getEkhtesasiArrayIndex(courseId)]);
                        }else {
                            registeringCourse();
                        }
                    }else if(checkEkhtesasi(ekhtesasi[getEkhtesasiArrayIndex(courseId)])){
                        student.addingEkhtesasiCourse(ekhtesasi[getEkhtesasiArrayIndex(courseId)]);
                    }else {
                        registeringCourse();
                    }
                    break;
                } case 2:{
                    System.out.println("darsi ba code morede nazar vojod nadare,lotfan dobare vared konid");
                    registeringCourse();
                    break;
                }
            }
        }
    }

    public void showMyCourses(){
        System.out.println("tedad vahed takhasosi:"+student.vahedTakhasosi+"\ntedad vahed omoomi:"+student.vahedOmomi);
        for (int i=0;i<student.tedadOmoomi;i++){
            omoomi[getOmoomiArrayIndex(student.omoomiIds[i])].showCourses();
        }
        for (int i=0;i<student.tedadEkhtesasi;i++){
            ekhtesasi[getEkhtesasiArrayIndex(student.ekhtesasiIds[i])].showCourses();
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
        for (int i=0;i<Omoomi.omooomiCounter;i++){
            if(omoomi[i].classId!=0){
                if(omoomi[i].collegeId==collegeId){
                    omoomi[i].showCourses();
                }
            }
        }
        for (int i=0;i<Ekhtesasi.ekhtesasiCounter;i++){
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
