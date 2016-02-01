package de.particity.impexp;

public class ImportFailedException extends Exception {

	public static final int CAUSE_UNKNOWN = -1;
	public static final int IMPORT_VERSIONPARSE_FAIL = 10;
	public static final int IMPORT_IMPL_MISSING = 11;
	public static final int IMPORT_LOAD_FAIL = 12;
	public static final int IMPORT_VERSION_UNSUPPORTED = 13;
	public static final int IMPORT_UNMARSHAL_FAIL = 14;
	public static final int IMPORT_VERSION_MISMATCH = 15;
	public static final int IMPORT_STORE_FAIL = 16;
	
	private int m_numType = CAUSE_UNKNOWN;
	
	public ImportFailedException(int type) {
		m_numType = type; 
	}
	
	public String getMessageCode() {
		String result = null;
		switch (m_numType) {
			case CAUSE_UNKNOWN:
				result = "admin.err.impexp.unknown";
				break;
			case IMPORT_VERSIONPARSE_FAIL:
				result = "admin.err.import.version";
				break;
			case IMPORT_IMPL_MISSING:
				result = "admin.err.import.noimpl";
				break;
			case IMPORT_LOAD_FAIL:
				result = "admin.err.import.loadfail";
				break;
			case IMPORT_VERSION_UNSUPPORTED:
				result = "admin.err.import.oldversion";
				break;
			case IMPORT_UNMARSHAL_FAIL:
				result = "admin.err.import.unmarshal";
				break;
			case IMPORT_VERSION_MISMATCH:
				result = "admin.err.import.wrongver";
				break;
		}
		return result;
	}
	
}
