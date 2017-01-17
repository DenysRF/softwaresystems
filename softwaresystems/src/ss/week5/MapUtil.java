package ss.week5;

import java.util.*;

public class MapUtil {
	//@requires map != null;
	//@ensures \result == (map.keySet().size() == map.values().size());
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	List<K> PreviousValues = new ArrayList <K>();
    	for (K i : map.keySet()){
    		for(K j: PreviousValues){
    			if(map.get(i).equals(map.get(j))){
    				return false;
    			}
    		}
    		PreviousValues.add(i);
    	}
        return true;
    }
    //@requires map!= null && range != null;
    //@ensures \result == (map.keySet().size() > map.values().size());
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	for (V v : range) {
    		boolean found = false;
    		for (K k : map.keySet()){
 				if (map.get(k).equals(v)){
 					found = true; 
 				}
 			} if (!found){
 				return false;
    		}
    	}
 		return true;
    }
        
    //@requires map != null;
    //@ensures inverse(\result) == map;
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> inverse = new HashMap<V, Set<K>>();
        for (K k : map.keySet()){
        	Set<K> temp = new HashSet<K>();
        	V v = map.get(k);
        	for (K kk : map.keySet()){
        		if (map.get(k).equals(map.get(kk))){
        			temp.add(kk);
        		}
        	}
        	inverse.put(v, temp);
        }
        return inverse;
    }
    //@requires map != null;
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> inverse = new HashMap<V, K>();
        for (K k : map.keySet()){
        	inverse.put(map.get(k), k);
        }
        return inverse;
	}
	//@requires f!= null && g!=null;
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		for(V v: f.values()){
			boolean comp = false;
			for (V k : g.keySet()){
				if (v.equals(k)){
					comp = true;
				}
			}	
			if (!comp){
				return false;
			}
		}
		return true;
	}
	// requires f != null && g!= null;
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		Map <K, W> composed = new HashMap <K, W>();
		if (compatible(f, g)){
			for (K k : f.keySet()){
				W w = (g.get(f.get(k)));
				composed.put(k, w);
			}
		} else {
			return null;
		}
		return composed;
	}
}
