package com.alueducation.cs.dsa;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
    This is a test class for our BetterLegoBag ADT implementation.
*/
public class UnorderedBetterLegoBagTest {

    private final int capacity = 1000; // the capacity of the bag

    private Bag<Lego> betterLegoBag;

    /*
        Before each test, run the setup method.
    */
    @BeforeEach
    public void setup(){
        betterLegoBag = new UnorderedBetterLegoBag(capacity);
    }

    @Test
    public void testAdd_empty() throws BagIsFullException{
        betterLegoBag.add(new Lego());
        assertEquals(1, betterLegoBag.size()); 
    }

    /*
        Test adding a Lego object to a not empty bag, but
        not full.
    */
    @Test
    public void testAdd_notEmpty() throws BagIsFullException{
        betterLegoBag.add(new Lego());
        betterLegoBag.add(new Lego());
        assertEquals(2, betterLegoBag.size());;
    }


    @Test
    public void testAdd_full() throws BagIsFullException {
        for(int i=0; i<capacity; i++){
            betterLegoBag.add(new Lego());
        }

        // add object to exceed bag capacity, expect exception
        assertThrows(BagIsFullException.class, () -> betterLegoBag.add(new Lego()));
    }  


    /*
        Test removing from an empty bag.  
    */
    @Test
    public void testRemove_empty(){
        assertNull(betterLegoBag.remove(new Lego()));
    }

    @Test
    public void testRemove_notEmpty() throws BagIsFullException{
        Lego[] legos = new Lego[99];

        for (int i = 0; i < legos.length; i++){
            legos[i] = new Lego();
            betterLegoBag.add(legos[i]);
        }

        // first, test for when the bag does not contain the object
        // second, test we can remove all objects added to the bag
        assertAll(
            () -> assertNull(betterLegoBag.remove(new Lego())),
            () -> 
                {
                    for (int j=0; j < legos.length; j++) {
                        assertNotNull(betterLegoBag.remove(legos[j]));
                    }
                }
        );
    }

    @Test
    public void testContains() throws BagIsFullException{
        Lego[] legos = new Lego[99];

        for (int i = 0; i < legos.length; i++){
            legos[i] = new Lego();
            betterLegoBag.add(legos[i]);
        }

        for (Lego lego : legos) {
            assertTrue(betterLegoBag.contains(lego));
        }
        
        // test condition is the object is not the bag.
        Lego xLego = new Lego();
        assertFalse(betterLegoBag.contains(xLego));
    }

    @Test
    public void testSize() throws BagIsFullException{
        int numberOfLegos = 100;

        for (int i = 0; i < numberOfLegos; i++){
            betterLegoBag.add(new Lego());
        }

        assertEquals(numberOfLegos, betterLegoBag.size());
    }

    @Test
    public void testEmpty() throws BagIsFullException{
        Lego[] legos = new Lego[99];

        for (int i = 0; i < legos.length; i++){
            legos[i] = new Lego();
            betterLegoBag.add(legos[i]);
        }

        // assert the removed elements array is of the same length
        // assert the size is zero
        assertAll(
            () -> assertEquals(legos.length, betterLegoBag.empty().length),
            () -> assertEquals(0, betterLegoBag.size())
        );     
    }

}