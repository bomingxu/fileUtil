package gov.gwssi.fileUpload;

import javax.jws.WebService;

@WebService
public interface FileUploadI {
	public String uploadFile(String fileContext,String filePath,String fileName);
	
	public void writeExcel(String filePath,String xcys_fileName);
	
}
