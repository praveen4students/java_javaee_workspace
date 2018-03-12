package com.jspiders.corejava.collections;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<V> implements Iterable<V> {

	private Object[] data;
	private int index = 0;
	private int intialSize = 10;
	private int incrementSize = 10;
	
	public MyArrayList() {
		data = new Object[intialSize];
	}

	public MyArrayList(int size) {
		data = new Object[size];
	}
	
	public V get(int position) {
		return (V)data[position];
	}
	
	public void add(V val) {
		if(index==data.length) {
			increaseSize();
		}
		data[index] = val;
		index++; //we can rewrite the above 2 lines into single line like data[index++] = val;
	}
	
	/*public void remove(int position) {
		int i = 0;
		try {
				for(i=position; i<index; i++) {
					data[i] = data[i+1];
				}
		} catch (Exception e) {
			data[i] = null;
		}
	}*/
	
	public void remove(int position) {
		int size = data.length;
		int numMoved = size - position - 1;
		System.arraycopy(data, position+1, data, position, numMoved);
		data[--size] = null;
	}
	
	public void trimToSize() {
		if(index<data.length) {
			data = Arrays.copyOf(data, index);
		}
	}
	
	public int size() {
		return index;
	}
	
	public boolean isEmpty() {
		return index==0;
	}
	
	public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }
	
	public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < index; i++)
                if (data[i]==null)
                    return i;
        } else {
            for (int i = 0; i < index; i++)
                if (o.equals(data[i]))
                    return i;
        }
        return -1;
    }

	public void clear() {
        for (int i = 0; i < index; i++) {
        	data[i] = null;
        }
        index = 0;
    }
	
	 public Object[] toArray() {
	        return Arrays.copyOf(data, index);
	    }
	 
	private void increaseSize() {
		data = Arrays.copyOf(data, data.length+incrementSize);
	}

	@Override
	public Iterator<V> iterator() {
		return new myItr();
	}
	
	private class myItr implements Iterator<V> {

		int counter = 0;
		
		@Override
		public boolean hasNext() {
			return data[counter]!=null;
		}

		@Override
		public V next() {
			return (V)data[counter++];
		}
		
	}
	
}//End of Class
