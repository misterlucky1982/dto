package by.mlend.data.to;

import java.util.List;

public interface ListTO<T> extends TransferObject {
	boolean add(T t);

	List<T> toList();

	int size();

	T get(int i);
}
