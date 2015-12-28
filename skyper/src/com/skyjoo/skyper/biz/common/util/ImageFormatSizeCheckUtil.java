package com.skyjoo.skyper.biz.common.util;

import org.springframework.web.multipart.MultipartFile;

import com.skyjoo.skyper.biz.common.upload.UploadFileResult;

public class ImageFormatSizeCheckUtil {

	  /**
     * 单个图片最大限制，默认1M
     */
    private static long                  size           = 1024 * 1024;
    
    /**
     * 默认图片格式
     */
    private static final String[] suffixs  = new String[] { "jpg", "jpeg", "png",
            "gif", "JPG", "JPEG", "PNG", "GIF", "bmp", "BMP" };
	
	public static UploadFileResult checkUploadFile(MultipartFile multipartFile) {
		
		UploadFileResult result = new UploadFileResult();
		
		if (multipartFile == null || multipartFile.isEmpty()) {
			return new UploadFileResult("file_empty", "文件为空.");
		}

		

		if (multipartFile.getSize() > size) {
			return new UploadFileResult("file_large", "文件太大，不能超过" + size / 1024+ " KB.");
		}

		//String suffix = getFileSuffix(multipartFile); // 原文件后缀
		String fileName=multipartFile.getOriginalFilename();
		String suffix =StringUtil.substring(fileName, StringUtil.lastIndexOf(fileName, ".") + 1);
		if (suffixs != null) {
			if (!ArrayUtil.contains(suffixs, suffix)) {
				return new UploadFileResult("file_suffix", "文件格式不正确, "
						+ ArrayUtil.toList(suffixs));
			}
		}

		result.setSuccess(true);
		return result;
	}

}
