package cta_Automation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Create_Excel {
	Date date = java.util.Calendar.getInstance().getTime();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
	String strDate = dateFormat.format(date);
	String filepath= ("D:\\Suresh\\CTA\\CTA_Metrics_"+strDate+".xlsx");
	File file= new File(filepath);
@SuppressWarnings("unused")
@Test
public void Analytics_Results() throws IOException{
	FileOutputStream fos= new FileOutputStream(file);
	@SuppressWarnings("resource")
	Workbook wb= new XSSFWorkbook();
	Sheet sh1= wb.createSheet("Corporate");
	Sheet sh2= wb.createSheet("Electronics");
	Sheet sh3= wb.createSheet("Building");
	Sheet sh4= wb.createSheet("Water");
	Sheet sh5= wb.createSheet("Transportation");
	Sheet sh6= wb.createSheet("Tedlar");
	Sheet sh7= wb.createSheet("N&B");
	Sheet sh8= wb.createSheet("Greatstuff");
	Sheet sh9= wb.createSheet("Safespec");
	Sheet sh10= wb.createSheet("PPE");
	Sheet sh11= wb.createSheet("Life Protection");
	Sheet sh12= wb.createSheet("CA");
	Sheet sh13= wb.createSheet("UK");
	Sheet sh14= wb.createSheet("CN");
	Sheet sh15= wb.createSheet("IN");
	wb.write(fos);
	}
}
