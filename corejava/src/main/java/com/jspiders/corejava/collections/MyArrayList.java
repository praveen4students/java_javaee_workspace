package com.jspiders.corejava.collections;

import java.util.Arrays;

public class MyArrayList<V> {

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
	
	public void remove(int position) {
		int i = 0;
		try {
				for(i=position; i<index; i++) {
					data[i] = data[i+1];
				}
		} catch (Exception e) {
			data[i] = null;
		}
	}
	
	private void increaseSize() {
		data = Arrays.copyOf(data, data.length+incrementSize);
	}
	
}//End of Class
