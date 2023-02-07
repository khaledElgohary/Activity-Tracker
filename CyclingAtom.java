public class CyclingAtom extends ListItem{
    private final Cycling data;

    public CyclingAtom(String name,String location,String date,int aDuration,int totalDistance
            ,int elevation){
        data=new Cycling(name, location, date, aDuration, totalDistance, elevation);
        type="CYCLING";

    }
    public void print() {
        System.out.println("< CYCLING, "+data.getName()+" >");
    }
    public String getType(){return type;}

    public int getTime(){return data.aDuration;}

    public String getDate(){return data.date;}

    public Cycling getData(){
        return data;
    }

}
