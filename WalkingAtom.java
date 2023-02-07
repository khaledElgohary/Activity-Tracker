public class WalkingAtom  extends ListItem{
    private final Walking data;

    public WalkingAtom(String name,String location,String date,int aDuration,int totalDistance,int elevation){
        data=new Walking(name, location, date, aDuration, totalDistance, elevation);
        type="WALKING";
    }

    public void print(){
        System.out.println("< WALKING , "+data.getName()+" >");
    }
    public String getType(){return type;}
    public int getTime(){return data.aDuration;}
    public Walking getData(){return data;}
    public String getDate(){return data.date;}
}
