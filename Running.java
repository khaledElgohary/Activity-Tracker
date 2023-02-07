public class Running extends GroundActivity{

    public Running(String name,String location,String date,int aDuration,int totalDistance,int elevation){
        super(name,location,date,aDuration,totalDistance,elevation);
    }

    public String toString(String time){
        String x="["+date+"]"+" RUNNING: "+"name "+"at "+location+"\n"+
                "duration: "+time+";"+"\n"+"distance: "+totalDistance+"km;"+"\n"+"elev: "+elevation+"m;\n"
                +"average speed: "+avgS()+" min/km";

        return x;
    }

    public int avgS(){

        return aDuration/totalDistance;
    }
}
