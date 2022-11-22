import java.util.Arrays;

public class ourArrayList<T> implements OurList{

    int size;

    Object[] source;

    public ourArrayList() {
        source = new Object[size];
    }

    @Override
    public void add(Object elt) {
        ensureCapacity(size+1);
        source[size++] = elt;
    }

    @Override
    public void setElt(Object elt, int index) {
        if (index < 0 || index >= (size + 1)) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        ensureCapacity(size+1);
        System.arraycopy(source,index, source, index + 1, size - index);
        source[index] = elt;
        size++;
    }

    @Override
    public Object getElt(int index) {
      if(size == 0 || index > size){
          throw new IllegalArgumentException("illegal index:" + index);
      }
       return source[index];
    }

    @Override
    public boolean contains(Object elt) {
        for (int i = 0; i < size; i++) {
            if(elt.equals(source[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object remove(int index) {
        Object removedElt = source[index];
        int movedIndex = size - index - 1;
        if (movedIndex > 0) {
            System.arraycopy(source, index + 1, source, index, movedIndex);
        }
        size--;
        return removedElt;
    }

    @Override
    public boolean couldRemove(Object elt) {
        for (int i = 0; i < source.length; i++) {
            if(elt.equals(source[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    //TODO: make comparator
    @Override
    public void sort() {

    }

    private void ensureCapacity(int capacity){
        Object[] oldSource = source;
        int newCapacity = (capacity * 3)/2 + 1;
        source = Arrays.copyOf(oldSource, newCapacity);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
