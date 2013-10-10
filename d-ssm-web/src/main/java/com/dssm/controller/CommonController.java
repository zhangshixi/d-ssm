package com.dssm.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.exception.NotFoundException;
import com.dssm.exception.SystemException;
import com.mtoolkit.util.EmptyUtil;
import com.mtoolkit.util.ServletUtil;

@Controller
public class CommonController extends BaseController {

	/* ---- version ---- */
    @RequestMapping(value="/version", method=RequestMethod.GET)
    public String version() {
        return "version";
    }
    
    /* ---- error ---- */
    @RequestMapping(value="/error", method=RequestMethod.GET)
    public String errorPage(ModelMap modelMap, String message) {
    	modelMap.put("message", message);
    	return "error/error";
    }
    
    @RequestMapping(value="/error/403", method=RequestMethod.GET)
    public String error403() {
        return "error/403";
    }
    
    @RequestMapping(value="/error/404", method=RequestMethod.GET)
    public String error404() {
        return "error/404";
    }
    
    @RequestMapping(value="/error/500", method=RequestMethod.GET)
    public String error500() {
        return "error/500";
    }

    /* ---- log ---- */
    @RequestMapping(value="/log/{name}/download", method=RequestMethod.GET)
    public void downloadLog(@PathVariable String name, HttpServletResponse response) {
    	File logFile = doGetLogFile(name);
    }
    
    @RequestMapping(value="/log/{name}", method=RequestMethod.GET)
    public void showLog(@PathVariable String name, HttpServletResponse response) {
    	File logFile = doGetLogFile(name);
    	
    	BufferedReader reader = null;
    	BufferedWriter writer = null;
    	String line = null;
    	try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(logFile)));
			writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
			while (true) {
				try {
					TimeUnit.MICROSECONDS.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				line = reader.readLine();
				if (line == null) {
					try {
						TimeUnit.MICROSECONDS.sleep(1000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					writer.write(line + "\r\n");
					writer.flush();
				}
			}
		} catch (FileNotFoundException e) {
			throw new NotFoundException("Log file is not exist: " + logFile.getAbsolutePath());
		} catch (IOException e) {
			throw new SystemException("Read log file error: " + logFile.getAbsolutePath());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    
    private File doGetLogFile(String name) {
    	if (EmptyUtil.isNullEmpty(name)) {
    		throw new NullPointerException("log name is null!");
    	} else {
    		if (!name.startsWith("/")) {
    			name = "/" + name;
    		}
    		String logFileName = getSystemPropertyLoader().getLogHome() + name;
    		return new File(logFileName);
    	}
    }
    
    
//    @RequestMapping(value="/log/{name}", method=RequestMethod.GET)
//    public String showLog(@PathVariable String name, ModelMap modelMap) {
//    	modelMap.put("name", name);
//    	return "error/log";
//    }
//    
//    @ResponseBody
//    @RequestMapping(value="/log", method=RequestMethod.POST)
//    public long getLog(String name, long pos, HttpServletResponse response) {
//    	File logFile = doGetLogFile(name);
//    	
//    	RandomAccessFile randomFile = null;
//    	String line = null;
//    	BufferedWriter writer = null;
//    	try {
//    		randomFile = new RandomAccessFile(logFile, "r");
//    		randomFile.seek(pos);
//    		writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
//    		
//    		while ((line = randomFile.readLine()) != null) {
//    			writer.write(ServletUtil.iso88591ToUtf8(line + "\r\n"));
//			}
//    		
//    		return randomFile.length();
//		} catch (FileNotFoundException e) {
//			throw new NotFoundException("Log file is not exist: " + logFile.getAbsolutePath());
//		} catch (IOException e) {
//			throw new SystemException("Read log file error: " + logFile.getAbsolutePath());
//		} finally {
//			try {
//				randomFile.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//    }
    
}