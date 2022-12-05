package AirPortSystem;
//only communicate with plane
public class communicateplane implements Communicate{
    String planeid;
    communicateplane(String planeid){
       this.planeid=planeid;
    }
    public void communicate(){
        // hardware control code here for using radar or wifi to communicate with plane
        System.out.println("communicate with "+planeid);
    }
    public void communicate(String message){
          //hardware hardware control code here for using radar or wifi to communicate with plane to transfer message
          System.out.println("communicate with "+planeid+" with message "+message);
    }
}
