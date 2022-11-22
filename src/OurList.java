public interface OurList<T> extends Comparable<T>{

    public void add(T elt);
    public void setElt(T elt, int index); //added elt by index
    public T getElt(int index);
    public boolean contains(T elt);
    public int size();
    public T remove(int index);
    public boolean couldRemove(T elt);
    public void sort();
}
