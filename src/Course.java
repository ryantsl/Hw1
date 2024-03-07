public class Course {
    public static int [] classIds=new int[100];

    public static int classCounter=0;
    public int [] examDate=new int[3];
    public int vahed;
    public int capacity;
    public int tedadeSabteNami=0;
    public int collegeId;
    public int[] studentIds=new int[100];

    public int classId;
    public  String className;
    public String teacherName;

    public Course(int classId,int vahed,int capacity,int collegeId,String className,String teacherName,int examDate,int examStartingTime,int examFinishingTime){
        this.classId=classId;
        this.vahed=vahed;
        this.capacity=capacity;
        this.collegeId=collegeId;
        this.className=className;
        this.teacherName=teacherName;
        this.examDate[0]=examDate;
        this.examDate[1]=examStartingTime;
        this.examDate[2]=examFinishingTime;
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

    public void addingCapacity(int newCapacity){
        if(newCapacity>this.capacity){
            this.capacity=newCapacity;
        }
    }

}
