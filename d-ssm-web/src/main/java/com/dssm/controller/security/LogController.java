package com.dssm.controller.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dssm.controller.BaseController;
import com.dssm.exception.NotFoundException;
import com.dssm.exception.SystemException;
import com.mtoolkit.util.CopyUtil;
import com.mtoolkit.util.EmptyUtil;

@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public String showLog(@PathVariable String name, long pos, ModelMap modelMap) {
        System.err.println(pos);
        modelMap.put("name", name);
        modelMap.put("pos", pos);
        return "back/log";
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
    
    @RequestMapping(value="/{name}/download", method=RequestMethod.GET)
    public void downloadLog(@PathVariable String name, HttpServletResponse response) {
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
    
    /* ---- private methods ---- */
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
    
}