public class GenericList extends ListItem{
    private Node top;

    public GenericList(){
        top=null;
    }

    public void insertFront(ListItem data){
        top=new Node(data,top);
    }

    public void print(){
        System.out.println("<<");
        if(top!=null)
            top.print();
        System.out.println(">>");
    }

    public Node getTop(){
        return top;
    }

    public Node getNext(){
        return top.getNext();
    }
}
