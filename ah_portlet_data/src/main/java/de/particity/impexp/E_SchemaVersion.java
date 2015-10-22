package de.particity.impexp;

import java.util.LinkedList;
import java.util.List;

import javax.naming.directory.SchemaViolationException;

/**
 * Enum for schema versions that provide import/export-mappings
 * 
 * The last entry always declares the current up-to-date version
 * 
 * @author sma
 *
 */
public enum E_SchemaVersion {
	
	/**
	 * Schema version 1.0.0, no predecessor known
	 */
	V100(1,0,0,true,null),
	//V200(2,0,0,V0100)
	;
	
	private int m_numMajor = -1;
	private int m_numMinor = -1;
	private int m_numSubMin = -1;
	private E_SchemaVersion m_objPre = null;
	private boolean m_bStable = false;
	
	private E_SchemaVersion(int major, int minor, int subminor, boolean stable, E_SchemaVersion pre) {
		m_numMajor = major;
		m_numMinor = minor;
		m_numSubMin = subminor;
		m_objPre = pre;
		m_bStable = stable;
	}
	
	public static List<E_SchemaVersion> getUpgradePath(int major, int minor, int subminor, boolean stableOnly) {
		List<E_SchemaVersion> result = new LinkedList<E_SchemaVersion>();
		
		E_SchemaVersion tmp = getLatest(stableOnly);
		// add all versions that are above the specified one
		while (tmp != null && tmp.compareTo(major, minor, subminor) >= 0) {
			result.add(tmp);
			tmp = tmp.getPredecessor();
		}
		
		return result;
	}
	
	public static List<E_SchemaVersion> getUpgradePath(E_SchemaVersion top) {
		List<E_SchemaVersion> result = new LinkedList<E_SchemaVersion>();
		
		E_SchemaVersion tmp = top;
		// add all versions that are above the specified one
		while (tmp != null) {
			result.add(tmp);
			tmp = tmp.getPredecessor();
		}
		
		return result;
	}
	
	/**
	 * Get latest stable version
	 * 
	 * @param stable
	 * @return
	 */
	public static E_SchemaVersion getLatest(boolean stable) {
		E_SchemaVersion result = null;
		
		E_SchemaVersion[] all = E_SchemaVersion.values();
		for (int i=all.length-1;i>=0;i--) {
			if (stable && !all[i].isStable()) {
				continue;
			}
			result = all[i];
			break;
		}
		return result;
	}
	
	public int compareTo(int major, int minor, int subminor) {
		int result = 0;
		
		int numThis = this.m_numMajor*1000+this.m_numMinor*100+this.m_numSubMin;
		int numArg = major*1000+minor*100+subminor;
		if (numThis > numArg)
			result = 1;
		else if (numThis < numArg)
			result = -1;
		
		return result;
	}
	
	public boolean isStable() {
		return m_bStable;
	}
	
	public E_SchemaVersion getPredecessor() {
		return m_objPre;
	}
}
