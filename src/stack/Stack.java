package stack;

public class Stack<E> extends ArrayList<E> {

	public void push(E item){
		add(item);
	}
	
	public E pop(){
		
		if(empty())
		{
			try {
				throw new StackException("Stack is empty");
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return remove(size()-1);
	}
	
	public E peek(){
		return get(size()-1);
	}
	
	public boolean empty(){
		
		return size()==0;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		
		return null;
	}

}
