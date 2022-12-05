package AirPortSystem;

public class communicategroundvehicle implements Communicate{
    int groundvehicleid;
    communicategroundvehicle(int groundvehicleid){
          this.groundvehicleid=groundvehicleid;
    }
    public void communicate(){
      //here is hardware control code for communicate
      System.out.println("communicate with "+groundvehicleid);
    }
    public void communicate(String message){
        //hardware hardware control code here for using radar or wifi to communicate with plane to transfer message
        System.out.println("communicate with ground vehicle "+groundvehicleid+" with message "+message);
  }
}
