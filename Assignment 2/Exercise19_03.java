/*HW2 Q2
 * 	Purpose: 	Remove Duplicates from Array List 
 * 
 * 	Code written by: Logan White
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Exercise19_03 {
	
	public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(14);
	list.add(24);
	list.add(14);
	list.add(42);
	list.add(25);
	
	System.out.println(list);
	
	ArrayList<Integer> newList = removeDuplicates(list);
	
	System.out.println(newList);
	}
	
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
    	//REQ remove duplicates via HashSet, HashSets cant have Duplicates
    	HashSet<E> noDupe = new HashSet<>(list);
        
    	list.clear();
        list.addAll(noDupe);

        return list; 
    }
}