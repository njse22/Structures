package Hash;

//import java.util.Scanner;

public class Interfaz {
	
	public static void main(String[] args) throws HashIsEmptyException, NonexistentKeyException {
	
		Hash<Integer, String> h = new Hash<Integer, String>(); 
	
		System.out.println("¿Esta vacia? : " + h.isEmpty());
		System.out.println("¿Cual es su tamaño? : "+h.getSize());
	
		
		
		h.put(1, "primero" );
		h.put(2, "segundo" );
		h.put(3, "tercero" );
		h.put(4, "cuarto"  );

		System.out.println("¿Esta vacia? : " + h.isEmpty());
		System.out.println("¿Cual es su tamaño? : "+h.getSize());
		
		System.out.println("se eliminara al numero dos");
		h.remove(2);
		
		System.out.println("¿Cual es su tamaño? : "+h.getSize());
		
		System.out.println("¿quien esta en dos? : " + h.get(2));  
		System.out.println("¿quien esta en uno? : " + h.get(1));
		
		
		
/*      proble de hackerearth de los numeros pares funciona con esta estructura  */		

//		Scanner s = new Scanner(System.in); 
//	
//		int N = s.nextInt(); 
//		
//		for (int i = 0; i < N; i++) {
//			int K = s.nextInt();
//			String V = s.nextLine();
//			h.put(K, V);
//			
//		}
//		
//		int Q = s.nextInt(); 
//
//		for (int i = 0; i < Q; i++) {
//			int x = s.nextInt();			
//			System.out.println(h.get(x).replaceAll(" ", ""));
//			
//		
//			
//		}
//
//		s.close();
		
	}

		
		
		
		
		
		
		
		
		
		
		
	
}
		
		
		
		
		
	
		
		
		
		

