package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

public class FWUtil 
{
public static String getXlData(String path,String Sheet,int r,int c)
{	
String v = "";
{
	try
	{

      Workbook wb= WorkbookFactory.create(new FileInputStream(path));

      v = wb.getSheet(Sheet).getRow(r).getCell(c).toString();

    }
	catch(Exception e)
			 {}
	return v;
}
}


public static int getXlRowCount(String path,String Sheet)
{
int count=0;
    try {
	     Workbook wb= WorkbookFactory.create(new FileInputStream(path));
	     count = wb.getSheet(Sheet).getLastRowNum();
        }
    catch(Exception e)
     {
        e.printStackTrace();
     }
return count;
}


public static void SetXlData(String path,String Sheet,int r,int c,String v)
{
    try {
	     Workbook wb= WorkbookFactory.create(new FileInputStream(path));
	     wb.getSheet(Sheet).getRow(r).getCell(c).setCellValue(v);
	     wb.write(new FileOutputStream(path));
        }
    catch(Exception e)
     {
        e.printStackTrace();
     }
}


public static void getphoto(WebDriver driver,String path)
{
    try {
	     TakeScreenShort t = (TakeScreenShort)driver;
	     File File = t.getScreenshortAs(OutputType.FILE);
	     File dstfile = new File(path);
	     FileUtils.copyFile(File,dstfile);
	     
    }
	     
    catch(Exception e)
     {
        e.printStackTrace();
     }

}

}
