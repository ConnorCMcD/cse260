import java.util.ArrayList;

public class GenericStack<E> extends ArrayList<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1493486127942832432L;
	public E peek() {
		return get(size()-1);
	}
	public E pop() {
		E popped = peek();
		remove(size()-1);
		return popped;
	}
	public void push(E toPush) {
		add(toPush);
		return;
	}
}
