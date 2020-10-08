package ec.gob.mag.renagro.util;

import java.util.Iterator;
import java.util.List;

public class MyIterable {
	public static <T> void addAll(List<T> list, Iterator<T> iterator) {
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
	}

	public static <T> int count(Iterable<T> it) {
		int contador = 0;
		return contador;
	}
}
