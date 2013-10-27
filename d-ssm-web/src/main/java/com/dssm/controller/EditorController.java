package com.dssm.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/editor")
public class EditorController extends BaseController {

	//最大文件大小
	public static final long UPLOAD_MAX_SIZE = 1000000L;
	
	//定义允许上传的文件扩展名
	public static HashMap<String, String> EXT_MAP;
	static {
		EXT_MAP = new HashMap<String, String>(4, 1F);
		EXT_MAP.put("flash", "swf,flv");
		EXT_MAP.put("image", "gif,jpg,jpeg,png,bmp");
		EXT_MAP.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		EXT_MAP.put("file",  "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	}
	
	@ResponseBody
	@RequestMapping(value="/upload", method=RequestMethod.POST)
    public String upload(MultipartFile imgFile, HttpServletRequest request) throws FileUploadException, IllegalStateException, IOException {
		//文件保存目录路径
		String savePath = getEditorUploadPath();
		//文件保存目录URL
		String saveUrl  = getEditorVisitPath();
		
		
		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		if(!EXT_MAP.containsKey(dirName)){
			return getError("目录名不正确。");
		}

		if(imgFile.isEmpty()){
			return getError("请选择文件。");
		}
		
		//检查文件大小
		if(imgFile.getSize() > UPLOAD_MAX_SIZE){
			return getError("上传文件大小超过限制。");
		}
		
		//检查扩展名
		String fileName = imgFile.getOriginalFilename();
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if(!Arrays.<String>asList(EXT_MAP.get(dirName).split(",")).contains(fileExt)){
			return getError("上传文件扩展名是不允许的扩展名。\n只允许" + EXT_MAP.get(dirName) + "格式。");
		}
		
		//检查目录
		File uploadDir = new File(savePath);
		if(!uploadDir.isDirectory()){
			return getError("上传目录不存在。");
		}
		//检查目录写权限
		if(!uploadDir.canWrite()){
			return getError("上传目录没有写权限。");
		}
		
		
		//创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
		
		
		File uploadedFile = new File(savePath, newFileName);
		imgFile.transferTo(uploadedFile);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("error", 0);
		result.put("url", saveUrl + newFileName);
		return new ObjectMapper().writeValueAsString(result);
    }
	
	@ResponseBody
	@RequestMapping(value="/show", method=RequestMethod.GET)
    public String show(HttpServletRequest request) {
		System.err.println(request.getSession().getServletContext().getRealPath("/"));
		
		//根目录路径，可以指定绝对路径，比如 /var/www/attached/
		String uploadPath = getEditorUploadPath();
		//根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/attached/
		String visitUrl  = getEditorVisitPath();
		//图片扩展名
		String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};

		String dirName = request.getParameter("dir");
		if (dirName != null) {
			if(!Arrays.<String>asList(new String[]{"image", "flash", "media", "file"}).contains(dirName)){
				return "Invalid Directory name.";
			}
			uploadPath += dirName + "/";
			visitUrl += dirName + "/";
			File saveDirFile = new File(uploadPath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
		}
		//根据path参数，设置各路径和URL
		String path = request.getParameter("path") != null ? request.getParameter("path") : "";
		String currentPath = uploadPath + path;
		String currentUrl = visitUrl + path;
		String currentDirPath = path;
		String moveupDirPath = "";
		if (!"".equals(path)) {
			String str = currentDirPath.substring(0, currentDirPath.length() - 1);
			moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0, str.lastIndexOf("/") + 1) : "";
		}

		//排序形式，name or size or type
		String order = request.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

		//不允许使用..移动到上一级目录
		if (path.indexOf("..") >= 0) {
			return "Access is not allowed.";
		}
		//最后一个字符不是/
		if (!"".equals(path) && !path.endsWith("/")) {
			return "Parameter is not valid.";
		}
		//目录不存在或不是目录
		File currentPathFile = new File(currentPath);
		if(!currentPathFile.isDirectory()){
			return "Directory does not exist.";
		}

		//遍历目录取的文件信息
		List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
		if(currentPathFile.listFiles() != null) {
			for (File file : currentPathFile.listFiles()) {
				Map<String, Object> hash = new Hashtable<String, Object>();
				String fileName = file.getName();
				if(file.isDirectory()) {
					hash.put("is_dir", true);
					hash.put("has_file", (file.listFiles() != null));
					hash.put("filesize", 0L);
					hash.put("is_photo", false);
					hash.put("filetype", "");
				} else if(file.isFile()){
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					hash.put("is_dir", false);
					hash.put("has_file", false);
					hash.put("filesize", file.length());
					hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
					hash.put("filetype", fileExt);
				}
				hash.put("filename", fileName);
				hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
				fileList.add(hash);
			}
		}

		if ("size".equals(order)) {
			Collections.sort(fileList, new SizeComparator());
		} else if ("type".equals(order)) {
			Collections.sort(fileList, new TypeComparator());
		} else {
			Collections.sort(fileList, new NameComparator());
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("moveup_dir_path", moveupDirPath);
		result.put("current_dir_path", currentDirPath);
		result.put("current_url", currentUrl);
		result.put("total_count", fileList.size());
		result.put("file_list", fileList);
		
        try {
			return new ObjectMapper().writeValueAsString(result);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "error!";
    }
	
	/* ---- private methods --- */
	private String getError(String message) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("error", 1);
		result.put("message", message);
		
		return new ObjectMapper().writeValueAsString(result);
	}
	
	private String getEditorUploadPath() {
		return getConfigPropertyLoader().getUploadPath() + "/editor/";
	}
	
	private String getEditorVisitPath() {
		return getConfigPropertyLoader().getImageDomain() + "/editor/";
	}
	
	/* ---- inner classes --- */
	public static class NameComparator implements Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String)hashA.get("filename")).compareTo((String)hashB.get("filename"));
			}
		}
	}
	
	public static class SizeComparator implements Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
				return 1;
			} else {
				if (((Long)hashA.get("filesize")) > ((Long)hashB.get("filesize"))) {
					return 1;
				} else if (((Long)hashA.get("filesize")) < ((Long)hashB.get("filesize"))) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
	
	public static class TypeComparator implements Comparator<Map<String, Object>> {
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String)hashA.get("filetype")).compareTo((String)hashB.get("filetype"));
			}
		}
	}
	
}
