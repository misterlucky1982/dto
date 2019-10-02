package by.mlend.data.to;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import by.mlend.data.util.Transfer;

public class TestCases {
	
	private ContractorTO getContractorTO(long id, long warehouse, String name){
		ContractorTO to = new ContractorTO();
		to.setId(id);
		to.setWarehouse(warehouse);
		to.setName(name);
		return to;
	}
	
	private StorageLocationTO getStorageLocationTO(long id, long warehouse, String name){
		StorageLocationTO to = new StorageLocationTO();
		to.setId(id);
		to.setWarehouse(warehouse);
		to.setName(name);
		return to;
	}

	@Test
	public void storegeLocationTOTransferTest() throws TOException{
		String name = "name";
		String anotherName = "anotherName";
		long id = 123;
		long warehouse = 456;
		StorageLocationTO to1 = getStorageLocationTO(id,warehouse,name);
		String line = Transfer.toTranferString(to1);
		assertEquals(to1,Transfer.storageLocationTO(line));
		to1.setName(anotherName);
		to1.setId(id+1);
		assertNotEquals(to1,Transfer.storageLocationTO(line));
		line = Transfer.toTranferString(to1);
		StorageLocationTO to = Transfer.storageLocationTO(line);
		assertEquals(anotherName,to.getName());
		assertTrue(to.getId()==id+1);
	}
	
	@Test
	public void storageLocationListTOTransferTest() throws TOException{
		StorageLocationTO to1 = this.getStorageLocationTO(1,1,"Name 1");
		StorageLocationTO to2 = this.getStorageLocationTO(2,1,"Name 2");
		StorageLocationTO to3 = this.getStorageLocationTO(3,1,"Name 3");
		to2.setDefault(true);
		StorageLocationListTO listTO = new StorageLocationListTO();
		listTO.add(to1);
		listTO.add(to2);
		String line = Transfer.toTranferString(listTO);
		StorageLocationListTO listTO2 = Transfer.storageLocationListTO(line);
		assertEquals(to1,listTO2.get(0));
		assertEquals(to2,listTO2.get(1));
		assertNotEquals(to3,listTO2.get(0));
		assertEquals(listTO,listTO2);
		listTO.add(to3);
		assertNotEquals(listTO,listTO2);
	}
	
	@Test
	public void contractorTOTransferTest() throws TOException{
		String name = "Name";
		String anotherName = "anotherName";
		long id1 = 244;
		long warehouse = 7;
		ContractorTO to1 = getContractorTO(id1,warehouse,name);
		String line = Transfer.toTranferString(to1);
		ContractorTO to2 = Transfer.contractorTO(line);
		assertEquals(to1,to2);
		to1.setName(anotherName);
		assertNotEquals(to1,to2);
	}
	
	@Test
	public void contractorTOListTransferTest()throws TOException{
		String name1 = "name 1";
		String name2 = "name 2";
		String name3 = "name 3";
		long id1 = 1;
		long id2 = 2;
		long id3 = 3;
		ContractorTO to1 = getContractorTO(id1,1,name1);
		ContractorTO to2 = getContractorTO(id2,1,name2);
		ContractorTO to3 = getContractorTO(id3,1,name3);
		ContractorListTO listTO1 = new ContractorListTO();
		listTO1.add(to1);
		listTO1.add(to2);
		String line = Transfer.toTranferString(listTO1);
		ContractorListTO listTO2 = Transfer.contractorListTO(line);
		assertEquals(listTO1,listTO2);
		listTO1.add(to3);
		assertNotEquals(listTO1,listTO2);
		
	}
	
	@Test
	public void remainderTOTest() throws TOException{
		long color = 1;
		long contractor = 2;
		long storage = 3;
		long warehouse = 4;
		int height = 2800;
		int width = 1000;
		int thickness = 18;
		Date arr = Date.valueOf("2019-08-08");
		Date leave = Date.valueOf("2019-08-09");
		String remark = "remark";
		String name = "name";
		RemainderTO to = new RemainderTO();
		to.setColor(color);
		to.setContractor(contractor);
		to.setStorage(storage);
		to.setWarehouse(warehouse);
		to.setDateOfArival(arr);
		to.setDateOfLeaving(leave);
		to.setHeight(height);
		to.setWidth(width);
		to.setThickness(thickness);
		to.setName(name);
		to.setRemark(remark);
		String line = Transfer.toTranferString(to);
		RemainderTO to2 = Transfer.remainderTO(line);
		assertEquals(to,to2);
	}
	
	@Test
	public void remainderListTOTest() throws TOException{
		RemainderTO to1 = new RemainderTO();
		RemainderTO to2 = new RemainderTO();
		to1.setId(1);
		to1.setColor(1);
		to2.setId(2);
		to2.setColor(2);
		RemainderListTO listTO = new RemainderListTO();
		listTO.add(to1);
		listTO.add(to2);
		String line = Transfer.toTranferString(listTO);
		RemainderListTO listTO2 = Transfer.remainderListTO(line);
		assertEquals(listTO,listTO2);
	}
	
	@Test
	public void permissionsTransferTest() throws TOException{
		UserPermissionsTO to = new UserPermissionsTO();
		String line = Transfer.toTranferString(to);
		UserPermissionsTO to2 = Transfer.userPermissionsTO(line);
		assertEquals(to,to2);
		to.setAccessAllowed(true);
		to.setContractorCreateUpdateDeleteAllowed(true);
		to.setRelocationAllowed(true);
		to.setRemainderCreateUpdateWithdrawAllowed(true);
		to.setRemainderHistoryDeleteAllowed(true);
		to.setReportPermited(true);
		to.setStorageLocationCreateUpdateDeleteAllowed(true);
		to.setThirdPartyBookingAllowed(true);
		to.setUserCreateUpdateDeleteAllowed(true);
		assertNotEquals(to,to2);
		line = Transfer.toTranferString(to);
		to2 = Transfer.userPermissionsTO(line);
		assertEquals(to,to2);
	}
	
	@Test
	public void userTOTransferTest() throws TOException{
		UserPermissionsTO permissions = new UserPermissionsTO();
		String name = "name";
		long contractor = 1;
		long warehouse = 2;
		UserTO to = new UserTO();
		to.setAsotiatedContractor(contractor);
		to.setName(name);
		to.setPermissions(permissions);
		to.setWareHouseId(warehouse);
		String line = Transfer.toTranferString(to);
		UserTO to2 = Transfer.userTO(line);
		assertEquals(to,to2);
		assertEquals(permissions,to2.getPermissions());
		assertTrue(to2.getAsotiatedContractor()==contractor);
		assertTrue(to2.getWareHouseId()==warehouse);
		assertEquals(name,to2.getName());
	}
	
	@Test
	public void userIdentityTOTransferTest() throws TOException{
		String login = "login";
		String password = "password";
		UserIdentityTO to = new UserIdentityTO();
		to.setLogin(login);
		to.setPassword(password);
		String line = Transfer.toTranferString(to);
		UserIdentityTO to2 = Transfer.userIdentityTO(line);
		assertEquals(to,to2);
		assertEquals(login,to2.getLogin());
		assertEquals(password,to2.getPassword());
	}
	
	@Test
	public void defaultStorageLocationTOTest(){
		StorageLocationTO to1 = getStorageLocationTO(1,1,"name");
		StorageLocationTO to2 = getStorageLocationTO(1,1,"name");
		to1.setDefault(true);
		assertNotEquals(Transfer.toTranferString(to1),Transfer.toTranferString(to2));
	}
}
