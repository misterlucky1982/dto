package by.mlend.data.to;

import java.sql.Date;

public class RemainderTO implements TransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private long warehouse;
	private String name;
	private long color;
	private long contractor;
	private long storage;
	private Date dateOfArival;
	private Date dateOfLeaving;
	private int height;
	private int width;
	private int thickness;
	private String remark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getColor() {
		return color;
	}

	public void setColor(long color) {
		this.color = color;
	}

	public long getContractor() {
		return contractor;
	}

	public void setContractor(long contractor) {
		this.contractor = contractor;
	}

	public Date getDateOfArival() {
		return dateOfArival;
	}

	public void setDateOfArival(Date dateOfArival) {
		this.dateOfArival = dateOfArival;
	}

	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getStorage() {
		return storage;
	}

	public void setStorage(long storage) {
		this.storage = storage;
	}

	/**
	 * @return the warehouse
	 */
	public long getWarehouse() {
		return warehouse;
	}

	/**
	 * @param warehouse the warehouse to set
	 */
	public void setWarehouse(long warehouse) {
		this.warehouse = warehouse;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (color ^ (color >>> 32));
		result = prime * result + (int) (contractor ^ (contractor >>> 32));
		result = prime * result + ((dateOfArival == null) ? 0 : dateOfArival.hashCode());
		result = prime * result + ((dateOfLeaving == null) ? 0 : dateOfLeaving.hashCode());
		result = prime * result + height;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + (int) (storage ^ (storage >>> 32));
		result = prime * result + thickness;
		result = prime * result + (int) (warehouse ^ (warehouse >>> 32));
		result = prime * result + width;
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
		RemainderTO other = (RemainderTO) obj;
		if (color != other.color)
			return false;
		if (contractor != other.contractor)
			return false;
		if (dateOfArival == null) {
			if (other.dateOfArival != null)
				return false;
		} else if (!dateOfArival.equals(other.dateOfArival))
			return false;
		if (dateOfLeaving == null) {
			if (other.dateOfLeaving != null)
				return false;
		} else if (!dateOfLeaving.equals(other.dateOfLeaving))
			return false;
		if (height != other.height)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (storage != other.storage)
			return false;
		if (thickness != other.thickness)
			return false;
		if (warehouse != other.warehouse)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	

}
