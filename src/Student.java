public class Student {
    public static int number_of_students=0;

    public static int [] ids=new int[100];
    public int id;
    public String name;

    public int password;
    public int vahedOmomi = 0;
    public int vahedTakhasosi = 0;

    public int tedadOmoomi=0;
    public int tedadEkhtesasi=0;

    public int[] omoomiIds=new int[10];
    public int[] ekhtesasiIds=new int[20];
    public int[] courses_id=new int[20];
    public Student(){

    }

    public void setId(int id) {
        this.id = id;
        Student.ids[Student.number_of_students]=id;
    }
    public void setNumber_of_students(){
        number_of_students++;
    }
    public void setName(String name){
        this.name=name;
    }

    public void setPassword(int password){
        this.password=password;
    }
    public Student(int id,String name,int password){
        setId(id);
        setName(name);
        setNumber_of_students();
        setPassword(password);
        System.out.println("profile shoma sakhte shod");
    }
    public void addingOmoomiCourse(Omoomi omoomi){
        this.vahedOmomi+=omoomi.vahed;
        this.omoomiIds[this.tedadOmoomi]=omoomi.classId;
        this.tedadOmoomi++;
        omoomi.studentIds[omoomi.tedadeSabteNami]=this.id;
        omoomi.tedadeSabteNami++;
        System.out.println("dars ba movafaqiat akhz shod");
    }
    public void addingEkhtesasiCourse(Ekhtesasi ekhtesasi){
        this.vahedTakhasosi+=ekhtesasi.vahed;
        this.ekhtesasiIds[this.tedadEkhtesasi]=ekhtesasi.classId;
        this.tedadEkhtesasi++;
        ekhtesasi.studentIds[ekhtesasi.tedadeSabteNami]=this.id;
        ekhtesasi.tedadeSabteNami++;
        System.out.println("dars ba movafaqiat akhz shod");
    }
    public void deleteingOmoomiCourse(Omoomi omoomi,int classId1){
        boolean temp=false;
        for (int i=0;i<tedadOmoomi;i++){
            if(temp){
                this.omoomiIds[i-1]=this.omoomiIds[i];
            }
            if(classId1==this.omoomiIds[i]){
                this.omoomiIds[i]=0;
                temp=true;
            }
        }
        temp=false;
        tedadOmoomi--;
        for (int i=0;i<omoomi.tedadeSabteNami;i++){
            if(temp){
                omoomi.studentIds[i-1]=omoomi.studentIds[i];
            }
            if(this.id==omoomi.studentIds[i]){
                omoomi.studentIds[i]=0;
                temp=true;
            }
        }
    }

    public void deleteigEkhtesasiCourse(Ekhtesasi ekhtesasi,int classId2){
        boolean temp=false;
        for (int i=0;i<tedadEkhtesasi;i++){
            if(temp){
                this.ekhtesasiIds[i-1]=this.ekhtesasiIds[i];
            }
            if(classId2==this.ekhtesasiIds[i]){
                this.ekhtesasiIds[i]=0;
                temp=true;
            }
        }
        temp=false;
        tedadEkhtesasi--;
        for (int i=0;i<ekhtesasi.tedadeSabteNami;i++){
            if(temp){
                ekhtesasi.studentIds[i-1]=ekhtesasi.studentIds[i];
            }
            if(this.id==ekhtesasi.studentIds[i]){
                ekhtesasi.studentIds[i]=0;
                temp=true;
            }
        }
        ekhtesasi.tedadeSabteNami--;
    }
    public static boolean idCheckerIsNew(int inputId){
        if(Student.number_of_students==0){
            return true;
        }
        for (int i=0;i<Student.number_of_students;i++){
            if(inputId==Student.ids[i]){
                return false;
            }
        }
        return true;
    }

//    public boolean checkPassword(int password){
//        if(this.password==password){
//            System.out.println("vorode mojadad");
//            return true;
//        }else {
//            return false;
//        }
//    }

    public static int getArrayIndex(int id){
        for(int i=0;i<Student.number_of_students;i++){
            if(id==Student.ids[i]){
                return i;
            }
        }
        return 0;
    }
}
