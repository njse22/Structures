package Heap;

public class MinHeap<T extends Comparable<T>> {
    private T[] Heap;
    private int size;
    private int maxsize;
 
 
    @SuppressWarnings("unchecked")
	public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = (T[]) new Comparable[maxsize];
    }
    
    public MinHeap(T[] array, int maxsize) {
    	this.maxsize = maxsize;
        this.size = array.length;
        Heap = (T[]) new Comparable[maxsize];
        for(int i=0;i<array.length;i++)
        	Heap[i+1] = array[i];
        buildMinHeap();
    }
 
    private int parent(int pos) {
        return pos / 2;
    }
 
    private int leftChild(int pos) {
        return (2 * pos);
    }
 
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }
 
    private void swap(int fpos,int spos) {
        T tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    @SuppressWarnings("unchecked")
	private void minHeapify(int pos) {
    	int smallest;
    	int l = leftChild(pos);
    	int r = rightChild(pos);
    	if(l <= size && Heap[l].compareTo(Heap[pos]) < 0)
    		smallest = l;
    	else
    		smallest = pos;
    	if(r <= size && Heap[r].compareTo(Heap[smallest]) < 0)
    		smallest = r;
    	if (smallest != pos) {
    		swap(pos, smallest);
    		minHeapify(smallest);
    	}
    }
    
    public int getSize() {
    	return this.size;
    }
 
    @SuppressWarnings("unchecked")
	public void insert(T element) {
        Heap[++size] = element;
        int current = size;
        while(current > 1 && Heap[current].compareTo(Heap[parent(current)]) < 0) {
            swap(current,parent(current));
            current = parent(current);
        }	
    }
    
    public void print() {
    	System.out.print("[");
        for (int i = 1; i <= size; i++ ) {
        	if(i==size)
        		System.out.print(Heap[i]);
        	else
        		System.out.print(Heap[i]+", ");
        }
        System.out.println("]");
    }
 
    public void buildMinHeap() {
    	for(int i=size/2;i>=1;i--)
    		minHeapify(i);
    }
    
    public T get(int pos) {
    	return Heap[pos];
    }
    
    public void set(int pos, T element) {
    	Heap[pos] = element;
    }
    
    public T remove(int pos) {
    	T extracted = Heap[pos];
        Heap[pos] = Heap[size--]; 
        minHeapify(pos);
        return extracted;
    }
    
    public void heapsort() {
    	int tmp = size;
    	for(int i=size;i>=2;i--) {
    		swap(1,i);
    		size--;
    		minHeapify(1);
    	}
    	size = tmp;
    }
    
 
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        @SuppressWarnings("rawtypes")
		MinHeap<Integer> minHeap = new MinHeap<>(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();
        minHeap.heapsort();
        minHeap.print();
        MinHeap<Integer> minHeap1 = new MinHeap<>(new Integer[] {12, 8, 9, 17, 4, 55},15);
        minHeap1.print();
    }
}
