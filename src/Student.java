public class Student {
    static int number_of_students=0;

    static int [] ids=new int[100];
    public int id;
    public String name;

    public int password;
    public int vahed_omomi = 0;
    public int vahed_takhasosi = 0;
    public int[][] courses_id=new int[10][10];
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
    public void adding_omoomi_course(Course course){

    }
    public void adding_ekhtesasi_course(Course course){

    }
    public void deleteing_course(Course course){

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
