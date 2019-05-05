package gov.gwssi.fileDeleted;

import javax.jws.WebService;

@WebService
public interface FileDeletedI {
	
	public String deletedFile(String filePath);
}
