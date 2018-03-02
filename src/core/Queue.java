package core;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements java.util.Queue<T>{
	// TODO implements functions
	
	private Q<T> first;
	private Q<T> last;
	
	private class Q<T> {
		private T head;
		private Q<T> tail;
		
		private Q(T t) {
			head = t;
		}
		
		public Q<T> add(T t) {
			tail = new Q<T>(t);
			return tail;
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		for (T t : arg0) {
			last.add(t);
		}
		return true;
	}

	@Override
	public void clear() {
		first = null;
		last = null;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return first == null || last == null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T t) {
		if (first == null || last == null) { 
			first = new Q<T>(t);
			last = first;
			return true;
		}
		last = last.add(t);
		return true;
	}

	@Override
	public T element() {
		if (isEmpty()) throw new NoSuchElementException();
		return peek();
	}

	@Override
	public boolean offer(T e) {
		return add(e);
	}

	@Override
	public T peek() {
		if (first == null) return null;
		return first.head;
	}

	@Override
	public T poll() {
		T res = peek();
		if (first == last) last = null;
		first = first.tail;
		return res;
	}

	@Override
	public T remove() {
		if (first == null || last == null) throw new NoSuchElementException();
		return poll();
	}
	
	
}
