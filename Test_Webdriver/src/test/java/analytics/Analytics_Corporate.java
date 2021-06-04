package analytics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.testng.annotations.Test;

public class Analytics_Corporate {
	int rownr=0;
	@Test(priority=0)
	public void HeaderValues() throws IOException{
		setCellData("Corporate",0,0,"SL No");
		setCellData("Corporate",1,0,"Method");
		setCellData("Corporate",2,0,"Value");
		setCellData("Corporate",3,0,"Pass/Fail");
	}
	@Test(priority=1)
	public void reportSuiteIds() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "dupontphoenixglobalnew";
		setCellData("Corporate",0,1,"1");
		setCellData("Corporate",1,1,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,1, Value);
		setCellData("Corporate",3,1,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=2)
	public void eVar1() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("eVar 1");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "https://www.dupont.com";
		setCellData("Corporate",0,2,"2");
		setCellData("Corporate",1,2,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,2,Value);
		setCellData("Corporate",3,2,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=3)
	public void eVar6() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("eVar 6");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "United States";
		setCellData("Corporate",0,3,"3");
		setCellData("Corporate",1,3,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,3,Value);
		setCellData("Corporate",3,3,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=4)
	public void eVar9() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("eVar 9");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "English";
		setCellData("Corporate",0,4,"4");
		setCellData("Corporate",1,4,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,4,Value);
		setCellData("Corporate",3,4,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=5)
	public void eVar31() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("eVar 31");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "www.dupont.com";
		setCellData("Corporate",0,5,"5");
		setCellData("Corporate",1,5,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,5,Value);
		setCellData("Corporate",3,5,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=6)
	public void eVar34() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("eVar 34");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "dp:corporate-homepage";
		setCellData("Corporate",0,6,"6");
		setCellData("Corporate",1,6,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,6,Value);
		setCellData("Corporate",3,6,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=7)
	public void Server() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "www.dupont.com";
		setCellData("Corporate",0,7,"7");
		setCellData("Corporate",1,7,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,7,Value);
		setCellData("Corporate",3,7,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=8)
	public void Events() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "event88";
		setCellData("Corporate",0,8,"8");
		setCellData("Corporate",1,8,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,8,Value);
		setCellData("Corporate",3,8,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=9)
	public void Prop6() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("Prop 6");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "United States";
		setCellData("Corporate",0,9,"9");
		setCellData("Corporate",1,9,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,9,Value);
		setCellData("Corporate",3,9,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=10)
	public void Prop32() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("Prop 32");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value ="dp:corporate-homepage";
		setCellData("Corporate",0,10,"10");
		setCellData("Corporate",1,10,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,10,Value);
		setCellData("Corporate",3,10,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=11)
	public void Prop70() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("Prop 70");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value ="D=v70";
		setCellData("Corporate",0,11,"11");
		setCellData("Corporate",1,11,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,11,Value);
		setCellData("Corporate",3,11,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=12)
	public void Hostname() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value ="dupont.d2.sc.omtrdc.net";
		setCellData("Corporate",0,12,"12");
		setCellData("Corporate",1,12,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,12,Value);
		setCellData("Corporate",3,12,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=13)
	public void Initiator() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value ="https://www.dupont.com";
		setCellData("Corporate",0,13,"13");
		setCellData("Corporate",1,13,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,13,Value);
		setCellData("Corporate",3,13,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=14)
	public void cookieType() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value ="Third";
		setCellData("Corporate",0,14,"14");
		setCellData("Corporate",1,14,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,14,Value);
		setCellData("Corporate",3,14,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=15)
	public void trackingServer() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value ="dupont.d2.sc.omtrdc.net";
		setCellData("Corporate",0,15,"15");
		setCellData("Corporate",1,15,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,15,Value);
		setCellData("Corporate",3,15,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=16)
	public void version() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value ="JS-2.9.0-D7QN";
		setCellData("Corporate",0,16,"16");
		setCellData("Corporate",1,16,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,16,Value);
		setCellData("Corporate",3,16,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=17)
	public void characterset() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("Character Set");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value ="UTF-8";
		setCellData("Corporate",0,17,"17");
		setCellData("Corporate",1,17,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,17,Value);
		setCellData("Corporate",3,17,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=18)
	public void colorquality() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("Color quality");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "24";
		setCellData("Corporate",0,18,"18");
		setCellData("Corporate",1,18,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,18,Value);
		setCellData("Corporate",3,18,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=19)
	public void cookiesenabled() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("Cookies Enabled");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "Y";
		setCellData("Corporate",0,19,"19");
		setCellData("Corporate",1,19,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,19,Value);
		setCellData("Corporate",3,19,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=20)
	public void CurrencyCode() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow("Currency Code");
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "USD";
		setCellData("Corporate",0,20,"20");
		setCellData("Corporate",1,20,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,20,Value);
		setCellData("Corporate",3,20,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=21)
	public void Referrer() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "https://www.dupont.com";
		setCellData("Corporate",0,21,"21");
		setCellData("Corporate",1,21,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,21,Value);
		setCellData("Corporate",3,21,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	@Test(priority=22)
	public void Resolution() throws IOException {
		XSSFSheet sh = getName();
		rownr = findRow(Thread.currentThread().getStackTrace()[1].getMethodName());
		String Var = sh.getRow(rownr).getCell(1).getStringCellValue();
		String Value = "1366x768";
		setCellData("Corporate",0,22,"22");
		setCellData("Corporate",1,22,Thread.currentThread().getStackTrace()[1].getMethodName());
		String Result;
		if(Var.contains(Value)) {Result = "Pass";} else {Result = "Fail";}
		setCellData("Corporate",2,22,Value);
		setCellData("Corporate",3,22,Result );
		Assert.assertTrue(Var.contains(Value));
	}
	
public XSSFSheet getName() throws IOException{
	
	File src = new File(xlFileinputPath);
	XSSFSheet sh = null;
	try{
		FileInputStream redirects = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook excel = new XSSFWorkbook(redirects);
		sh = excel.getSheetAt(0);
	}
	catch (FileNotFoundException e){
		e.printStackTrace();
	}
	return sh;
}
public FileInputStream fis = null;
public FileOutputStream fos = null;
public XSSFWorkbook workbook = null;
public XSSFSheet sheet = null;
public XSSFRow row = null;
public XSSFCell cell = null;
Date date = java.util.Calendar.getInstance().getTime();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
String strDate = dateFormat.format(date);
String xlFilePath = "D:\\Suresh\\Analytics_Results_"+strDate+".xlsx";
String xlFileinputPath = "D:\\Suresh\\Analytics_Corporate.xlsx";


public XSSFSheet setCellData(String sheetName, int colNumber, int rowNum, String value){
	try{
		FileInputStream fis = new FileInputStream(xlFilePath);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
    sheet = workbook.getSheet(sheetName);
    row = sheet.getRow(rowNum);
    if(row==null)
        row = sheet.createRow(rowNum);
    	cell = row.getCell(colNumber);
    		if(cell == null)
    			cell = row.createCell(colNumber);
    			cell.setCellValue(value);
    			fos = new FileOutputStream(xlFilePath);
    			workbook.write(fos);
    			fos.close();
		}
	catch (Exception ex)
	{
    ex.printStackTrace();
	}
return sheet;
}
private int findRow(String cellContent) throws IOException {
    FileInputStream input = new FileInputStream(xlFileinputPath);
    @SuppressWarnings("resource")
	XSSFWorkbook wb = new XSSFWorkbook(input);
    XSSFSheet sheet = wb.getSheetAt(0);
    for (Row row : sheet) {
        for (Cell cell : row) {
            if (cell.getCellType() == CellType.STRING) {
                if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                    return row.getRowNum();  
                }
            }
        }
    }               
	return 0;
}
}
