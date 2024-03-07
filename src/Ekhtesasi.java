public class Ekhtesasi extends Course{
    public double [] classTime=new double[2];

    public int classDay1;

    public int classDay2;
    public static int ekhtesasiCounter=0;
    public Ekhtesasi(int classId,int vahed,int capacity,int collegeId,String className,String teacherName,int examDate,
                  double examStartingTime,double examFinishingTime,int classDay1,int classDay2,double classStartingTime,double classFinishingTime){
        super(classId,vahed,capacity,collegeId,className,teacherName,examDate,examStartingTime,examFinishingTime);
        ekhtesasiCounter++;
        this.classDay1=classDay1;
        this.classDay2=classDay2;
        this.classTime[0]=classStartingTime;
        this.classTime[1]=classFinishingTime;
    }
    public  void showCourses(){
        System.out.println("ekhtesasi--code dars:"+this.classId+"--daneshkade;"+collegeName[this.collegeId]+"--name dars:"+this.className+"--name ostad:"+this.teacherName);
        System.out.println("vahed:"+this.vahed+"--zarfiat:"+this.tedadeSabteNami+"/"+this.capacity+"--rooz class:"+Ekhtesasi.rooz[this.classDay1]+"va"+Ekhtesasi.rooz[this.classDay2]+"--saat class:az"
                +this.classTime[0]+"ta"+this.classTime[1]);
        System.out.println("tarikhe emtehan:"+this.examDatee+"  az saat "+this.examDate[0]+"  ta saat "+this.examDate[1]+"\n\n");
    }
}
