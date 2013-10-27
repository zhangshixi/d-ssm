package com.dssm.loader;

import com.mtoolkit.spring.config.AbstractPropertyLoader;

public class ConfigPropertyLoader extends AbstractPropertyLoader {

	public String getUploadPath() {
		return getProperty("upload.path");
	}
	
	public String getImageDomain() {
		return getProperty("image.domain");
	}
	
}
