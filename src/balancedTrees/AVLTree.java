package balancedTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AVLTree<T extends Comparable<T>> implements BalancedTree<T> {

	private NodeAVL<T> root; 
	private int size; 
	
	public AVLTree() {
		root = null; 
		size = 0; 
	}

	@Override
	public void add(NodeABB<T> newElement) {
		if(root == null) {
			root = (NodeAVL<T>)newElement;
			root.setBalancedFactor(root.calculateBalanceFactor());
			size++; 
		}
		else {
			if(root.add(newElement)) {
				size++; 
			}
			if(newElement.getFather().getFather() != null)
				balancedTree((NodeAVL<T>)newElement, (NodeAVL<T>)newElement.getFather());	
		}
		
	}

	@Override
	public NodeABB<T> getRoot() {
		return root;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public NodeABB<T> maximum(NodeABB<T> reference) {
		if(root == null) 
			return null;
		else 
			return root.maximum(); 
		
	}

	@Override
	public NodeABB<T> minimum(NodeABB<T> reference) {
		if(root == null)
			return null; 
		else 
			return root.minimun(); 
	}

	@Override
	public void remove(NodeABB<T> reference) {
		root.remove(reference); 
		
	}

	@Override
	public NodeABB<T> search(T value) throws NodeNotFoundException {
		if(root == null) 
			throw new NodeNotFoundException("this node not found"); 
		else 
			return root.buscar(value); 
	
	
	}

	@Override
	public NodeABB<T> getSuccerssor(NodeABB<T> reference) {
		return root.getLeft().maximum(); 
		
	}

	@Override
	public void leftRotate(NodeABB<T> reference) {
		if(reference.getFather() != null) {
			NodeABB<T> x = reference.getFather(); 
			if(reference.getLeft() != null) {
				NodeABB<T> b = reference.getLeft(); 
				x.setRight(b);
			}
			
			reference.setFather(x.getFather());
			
			if(x.getFather() == null) {
				root = (NodeAVL<T>)reference; 
			}
			else if(x.isLeftSon()) {
				x.getFather().setLeft(reference);
			}
			else {
				x.getFather().setRight(reference);
			}
			
			reference.setLeft(x);
			reference.setFather(x.getFather());
			
		}
		
	}

	@Override
	public void rigthRotate(NodeABB<T> reference) {
		if(reference.getFather() != null) {
			NodeABB<T> y = reference.getRight();
			
			if(reference.getRight() != null) {
				NodeABB<T> b = reference.getRight(); 
				y.setLeft(b);
			}
			reference.setFather(y.getFather());
			
			if(y.getFather() == null) {
				root = (NodeAVL<T>)reference; 
			}
			else if(y.isLeftSon()) {
				y.getFather().setLeft(reference);
			}
			else {
				y.getFather().setRight(reference);
			}
			
			reference.setRight(y);
			reference.setFather(y.getFather());
			
		}
		
	}

	@Override
	public boolean exist(T value) {
		boolean exist = false ; 
		try{
			if(search(value) != null) {
				exist = true; 
			}
			
		}catch (NodeNotFoundException e) {
			e.printStackTrace();
		}
		
		return exist;
	}
	
	public int calculateBalanceFactor() {
		if ( root == null )
			return 0;
		else
			return root.calculateBalanceFactor();

	}

	
	

	/**
	 * balancedTree : this method balanced the tree 
	 * @param NodeAVL newAVL    : the node has been added to tree
	 * 		  NodeAVL fatherAVL : the node that is father of newAVL 
	 * */
	public void balancedTree(NodeAVL<T> newAVL, NodeAVL<T> fatherAVL) {
		
//		if(((NodeAVL<T>) fatherAVL.getFather()).balanceFactor() == 2) {
//			if(fatherAVL.balanceFactor() == -1) {
//				rigthRotate(fatherAVL);
//			}
//			leftRotate(fatherAVL);
//		}
		
		boolean balanced = false; 
		
		do {
			 // balance_factor(P) has not yet been updated!
			 if (newAVL.isLeftSon()) { 
				 // the left subtree increases
				 if (fatherAVL.calculateBalanceFactor() == 1) { // The left column in the picture
					 // ==> the temporary balance_factor(P) == 2 ==> rebalancing is required.
					 if (newAVL.calculateBalanceFactor() == -1) { // Left Right Case
						 leftRotate(newAVL); // Reduce to Left Left Case
					 }
					 // Left Left Case
					 rigthRotate(fatherAVL);
//					 balanced = true; // Leave the loop
					 break; 
				 }
				 else if (fatherAVL.calculateBalanceFactor() == -1) {
					  fatherAVL.setBalancedFactor(fatherAVL.balanceFactor());  // N’s height increase is absorbed at P.
//					 balanced = true; // Leave the loop
					 break; 
			 }
			 fatherAVL.setBalancedFactor(fatherAVL.balanceFactor());  // Height increases at P
			 
			 } 
			 else { // N == right_child(P), the child whose height increases by 1.
				 if (fatherAVL.calculateBalanceFactor() == -1) { // The right column in the picture
					 // ==> the temporary balance_factor(P) == -2 ==> rebalancing is required.
					 if (newAVL.calculateBalanceFactor() == 1) { // Right Left Case
						 rigthRotate(newAVL); // Reduce to Right Right Case
					 }
					 // Right Right Case
					 leftRotate(fatherAVL);
//					 balanced = true; // Leave the loop
					 break; 
				 }
				 if (fatherAVL.calculateBalanceFactor() == 1) {
					 fatherAVL.setBalancedFactor(fatherAVL.balanceFactor());  // N’s height increase is absorbed at P.
//					 balanced = true; // Leave the loop
					 break; 
				 }
				 fatherAVL.setBalancedFactor(calculateBalanceFactor());  // Height increases at P
			 }
			 newAVL = fatherAVL;
//			 fatherAVL.setFather(newAVL);
			} while (fatherAVL != null && !balanced); // Possibly up to t

		
		
		
		
		
	}

	/*********************************************************************************/
	
	public void printNode(NodeAVL<T> node) {
		int maxLavel = maxLevel(node);
		
		printNodeInternal(Collections.singletonList(node), 1, maxLavel);
	}

	private void printNodeInternal(List<NodeAVL<T>> singletonList, int level, int maxLavel) {
		if( singletonList.isEmpty() || isAllElementsNull(singletonList))
			return ; 
		
		int floor = maxLavel - level;
		int endgeLines = (int)Math.pow(2, (Math.max(floor - 1, 0) ) );
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		printWhitespaces(firstSpaces); 
		
		List<NodeAVL<T>> newNodes = new ArrayList<NodeAVL<T>>(); 
		  for (NodeAVL<T> node : singletonList) {
	            if (node != null) {
	                System.out.print(node.getValue() + " ");
	                newNodes.add((NodeAVL<T>) node.getLeft());
	                newNodes.add((NodeAVL<T>) node.getRight());
	            } else {
	                newNodes.add(null);
	                newNodes.add(null);
	                System.out.print(" ");
	            }

	           printWhitespaces(betweenSpaces);
	        }
	        System.out.println("");
	        for (int i = 1; i <= endgeLines; i++) {
	            for (int j = 0; j < singletonList.size(); j++) {
	                printWhitespaces(firstSpaces - i);
	                if (singletonList.get(j) == null) {
	                    printWhitespaces(endgeLines + endgeLines + i + 1);
	                    continue;
	                }

	                if (singletonList.get(j).getLeft() != null)
	                    System.out.print("/");
	                else
	                    printWhitespaces(1);

	                printWhitespaces(i + i - 1);

	                if (singletonList.get(j).getRight() != null)
	                    System.out.print("\\");
	                else
	                    printWhitespaces(1);

	                printWhitespaces(endgeLines + endgeLines - i);
	            }

	            System.out.println("");
	        }

	        printNodeInternal(newNodes, level + 1, maxLavel);
	}



	private void printWhitespaces(int firstSpaces) {
		for (int i = 0; i < firstSpaces; i++) 
			System.out.print(" ");
	}

	private boolean isAllElementsNull(List<NodeAVL<T>> singletonList) {
	
		for (NodeAVL<T> nodeAVL : singletonList) {
			if(nodeAVL != null)
				return false; 
		}
		
		return true;
	}

	private int maxLevel(NodeAVL<T> node) {
		if(node == null ) {
			return 0; 
		}
		else 
			return Math.max(maxLevel((NodeAVL<T>) node.getLeft()), maxLevel( (NodeAVL<T>)node.getRight()));
	}
	
	
}
