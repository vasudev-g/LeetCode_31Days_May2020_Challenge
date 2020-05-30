/* We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.) */

class Solution {
    public int[][] kClosest(int[][] p, int k) {
        
HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(int i=0;i<p.length;i++)
		{
			int dis=p[i][0]*p[i][0] + p[i][1]*p[i][1];
			hm.put(i,dis);
		}
		int ans[][]=new int[k][2];
		int t=0;
		hm=sortHashMapByValues(hm,k);
		
		for(Integer p1:hm.keySet())
		{
			ans[t][0]=p[p1][0];
			ans[t][1]=p[p1][1];
			t++;
			
		}
		return ans;
	}
		
	private static LinkedHashMap<Integer, Integer> sortHashMapByValues(HashMap<Integer, Integer> h1, int k) {
		// TODO Auto-generated method stub
		List<Integer> mapKeys = new ArrayList<>(h1.keySet());
	    List<Integer> mapValues = new ArrayList<>(h1.values());
	    Collections.sort(mapValues); 
	    //Collections.sort(mapKeys,Collections.reverseOrder());
	    
	    LinkedHashMap<Integer, Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	    	if(sortedMap.size()==k)
	    		break;
	        Integer val = valueIt.next();
	        Iterator<Integer> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Integer key = keyIt.next();
	            Integer comp1 = h1.get(key);
	            Integer comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}


}