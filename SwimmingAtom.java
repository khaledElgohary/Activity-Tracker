public class SwimmingAtom extends ListItem{
    private final Swimming data;

    public SwimmingAtom(String name,String location,String date,int aDuration,int nLabs,int labLength){
        data=new Swimming(name, location, date, aDuration, nLabs, labLength);
        type="SWIMMING";
    }

    public void print() {
        System.out.println("< SWIMMING: "+data.getName()+" >");
    }
    public String getType(){return type;}
    public int getTime(){return data.aDuration;}
    public Swimming getData(){return data;}
    public String getDate(){return data.date;}
}
