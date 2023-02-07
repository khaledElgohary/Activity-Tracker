public class Cycling extends GroundActivity{


    public Cycling(String name,String location,String date,int aDuration,int totalDistance
    ,int elevation){
        super(name,location,date,aDuration,totalDistance,elevation);

    }

    public float avgS(){
        double x=(double) aDuration/60;
        return (float) totalDistance/(float)x;
    }

    public String toString(String time){
        String x="["+date+"]"+" Cycling: "+name+" at "+location+"\n"+
        "duration: "+time+";"+"\n"+"distance: "+totalDistance+"km;"+"\n"+"elev: "+elevation+"m;\n"
        +"average speed: "+avgS()+"km/h";

        return x;
    }
}
