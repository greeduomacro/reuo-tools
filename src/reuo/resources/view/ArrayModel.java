package reuo.resources.view;

import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class ArrayModel<T> implements ListModel<T> {
	protected List<ListDataListener> listeners = new ArrayList<ListDataListener>();
	protected T[] array;

	public ArrayModel(T[] array) {
		this.array = array;
	}

	public void addListDataListener(ListDataListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public T getElementAt(int id) {
		return array[id];
	}

	public int getSize() {
		return array.length;
	}

	public void removeListDataListener(ListDataListener listener) {
		listeners.remove(listener);
	}

	public void setArray(Object[] array) {
		ListDataEvent event = new ListDataEvent(this,
				ListDataEvent.CONTENTS_CHANGED, 0, array.length);

		for (ListDataListener listener : listeners) {
			listener.contentsChanged(event);
		}
	}

}
