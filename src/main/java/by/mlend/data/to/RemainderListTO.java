package by.mlend.data.to;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemainderListTO implements Iterable<RemainderTO>, ListTO<RemainderTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<RemainderTO> remainders = new ArrayList<>();

	@Override
	public Iterator<RemainderTO> iterator() {
		return this.remainders.iterator();
	}

	@Override
	public boolean add(RemainderTO t) {
		return t != null ? this.remainders.add(t) : false;
	}

	@Override
	public RemainderTO get(int index) {
		return this.remainders.get(index);
	}

	@Override
	public int size() {
		return this.remainders.size();
	}

	@Override
	public List<RemainderTO> toList() {
		return this.remainders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((remainders == null) ? 0 : remainders.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemainderListTO other = (RemainderListTO) obj;
		if (remainders == null) {
			if (other.remainders != null)
				return false;
		} else if (!Arrays.deepEquals(remainders.toArray(), other.remainders.toArray()))
			return false;
		return true;
	}
	
	

}
