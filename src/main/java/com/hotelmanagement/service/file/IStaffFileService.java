package com.hotelmanagement.service.file;

import com.hotelmanagement.dto.FileDTO;

public interface IStaffFileService {
	FileDTO upFile(Long id, FileDTO fileDto);
	FileDTO upAvatar(Long id, FileDTO fileDto);
	FileDTO delete(Long id);
	FileDTO deleteFile(Long id, FileDTO fileDto);
	FileDTO deleteAvatar(Long id);
	byte[] getFile(String source);
}
