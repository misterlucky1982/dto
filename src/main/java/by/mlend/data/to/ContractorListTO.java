package by.mlend.data.to;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ContractorListTO implements ListTO<ContractorTO>, Iterable<ContractorTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ContractorTO> listTO = new ArrayList<>();

	@Override
	public boolean add(ContractorTO t) {
		return t != null ? this.listTO.add(t) : false;
	}

	@Override
	public ContractorTO get(int index) {
		return this.listTO.get(index);
	}

	@Override
	public int size() {
		return this.listTO.size();
	}

	@Override
	public List<ContractorTO> toList() {
		return this.listTO;
	}

	@Override
	public Iterator<ContractorTO> iterator() {
		return this.listTO.iterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listTO == null) ? 0 : listTO.hashCode());
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
		ContractorListTO other = (ContractorListTO) obj;
		if (listTO == null) {
			if (other.listTO != null)
				return false;
		} else if (Arrays.deepEquals(listTO.toArray(), other.listTO.toArray()))
			return true;
		return false;
	}

}
