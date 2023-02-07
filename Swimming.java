public class Swimming extends Activity{
    int nLabs;
    int labLength;
    public Swimming(String name,String location,String date,int aDuration,int nLabs,int labLength){
        super(name,location,date,aDuration);
        this.nLabs=nLabs;
        this.labLength=labLength;
    }

    public float getPace(){
        return (float) aDuration/(nLabs*labLength);
    }

    public String toString(String time){
        String x="["+date+"] "+"SWIMMING: "+name+" at "+location+"\n"
        +"duration: "+time+";\n"+"distance: "+(nLabs*labLength)+"km;\n"+"average pace: "+getPace()+" min/km";
        return x;
    }
}
