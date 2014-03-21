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
	 * Fügt Object am Ende hinzu
	 * @param e 
	 * @return gibt true zurück
	 */
	public boolean add(Object e){
		this.add(this.index, e);
		return true;
	}


	/**
	 * Fügt das übergebene Element an der spezifischen Stellen der Liste ein.
	 * @param index 
	 * @param element 
	 * @throw Falls der übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung
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
	 * Löscht alle Elemente von der Liste.
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
	 * Vergrößert die minimum Größe der Liste
	 * @param minCapacity Die Minimumgröße
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
	 * Gibt das Objekt zurück, welches den angegebenen Index hat.
	 * @param index 
	 * @throw Falls der übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung.
	 * @return Das gewünschte Objekt.
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
	 * Diese Methode überprüft ob die ArrayList leer ist.
	 * @return true oder false
	 */
	public boolean isEmpty(){
		if(this.index==0) { 
			return true;
		}else {
			return false;
		}
	}

}
