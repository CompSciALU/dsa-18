package com.alueducation.cs.dsa;

/**
 * UnorderedBetterLegoBag is a bag that can only hold Lego bricks.
 * It implements the Bag Abstract Data Type interface.
 * 
 * Unlike BetterLegoBag, it does not preserve the order in
 * which elements are added to the bag.
 * 
 * @author Stephen Naicken
 */
public class UnorderedBetterLegoBag implements Bag<Lego> {

	private Lego[] legos;
	private int capacity;

	/**
     * Creates an UnorderedBetterLegoBag with given capacity.
     * 
     * @param   size    Capacity of the bag.
     */
    public UnorderedBetterLegoBag(int capacity) {
		this.capacity = capacity;
		legos = new Lego[capacity];
    }

	/**
     * Add a Lego to the bag.
     * 
     * @param  t   Lego to be added to the bag.
    */
	@Override
	public void add(Lego t) throws BagIsFullException {
		int i = 0;
		// find the first element containing null
		while (i<capacity){
			if (legos[i] == null){
				legos[i] = t;
				break;
			}
			i++;
		}
		
		// no null element in the array, throw exception
		if(capacity == i){
			throw new BagIsFullException();
		}
	}

	/**
     * Removes the object at the top (closest to the opening opening).
     * 
     * @return Lego object at the top of the bag.
     */
	@Override
	public Lego remove() {
		return null;
	}

	/**
     * This method removes the first occurance of a Lego from the bag.
     * 
     * @param  t   the lego to be removed.    
     * @return     the removed lego from the bag.
    */
	@Override
	public Lego remove(Lego t) {
		// iterate to find first occurance
		for(int i=0; i < capacity; i++){
			if (legos[i] != null && legos[i].equals(t)){
				// set array element i to null and return previously held lego
				Lego tmpLego = legos[i];
				legos[i] = null;
				return tmpLego;
			}
		}

		// not found, return null
		return null;
	}
	
	/**
     * Check if the Lego is in the bag.
     * 
     * @param  t   Lego to be checked if in bag.
     * @return     {@code true} if in the bag, {@code false} otherwise.
    */
	@Override
	public boolean contains(Lego t) {
		for(int i=0; i<capacity; i++){
			if(legos[i] != null && legos[i].equals(t)){
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
		int counter = 0;
		for(int i=0; i<capacity; i++){
			if(legos[i] != null){
				counter++;
			}
		}
		return counter;
	}

	/**
     * Empties the bag.
     * 
     * @return   The Legos in the bag that have been removed   
     */
	@Override
	public Lego[] empty() {
		// move the nulls to the end of the temp array
		int counter = 0;
		Lego[] tmpLegos = new Lego[capacity];
		for(int i = 0; i < capacity; i++){
			if (legos[i] != null){
				tmpLegos[counter++] = legos[i];
				legos[i] = null;
			}
		}

		// trim the temp array
		Lego[] rmLegos = new Lego[counter];
		for(int j = 0; j < counter; j++){
			rmLegos[j] = tmpLegos[j];
		}

		return rmLegos;

		/*

			// ArrayList approach:

			List<Lego> legoList = new ArrayList<>();
			for(int i=0; i<capacity; i++){
				if(this.legos[i] != null){
					legoList.add(this.legos[i]);
				}
			}
			Lego[] legos = new Lego[legoList.size()];
			return legoList.toArray(legos);
		*/
	}

}