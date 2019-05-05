package gov.gwssi.fileUpload;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.jws.WebService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.thoughtworks.xstream.core.util.Base64Encoder;

@WebService
public class FileUploadImpl implements FileUploadI {
	/**
	 * 附件上传
	 * fileContext 附件类容
	 * filePath 上传路径
	 * fileName 附件名称
	 */
	@Override
	public String uploadFile(String fileContext,String filePath,String fileName){
	   String result = "";
	   try {
		   String[] fileContextList = fileContext.split(";");
		   String[] fileNameList = fileName.split(";");
		   for(int i=0;i<fileContextList.length;i++){
			   String fileContext2 = fileContextList[i];
			   String fileName2 = fileNameList[i];
			   Base64Encoder base64 = new Base64Encoder();
			   byte[] byt = base64.decode(fileContext2);
			   File file = new File(filePath+"\\\\"+fileName2);
			   if(!file.getParentFile().exists()){  
				   file.getParentFile().mkdirs();  
			   }
			   if(!file.exists()){
				   file.createNewFile();  
			   }
			   FileOutputStream fos = new FileOutputStream(file);
			   fos.write(byt);
			   fos.close();
		   }
		  	result = "1";
		} catch (Exception e) {
			result = "0";
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 生成excel
	 * filePath excel路径
	 * ysmc_fileName excel名称
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void writeExcel(String filePath, String ysmc_fileName){
		try {
			File file = new File(filePath);
		  	if(!file.getParentFile().exists()){  
	            file.getParentFile().mkdirs();  
	        }
		  	if(!file.exists()){
		  		file.createNewFile();  
		  	}
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("shell1");
	        HSSFRow row = sheet.createRow(0);
	        HSSFCell cell = row.createCell(0);
	        cell.setCellValue("元素名称");
	        cell = row.createCell(1);
	        cell.setCellValue("附件名称");

	        String[] ysmc_fileNames = ysmc_fileName.split(";");
	        for (int i = 0; i < ysmc_fileNames.length; i++) {
	            HSSFRow row1 = sheet.createRow(i + 1);
	            String ysmc = ysmc_fileNames[i].split(":")[0];
	            String fileName = ysmc_fileNames[i].split(":")[1];
	            row1.createCell(0).setCellValue(ysmc);
	            row1.createCell(1).setCellValue(fileName);
	        }

	        try {
	            FileOutputStream fos = new FileOutputStream(filePath);
	            workbook.write(fos);
	            fos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
