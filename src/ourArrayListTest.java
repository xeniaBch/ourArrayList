import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ourArrayListTest {

    ourArrayList<Integer> arrayList = new ourArrayList<>();

    @Test
    public void testAddElement(){
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(3);
        assertEquals(4, arrayList.size);
    }

    @Test
    public void testIndexAddElement(){
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.setElt(3, 1);
        arrayList.setElt(1, 2);
        assertEquals(5, arrayList.size);
    }

    @Test
    public void testGetElement(){
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.setElt(3, 1);
        arrayList.setElt(1, 2);
        assertEquals(1, arrayList.getElt(2));
    }

    @Test
    public void testContains(){
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.setElt(3, 1);
        arrayList.setElt(1, 2);
        assertTrue( arrayList.contains(2));
    }

    @Test
    public void testRemove(){
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.setElt(3, 1);
        arrayList.setElt(1, 2);
        assertEquals(3, arrayList.remove(1));
        assertEquals(4, arrayList.size());
        assertFalse( arrayList.contains(3));
    }

    @Test
    public void testCouldRemove(){
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.setElt(3, 1);
        arrayList.setElt(1, 2);
        assertTrue(arrayList.couldRemove(2));
        assertEquals(4, arrayList.size());
        assertFalse(arrayList.contains(2));
    }

    @Test
    public void testSort(){
        arrayList.add(14);
        arrayList.add(-3);
        arrayList.add(4);
        arrayList.add(0);
        arrayList.setElt(18, 1);
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(-8);
        arrayList.add(12);
        arrayList.add(7);
        Integer[] res = {-8, -3, 0, 3, 4, 7, 9, 12, 14, 18};
        arrayList.sort();
        assertEquals(res[0], arrayList.getElt(0));
    }
}