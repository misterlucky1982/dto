package by.mlend.data.to;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StorageLocationListTO implements Iterable<StorageLocationTO>, ListTO<StorageLocationTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<StorageLocationTO> listStTO = new ArrayList<>();

	@Override
	public Iterator<StorageLocationTO> iterator() {
		return this.listStTO.iterator();
	}

	@Override
	public boolean add(StorageLocationTO t) {
		return t != null ? this.listStTO.add(t) : false;
	}

	@Override
	public StorageLocationTO get(int index) {
		return this.listStTO.get(index);
	}

	@Override
	public int size() {
		return this.listStTO.size();
	}

	@Override
	public List<StorageLocationTO> toList() {
		return this.listStTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listStTO == null) ? 0 : listStTO.hashCode());
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
		StorageLocationListTO other = (StorageLocationListTO) obj;
		if (listStTO == null) {
			if (other.listStTO != null)
				return false;
		} else if (!Arrays.deepEquals(listStTO.toArray(), other.listStTO.toArray()))
			return false;
		return true;
	}
	
	

}
