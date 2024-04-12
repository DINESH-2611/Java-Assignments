package arraylist;

import java.util.ArrayList;

public class CircularBuffer {
    int size;
    ArrayList<String> list;
    int index;
    CircularBuffer(int size){
        this.size=size;
        list=new ArrayList<>(size);
    }

    public void addMessage(String s) {
        if(list.size()>=size){
            list.set(index,s);
        }
        else {
            list.add(s);
        }
        index=(index+1)%size;
    }

    public void printMessage() {
        for(String msg:list){
            System.out.println(msg);
        }
    }
}
class CircularDemo{
    public static void main(String[] args) {
        CircularBuffer cd=new CircularBuffer(5);
        cd.addMessage("Hello java");
        cd.addMessage("How are you?");
        cd.addMessage("Iam Fine");
        cd.addMessage("How old are you?");
        cd.addMessage("I am 21 years old");
        cd.addMessage("bye bye bye!");
        cd.addMessage("Thank you");
        cd.printMessage();
    }
}

