package AirPortSystem;
class ground{
    private groundvehicle vehicle;
    private boolean lock;
    private groundtrack track;
    ground(int i){
        this.vehicle=new groundvehicle(i);
        this.track=new groundtrack(i);
        lock=false;
    }
    public groundvehicle getGroundvehicles(){
        return vehicle;
    }
    public boolean getlock(){
        return lock;
    }
    public groundtrack getgroundtrack(){
        return track;
    }
    public void lock(){
        lock=true;
    }
    public void unlock(){
        lock=false;
    }
    public String toString(){
        return vehicle.toString()+" working in "+track.toString();
    }
}
