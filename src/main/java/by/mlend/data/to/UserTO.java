package by.mlend.data.to;

public class UserTO implements TransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long wareHouseId;
	private long asotiatedContractor;
	private String name;
	private UserPermissionsTO permissions;

	public long getWareHouseId() {
		return wareHouseId;
	}

	public void setWareHouseId(long wareHouseId) {
		this.wareHouseId = wareHouseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserPermissionsTO getPermissions() {
		return permissions;
	}

	public void setPermissions(UserPermissionsTO permissions) {
		this.permissions = permissions;
	}

	public long getAsotiatedContractor() {
		return asotiatedContractor;
	}

	public void setAsotiatedContractor(long asotiatedContractor) {
		this.asotiatedContractor = asotiatedContractor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (asotiatedContractor ^ (asotiatedContractor >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + (int) (wareHouseId ^ (wareHouseId >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTO other = (UserTO) obj;
		if (asotiatedContractor != other.asotiatedContractor)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		if (wareHouseId != other.wareHouseId)
			return false;
		return true;
	}
	
	
}
