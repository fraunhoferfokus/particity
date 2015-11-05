package de.particity.util;

import java.io.InputStream;
import java.util.Properties;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Version {
	
	public static String PARTICITY_VERSION = null;
	public static Integer PARTICITY_MAJOR = null;
	public static Integer PARTICITY_MINOR = null;
	public static Integer PARTICITY_SUBMINOR = null;
	public static String PARTICITY_SUFFIX = null;
	
	private static final String PROP_VERSION = "particity.version";
	
	private static Log m_objLog = LogFactoryUtil.getLog(Version.class);
	
	static {
		try {
			InputStream in = Version.class.getResourceAsStream("/particity.properties");
			Properties pin = new Properties();
			pin.load(in);
			String ver = pin.getProperty(PROP_VERSION);
			if (ver != null) {
				PARTICITY_VERSION = ver;
				String[] split = ver.split("\\.");
				if (split.length > 0) {
					PARTICITY_MAJOR = toInt(split[0]);
						if (split.length > 1) {
							PARTICITY_MINOR = toInt(split[1]);
							if (split.length > 2) {
								PARTICITY_SUBMINOR = toInt(split[2]);
								if (split[2].contains("-")) {
									split = split[2].split("-");
									PARTICITY_SUBMINOR = toInt(split[0]);
									if (split.length > 1)
										PARTICITY_SUFFIX = split[1];
								}
							}
						}
				}
			}
		} catch (Throwable t) {
			m_objLog.error("Error reading version information",t);
		}
	}

	private static Integer toInt(String num) {
		Integer result = null;
		
		try {
			result = Integer.parseInt(num);
		} catch (Throwable t) {}
		
		return result;
	}
	
}
