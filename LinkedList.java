// On my honor:
//
// - I have not used code obtained from another student,
// or any other unauthorized source, either modified or unmodified.
//
// - All code and documentation used in my program is either my original
// work, or was derived, by me, from the source code provided by the assignment.
//
// - I have not discussed coding details about this project with anyone
// other than my instructor, teaching assistants assigned to this
// course, except via the message board for the course. I understand that I
// may discuss the concepts of this program with other students, and that
// another student may help me debug my program so long as neither of us
// writes anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor letter of this restriction.
//

public class LinkedList implements List{
	
	Node head;
	int size;
	
	//Node class 
	class Node{
		Object element;
		Node next;
		
		public Node(Object element){
			this.element = element; 
		}
	}
	
	public LinkedList(){ 
		head = new Node(null);
		size = 0;
	}
	
	/***********ADD METHODS ************/
	public void add(Object item){ 
		Node newNode = new Node(item);
		
			if (isEmpty() == true){
				head.next = newNode;
			}
			
			else{
			Node current = head;

				while(current.next != null){ 
					current = current.next;
				}
			
			current.next = newNode; 
			}
			
			size++;
	}
	
	public void add(int index, Object item){ 
		if(!(index > size)){
			Node newNode = new Node(item);
			if(isEmpty() == true)
				head = newNode;
			
			else{
				Node current = head;
				for (int i = 1; i < index; i++){
					current = current.next;
				}
				newNode.next = current.next;
				current.next = newNode;
			}
			size++;
		}
		else{	
		}
	}
	
	/***********REMOVE METHODS ************/
	public void remove(int index){
		if(!(index > size)){
			Node previous = head;
			for (int i = 1; i < index; i++){
				previous = previous.next;
			}
			
			Node current = previous.next;
			previous.next = current.next;
			size--;
		}
		else{
		}
		
	}
	
	public void remove(Object item){
		Node previous = head;
		while(null != previous.next && !item.equals(previous.next.element)){
			previous = previous.next;
		}
		
		Node current = previous.next;
		previous.next = current.next;
		size--;
	}
	

	public boolean isEmpty(){ //returns true if LinkedList is empty 
		if (null == head.next)
			return true;
		else{
			return false;
		}
	}
	
	
	public String toString() {  //[ size: the_size_of_the_list item1, item2, .... ]
		String result = "";
	    Node current = head;
	    result = result + "[size: " + size()  +" ";
	    while(current.next != null){
	    	result += current.next.element;
			current = current.next;
			if(null != current.next)
				result+= ", ";
		}
	    result = result + "]";
	    return result;
	}

	
	
	public List duplicate(){ //creates a duplicate list 
		LinkedList duplicateList = new LinkedList();
		Node duplicateNode = duplicateList.head;
		
		Node oldCurrent = head;
		while(null != oldCurrent.next) {
			duplicateNode.next = new Node(oldCurrent.next.element);
			oldCurrent = oldCurrent.next;
			duplicateNode = duplicateNode.next;
			duplicateList.size++;
		}
		return duplicateList;
	}
	
	public int size(){
		return size;
	}
	

	public List duplicateReversed(){ 
		LinkedList duplicateReversedList = new LinkedList();
		
		for(int i = size; i > 0; i --){	
			Node oldCurrent = head;		
			for(int x = 0; x < i; x ++){
				oldCurrent = oldCurrent.next;
			}
			duplicateReversedList.add(oldCurrent.element);
		}
		return duplicateReversedList;
	}


	
}

