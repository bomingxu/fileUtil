package gov.gwssi.fileDeleted;

import java.io.File;

public class FileDeletedImpl implements FileDeletedI {

	@Override
	public String deletedFile(String filePath) {
		String result = "";
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			result="0";
 		}else{
 			file.delete();
 			result = "1";
 		}
		return result;
	}

}
