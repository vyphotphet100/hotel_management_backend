package com.hotelmanagement.service.file.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.FileDTO;
import com.hotelmanagement.service.file.IStaffFileService;
import com.hotelmanagement.utils.MyFileUtil;

@Service
public class StaffFileService extends BaseFileService implements IStaffFileService {

	@Override
	public FileDTO upFile(Long id, FileDTO fileDto) {
		byte[] byteData = Base64.getDecoder().decode(fileDto.getBase64().getBytes());

		// check dir if it exists or not, if not -> create
		File uploadDir = new File("src/main/resources/sources/staff/" + id);
		if (!uploadDir.exists())
			uploadDir.mkdirs();

		// try to write data to drive
		try {
			OutputStream stream = new FileOutputStream(MyFileUtil.getInstance().removeDoubleSlash(
					uploadDir.getAbsolutePath() + "/" + fileDto.getFileName() + "." + fileDto.getFileType()));

			stream.write(byteData);
			stream.close();

			// Get fileLink return
			String fileLink = "/api/file/staff/" + id + "/" + fileDto.getFileName() + "." + fileDto.getFileType();
			fileLink = MyFileUtil.getInstance().removeDoubleSlash(fileLink);

			fileDto.getListResult().add(fileLink);
			fileDto.setBase64(null);
			fileDto.setMessage("Upload file successfully.");
			return fileDto;
		} catch (IOException ex) {
			ex.printStackTrace();
			return (FileDTO) this.ExceptionObject(fileDto, "Something's wrong. Please check again.");
		}

	}

	@Override
	public FileDTO upAvatar(Long id, FileDTO fileDto) {
		fileDto.setFileName("avatar");
		fileDto.setFileType("png");
		return this.upFile(id, fileDto);
	}

	@Override
	public FileDTO delete(Long id) {
		FileDTO fileDto = new FileDTO();
		try {
			FileUtils.deleteDirectory(
					new File(MyFileUtil.getInstance().removeDoubleSlash("src/main/resources/sources/staff/" + id)));

			fileDto.setMessage("Delete staff successfully.");
			return fileDto;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (FileDTO) this.ExceptionObject(fileDto, "Something's wrong. Please check again.");
		}
	}

	@Override
	public FileDTO deleteFile(Long id, FileDTO fileDto) {
		try {
			FileUtils.deleteDirectory(
					new File(MyFileUtil.getInstance().removeDoubleSlash("src/main/resources/sources/staff/" + id + "/"
							+ fileDto.getFileName() + "." + fileDto.getFileType())));

			fileDto.setMessage("Delete file " + fileDto.getFileName() + "." + fileDto.getFileType() + " of staff " + id
					+ " successfully.");
			return fileDto;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (FileDTO) this.ExceptionObject(fileDto, "Something's wrong. Please check again.");
		}
	}

	@Override
	public FileDTO deleteAvatar(Long id) {
		FileDTO fileDto = new FileDTO();
		fileDto.setFileName("avatar");
		fileDto.setFileType("png");
		return this.deleteFile(id, fileDto);
	}

	@Override
	public byte[] getFile(String source) {
		String fileName = source.split("/api/file/staff/")[1];
		File rootPath = new File(MyFileUtil.getInstance().removeDoubleSlash("src/main/resources/sources/staff/" + fileName));
		return MyFileUtil.getInstance().getByteBySource(rootPath.getAbsolutePath());
	}

}
