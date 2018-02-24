package com.example.demo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传测试
 * @author chenbq
 * 2017-02-13
 */

@Controller
public class FileUploader {
	
	private static Logger log = LoggerFactory.getLogger(FileUploader.class);

	@RequestMapping("choose_file")
	public String chooseFile() {
		return "choose_file";
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file) {
		String msg = "";
		if (!file.isEmpty()) {
			String fileName = "e:/mylab/" + file.getOriginalFilename();
			log.info("file name:" + fileName);
			log.info("file content type:" + file.getContentType());
			log.info("file size:" + file.getSize());
			try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName))) {
				out.write(file.getBytes());
				out.flush();
			} catch(IOException e) {
				log.info("保存文件失败");
			}
			msg = "上传成功";
			log.info(msg);
		} else {
			msg = "上传失败，文件为空！";
			log.info(msg);
		}
		
		return msg;
	}
	
	
}
