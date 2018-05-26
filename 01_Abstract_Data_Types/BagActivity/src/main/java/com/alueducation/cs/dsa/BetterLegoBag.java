package com.alueducation.cs.dsa;


/**
 * BetterLegoBag is a bag that can only hold Lego bricks.
 * It implements the Bag Abstract Data Type interface.
 * 
 * @author Stephen Naicken
 */

 public class BetterLegoBag implements Bag<Lego> {

    // backing data structure to store the object
    private Lego[] legos;
    
    // position of next writable array element
    private int pos = 0;

    // capacity of the bag
    private int capacity;

    /**
     * Creates a BetterLegoBag with given capacity.
     * 
     * @param   size    Capacity of the bag.
     */
    public BetterLegoBag(int capacity){
        legos = new Lego[capacity];
        this.capacity = capacity;
    }

    /**
     * Add a Lego to the bag.
     * 
     * @param  t   Lego to be added to the bag.
    */
    @Override
    public void add(Lego t) throws BagIsFullException{
        if (pos >= capacity) throw new BagIsFullException();
        legos[pos++] = t;
    }

    /**
     * Removes the object at the top (closest to the opening opening).
     * 
     * @return Lego object at the top of the bag.
     */
    @Override
    public Lego remove() {
        return legos[pos>0 ? --pos : null];
    }

    /**
     * This method removes the first occurance of a Lego from the bag.
     * 
     * @param  t   the lego to be removed.    
     * @return     the removed lego from the bag.
    */
    @Override
    public Lego remove(Lego t){
        Lego removedLego = null;

        // find the index of the lego to remove
        int i;
        for(i = 0; i < pos; i++){
            if(legos[i].equals(t)){
                removedLego = legos[i];
                break;
            }
        }

        // remove the lego
        if(removedLego != null){
            int c = 0; // counter
            Lego[] newLegos = new Lego[legos.length-1];
            for (int j=0; j < pos; j++){
                if (j!=i){
                    // only copy across legos not to be removed
                    newLegos[c++] = legos[j];
                }
            }
            legos = newLegos;
            pos--;
        }

        return removedLego;
    }

    /**
     * Check if the Lego is in the bag.
     * 
     * @param  t   Lego to be checked if in bag.
     * @return     {@code true} if in the bag, {@code false} otherwise.
    */
    @Override
    public boolean contains(Lego t) {
        for(int i=0; i< pos; i++){
            if (legos[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    /** 
     * Returns the number of Legos in the bag.
     * 
     * @return      Number of Legos in the bag
    */
    @Override
    public int size() {
        return pos;
    }

    /**
     * Empties the bag.
     * 
     * @return   The Legos in the bag that have been removed   
     */
    @Override
    public Lego[] empty() {
        Lego[] legos = new Lego[pos];
        // System.arraycopy uses a native method, 
        // but you can also use a for-loop.
        System.arraycopy(this.legos, 0, legos, 0, pos);
        pos = 0;
        return legos;
    }
 }