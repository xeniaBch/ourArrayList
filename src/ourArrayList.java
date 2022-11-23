import java.util.Arrays;

public class ourArrayList<T> implements OurList{

    int size;
    int capacity;

    Object[] source;

    public ourArrayList() {
        this.capacity = 10;
        source = new Object[capacity];
    }

    @Override
    public void add(Object elt) {
        if(size == capacity) ensureCapacity(capacity);
        source[size++] = elt;
    }

    @Override
    public void setElt(Object elt, int index) {
        if (index < 0 || index >= (size + 1)) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        if(size == capacity) ensureCapacity(capacity);
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
        Arrays.sort(source);
    }

    private void ensureCapacity(int capacity){
        Object[] oldSource = source;
        int newCapacity = (capacity * 3 + 1)/2;
        source = Arrays.copyOf(oldSource, newCapacity);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
