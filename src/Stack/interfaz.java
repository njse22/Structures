package Stack;

public class interfaz {
	
	
	public static void main(String[] args) {
		
		Stack< Integer > s = new Stack< Integer >(); 
		
		System.out.println(s.isEmpty()+ " ¿está vacia?");
		s.push(3);
		s.push(4);
		s.push(6);
		System.out.println(s.topElement().getValue() + " despues de agregar");
		System.out.println(s.getSize() + " tamaño despues de agregar");
		s.pop();
		System.out.println(s.getSize() + " tamaño despues de eliminar");
		System.out.println(s.topElement().getValue() + " nuevo valor top");
		System.out.println(s.isEmpty()+ " ¿está vacia?");
	}

}
