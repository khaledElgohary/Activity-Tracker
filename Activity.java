public abstract class Activity {
    String name;
    String location;
    String date;
    int aDuration;


    public Activity(String name,String location,String date,int aDuration){
        this.name=name;
        this.location=location;
        this.date=date;
        this.aDuration=aDuration;
    }

    public String toString(String time){
        String x="["+date+"]"+ "Activity: "+name+" at "+location+"\n"
        +"duration: "+time;
        return x;
    }

    public String getName(){
        return name;
    }
}
