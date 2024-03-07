public class Omoomi extends Course {
    public double [] classTime=new double[2];

    public int classDay;

    public static int omooomiCounter=0;

    public Omoomi(int classId,int vahed,int capacity,int collegeId,String className,String teacherName,int examDate,
                  double examStartingTime,double examFinishingTime,int classDay,double classStartingTime,double classFinishingTime){
        super(classId,vahed,capacity,collegeId,className,teacherName,examDate,examStartingTime,examFinishingTime);
        this.classDay=classDay;
        this.classTime[0]=classStartingTime;
        this.classTime[1]=classFinishingTime;
        omooomiCounter++;
    }
    public  void showCourses(){
        System.out.println("omoomi--code dars:"+this.classId+"--daneshkade;"+collegeName[this.collegeId]+"--name dars:"+this.className+"--name ostad:"+this.teacherName);
        System.out.println("vahed:"+this.vahed+"--zarfiat:"+this.tedadeSabteNami+"/"+this.capacity+"--rooz class:"+Omoomi.rooz[this.classDay]+"--saat class:az"
                +this.classTime[0]+"ta"+this.classTime[1]);
        System.out.println("tarikhe emtehan:"+this.examDatee+"  az saat "+this.examDate[0]+"  ta saat "+this.examDate[1]+"\n\n");
    }
}
