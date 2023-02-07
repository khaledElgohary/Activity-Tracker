public class RunningAtom extends ListItem {
    private final Running data;
    public RunningAtom(String name,String location,String date,int aDuration,int totalDistance,int elevation){
        data=new Running(name, location, date, aDuration, totalDistance, elevation);
        type="RUNNING";
    }

    public void print(){
        System.out.println("< RUNNING , "+data.getName()+">");
    }
    public String getType(){return type;}
    public int getTime(){return data.aDuration;}
    public Running getData(){return data;}
    public String getDate(){return data.date;}
}
