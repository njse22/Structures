package BlackRedTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackRedTree<T,K extends Comparable<K>> implements IBlackRedTree<T, K> {

	private NodeBlackRed<T,K> root;
	private int size; 
	
	@Override
	public void add(NodeBlackRed<T, K> newElement) {
		if(root == null) {
			
			root = newElement; 
			root.setColor(NodeBlackRed.BLACK);
			size++; 
		}
		else {
			
			if(root.add(newElement)) {
				size++; 
			}
		}
		
		if(newElement.getFather() != null && newElement.getGrandFather() != null) {
			balancedTree(newElement);
		}
	}

	@Override
	public NodeBlackRed<T, K> getRoot() {
		return root;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public NodeBlackRed<T, K> maximum(NodeBlackRed<T, K> reference) {
		if(root == null) 
			return null;
		else 
			return root.maximum(); 
	}

	@Override
	public NodeBlackRed<T, K> minimum(NodeBlackRed<T, K> reference) {
		if(root == null)
			return null; 
		else 
			return root.minimun(); 
	}

	@Override
	public void remove(NodeBlackRed<T, K> reference) {
		root.remove(reference);
		balancedTree(reference); 
	}

	@Override
	public NodeBlackRed<T, K> search(K key) throws NodeNotFoundException {
		if(root == null) 
			throw new NodeNotFoundException("this node not found"); 
		else 
			return root.buscar(key); 
	}

	@Override
	public NodeBlackRed<T, K> getSuccerssor(NodeBlackRed<T, K> actual) {
		return root.getLeft().maximum();
	}

	@Override
	public void leftRotate(NodeBlackRed<T, K> reference) {
		if(reference.getFather() != null) {
			NodeBlackRed<T,K> x = reference.getFather(); 
			if(reference.getLeft() != null) {
				NodeBlackRed<T,K> b = reference.getLeft(); 
				x.setRight(b);
			}
			
			reference.setFather(x.getFather());
			
			if(x.getFather() == null) {
				root = reference; 
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
	public void rigthRotate(NodeBlackRed<T, K> reference) {
		if(reference.getFather() != null) {
			NodeBlackRed<T,K> y = reference.getRight();
			
			if(reference.getRight() != null) {
				NodeBlackRed<T,K> b = reference.getRight(); 
				y.setLeft(b);
			}
			reference.setFather(y.getFather());
			
			if(y.getFather() == null) {
				root = reference; 
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
	public boolean exist(K key) {
		boolean exist = false ; 
		try{
			if(search(key) != null) {
				exist = true; 
			}
			
		}catch (NodeNotFoundException e) {
			e.printStackTrace();
		}
		
		return exist;
	}

private void balancedTree(NodeBlackRed<T,K> newElement) {
		
		while( newElement.getFather().getColor() == NodeBlackRed.RED ) {
			if( newElement.getFather().isLeftSon() ) {
				
				if(newElement.getGrandFather().getRight() != null && 
						newElement.getGrandFather().getRight().getColor() == NodeBlackRed.RED) {
					
					newElement.getFather().setColor(NodeBlackRed.BLACK);
					newElement.getGrandFather().getRight().setColor(NodeBlackRed.BLACK);
					newElement.getGrandFather().setColor(NodeBlackRed.RED);
					newElement = newElement.getGrandFather();
					
					if(root.getColor() == NodeBlackRed.RED)
						root.rePaint();
					if(newElement.getFather() == null)
						break; 
				}
				else {
					if(newElement.isRigthSon()) {
						newElement = newElement.getFather(); 
						leftRotate(newElement);
					}
					newElement.getFather().setColor(NodeBlackRed.BLACK); 
					newElement.getGrandFather().setColor(NodeBlackRed.RED);
					rigthRotate(newElement.getFather());
				}
			
			}else {
				if( newElement.getFather().isRigthSon() ) {
					NodeBlackRed<T,K> y = newElement.getGrandFather().getLeft();
					if(newElement.getGrandFather().getLeft() != null && 
							newElement.getGrandFather().getLeft().getColor() == NodeBlackRed.RED) {
						
						newElement.getFather().setColor(NodeBlackRed.BLACK);
						newElement.getGrandFather().getLeft().setColor(NodeBlackRed.BLACK);
						newElement.getGrandFather().setColor(NodeBlackRed.RED);
						newElement = newElement.getGrandFather(); 
						
						if(root.getColor() == NodeBlackRed.RED)
							root.rePaint();
						
						if(newElement.getFather() == null)
							break; 
					}
					else {
						if(newElement.isLeftSon()) {
							newElement = newElement.getFather(); 
							rigthRotate(newElement);
						}
						newElement.getFather().setColor(NodeBlackRed.BLACK); 
						newElement.getGrandFather().setColor(NodeBlackRed.RED);
						leftRotate(newElement.getFather());
					}

				}		
			}
		}
	}	
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

public void printNode(NodeBlackRed<T,K> node) {
	int maxLavel = maxLevel(node);
	
	printNodeInternal(Collections.singletonList(node), 1, maxLavel);
}

private void printNodeInternal(List<NodeBlackRed<T,K>> singletonList, int level, int maxLavel) {
	if( singletonList.isEmpty() || isAllElementsNull(singletonList))
		return ; 
	
	int floor = maxLavel - level;
	int endgeLines = (int)Math.pow(2, (Math.max(floor - 1, 0) ) );
	int firstSpaces = (int) Math.pow(2, (floor)) - 1;
	int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

	printWhitespaces(firstSpaces); 
	
	List<NodeBlackRed<T,K>> newNodes = new ArrayList<NodeBlackRed<T,K>>(); 
	  for (NodeBlackRed<T,K> node : singletonList) {
            if (node != null) {
                System.out.print(node.getValue() + " ");
                newNodes.add(node.getLeft());
                newNodes.add( node.getRight());
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

private boolean isAllElementsNull(List<NodeBlackRed<T,K>> singletonList) {

	for (NodeBlackRed<T,K> nodeAVL : singletonList) {
		if(nodeAVL != null)
			return false; 
	}
	
	return true;
}

private int maxLevel(NodeBlackRed<T,K> node) {
	if(node == null ) {
		return 0; 
	}
	else 
		return Math.max(maxLevel( node.getLeft()), maxLevel( node.getRight()));
}


	
}
