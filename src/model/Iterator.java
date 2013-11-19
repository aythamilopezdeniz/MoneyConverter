package model;

public class Iterator implements Iterable<Integer>{

    @Override
    public java.util.Iterator<Integer> iterator() {
        Iterator iterator=new Iterator();
        return iterator();
    }
    
}