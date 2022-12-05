package AirPortSystem;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.LinkedBlockingDeque;

class landingAndTakeOff{
    private static ground[] groundresource=new ground[5];
    private static ground emergencyground=new ground(5);
    private static LinkedBlockingDeque<String> plane=new LinkedBlockingDeque<>();
    public static void run(){
        StdIn.setFile(LocalDate.now().toString()+".in");
        StdOut.setFile(LocalDate.now().toString()+".out");
        for (int i=0;i<5;i++){
            groundresource[i]=new ground(i);
        }
        int count=StdIn.readInt();
        String weather=StdIn.readString();
        StdOut.println("today is "+LocalDate.now()+" weather is "+weather);
        if (weather.equals("hardly weather")) {
            System.out.println("today weather is bad, the airport close");
            for (int i=0;i<count;i++){
                communicategroundvehicle cgv=new communicategroundvehicle(i);
                cgv.communicate("airport is close");
                communicateplane cp=new communicateplane(StdIn.readString());
                cp.communicate("the airport is close, please go to another airport");
            }
        }
        else {
            for (int i=0;i<count;i++){
            plane.add(StdIn.readString());
            landingAndTakeOff l=new landingAndTakeOff();
            planethread p=l.new planethread();
            p.start();
        }
        }
    }
    public static void emergency(){
            emergencyground.lock();
            System.out.println("emergency happened");
            System.out.println(plane.poll()+"landing in emergency track 5 at time"+LocalTime.now());
            emergencyground.unlock();
            }
    class planethread extends Thread{
    @Override
    public void run(){
             int i=0;
                 while(true){
              if (groundresource[i].getlock()) {
                 i=(i+1)%5;
              }
             else {
                    String name=plane.poll();
                    groundresource[i].lock();
                    StdOut.println(name+" has using track "+i+" at time "+LocalTime.now());
                    communicateplane cp=new communicateplane(name);
                    cp.communicate("land in track "+i);
                    communicategroundvehicle cgv=new communicategroundvehicle(i);
                    cgv.communicate("vehicle "+i+" go to track "+i+" to wait for "+name);
                    try {
                       sleep(1000);
                   } catch (InterruptedException e) { 
                   }
                   StdOut.println(name+" has leave track "+i+" at time "+LocalTime.now());
                   groundresource[i].unlock();
                   break;
             }
             }  
             }
    }
}
