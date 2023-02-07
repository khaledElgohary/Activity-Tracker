public class Node {
    private ListItem data;
    private Node next;

    public Node(ListItem data,Node next){
        this.data=data;
        this.next=next;
    }

    public void print(){
        data.print();
        if(next !=null)
            next.print();
    }

    public Node getNext(){
        return next;
    }

    public ListItem getData() {
        return data;
    }
}
