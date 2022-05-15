package com.ebook.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileManagerService {
	public final static String FILE_UPLOAD_PATH = "C:\\Users\\mayo1\\Desktop\\web\\6_spring_project\\ebook_library\\workspace\\images/";
	//public final static String FILE_UPLOAD_PATH = "/home/ec2-user/images/";

	// input: file, output:imagePath
	public String saveFile(String loginId, MultipartFile file) throws IOException {
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + directoryName;

		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null; // 디렉토리 폴더 생성 실패 시 path null
		}

		byte[] bytes = file.getBytes();
		Path path = Paths.get(filePath + file.getOriginalFilename());
		Files.write(path, bytes);

		return "/images/" + directoryName + file.getOriginalFilename();
	}


}
