/*Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer. */

class Solution {
    public String frequencySort(String s) {
        char str[]=s.toCharArray();
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		for(int i=0;i<s.length();i++) {
			if(hm.containsKey(String.valueOf(str[i])))
			{
				hm.put(String.valueOf(str[i]), hm.get(String.valueOf(str[i]))+1);
			}
			else
			{
				hm.put(String.valueOf(str[i]), 1);
			}
		}
		
		hm=sortHashMapByValues(hm);
		String ans="";
		for(String p:hm.keySet())
		{
			int val=hm.get(p);
			for(int k=0;k<val;k++)
			{
				ans=ans+p;
			}
		}
		return ans;
    }
    private static LinkedHashMap<String, Integer> sortHashMapByValues(HashMap<String, Integer> h1) {
		// TODO Auto-generated method stub
		List<String> mapKeys = new ArrayList<>(h1.keySet());
	    List<Integer> mapValues = new ArrayList<>(h1.values());
	    Collections.sort(mapValues,Collections.reverseOrder()); 
	    //Collections.sort(mapKeys,Collections.reverseOrder());
	    
	    LinkedHashMap<String, Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Integer val = valueIt.next();
	        Iterator<String> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            String key = keyIt.next();
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