package de.particity.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Persistent in-memory logger implementation
 * 
 * @author sma
 *
 */
public class PersistentLog {

	private static PersistentLog m_objSelf = null;
	
	private Map<String, Log> m_objLogs = null;
	
	private PersistentLog() {
		m_objLogs = new ConcurrentHashMap<String, PersistentLog.Log>();
	}
	
	public static final synchronized PersistentLog getInstance() {
		if (m_objSelf == null)
			m_objSelf = new PersistentLog();
		return m_objSelf;
	}
	
	public Log addLog(String name) {
		Log result = new Log();
		m_objLogs.put(name, result);
		return result;
	}
	
	public Log getLog(String name) {
		return m_objLogs.get(name);
	}
	
	public void removeLog(String name) {
		m_objLogs.remove(name);
	}
	
	public class Log {
		private ConcurrentLinkedQueue<LogEntry> m_objLog = null;
		
		public Log() {
			m_objLog = new ConcurrentLinkedQueue<PersistentLog.LogEntry>();
		}
		
		public void log(Object msg) {
			m_objLog.add(new LogEntry(msg));
		}
		
		public void err(Object msg) {
			m_objLog.add(new LogEntry(msg,true));
		}
		
		public String toString() {
			return toString("\"","\" ","\n !!","!! \n");
		}
		
		public String toString(String logPre, String logSuff, String errPre, String errSuff) {
			StringBuffer result = new StringBuffer();
			
			for (LogEntry entry : m_objLog) {
				result.append(entry.isError() ? errPre : logPre).append(entry.getMsg()).append(entry.isError() ? errSuff : logSuff);
			}
			
			return result.toString();
		}
	}
	
	private class LogEntry {
		private String m_objMsg = null;
		long m_numTimestamp = -1;
		boolean m_bError = false;
		
		public LogEntry(Object msg) {
			this(msg,false);
		}
		
		public LogEntry(Object msg, boolean isError) {
			if (msg != null)
				m_objMsg = msg.toString();
			m_numTimestamp = System.currentTimeMillis();
			m_bError = isError;
		}
		
		public String getMsg() {
			return m_objMsg;
		}
		
		public boolean isError() {
			return m_bError;
		}
		
		public long getTimestamp() {
			return m_numTimestamp;
		}
	}
	
}
