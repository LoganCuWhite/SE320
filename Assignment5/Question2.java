/*	Assignment: HW5 Q2
 * 	Purpose: 	A precondition or requires clause for the method removeDuplicates, so all duplicatesfrom List lst are removed. 

 * 
 * 	Code written by: Logan White
 *  
 * 
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Question2 {

    /**
     * Removes all duplicates from the given list.
     * @param lst list to remove duplicates from
     * @requires lst must not be null or empty
     */
    public static void removeDuplicates(List lst) {
        if (lst == null || lst.size() == 0) return;
        List copy = new ArrayList(lst);
        Iterator elements = copy.iterator();
        Object pre = elements.next();
        while(elements.hasNext()) {
            Object nex = elements.next();
            if (pre.equals(nex)) lst.remove(nex);
            else pre = nex;
        }
    }

}