package org.hi.framework.dao.impl;

import org.hi.framework.dao.Sorter;

public class SorterFactory {
	
	public static Sorter getSimpleSort(String name){
		Sorter sort = new SimpleSorter();
		sort.addSort(name);
		return sort;
	}
	
	public static Sorter getSimpleSort(String name,String direction){
		Sorter sort = new SimpleSorter();
		sort.addSort(name, direction);
		return sort;
	}
	
}
