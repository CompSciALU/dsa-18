package com.alueducation.cs.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * LegoBag is a bag that can only hold Lego bricks.
 * It implements the Bag Abstract Data Type.
 * 
 * @author Stephen Naicken
 */

 public class LegoBag implements Bag<Lego> {

    // backing data structure to store the object
    private List<Lego> legos;

    public LegoBag(){
        legos = new ArrayList<>();
    }

    /**
     * Add a Lego to the bag.
     * 
     * @param  t   Lego to be added to the bag.
    */
    @Override
    public void add(Lego t) {
        legos.add(t);
    }

    /**
     * This method removes the first occurance of a Lego from the bag.
     * 
     * @param  t   the lego to be removed.    
     * @return     the removed lego from the bag.
    */
    @Override
    public Lego remove(Lego t) {
        return legos.remove(t) ? t : null;
    }

    /**
     * Removes the Lego at the top of the bag (closest to opening).
     * 
     * @return Lego object at the top of bag.
     */
    @Override
    public Lego remove() {
        if(legos.size() == 0){
            return null;
        }
        return legos.remove(legos.size()-1);
    }

    /**
     * Check if the Lego is in the bag.
     * 
     * @param  t   Lego to be checked if in bag.
     * @return     {@code true} if in the bag, {@code false} otherwise.
    */
    @Override
    public boolean contains(Lego t) {
        return legos.contains(t);
    }

    /** 
     * Returns the number of Legos in the bag.
     * 
     * @return      Number of Legos in the bag
    */
    @Override
    public int size() {
        return legos.size();
    }


    /**
     * Empties the bag.
     * 
     * @return   The Legos in the bag that have been removed   
     */
    @Override
    public Lego[] empty() {
        Lego[] legos = new Lego[this.legos.size()];
        this.legos.toArray(legos);
        this.legos.clear();
        return legos;
    }
 }