public abstract class GroundActivity extends Activity{
    int totalDistance;
    int elevation;
    public GroundActivity(String name,String location,String date,int aDuration,int totalDistance
    ,int elevation){
        super(name,location,date,aDuration);
        this.totalDistance=totalDistance;
        this.elevation=elevation;
    }
}
