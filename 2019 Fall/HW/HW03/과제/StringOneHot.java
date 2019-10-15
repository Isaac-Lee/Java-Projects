package °úÁ¦;
import java.util.*;

public class StringOneHot {
	String string = new String();
	Set<String> strSet =  new TreeSet<String>();
	Map<String, Integer> strMap = new TreeMap<String, Integer>();
	Map<String, ArrayList<Integer>> strOneHotVector = new HashMap<String, ArrayList<Integer>>();
	
	public StringOneHot(String str) {
		this.string = str;
		for (int i = 0; i < string.length(); i++) {
			this.strSet.add(string.substring(i, i+1));
		}
		int i=0;
		for (String chr : strSet) {
			strMap.put(chr, i);
			i++;
		}
		for (String chr : strSet) {
			ArrayList<Integer> list = new ArrayList<Integer>(4
					);
			for (int j =0; j < strSet.size(); j ++) {
				if (j == strMap.get(chr)) {
					list.add(1);
				}
				else
					list.add(0);
			}
			strOneHotVector.put(chr, list);
		}
	}
	
	public String getString() {
		return this.string;
	}
	
	public TreeSet<String> getStrSet() {
		return (TreeSet<String>) this.strSet;
	}
	
	public TreeMap<String, Integer> getStrMap() {
		return (TreeMap<String, Integer>) this.strMap;
	}
	
	public HashMap<String, ArrayList<Integer>> getStrOneHotVec() {
		return (HashMap<String, ArrayList<Integer>>) this.strOneHotVector;
	}

}
