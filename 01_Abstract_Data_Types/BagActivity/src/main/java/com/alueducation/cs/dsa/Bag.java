package com.alueducation.cs.dsa;

/**
 * Abstract Data Type definition of a bag using 
 * a Java interface.
 * 
 * @author Stephen Naicken
 */

interface Bag <T>{

    // add an object of type T to the bag
    void add(T t) throws BagIsFullException;

    // remove an object of type T from the bag
    T remove(T t);

    // remove the uppermost object from the bag
    T remove();

    // check if an object of type T is contained in the bag
    boolean contains(T t);

    // returns the number of items in the bag
    int size();

    // empty the bag
    T[] empty();

}