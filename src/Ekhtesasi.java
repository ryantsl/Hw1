public class Ekhtesasi extends Course{
    public int [] classTime=new int[4];
    public static int ekhtesasiCounter=0;
    public Ekhtesasi(int classId,int vahed,int capacity,int collegeId,String className,String teacherName,int examDate,
                  int examStartingTime,int examFinishingTime,int classDay1,int classDay2,int classStartingTime,int classFinishingTime){
        super(classId,vahed,capacity,collegeId,className,teacherName,examDate,examStartingTime,examFinishingTime);
        ekhtesasiCounter++;
        this.classTime[0]=classDay1;
        this.classTime[1]=classDay2;
        this.classTime[2]=classStartingTime;
        this.classTime[3]=classFinishingTime;
    }
}
