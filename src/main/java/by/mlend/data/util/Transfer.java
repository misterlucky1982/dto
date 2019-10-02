package by.mlend.data.util;

import java.sql.Date;
import java.util.Iterator;

import by.mlend.data.to.ContractorListTO;
import by.mlend.data.to.ContractorTO;
import by.mlend.data.to.RemainderListTO;
import by.mlend.data.to.RemainderTO;
import by.mlend.data.to.StorageLocationListTO;
import by.mlend.data.to.StorageLocationTO;
import by.mlend.data.to.TOException;
import by.mlend.data.to.TransferObject;
import by.mlend.data.to.UserIdentityTO;
import by.mlend.data.to.UserPermissionsTO;
import by.mlend.data.to.UserTO;

public class Transfer {

	private final static int ID_LENGTH = 16;
	private final static int ID_START_POSITION = 0;
	private final static int WAREHOUSE_START = 16;
	private final static int WAREHOUSE_LENGTH = 16;
	private final static int COLOR_LENGTH = 16;
	private final static int COLOR_START_POSITION = 32;
	private static final int STORAGE_LENGTH = 16;
	private static final int STORAGE_START_POSITION = 48;
	private static final int CONTRACTOR_LENGTH = 16;
	private static final int CONTRACTOR_START_POSITION = 64;
	private static final int HEIGHT_LENGTH = 3;
	private static final int HEIGHT_START_POSITION = 80;
	private static final int WIDTH_LENGTH = 3;
	private static final int WIDTH_START_POSITION = 83;
	private static final int THICKNESS_LENGTH = 2;
	private static final int THICKNESS_START_POSITION = 86;
	private static final int DATE_LENGTH = 10;
	private static final int ARRIVAL_START_POSITION = 88;
	private static final int LEAVING_START_POSITION = 98;
	private static final int NAME_ID_COUNT_LENGTH = 3;
	private static final int NAME_ID_COUNT_START_POSITION = 108;
	private static final String EMPTY_DATE = "          ";

	private static final String SPLITTER = "x";
	private static final String REMAINDERLISTTO_SPLITTER = ":";
	private static final String STORAGELOCATIONLISTTO_SPLITTER = "!";
	private static final String CONTRACTORLISTTO_SPLITTER = "X";

	public static String toTranferString(TransferObject ob) {
		if (ob == null)
			return null;
		if (ob instanceof RemainderTO)
			return writeRemainderTO((RemainderTO) ob);
		if (ob instanceof RemainderListTO)
			return writeRemainderListTO((RemainderListTO) ob);
		if (ob instanceof StorageLocationTO)
			return writeStorageLocationTO((StorageLocationTO) ob);
		if (ob instanceof StorageLocationListTO)
			return writeStorageLocationListTO((StorageLocationListTO) ob);
		if (ob instanceof ContractorTO)
			return writeContractorTO((ContractorTO) ob);
		if (ob instanceof ContractorListTO)
			return writeContractorListTO((ContractorListTO) ob);
		if (ob instanceof UserTO)
			return writeUserTO((UserTO) ob);
		if(ob instanceof UserPermissionsTO)
			return writeUserPermissions((UserPermissionsTO)ob);
		if(ob instanceof UserIdentityTO)
			return writeUserIdentityTO((UserIdentityTO)ob);
		return null;
	}


	private static String writeRemainderTO(RemainderTO to) {
		StringBuilder sb = new StringBuilder();
		String temp = Long.toHexString(to.getId());
		sb.append(temp);
		sb.append(spaces(ID_LENGTH - temp.length()));
		temp = Long.toHexString(to.getWarehouse());
		sb.append(temp);
		sb.append(spaces(WAREHOUSE_LENGTH-temp.length()));
		temp = to.getColor() != 0 ? Long.toHexString(to.getColor()) : "";
		sb.append(temp);
		sb.append(spaces(COLOR_LENGTH - temp.length()));
		temp = to.getStorage() != 0 ? Long.toHexString(to.getStorage()) : "";
		sb.append(temp);
		sb.append(spaces(STORAGE_LENGTH - temp.length()));
		temp = to.getContractor() != 0 ? Long.toHexString(to.getContractor()) : "";
		sb.append(temp);
		sb.append(spaces(CONTRACTOR_LENGTH - temp.length()));
		temp = Long.toHexString(to.getHeight());
		sb.append(temp);
		sb.append(spaces(HEIGHT_LENGTH - temp.length()));
		temp = Long.toHexString(to.getWidth());
		sb.append(temp);
		sb.append(spaces(WIDTH_LENGTH - temp.length()));
		temp = Long.toHexString(to.getThickness());
		sb.append(temp);
		sb.append(spaces(THICKNESS_LENGTH - temp.length()));
		temp = to.getDateOfArival() != null ? to.getDateOfArival().toString() : "";
		sb.append(temp);
		sb.append(spaces(DATE_LENGTH - temp.length()));
		temp = to.getDateOfLeaving() != null ? to.getDateOfLeaving().toString() : "";
		sb.append(temp);
		sb.append(spaces(DATE_LENGTH - temp.length()));
		temp = byteString(to.getName() != null ? to.getName() : "");
		String temp2 = Long.toHexString(temp.length());
		sb.append(temp2);
		sb.append(spaces(NAME_ID_COUNT_LENGTH - temp2.length()));
		sb.append(temp);
		sb.append(byteString(to.getRemark() != null ? to.getRemark() : ""));
		return sb.toString();
	}

	public static RemainderTO remainderTO(String line) throws TOException {
		try {
			RemainderTO to = new RemainderTO();
			String temp = line.substring(ID_START_POSITION, ID_START_POSITION + ID_LENGTH);
			to.setId(Long.decode("0x" + temp.trim()));
			temp = line.substring(WAREHOUSE_START,WAREHOUSE_START+WAREHOUSE_LENGTH);
			to.setWarehouse(Long.decode("0x"+temp.trim()));
			temp = line.substring(COLOR_START_POSITION, COLOR_LENGTH + COLOR_START_POSITION);
			if (!emptyString(temp))
				to.setColor(Long.decode("0x" + temp.trim()));
			temp = line.substring(STORAGE_START_POSITION, STORAGE_START_POSITION + STORAGE_LENGTH);
			if (!emptyString(temp))
				to.setStorage(Long.decode("0x" + temp.trim()));
			temp = line.substring(CONTRACTOR_START_POSITION, CONTRACTOR_LENGTH + CONTRACTOR_START_POSITION);
			if (!emptyString(temp))
				to.setContractor(Long.decode("0x" + temp.trim()));
			temp = line.substring(HEIGHT_START_POSITION, HEIGHT_LENGTH + HEIGHT_START_POSITION);
			to.setHeight(Integer.decode("0x" + temp.trim()));
			temp = line.substring(WIDTH_START_POSITION, WIDTH_LENGTH + WIDTH_START_POSITION);
			to.setWidth(Integer.decode("0x" + temp.trim()));
			temp = line.substring(THICKNESS_START_POSITION, THICKNESS_LENGTH + THICKNESS_START_POSITION);
			to.setThickness(Integer.decode("0x" + temp.trim()));
			temp = line.substring(ARRIVAL_START_POSITION, ARRIVAL_START_POSITION + DATE_LENGTH);
			if (!EMPTY_DATE.equals(temp))
				to.setDateOfArival(Date.valueOf(temp.trim()));
			temp = line.substring(LEAVING_START_POSITION, LEAVING_START_POSITION + DATE_LENGTH);
			if (!EMPTY_DATE.equals(temp))
				to.setDateOfLeaving(Date.valueOf(temp.trim()));
			int nameStart = NAME_ID_COUNT_START_POSITION + NAME_ID_COUNT_LENGTH;
			temp = line.substring(NAME_ID_COUNT_START_POSITION, nameStart);
			int nameLength = Integer.decode("0x" + temp.trim());
			String name = line.substring(nameStart, nameStart + nameLength);
			if (name.length() > 0)
				to.setName(fromByteString(name));
			String remark = line.substring(nameStart + nameLength);
			if (remark.length() > 0)
				to.setRemark(fromByteString(remark));
			return to;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new TOException();
		}
	}

	private static String writeRemainderListTO(RemainderListTO to) {
		Iterator<RemainderTO> it = to.iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			if (sb.length() > 0)
				sb.append(REMAINDERLISTTO_SPLITTER);
			sb.append(writeRemainderTO(it.next()));
		}
		return sb.toString();
	}

	public static RemainderListTO remainderListTO(String line) throws TOException {
		try {
			RemainderListTO listTO = new RemainderListTO();
			if ("".equals(line))
				return listTO;
			String lines[] = line.split(REMAINDERLISTTO_SPLITTER);
			for (String to : lines)
				listTO.add(remainderTO(to));
			return listTO;
		} catch (RuntimeException | TOException e) {
			e.printStackTrace();
			throw new TOException();
		}
	}

	private final static int ID_LENGTH_ST_LOC = 16;
	private final static int ID_START_POSITION_ST_LOC = 1;
	private final static int WAREHOUSE_START_ST = 17;
	private final static int STORAGE_NAME_START = 33;
	private final static char DEFAULT_STORAGE_MARK = '<';
	private final static char NONDEFAULT_STORAGE_MARK = '>';
	private final static int ISDEFAULT_MARK_INDEX = 0;
	
	private static String writeStorageLocationTO(StorageLocationTO to) {
		StringBuilder sb = new StringBuilder();
		sb.append(to.isDefault()?DEFAULT_STORAGE_MARK:NONDEFAULT_STORAGE_MARK);
		sb.append(Long.toHexString(to.getId()));
		sb.append(spaces(ID_START_POSITION_ST_LOC+ID_LENGTH_ST_LOC - sb.length()));
		sb.append(Long.toHexString(to.getWarehouse()));
		sb.append(spaces(ID_START_POSITION_ST_LOC+WAREHOUSE_LENGTH+ID_LENGTH_ST_LOC-sb.length()));
		sb.append(byteString(to.getName()));
		return sb.toString();
	}

	public static StorageLocationTO storageLocationTO(String line) throws TOException {
		try {
			StorageLocationTO to = new StorageLocationTO();
			to.setDefault(line.charAt(ISDEFAULT_MARK_INDEX)==DEFAULT_STORAGE_MARK);
			String temp = line.substring(ID_START_POSITION_ST_LOC, ID_LENGTH_ST_LOC);
			to.setId(Long.decode("0x" + temp.trim()));
			temp = line.substring(WAREHOUSE_START_ST, WAREHOUSE_START_ST+WAREHOUSE_LENGTH);
			to.setWarehouse(Long.decode("0x"+temp.trim()));
			temp = line.substring(STORAGE_NAME_START);
			to.setName(fromByteString(temp));
			return to;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new TOException();
		}
	}

	private static String writeStorageLocationListTO(StorageLocationListTO listTO) {
		StringBuilder sb = new StringBuilder();
		Iterator<StorageLocationTO> it = listTO.iterator();
		while (it.hasNext()) {
			if (sb.length() != 0)
				sb.append(STORAGELOCATIONLISTTO_SPLITTER);
			sb.append(writeStorageLocationTO(it.next()));
		}
		return sb.toString();
	}

	public static StorageLocationListTO storageLocationListTO(String line) throws TOException {
		try {
			StorageLocationListTO listTO = new StorageLocationListTO();
			if ("".equals(line))
				return listTO;
			String lines[] = line.split(STORAGELOCATIONLISTTO_SPLITTER);
			for (String s : lines)
				listTO.add(storageLocationTO(s));
			return listTO;
		} catch (RuntimeException | TOException e) {
			e.printStackTrace();
			throw new TOException();
		}
	}

	private static String writeContractorTO(ContractorTO to) {
		StringBuilder sb = new StringBuilder();
		sb.append(Long.toHexString(to.getId()));
		sb.append(spaces(ID_LENGTH_CONTR - sb.length()));
		sb.append(Long.toHexString(to.getWarehouse()));
		sb.append(spaces(ID_LENGTH_CONTR + WAREHOUSE_LENGTH - sb.length()));
		sb.append(byteString(to.getName()));
		return sb.toString();
	}

	private final static int ID_LENGTH_CONTR = 16;
	private final static int ID_START_POSITION_CONTR = 0;
	private final static int WAREHOUSE_START_CONTR = 16;
	
	public static ContractorTO contractorTO(String line) throws TOException {
		try {
			ContractorTO to = new ContractorTO();
			String temp = line.substring(ID_START_POSITION_CONTR, ID_LENGTH_CONTR);
			to.setId(Long.decode("0x" + temp.trim()));
			temp = line.substring(WAREHOUSE_START_CONTR, WAREHOUSE_START_CONTR+WAREHOUSE_LENGTH);
			to.setWarehouse(Long.decode("0x"+temp.trim()));
			temp = line.substring(ID_LENGTH_CONTR+WAREHOUSE_LENGTH);
			to.setName(fromByteString(temp));
			return to;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new TOException();
		}
	}

	public static ContractorListTO contractorListTO(String line) throws TOException {
		try {
			ContractorListTO listTO = new ContractorListTO();
			if ("".equals(line))
				return listTO;
			String lines[] = line.split(CONTRACTORLISTTO_SPLITTER);
			for (String s : lines)
				listTO.add(contractorTO(s));
			return listTO;
		} catch (RuntimeException | TOException e) {
			e.printStackTrace();
			throw new TOException();
		}
	}

	private static String writeContractorListTO(ContractorListTO listTO) {
		StringBuilder sb = new StringBuilder();
		Iterator<ContractorTO> it = listTO.iterator();
		while (it.hasNext()) {
			if (sb.length() != 0)
				sb.append(CONTRACTORLISTTO_SPLITTER);
			sb.append(writeContractorTO(it.next()));
		}
		return sb.toString();
	}

	private static final String UNAUTHORIZED_USER = "X";
	private static final char TRUE = ':';
	private static final char FALSE = '!';
	private static final int USERPERMISSIONSLENGTH = 9;
	private static final int ACESSALLOWED = 0;
	private static final int CONTRACTORCUDALLOWED = 1;
	private static final int RELOCATIONALLOWED = 2;
	private static final int REMAINDERCUDALLOWED = 3;
	private static final int HISTORYIMPACTALLOWED = 4;
	private static final int REPORTPERMITION = 5;
	private static final int STORAGECUDALLOWED = 6;
	private static final int THIRDPARTYBOOKALLOWED = 7;
	private static final int USERCUDALLOWED = 8;

	private static String writeUserPermissions(UserPermissionsTO to) {
		StringBuilder sb = new StringBuilder();
		sb.append(to.isAccessAllowed() ? TRUE : FALSE);
		sb.append(to.isContractorCreateUpdateDeleteAllowed() ? TRUE : FALSE);
		sb.append(to.isRelocationAllowed() ? TRUE : FALSE);
		sb.append(to.isRemainderCreateUpdateWithdrawAllowed() ? TRUE : FALSE);
		sb.append(to.isRemainderHistoryDeleteAllowed() ? TRUE : FALSE);
		sb.append(to.isReportPermited() ? TRUE : FALSE);
		sb.append(to.isStorageLocationCreateUpdateDeleteAllowed() ? TRUE : FALSE);
		sb.append(to.isThirdPartyBookingAllowed() ? TRUE : FALSE);
		sb.append(to.isUserCreateUpdateDeleteAllowed() ? TRUE : FALSE);
		return sb.toString();
	}

	public static UserPermissionsTO userPermissionsTO(String line) throws TOException {
		if (line == null || line.length() != USERPERMISSIONSLENGTH)
			throw new TOException();
		char[] chars = line.toCharArray();
		for (char ch : chars)
			if (ch != TRUE && ch != FALSE)
				throw new TOException();
		UserPermissionsTO to = new UserPermissionsTO();
		to.setAccessAllowed(TRUE == chars[ACESSALLOWED]);
		to.setContractorCreateUpdateDeleteAllowed(TRUE == chars[CONTRACTORCUDALLOWED]);
		to.setRelocationAllowed(TRUE == chars[RELOCATIONALLOWED]);
		to.setRemainderCreateUpdateWithdrawAllowed(TRUE == chars[REMAINDERCUDALLOWED]);
		to.setRemainderHistoryDeleteAllowed(TRUE == chars[HISTORYIMPACTALLOWED]);
		to.setReportPermited(TRUE == chars[REPORTPERMITION]);
		to.setStorageLocationCreateUpdateDeleteAllowed(TRUE == chars[STORAGECUDALLOWED]);
		to.setThirdPartyBookingAllowed(TRUE == chars[THIRDPARTYBOOKALLOWED]);
		to.setUserCreateUpdateDeleteAllowed(TRUE == chars[USERCUDALLOWED]);
		return to;
	}

	private static final int WAREHOUSEIDLENGTH = 16;
	private static final int ASOTIATEDCONTRACTORIDLENGTH = 16;
	private static final int USERNAMESTARTPOSITION = 41;

	private static String writeUserTO(UserTO to) {
		if (to == null)
			return UNAUTHORIZED_USER;
		StringBuilder sb = new StringBuilder();
		sb.append(Long.toHexString(to.getWareHouseId()));
		sb.append(spaces(WAREHOUSEIDLENGTH - sb.length()));
		sb.append(Long.toHexString(to.getAsotiatedContractor()));
		sb.append(spaces(WAREHOUSEIDLENGTH + ASOTIATEDCONTRACTORIDLENGTH - sb.length()));
		sb.append(writeUserPermissions(to.getPermissions() != null ? to.getPermissions() : new UserPermissionsTO()));
		if (to.getName() != null)
			sb.append(byteString(to.getName()));
		return sb.toString();
	}

	public static UserTO userTO(String line) throws TOException {
		try {
			UserTO to = new UserTO();
			String temp = line.substring(0, WAREHOUSEIDLENGTH);
			to.setWareHouseId(Long.decode("0x" + temp.trim()));
			temp = line.substring(WAREHOUSEIDLENGTH, ASOTIATEDCONTRACTORIDLENGTH + WAREHOUSEIDLENGTH);
			to.setAsotiatedContractor(Long.decode("0x" + temp.trim()));
			to.setPermissions(userPermissionsTO(
					line.substring(ASOTIATEDCONTRACTORIDLENGTH + WAREHOUSEIDLENGTH, ASOTIATEDCONTRACTORIDLENGTH + WAREHOUSEIDLENGTH+USERPERMISSIONSLENGTH)));
			to.setName(fromByteString(line.substring(USERNAMESTARTPOSITION)));
			return to;
		} catch (RuntimeException e) {
			throw new TOException();
		}
	}

	private static boolean emptyString(String line) {
		return line == null || line.trim().length() == 0;
	}

	private static char[] spaces(int num) {
		char[] chars = new char[num];
		for (int i = 0; i < chars.length; i++)
			chars[i] = ' ';
		return chars;
	}

	private static String byteString(String line) {
		byte[] bytes = line.getBytes();
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes)
			sb.append(SPLITTER + Byte.toString(b));
		if (sb.length() > 0)
			sb.deleteCharAt(0);
		return sb.toString();
	}

	private static String fromByteString(String line) {
		if (line == null || line.length() == 0)
			return line;
		String[] strings = line.split(SPLITTER);
		byte[] bytes = new byte[strings.length];
		for (int i = 0; i < bytes.length; i++)
			bytes[i] = Byte.parseByte(strings[i]);
		return new String(bytes);
	}
	
	private static final int LOGINLENGTHMARKERLENGTH = 8;
	
	private static String writeUserIdentityTO(UserIdentityTO to){
		String login = to.getLogin()!=null?to.getLogin():"";
		login = byteString(login);
		String password = to.getPassword()!=null?to.getPassword():"";
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toHexString(login.length()));
		sb.append(spaces(LOGINLENGTHMARKERLENGTH-sb.length()));
		sb.append(login);
		sb.append(byteString(password));
		return sb.toString();
	}
	
	public static UserIdentityTO userIdentityTO(String line) throws TOException{
		try{
			int nameLength = Integer.decode("0x"+line.substring(0, LOGINLENGTHMARKERLENGTH).trim());
			String login = fromByteString(line.substring(LOGINLENGTHMARKERLENGTH, LOGINLENGTHMARKERLENGTH+nameLength));
			String password = fromByteString(line.substring(LOGINLENGTHMARKERLENGTH+nameLength));
			UserIdentityTO to = new UserIdentityTO();
			to.setLogin(login);
			to.setPassword(password);
			return to;
		}catch(RuntimeException e){
			throw new TOException();
		}
	}
}
