package com.skyjoo.skyper.biz.common.util;

import org.springframework.web.multipart.MultipartFile;

import com.skyjoo.skyper.biz.common.upload.UploadFileResult;

public class ImageFormatSizeCheckUtil {

	  /**
     * ����ͼƬ������ƣ�Ĭ��1M
     */
    private static long                  size           = 1024 * 1024;
    
    /**
     * Ĭ��ͼƬ��ʽ
     */
    private static final String[] suffixs  = new String[] { "jpg", "jpeg", "png",
            "gif", "JPG", "JPEG", "PNG", "GIF", "bmp", "BMP" };
	
	public static UploadFileResult checkUploadFile(MultipartFile multipartFile) {
		
		UploadFileResult result = new UploadFileResult();
		
		if (multipartFile == null || multipartFile.isEmpty()) {
			return new UploadFileResult("file_empty", "�ļ�Ϊ��.");
		}

		

		if (multipartFile.getSize() > size) {
			return new UploadFileResult("file_large", "�ļ�̫�󣬲��ܳ���" + size / 1024+ " KB.");
		}

		//String suffix = getFileSuffix(multipartFile); // ԭ�ļ���׺
		String fileName=multipartFile.getOriginalFilename();
		String suffix =StringUtil.substring(fileName, StringUtil.lastIndexOf(fileName, ".") + 1);
		if (suffixs != null) {
			if (!ArrayUtil.contains(suffixs, suffix)) {
				return new UploadFileResult("file_suffix", "�ļ���ʽ����ȷ, "
						+ ArrayUtil.toList(suffixs));
			}
		}

		result.setSuccess(true);
		return result;
	}

}
