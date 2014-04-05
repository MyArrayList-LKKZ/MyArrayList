package zainzinger.dynamicData;

/**
 * MyArrayList
 * @author lzainzinger
 * @author clehner
 * @author pkronowetter
 * @author skreutzer
 * @version 2014-04-05
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
	 * @throw Falls der Übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung
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
	
	public void trimToSize(){
		Object[] zw = new Object[this.index];//Erzeugt eine Zwischenvariable
		for(int i = 0; i < this.index; ++i){
			zw[i] = this.get(i);//Speichert die Objekte in die Zwischenvariable
		}
		this.array = new Object[this.index];//Verkleinern der Liste
		for(int i = 0; i < zw.length; ++i){
			this.array[i] = zw[i];//Speichern der Objekte von der Zwischenvariable in die Liste.
		}
	}
	
	/**
	 * Ersetzt das Objekt an einem bestimmten Index durch ein neues.
	 * @param index der Index an welcher Position das Element erzetzt werden soll
	 * @param element das neue Element welches hinzugefügt wird
	 * @throw Falls der übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung
	 * @return das Element was vorher in der Liste stand
	 */
	public Object set(int index, Object element) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder größer als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft die Exception
		}else{// falls sich der übergebene Index im erlaubten Rahmen befindet
			Object o = get(index);//Speichert den alten Wert.
			array[index] = element;//Ersetzt den alten Wert durch den neuen
			return o;//Gibt den alten Wert zurück
		}
	}
	
	/**
	 * Löscht das Element an der spezifischen Stellen der Liste ein.
	 * Falls das Elemente am Anfang oder in der Mitte der Liste gelöscht wird werden die nachfolgenden Indexes um 1 verringert.
	 * @param index der Index an welcher Position das Element gelöscht werden soll.
	 * @throw Falls der übergebene Index kleiner 0 oder größer als die Länge der Liste ist kommt es zu einer Fehlermeldung
	 * @return Das Obejkt, welches gelöscht wurde.
	 */
	public Object remove(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder größer als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}else{// falls sich der übergebene Index im erlaubten Rahmen befindet
			Object o = this.get(index);
			Object[] zw = new Object[this.array.length];//Speichert die Liste in eine Zwischenvariable
			for(int i = 0; i < this.array.length; i++){
				zw[i] = this.get(i);
			}
			this.array = new Object[this.array.length-1]; //Array verkleinern
			int x = 0;
			for(int i = 0; i < zw.length; i++){
				if(i != index){
					this.array[x] = zw[i]; //Array wieder füllen
				}
				if(this.array.length > 0 && this.array.length > x){ //Das gelöschte Element wird nicht wieder eingefügt
					if(i != index){
						++x;
					}
				}
			}
			this.index--;
			return o;//Gibt das gewünschte Objekt zurück
		}	
	}
}

