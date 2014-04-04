package zainzinger.dynamicData;

/**
 * MyArrayList
 * @author lzainzinger
 * @author clehner
 * @author pkronowetter
 * @author skreutzer
 * @version 2014-03-21
 */
public class MyArrayList {
	private Object[] array;
	private int index;

	/**
	 * Default Konstruktor
	 */
	public MyArrayList(){
		this(10);
	}

 
	/**
	 * Konstruktor
	 * @param initialCapacity 
	 * @throw Falls die Parameter negativ sind kommt es zu einer Fehlermeldung;
	 */
	public MyArrayList(int initialCapacity) throws IllegalArgumentException{
		if(initialCapacity < 0){
			IllegalArgumentException f = new IllegalArgumentException("Illegal Capacity: "+initialCapacity);
			throw f;
		}else{
			this.array = new Object[initialCapacity];
			this.index = 0;
		}
	}


	/**
	 * FŸgt Object am Ende hinzu
	 * @param e 
	 * @return gibt true zurŸck
	 */
	public boolean add(Object e){
		this.add(this.index, e);
		return true;
	}


	/**
	 * FŸgt das Ÿbergebene Element an der spezifischen Stellen der Liste ein.
	 * @param index 
	 * @param element 
	 * @throw Falls der Ÿbergebene Index kleiner 0 oder grš§er als die LŠnge der Liste ist kommt es zu einer Fehlermeldung
	 */
	public void add(int index, Object element) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);
			throw f;
		}
		else{
			if(index < this.index){
				Object[] hilfsarray=new Object[this.array.length+1];
				int z = 0;
				for(int i=0;i<this.array.length;i++){
					if(index == i){
						hilfsarray[i]=element;
						z = 1;
					}
					hilfsarray[i+z]=this.array[i];
				}
				this.array=hilfsarray;
			}
			else{
				try{
					this.array[index] = element;
				}catch(java.lang.ArrayIndexOutOfBoundsException f){
					Object[] hilfsarray=new Object[this.array.length+1];
					for(int i=0;i<this.array.length;i++){
						hilfsarray[i]=this.array[i];
					}
					hilfsarray[hilfsarray.length-1]=element;
					this.array=hilfsarray;
				}
			}
		}
		this.index++;
	}


	/**
	 * Lšscht alle Elemente von der Liste.
	 */
	public void clear(){
		this.array = new Object[this.array.length];
		this.index = 0;
	}

	/**
	 * Clonen der Liste
	 */
	public Object[] clone(){
		return this.array.clone();
	}


	/**
	 * Zeigt ob Element in der Liste ist
	 * @param o das Element was in der Liste gesucht werden soll
	 * @return true wenn sich das Element in der Liste befindet
	 */
	public boolean contains(Object o){
		for(int i=0;i<this.index;i++){
			if(o.equals(this.get(i))){
				return true;
			}
		}
		return false;
	}

	/**
	 * Vergrš§ert die minimum Grš§e der Liste
	 * @param minCapacity Die Minimumgrš§e
	 */
	public void ensureCapacity(int minCapacity){
		Object[] zw = new Object[this.array.length];
		for(int i = 0; i < this.index; i++){
			zw[i] = this.get(i);
		}
		this.array = new Object[minCapacity];
		for(int i = 0; i < zw.length; i++){
			this.array[i] = zw[i];
		}
	}

	/**
	 * Gibt das Objekt zurŸck, welches den angegebenen Index hat.
	 * @param index 
	 * @throw Falls der Ÿbergebene Index kleiner 0 oder grš§er als die LŠnge der Liste ist kommt es zu einer Fehlermeldung.
	 * @return Das gewŸnschte Objekt.
	 */
	public Object get(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);
			throw f;
		}else{
			return this.array[index];
		}
	}

	/**
	 * Diese Methode ŸberprŸft ob die ArrayList leer ist.
	 * @return true oder false
	 */
	public boolean isEmpty(){
		if(this.index==0) { 
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Die Liste  wird als Arrayzurück gegeben
	 * @return Die Liste als Array.
	 */
	public Object[] toArray(){
		return this.array;
	}
	
	
	/**
	 * Löscht Bereiche an Einträgen aus einer Liste. 
	 * 
	 * @param fromIndex der kleinere Index
	 * @param toIndex Der größere Index
	 * @throw Falls einer der übergebene Index kleiner 0 oder größer 0 als die Länge der Liste ist
	 *  	  oder der kleinere Index größer als der Größere ist, kommt es zu einer Fehlermeldung 
	 */
	protected void removeRange(int fromIndex, int toIndex) throws IndexOutOfBoundsException{
		if(fromIndex < 0 || fromIndex > this.index || toIndex < 0 || toIndex > this.index || fromIndex > toIndex){
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);
			throw f;
		}else{
			for(int i=fromIndex;i<=toIndex;i++){
				this.remove(i);
			}
		}
	}
	private void remove(int i) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Gibt die erste Stelle(Index) eines gesuchten Objektes zurück
	 *                          
	 * @param o Das gesuchte Objekt
	 * @return Der Index des gesuchten Objekts
	 */
	public int indexOf(Object o){
		for(int i=0;i<this.index;i++){
			if(o.equals(this.get(i))){
				return i;
		}
	}
		return -1;
	}
}

