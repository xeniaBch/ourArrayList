import org.junit.Test;

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
        System.out.println(arrayList.contains(2));

    }
}