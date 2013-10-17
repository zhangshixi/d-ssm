package com.dssm.controller.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dssm.controller.BaseController;
import com.dssm.exception.NotFoundException;
import com.dssm.exception.SystemException;
import com.mtoolkit.page.Page;
import com.mtoolkit.util.ArrayUtil;
import com.mtoolkit.util.CopyUtil;
import com.mtoolkit.util.EmptyUtil;

@Controller
@RequestMapping("/log")
@RequiresRoles("log:manager")
public class LogController extends BaseController {

    @RequestMapping(method=RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "back/log/index";
    }
    
    @RequestMapping(value="/list", method=RequestMethod.POST)
	public String showList(Page<File> page, String fileName, ModelMap modelMap) {
    	File logDir = doGetLogDir();
        File[] logFiles = logDir.listFiles(new LogFileNameFilter(fileName));
        
        page.setTotalData(logFiles.length);
        int pageSize = page.getToIndex() + 1 - page.getFromIndex();
        List<LogFile> resultList = new ArrayList<LogFile>(pageSize);
        for (int i = page.getFromIndex(); i <= page.getToIndex(); i++) {
        	resultList.add(new LogFile(logFiles[i]));
        }
        
        modelMap.put("page", page);
        modelMap.put("resultList", resultList);
		
		return "back/log/list";
	}

    @RequestMapping(value="/{name}/remove", method=RequestMethod.GET)
    public String remove(@PathVariable String name, HttpServletResponse response) {
    	 File logFile = doGetLogFile(name);
    	 logFile.delete();
    	 
    	 return redirectTo("/log");
    }
    
    @RequestMapping(value="/{name}/download", method=RequestMethod.GET)
    public void download(@PathVariable String name, HttpServletResponse response) {
        File logFile = doGetLogFile(name);
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment;fileName=" + name);
        
        InputStream input = null;
        try {
            input = new FileInputStream(logFile);
            CopyUtil.copy(input, response.getOutputStream());
        } catch (FileNotFoundException e) {
            throw new NotFoundException("Log file is not exist: " + logFile.getAbsolutePath());
        } catch (IOException e) {
            throw new SystemException("Read log file error: " + logFile.getAbsolutePath());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                throw new SystemException("Close log file error: " + logFile.getAbsolutePath());
            }
        }
    }
    
    @RequestMapping(value="/{name}/clear", method=RequestMethod.GET)
    public String clear(@PathVariable String name, HttpServletResponse response) {
    	 File logFile = doGetLogFile(name);
    	 OutputStream output = null;
         try {
        	 output = new FileOutputStream(logFile);
             CopyUtil.copy(ArrayUtil.EMPTY_BYTE_ARRAY, output);
         } catch (FileNotFoundException e) {
             throw new NotFoundException("Log file is not exist: " + logFile.getAbsolutePath());
         } catch (IOException e) {
             throw new SystemException("Read log file error: " + logFile.getAbsolutePath());
         } finally {
             try {
                 if (output != null) {
                	 output.close();
                 }
             } catch (IOException e) {
                 throw new SystemException("Close log file error: " + logFile.getAbsolutePath());
             }
         }
    	 
    	 return redirectTo("/log");
    }

    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public String showLog(@PathVariable String name, long pos, ModelMap modelMap) {
        modelMap.put("name", name);
        modelMap.put("pos", pos);
        return "back/log/monitor";
    }
    
    @ResponseBody
    @RequestMapping(value = "/{name}/{pos}", method = RequestMethod.POST)
    public String getLog(@PathVariable String name, @PathVariable long pos) {
        StringBuilder buff = new StringBuilder();
        buff.append("13:22:49 DEBUG Returning cached instance of singleton bean 'sqlSessionFactory'").append("<br/>");
        buff.append("13:23:04 DEBUG DispatcherServlet with name 'springMvc' processing POST request for [/d-ssm/log/info/0]").append("<br/>");
        buff.append("13:23:04 DEBUG Looking up handler method for path /log/info/0").append("<br/>");
        buff.append("13:23:04 DEBUG Returning handler method [public java.lang.String com.dssm.controller.CommonController.getLog(java.lang.String,long)]").append("<br/>");
        buff.append("13:23:04 DEBUG Returning cached instance of singleton bean 'commonController'").append("<br/>");
        buff.append("13:23:04 DEBUG Returning cached instance of singleton bean 'systemPropertyLoader'").append("<br/>");
        buff.append("13:23:05 DEBUG Written [13:07:28 INFO  Root WebApplicationContext: initialization started").append("<br/>");
        
        return buff.toString();
        
//        File logFile = doGetLogFile(name);
//
//        String line = null;
//        RandomAccessFile randomFile = null;
//        StringBuilder response = new StringBuilder();
//        try {
//            randomFile = new RandomAccessFile(logFile, "r");
//            randomFile.seek(pos);
//
//            while ((line = randomFile.readLine()) != null) {
//                response.append(line + "<br/>");
//            }
//
//            return response.length() == 0 ? null : response.toString();
////            return pos + response.length();
//        } catch (FileNotFoundException e) {
//            throw new NotFoundException("Log file is not exist: " + logFile.getAbsolutePath());
//        } catch (IOException e) {
//            throw new SystemException("Read log file error: " + logFile.getAbsolutePath());
//        } finally {
//            try {
//                randomFile.close();
//            } catch (IOException e) {
//                throw new SystemException("Close log file error: " + logFile.getAbsolutePath());
//            }
//        }
    }
    
    /* ---- private methods ---- */
    private File doGetLogDir() {
    	return new File(getSystemPropertyLoader().getLogHome());
    }
    
    private File doGetLogFile(String name) {
    	if (EmptyUtil.isNullEmpty(name)) {
    		throw new NullPointerException("logname");
    	} else {
    		if (!name.startsWith("/")) {
    			name = "/" + name;
    		}
    		String logFileName = getSystemPropertyLoader().getLogHome() + name;
    		return new File(logFileName);
    	}
    }
    
    /* ---- inner classes ---- */
    private class LogFileNameFilter implements FilenameFilter {

    	private String fileName;
    	public LogFileNameFilter(String fileName) {
    		this.fileName = fileName;
		}
    	
		@Override
		public boolean accept(File dir, String name) {
			return fileName != null && name.contains(fileName);
		}
    	
    }
    
    public static class LogFile {
    	
    	private String name;
    	private String size;
    	private String absolutePath;
    	private Date   lastModifiedTime;
    	
    	public LogFile(File logFile) {
    		this.name = logFile.getName();
    		this.size = (logFile.length() % 1024L == 0 
    				? logFile.length() / 1024L 
    				: logFile.length() / 1024L + 1) + "KB";
    		this.absolutePath = logFile.getAbsolutePath();
    		this.lastModifiedTime = new Date(logFile.lastModified());
		}
    	
    	public String getName() {
			return this.name;
		}
    	public String getSize() {
    		return this.size;
    	}
    	public String getAbsolutePath() {
			return this.absolutePath;
		}
    	public Date getLastModifiedTime() {
			return this.lastModifiedTime;
		}
    	
    }
 
}