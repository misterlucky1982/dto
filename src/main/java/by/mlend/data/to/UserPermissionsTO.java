package by.mlend.data.to;

public class UserPermissionsTO implements TransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isAccessAllowed;
	private boolean isRemainderCreateUpdateWithdrawAllowed;
	private boolean isRemainderHistoryDeleteAllowed;
	private boolean isThirdPartyBookingAllowed;
	private boolean isRelocationAllowed;
	private boolean isReportPermited;
	private boolean isUserCreateUpdateDeleteAllowed;
	private boolean isContractorCreateUpdateDeleteAllowed;
	private boolean isStorageLocationCreateUpdateDeleteAllowed;

	public boolean isAccessAllowed() {
		return isAccessAllowed;
	}

	public void setAccessAllowed(boolean isAccessAllowed) {
		this.isAccessAllowed = isAccessAllowed;
	}

	public boolean isRemainderCreateUpdateWithdrawAllowed() {
		return isRemainderCreateUpdateWithdrawAllowed;
	}

	public void setRemainderCreateUpdateWithdrawAllowed(boolean isRemainderCreateUpdateWithdrawAllowed) {
		this.isRemainderCreateUpdateWithdrawAllowed = isRemainderCreateUpdateWithdrawAllowed;
	}

	public boolean isRemainderHistoryDeleteAllowed() {
		return isRemainderHistoryDeleteAllowed;
	}

	public void setRemainderHistoryDeleteAllowed(boolean isRemainderHistoryDeleteAllowed) {
		this.isRemainderHistoryDeleteAllowed = isRemainderHistoryDeleteAllowed;
	}

	public boolean isThirdPartyBookingAllowed() {
		return isThirdPartyBookingAllowed;
	}

	public void setThirdPartyBookingAllowed(boolean isThirdPartyBookingAllowed) {
		this.isThirdPartyBookingAllowed = isThirdPartyBookingAllowed;
	}

	public boolean isRelocationAllowed() {
		return isRelocationAllowed;
	}

	public void setRelocationAllowed(boolean isRelocationAllowed) {
		this.isRelocationAllowed = isRelocationAllowed;
	}

	public boolean isReportPermited() {
		return isReportPermited;
	}

	public void setReportPermited(boolean isReportPermited) {
		this.isReportPermited = isReportPermited;
	}

	public boolean isUserCreateUpdateDeleteAllowed() {
		return isUserCreateUpdateDeleteAllowed;
	}

	public void setUserCreateUpdateDeleteAllowed(boolean isUserCreateUpdateAllowed) {
		this.isUserCreateUpdateDeleteAllowed = isUserCreateUpdateAllowed;
	}

	public boolean isContractorCreateUpdateDeleteAllowed() {
		return isContractorCreateUpdateDeleteAllowed;
	}

	public void setContractorCreateUpdateDeleteAllowed(boolean isContractorCreateUpdateDeleteAllowed) {
		this.isContractorCreateUpdateDeleteAllowed = isContractorCreateUpdateDeleteAllowed;
	}

	public boolean isStorageLocationCreateUpdateDeleteAllowed() {
		return isStorageLocationCreateUpdateDeleteAllowed;
	}

	public void setStorageLocationCreateUpdateDeleteAllowed(boolean isStorageLocationCreateUpdateDeleteAllowed) {
		this.isStorageLocationCreateUpdateDeleteAllowed = isStorageLocationCreateUpdateDeleteAllowed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAccessAllowed ? 1231 : 1237);
		result = prime * result + (isContractorCreateUpdateDeleteAllowed ? 1231 : 1237);
		result = prime * result + (isRelocationAllowed ? 1231 : 1237);
		result = prime * result + (isRemainderCreateUpdateWithdrawAllowed ? 1231 : 1237);
		result = prime * result + (isRemainderHistoryDeleteAllowed ? 1231 : 1237);
		result = prime * result + (isReportPermited ? 1231 : 1237);
		result = prime * result + (isStorageLocationCreateUpdateDeleteAllowed ? 1231 : 1237);
		result = prime * result + (isThirdPartyBookingAllowed ? 1231 : 1237);
		result = prime * result + (isUserCreateUpdateDeleteAllowed ? 1231 : 1237);
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
		UserPermissionsTO other = (UserPermissionsTO) obj;
		if (isAccessAllowed != other.isAccessAllowed)
			return false;
		if (isContractorCreateUpdateDeleteAllowed != other.isContractorCreateUpdateDeleteAllowed)
			return false;
		if (isRelocationAllowed != other.isRelocationAllowed)
			return false;
		if (isRemainderCreateUpdateWithdrawAllowed != other.isRemainderCreateUpdateWithdrawAllowed)
			return false;
		if (isRemainderHistoryDeleteAllowed != other.isRemainderHistoryDeleteAllowed)
			return false;
		if (isReportPermited != other.isReportPermited)
			return false;
		if (isStorageLocationCreateUpdateDeleteAllowed != other.isStorageLocationCreateUpdateDeleteAllowed)
			return false;
		if (isThirdPartyBookingAllowed != other.isThirdPartyBookingAllowed)
			return false;
		if (isUserCreateUpdateDeleteAllowed != other.isUserCreateUpdateDeleteAllowed)
			return false;
		return true;
	}
	
	

}
