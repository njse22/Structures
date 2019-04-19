package treeAVL;

public interface ITreeAVL <K extends Comparable<K>, T>{
	public void add(K key, T value) throws ElementNoFoundException;
	public NodeAVL<K, T> search(K key) throws ElementNoFoundException;
	public boolean remove(K key);
	public void leftRotate(NodeAVL<K, T> nodeReference);
	public void rigthRotate(NodeAVL<K, T> nodeReference);
	public void balanceTree( NodeAVL<K, T> fatherNode);

}
