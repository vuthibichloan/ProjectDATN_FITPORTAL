package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {
	private static FileInputStream fis;
	private static Workbook wb;
	private static Sheet ws;
	private static Cell cell;
	private static String excelFilePath;
	private static Map<String, Integer> columns = new HashMap<String, Integer>();

//1. WORKING WITH EXCEL FILE
	// Cau truc 1 file Excel bao gom: WorkBook, WrokSheet, Row,Column, Cell
	// Thu vien Apache POI cung cap cac class de lam viec voi cac
	// thanh phan nay cua Excel
	// Phuong thuc tao file Excel neu chua co
	public static void setExcelFile(String ExcelPath, String SheetName) throws Exception {
		try {
			File f = new File(ExcelPath);

			if (!f.exists()) {
				f.createNewFile();
				System.out.println("File doesn't exist, so created!");
			}
			fis = new FileInputStream(ExcelPath);
			wb = WorkbookFactory.create(fis);
			ws = wb.getSheet(SheetName);
			if (ws == null) {
				ws = wb.createSheet(SheetName);
			}
			excelFilePath = ExcelPath;
			// adding all the column header names to the map 'columns'
			ws.getRow(0).forEach(cell -> {
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Sheet getSheet(String SheetName) {
		Sheet ws = wb.getSheet(SheetName);
		if (!isSheet(SheetName)) {
			ws = wb.createSheet(SheetName);
		}
		return ws;
	}

	public static boolean isSheet(String SheetName) {
		return wb.getSheetIndex(SheetName) >= 0;
	}

	// 3. WORKING WITH ROW IN EXCEL
	public static Row getRow(Sheet sheet, int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			row = sheet.createRow(rowIndex);
		}
		return row;
	}

	// This method is to get the row count used of the excel sheet
	public static int getRowCount(String SheetName) {
		ws = wb.getSheet(SheetName);
		int number = ws.getLastRowNum() + 1;
		return number;
	}

	// 4. WORKING WITH CELL IN EXCEL
	// Chi so hang/cot tren excel duoc tinh tu 0
	public static String getCellData(int rownum, int colnum) {
		try {
			cell = ws.getRow(rownum).getCell(colnum);
			String cellData = null;

			switch (cell.getCellType()) {
			case STRING:
				cellData = cell.getStringCellValue();
				break;
			case NUMERIC:
				cellData = String.valueOf(cell.getNumericCellValue());
				break;
			case BOOLEAN:
				cellData = Boolean.toString(cell.getBooleanCellValue());
				break;
			case BLANK:
				cellData = "";
				break;
			case FORMULA:
				cellData = cell.getCellFormula();
				break;
			default:
				break;
			}
			return cellData;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}

	public static String getCellData(String sheetName, int rowIndex, int colIndex) {
		Sheet sheet = getSheet(sheetName);
		Row row = getRow(sheet, rowIndex);
		Cell cell = getCell(row, colIndex);
		return cell.getStringCellValue();
	}

	public static Cell getCell(Row row, int colIndex) {
		Cell cell = row.getCell(colIndex - 1);
		if (cell == null) {
			cell = row.createCell(colIndex - 1);
		}
		return cell;
	}
}
