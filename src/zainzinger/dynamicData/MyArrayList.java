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
	 * F�gt Object am Ende hinzu
	 * @param e 
	 * @return gibt true zur�ck
	 */
	public boolean add(Object e){
		this.add(this.index, e);
		return true;
	}


	/**
	 * F�gt das �bergebene Element an der spezifischen Stellen der Liste ein.
	 * @param index 
	 * @param element 
	 * @throw Falls der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist kommt es zu einer Fehlermeldung
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
	 * L�scht alle Elemente von der Liste.
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
	 * Vergr��ert die minimum Gr��e der Liste
	 * @param minCapacity Die Minimumgr��e
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
	 * Gibt das Objekt zur�ck, welches den angegebenen Index hat.
	 * @param index 
	 * @throw Falls der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist kommt es zu einer Fehlermeldung.
	 * @return Das gew�nschte Objekt.
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
	 * Diese Methode �berpr�ft ob die ArrayList leer ist.
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
	 * Die Liste  wird als Arrayzur�ck gegeben
	 * @return Die Liste als Array.
	 */
	public Object[] toArray(){
		return this.array;
	}
	
	
	/**
	 * L�scht Bereiche an Eintr�gen aus einer Liste. 
	 * 
	 * @param fromIndex der kleinere Index
	 * @param toIndex Der gr��ere Index
	 * @throw Falls einer der �bergebene Index kleiner 0 oder gr��er 0 als die L�nge der Liste ist
	 *  	  oder der kleinere Index gr��er als der Gr��ere ist, kommt es zu einer Fehlermeldung 
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
	 * Gibt die erste Stelle(Index) eines gesuchten Objektes zur�ck
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
	 * @param element das neue Element welches hinzugef�gt wird
	 * @throw Falls der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist kommt es zu einer Fehlermeldung
	 * @return das Element was vorher in der Liste stand
	 */
	public Object set(int index, Object element) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder gr��er als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft die Exception
		}else{// falls sich der �bergebene Index im erlaubten Rahmen befindet
			Object o = get(index);//Speichert den alten Wert.
			array[index] = element;//Ersetzt den alten Wert durch den neuen
			return o;//Gibt den alten Wert zur�ck
		}
	}
	
	/**
	 * L�scht das Element an der spezifischen Stellen der Liste ein.
	 * Falls das Elemente am Anfang oder in der Mitte der Liste gel�scht wird werden die nachfolgenden Indexes um 1 verringert.
	 * @param index der Index an welcher Position das Element gel�scht werden soll.
	 * @throw Falls der �bergebene Index kleiner 0 oder gr��er als die L�nge der Liste ist kommt es zu einer Fehlermeldung
	 * @return Das Obejkt, welches gel�scht wurde.
	 */
	public Object remove(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > this.index){//wenn der Parameter index kleiner 0 oder gr��er als die Size der Liste ist
			IndexOutOfBoundsException f = new IndexOutOfBoundsException("Index: "+index+", Size: "+this.index);//erzeugt ein Objekt welche eine Fehlermeldung liefert
			throw f;//wirft eine Exception
		}else{// falls sich der �bergebene Index im erlaubten Rahmen befindet
			Object o = this.get(index);
			Object[] zw = new Object[this.array.length];//Speichert die Liste in eine Zwischenvariable
			for(int i = 0; i < this.array.length; i++){
				zw[i] = this.get(i);
			}
			this.array = new Object[this.array.length-1]; //Array verkleinern
			int x = 0;
			for(int i = 0; i < zw.length; i++){
				if(i != index){
					this.array[x] = zw[i]; //Array wieder f�llen
				}
				if(this.array.length > 0 && this.array.length > x){ //Das gel�schte Element wird nicht wieder eingef�gt
					if(i != index){
						++x;
					}
				}
			}
			this.index--;
			return o;//Gibt das gew�nschte Objekt zur�ck
		}	
	}
}

