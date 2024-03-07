public class Omoomi extends Course {
    public int [] classTime=new int[3];

    public static int omooomiCounter=0;

    public Omoomi(int classId,int vahed,int capacity,int collegeId,String className,String teacherName,int examDate,
                  int examStartingTime,int examFinishingTime,int classDay,int classStartingTime,int classFinishingTime){
        super(classId,vahed,capacity,collegeId,className,teacherName,examDate,examStartingTime,examFinishingTime);
        omooomiCounter++;
        this.classTime[0]=classDay;
        this.classTime[1]=classStartingTime;
        this.classTime[2]=classFinishingTime;
    }
}
