package dataproviders;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object [][] getDataFromExcel(String sheetName) 
	{
		XSSFWorkbook wb;
		Object [][] arr=null;
		try 
		{
			File src = new File("./TestData/ApplicationTestData.xlsx"); //pointed out the location using File
			wb = new XSSFWorkbook(src);
			XSSFSheet sheet1=wb.getSheet(sheetName);	//using sheet in this WB XSSFSheet
			int row=sheet1.getPhysicalNumberOfRows();	//using this sheet to get number of rows
			int columns=sheet1.getRow(0).getPhysicalNumberOfCells(); //using same reference to get columns and gets the data using rows
			
			System.out.println("***Number of Test to be Executed *** " +row);
			System.out.println("***Number of Columns to be Passed *** " +columns);
			
			arr= new Object[row][columns]; 	//Two dimension arrays using rows and columns for dumping the 
			      										//data and running two loops outer and inner loops
			for(int i=0; i<row; i++) 
			{
				for(int j=0; j<columns; j++) 
				{
					arr [i][j]=sheet1.getRow(i).getCell(j).getStringCellValue(); //using this for dumping the data in array
				}
			}
			wb.close();
		} catch (InvalidFormatException e) 
		{
			System.out.println("Sorry we don't support this format " + e.getMessage());
		} catch (IOException e) 
		{
			System.out.println("Somthing went wrong could not read the excel " + e.getMessage());
		}
		
		return arr;
		
		
	}

}
