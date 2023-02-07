public class Walking extends GroundActivity{

    public Walking(String name,String location,String date,int aDuration,int totalDistance,int elevation){
        super(name,location,date,aDuration,totalDistance,elevation);
    }

    public String toString(String time){
        String x="["+date+"]"+" WALKING: "+"name "+"at "+location+"\n"+
                "duration: "+time+";"+"\n"+"distance: "+totalDistance+"km;"+"\n"+"elev: "+elevation+"m;\n"
                +"average speed: "+avgS()+"km/h";

        return x;
    }

    public int avgS(){
        return aDuration/totalDistance;
    }
}
