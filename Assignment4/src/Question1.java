/*	Assignment: HW4 Q1
 * 	Purpose: 	Creates Two LinkedHashSets and finds their union difference and intersections
 * 
 * 	Code written by: Logan White
 * 
 * 
 */

import java.util.LinkedHashSet;

public class Question1 {
    public static void main(String[] args) {
        //given sets
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");
		
        
        System.out.println("Given Hash Sets: ");
        System.out.println("set1: " + set1);
		System.out.println("set2: " + set2);

        try {
			LinkedHashSet<String> UnionItems = Union(set1,set2);
			LinkedHashSet<String> DifferenceItems = Difference(set1,set2);
			LinkedHashSet<String> IntersectionItems = Intersection(set1,set2);
			
			System.out.println(" \nQuestion 1 Answer: ");
			System.out.println("Union of Sets: " + UnionItems);
			System.out.println("Difference between Sets:" + DifferenceItems);
			System.out.println("Intersection of the Sets: " + IntersectionItems);
		} 
        catch (Exception e) {
			e.printStackTrace();
		}    
    }
    
    public static LinkedHashSet<String> Union(LinkedHashSet<String> set1,LinkedHashSet<String> set2) {
    	//Finding the union of the two sets
    	LinkedHashSet<String> SetCopy = new LinkedHashSet<>(set1);
    	SetCopy.addAll(set2);
        
        return SetCopy;
    }
    
    public static LinkedHashSet<String> Difference(LinkedHashSet<String> set1,LinkedHashSet<String> set2) {
        //Finding the difference between the two sets
    	LinkedHashSet<String> SetCopy = new LinkedHashSet<>(set1);
        SetCopy.removeAll(set2);

        return SetCopy;
    }
    
    public static LinkedHashSet<String> Intersection(LinkedHashSet<String> set1,LinkedHashSet<String> set2) {
    	//Finding the Intersection between the sets
    	LinkedHashSet<String> SetCopy = new LinkedHashSet<>(set1);
        SetCopy.retainAll(set2);

        return SetCopy;
    }

}
