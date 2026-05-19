package com.gameHub.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {
	
	// 서버에서 ajax 로 데이터 전송 시, UTF-8 Enc 해서 전송함.
	@PostMapping(value="/upload", produces="text/plain; charset=UTF-8")
	@ResponseBody
	public String uploadImg(@RequestParam("file") MultipartFile imageInput) {

		if (imageInput != null && !imageInput.isEmpty()) {
			String originalName = imageInput.getOriginalFilename();
			String savedName = UUID.randomUUID().toString() + "_" + originalName;
			File savedImageFile = new File("C:\\upload\\post", savedName);

			try {
				imageInput.transferTo(savedImageFile);
				System.out.println("이미지 업로드 성공: [" + savedImageFile.getPath() + "]");

			} catch (Exception e) {
				throw new RuntimeException("이미지 업로드 실패", e);
			}
			return savedName;

		}
		return null;
	}
}
