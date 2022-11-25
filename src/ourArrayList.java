import java.util.Arrays;

public class ourArrayList<T> implements OurList<T>{

    int size;
    int capacity;

    T[] source;

    public ourArrayList() {
        this.capacity = 10;
        source = (T[]) new Object[capacity];
    }

    @Override
    public void add(T elt) {
        if(size == capacity) ensureCapacity(capacity);
        source[size++] = elt;
    }

    @Override
    public void setElt(T elt, int index) {
        if (index < 0 || index >= (size + 1)) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        if(size == capacity) ensureCapacity(capacity);
        System.arraycopy(source,index, source, index + 1, size - index);
        source[index] = elt;
        size++;
    }

    @Override
    public T getElt(int index) {
      if(size == 0 || index > size){
          throw new IllegalArgumentException("illegal index:" + index);
      }
       return source[index];
    }

    @Override
    public boolean contains(T elt) {
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
    public T remove(int index) {
        T removedElt = source[index];
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
        Arrays.sort(source,0, size());
    }

    private void ensureCapacity(int capacity){
        T[] oldSource = source;
        int newCapacity = (capacity * 3 + 1)/2;
        source = Arrays.copyOf(oldSource, newCapacity);
    }


}
