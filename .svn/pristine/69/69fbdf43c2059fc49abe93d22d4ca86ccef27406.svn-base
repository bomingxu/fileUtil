package gov.gwssi.fileDownLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.thoughtworks.xstream.core.util.Base64Encoder;

public class FileDownLoadImpl implements FileDownLoadI {

	@Override
	public String downLoadFiles(String filePaths,String zipFileName,String zipFilePath ) throws IOException {
		List<File> fileList = new ArrayList<File>();
	   if(filePaths != null && filePaths.length()>0){
		   String[] filePathList = filePaths.split(";");
		   for(int i=0;i<filePathList.length;i++){
			   String filePath = filePathList[i];
			   File file = new File(filePath);
			   fileList.add(file);
		   }
	   }
	   byte[] buf = new byte[1024];
	   try {
		   File zipFile = new File(zipFilePath +   File.separator+ zipFileName);
		   if(!zipFile.getParentFile().exists()){
			   zipFile.getParentFile().mkdirs();
		   }
		   if(!zipFile.exists()){
			   zipFile.createNewFile();
		   }
		   ZipOutputStream out =new ZipOutputStream(new FileOutputStream(zipFile));
		   for (Iterator<File> it = fileList.iterator(); it.hasNext();) {
			   File f = (File) it.next();
			   if(!f.exists()){
				   continue;
			   }
			   FileInputStream in = new FileInputStream(f);
			   out.putNextEntry(new ZipEntry(f.getName()));    
			   int len;
			   while ((len = in.read(buf)) > 0) {
				   out.write(buf, 0, len);
			   }
			   out.closeEntry();
			   in.close();
		   }
		   out.close();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
	   InputStream inputStream = new FileInputStream(zipFilePath+"\\"+zipFileName);
	   byte[] bytes =  new byte[inputStream.available()];
	   inputStream.read(bytes);
	   inputStream.close();
	   Base64Encoder base64 = new Base64Encoder();
	   String str = base64.encode(bytes);
	   return str; 
	}
	
	@Override
	public String downLoadFile(String filePath) throws Exception {
		InputStream in = new FileInputStream(filePath);
		byte[] bytes =  new byte[in.available()];
		in.read(bytes);
		in.close();
		Base64Encoder base64 = new Base64Encoder();
		String str = base64.encode(bytes);
	    return str; 
	}

}
