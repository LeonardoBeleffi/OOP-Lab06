package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
    private static final int TO_MS = 1_000_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	for (int i = 1000; i < 2000; i++) {
    		al.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	LinkedList<Integer> ll = new LinkedList<Integer>();
    	ll.addAll(al);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int startIndex = 0;
    	int lastIndex = al.size() - 1;
    	int last = al.get(lastIndex);
    	al.add(lastIndex, al.get(startIndex));
    	al.add(startIndex, last);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (int i : al) {
    		System.out.println(i);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long t = System.nanoTime();
    	for (int i = 0; i < 100_000; i++) {
    		al.add(0, i);
    	}
    	System.out.println("AddToHeadArrayListTime = " + (System.nanoTime() - t) / TO_MS + "ms");
    	t = System.nanoTime();
    	for (int i = 0; i < 100_000; i++) {
    		ll.add(0, i);
    	}
    	System.out.println("AddToHeadLinkedListTime = " + (System.nanoTime() - t) / TO_MS + "ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	t = System.nanoTime();
    	for (int i = 0; i < 100_000; i++) {
    		al.get(al.size() / 2);
    	}
    	System.out.println("ReadFromMiddleArrayListTime = " + (System.nanoTime() - t) / TO_MS + "ms");
    	t = System.nanoTime();
    	for (int i = 0; i < 100_000; i++) {
    		ll.get(ll.size() / 2);
    	}
    	System.out.println("ReadFromMiddleLinkedListTime = " + (System.nanoTime() - t) / TO_MS + "ms");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	Map<String, Long> m = new HashMap<String, Long>();
    	m.put("Africa", 1_110_635_000L);
    	m.put("Americas", 972_005_000L);
    	m.put("Antarctica", 0L);
    	m.put("Asia", 4_298_723_000L);
    	m.put("Europe", 742_452_000L);
    	m.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
    	long tot = 0;
    	for (java.util.Map.Entry<String, Long> e : m.entrySet()) {
    		tot += e.getValue();
    	}
    	System.out.println("TotalPopulationOfTheWorld = " + tot);
    }
}
