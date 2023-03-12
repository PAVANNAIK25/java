package HashMaps;

public class MapUse {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> test = new Map<>();
		
		for(int i=0; i<25; i++) {
			test.insert("abc"+i, i+1);
			System.out.println("Loadfactor at abc" + i + "= " + test.loadFactor() );
		}	
		
		System.out.println("Size: " + test.size());
		System.out.println("Remove: " + test.removeKey("abc5"));
		System.out.println("Remove: " + test.removeKey("abc10"));
		System.out.println("GetValue: "+ test.getValue("abc18"));
		System.out.println("Size: " + test.size());
		
	}

}
