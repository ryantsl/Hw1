public class Course {
    public static int [] classIds=new int[100];

    public static int classCounter=0;
    public double [] examDate=new double[2];

    public int examDatee;
    public int vahed;
    public int capacity;
    public int tedadeSabteNami=0;
    public int collegeId;
    public int[] studentIds=new int[100];

    public static String []collegeName={"barq","computer","mechanic","riazi","fizik"};

    public static String[]rooz={"shanbe","1 shanbe","2 shanbe","3 shanbe","4 shanbe","5 shanbe","jome"};
    public int classId;
    public  String className;
    public String teacherName;

    public Course(int classId,int vahed,int capacity,int collegeId,String className,String teacherName,int examDate,double examStartingTime,double examFinishingTime){
        this.classId=classId;
        this.vahed=vahed;
        this.capacity=capacity;
        this.collegeId=collegeId;
        this.className=className;
        this.teacherName=teacherName;
        this.examDatee=examDate;
        this.examDate[0]=examStartingTime;
        this.examDate[1]=examFinishingTime;
        classCounter++;
    }

    public boolean checker(int studentId){
        int i=0;
        while (true){
            if(this.studentIds[i]==studentId){
                return false;
            }
            i++;
            if(i==100){
                return true;
            }
        }
    }


    public void addingStudent(int studentId){
        int i=0;
        if(checker(studentId)){
            while (true){
                if(this.studentIds[i]==0){
                    this.studentIds[i]=studentId;
                    this.tedadeSabteNami++;
                    System.out.println("daneshjoo ba movafaqiat be dars ezafe shod");
                    break;
                }else {
                    i++;
                }
            }
        }else {
            System.out.println("daneshjo dars ra darad");
        }
    }


    public void removingStudent(int studentId){
        int i=0;
        while (true){
            if(this.studentIds[i]==studentId){
                this.studentIds[i]=0;
                this.tedadeSabteNami--;
                System.out.println("daneshjoo ba movafaqiat az dars hazf shod");
                break;
            }else {
                i++;
            }
            if(i==100){
                System.out.println("daneshjo morede nazar in dars ra nadarad");
            }
        }
    }

    public  boolean addingCapacity(int newCapacity){
        if(newCapacity>this.capacity){
            this.capacity=newCapacity;
            return true;
        }else {
            System.out.println("zarfiat kamtar az zarfiat ghabli");
            return false;
        }
    }

//    public static void showCourses(){
//
//    }

}
