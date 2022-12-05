package AirPortSystem;
class groundvehicle{
    private  int id;
    private  int load;
    private static final int capacity=200;
    groundvehicle(int id){
        this.id=id;
        this.load=0;
    }
    groundvehicle(int id,int load){
        this.id=id;
        this.load=load;
    }
    public void setload(int load){
        this.load=load;
    }
    public boolean testifoverload(){
        return load>=capacity;
    }
    public int getid(){
        return id;
    }
    public int getload(){
        return load;
    }
    public int getcapacity(){
        return capacity;
    }
    public String toString(){
        return "groundvehicle "+id;
    }
}