package org.hi.metadata.hsc.util;

import java.io.File;
import java.io.FilenameFilter;

import org.hi.metadata.hsc.context.ServiceFactory;



public class ServiceFilenameFilter implements FilenameFilter {
	
	public boolean accept(File dir, String name) {
		return name.endsWith( ServiceFactory.SERVICE_CONFIG_FILE_SUFFIX );
	}
	
}
