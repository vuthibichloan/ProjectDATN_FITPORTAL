package executionEngine;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import keyword.ActionKeywords;
import report.*;
import utils.*;

public class ExecuteTest {
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String locatorType;
	public static String locatorValue;
	public static String testData;
	public static String testsuiteID;
	public static String Description;
	int CasePass = 0;
	int CaseFail = 0;
	int CaseSkip = 0;

	ArrayList<String> arrCasename = new ArrayList<String>();
	ArrayList<String> arrMatkhau = new ArrayList<String>();
	ArrayList<String> arrTaikhoan = new ArrayList<String>();
	ArrayList<String> arrResult = new ArrayList<String>();

	ArrayList<String> arrMadot = new ArrayList<String>();
	ArrayList<String> arrTendot = new ArrayList<String>();
	
	ArrayList<String> arrMaSV = new ArrayList<String>();
	ArrayList<String> arrTenSV = new ArrayList<String>();
	
	ArrayList<String> arrMaGV = new ArrayList<String>();
	ArrayList<String> arrTenGV = new ArrayList<String>();
	
	ArrayList<String> arrNoidung = new ArrayList<String>();
	ArrayList<String> arrLink = new ArrayList<String>();

	String sPath = System.getProperty("user.dir") + "\\src\\test\\resources\\dataEngine\\data.xlsx";

	@Ignore
	@Test
	public void testSuiteDotlamDATNPage() throws Exception {
		ExcelUtils.setExcelFile(sPath, "DotlamDATNPage");
		Sheet sheet = ExcelUtils.getSheet("DotlamDATNPage");
		int rowCount = sheet.getLastRowNum();
		int row = 1;
		String tmp;
		// Lay du lieu tung dong trong file Data dua vao tung mang arrI
		ExcelUtils.setExcelFile(sPath, "DotlamDATNPage");
		Sheet dataSheet = ExcelUtils.getSheet("DotlamDATNPage");
		int rowCountData = dataSheet.getLastRowNum();
		while (row <= rowCountData) {

			tmp = ExcelUtils.getCellData("DataDotlamDATN", row, 1) + "";
			arrCasename.add(tmp);

			tmp = ExcelUtils.getCellData("DataDotlamDATN", row, 2) + "";
			arrTaikhoan.add(tmp);

			tmp = ExcelUtils.getCellData("DataDotlamDATN", row, 3) + "";
			arrMatkhau.add(tmp);

			tmp = ExcelUtils.getCellData("DataDotlamDATN", row, 4) + "";
			arrMadot.add(tmp);

			tmp = ExcelUtils.getCellData("DataDotlamDATN", row, 5) + "";
			arrTendot.add(tmp);

			tmp = ExcelUtils.getCellData("DataDotlamDATN", row, 6) + "";
			arrResult.add(tmp);

			row = row + 1;
		}
		RecordVideo.startRecord("TestSuitetDotlamDATNPage");	
		// Ko lay hang tieu de dau tien		
				for (int i = 0; i < arrCasename.size(); i++) {
					if (i<=13) {
						for (int iRow = 1; iRow <= rowCount - 70; iRow++) {
							reuseDotlamDATN(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									arrMadot.get(i), arrTendot.get(i),null,null, null,null,null, arrResult.get(i));
						}
					}
					if (i==14 ) {
						for (int iRow = 14; iRow <= rowCount - 57; iRow++) {
							reuseDotlamDATN(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									arrMadot.get(i), arrTendot.get(i),null,null, null,null,null, arrResult.get(i));
						}
					}
					if (i==15 ) {
						for (int iRow = 27; iRow <= rowCount - 44; iRow++) {
							reuseDotlamDATN(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									arrMadot.get(i), arrTendot.get(i),null,null, null,null,null, arrResult.get(i));
						}
					}
					if (i==16 ) {
						for (int iRow = 40; iRow <= rowCount - 33; iRow++) {
							reuseDotlamDATN(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									arrMadot.get(i), arrTendot.get(i),null,null, null,null,null, arrResult.get(i));
						}
					}
					if (i==17 ) {
						for (int iRow = 51; iRow <= rowCount - 22; iRow++) {
							reuseDotlamDATN(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									arrMadot.get(i), arrTendot.get(i),null,null,null, null,null, arrResult.get(i));
						}
					}
					if (i==18 ) {
						for (int iRow = 62; iRow <= rowCount - 11; iRow++) {
							reuseDotlamDATN(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									arrMadot.get(i), arrTendot.get(i),null,null,null, null,null, arrResult.get(i));
						}
					}
					if (i==19 ) {
						for (int iRow = 73; iRow <= rowCount; iRow++) {
							reuseDotlamDATN(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									arrMadot.get(i), arrTendot.get(i),null,null,null,null, null, arrResult.get(i));
						}
					}
				}	
		RecordVideo.stopRecord();
		reportInConsole();
	}
	public void reuseDotlamDATN(int iRow) {
			System.out.println("Line:" + iRow);
			testsuiteID = ExcelUtils.getCellData("DotlamDATNPage", iRow, 1);
			Description = ExcelUtils.getCellData("DotlamDATNPage", iRow, 2);
			sActionKeyword = ExcelUtils.getCellData("DotlamDATNPage", iRow, 3);
			locatorType = ExcelUtils.getCellData("DotlamDATNPage", iRow, 4);
			locatorValue = ExcelUtils.getCellData("DotlamDATNPage", iRow, 5);
			testData = ExcelUtils.getCellData("DotlamDATNPage", iRow, 6);
			System.out.println(Description);

		}
	
	@Ignore
	@Test
	public void testSuiteBaocaokqlamDATN() throws Exception {
		ExcelUtils.setExcelFile(sPath, "BaocaoPage");
		Sheet sheet = ExcelUtils.getSheet("BaocaoPage");
		int rowCount = sheet.getLastRowNum();
		int row = 1;
		String tmp;
		// Lay du lieu tung dong trong file Data dua vao tung mang arrI
		ExcelUtils.setExcelFile(sPath, "BaocaoPage");
		Sheet dataSheet = ExcelUtils.getSheet("BaocaoPage");
		int rowCountData = dataSheet.getLastRowNum();
		while (row <= rowCountData) {

			tmp = ExcelUtils.getCellData("DataBaocao", row, 1) + "";
			arrCasename.add(tmp);

			tmp = ExcelUtils.getCellData("DataBaocao", row, 2) + "";
			arrTaikhoan.add(tmp);

			tmp = ExcelUtils.getCellData("DataBaocao", row, 3) + "";
			arrMatkhau.add(tmp);

			tmp = ExcelUtils.getCellData("DataBaocao", row, 4) + "";
			arrLink.add(tmp);

			tmp = ExcelUtils.getCellData("DataBaocao", row, 5) + "";
			arrResult.add(tmp);

			row = row + 1;
		}
		RecordVideo.startRecord("TestSuiteBaocaokqlamDATN");

		// Ko lay hang tieu de dau tien
		for (int i = 0; i < arrCasename.size(); i++) {
			if (i==0) {
				for (int iRow = 1; iRow <= rowCount - 129; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==1) {
				for (int iRow = 11; iRow <= rowCount - 119; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==2) {
				for (int iRow = 21; iRow <= rowCount - 108; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==3) {
				for (int iRow = 32; iRow <= rowCount - 98; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==4) {
				for (int iRow = 42; iRow <= rowCount - 88; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==5) {
				for (int iRow = 52; iRow <= rowCount -78; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==6) {
				for (int iRow = 62; iRow <= rowCount - 68; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==7) {
				for (int iRow = 72; iRow <= rowCount - 58; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==8) {
				for (int iRow = 82; iRow <= rowCount - 48; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==9) {
				for (int iRow = 92; iRow <= rowCount - 37; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==10) {
				for (int iRow = 103; iRow <= rowCount - 24; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==11) {
				for (int iRow = 116; iRow <= rowCount - 11; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
			if (i==12) {
				for (int iRow = 129; iRow <= rowCount; iRow++) {
					reuseBaoCao(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null,null, null, null, arrLink.get(i), arrResult.get(i));
				}
			}
		}
		RecordVideo.stopRecord();
		reportInConsole();		
		
	}
	public void reuseBaoCao(int iRow) {
		System.out.println("Line:" + iRow);
		testsuiteID = ExcelUtils.getCellData("BaocaoPage", iRow, 1);
		Description = ExcelUtils.getCellData("BaocaoPage", iRow, 2);
		sActionKeyword = ExcelUtils.getCellData("BaocaoPage", iRow, 3);
		locatorType = ExcelUtils.getCellData("BaocaoPage", iRow, 4);
		locatorValue = ExcelUtils.getCellData("BaocaoPage", iRow, 5);
		testData = ExcelUtils.getCellData("BaocaoPage", iRow, 6);
		System.out.println(Description);

	}
	
	@Ignore
	@Test 
	public void testSuiteQLCanBoGiangVienPage() throws Exception {
		ExcelUtils.setExcelFile(sPath, "QLcanboGVPage");
		Sheet sheet = ExcelUtils.getSheet("QLcanboGVPage");
		int rowCount = sheet.getLastRowNum();
		int row = 1;
		String tmp;
		// Lay du lieu tung dong trong file Data dua vao tung mang arrI
		ExcelUtils.setExcelFile(sPath, "DataQLcanboGV");
		Sheet dataSheet = ExcelUtils.getSheet("DataQLcanboGV");
		int rowCountData = dataSheet.getLastRowNum();
		while (row <= rowCountData) {

			tmp = ExcelUtils.getCellData("DataQLcanboGV", row, 1) + "";
			arrCasename.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLcanboGV", row, 2) + "";
			arrTaikhoan.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLcanboGV", row, 3) + "";
			arrMatkhau.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLcanboGV", row, 4) + "";
			arrMaGV.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLcanboGV", row, 5) + "";
			arrTenGV.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLcanboGV", row, 6) + "";
			arrResult.add(tmp);

			row = row + 1;
		}
		RecordVideo.startRecord("testSuiteQLCanBoGiangVienPage");

		// Ko lay hang tieu de dau tien
		for (int i = 0; i < arrCasename.size(); i++) {
			if (i<=11) {
				for (int iRow = 1; iRow <= rowCount - 48; iRow++) {
					reuseQLGV(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null, null,arrMaGV.get(i), arrTenGV.get(i),null,  arrResult.get(i));
				}
			}
			if (i==12 ) {
				for (int iRow = 14; iRow <= rowCount - 35; iRow++) {
					reuseQLGV(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null, null,arrMaGV.get(i), arrTenGV.get(i), null,arrResult.get(i));
				}
			}
			if (i==13 || i== 14 ) {
				for (int iRow = 27; iRow <= rowCount - 22; iRow++) {
					reuseQLGV(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null, null,arrMaGV.get(i), arrTenGV.get(i),null, arrResult.get(i));
				}
			}
			if (i==15 ) {
				for (int iRow = 40; iRow <= rowCount - 11; iRow++) {
					reuseQLGV(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null, null,arrMaGV.get(i), arrTenGV.get(i),null,arrResult.get(i));
				}
			}
			if (i==16 ) {
				for (int iRow = 51; iRow <= rowCount; iRow++) {
					reuseQLGV(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
							null, null,null, null,arrMaGV.get(i), arrTenGV.get(i),null, arrResult.get(i));
				}
			}
		}
		RecordVideo.stopRecord();
		reportInConsole();
	}
	public void reuseQLGV(int iRow) {
		System.out.println("Line:" + iRow);
		testsuiteID = ExcelUtils.getCellData("QLcanboGVPage", iRow, 1);
		Description = ExcelUtils.getCellData("QLcanboGVPage", iRow, 2);
		sActionKeyword = ExcelUtils.getCellData("QLcanboGVPage", iRow, 3);
		locatorType = ExcelUtils.getCellData("QLcanboGVPage", iRow, 4);
		locatorValue = ExcelUtils.getCellData("QLcanboGVPage", iRow, 5);
		testData = ExcelUtils.getCellData("QLcanboGVPage", iRow, 6);
		System.out.println(Description);

	}
	
	@Ignore
	@Test 
	public void testSuiteQLSinhVienPage() throws Exception {
		ExcelUtils.setExcelFile(sPath, "QLSinhVienPage");
		Sheet sheet = ExcelUtils.getSheet("QLSinhVienPage");
		int rowCount = sheet.getLastRowNum();
		int row = 1;
		String tmp;
		// Lay du lieu tung dong trong file Data dua vao tung mang arrI
		ExcelUtils.setExcelFile(sPath, "DataQLSinhVien");
		Sheet dataSheet = ExcelUtils.getSheet("DataQLSinhVien");
		int rowCountData = dataSheet.getLastRowNum();
		while (row <= rowCountData) {

			tmp = ExcelUtils.getCellData("DataQLSinhVien", row, 1) + "";
			arrCasename.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLSinhVien", row, 2) + "";
			arrTaikhoan.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLSinhVien", row, 3) + "";
			arrMatkhau.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLSinhVien", row, 4) + "";
			arrMaSV.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLSinhVien", row, 5) + "";
			arrTenSV.add(tmp);

			tmp = ExcelUtils.getCellData("DataQLSinhVien", row, 6) + "";
			arrResult.add(tmp);

			row = row + 1;
		}
		RecordVideo.startRecord("testSuiteQLSinhVienPage");
		// Ko lay hang tieu de dau tien
				for (int i = 0; i < arrCasename.size(); i++) {
					if (i<=11) {
						for (int iRow = 1; iRow <= rowCount - 48; iRow++) {
							reuseQLSV(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									null, null, arrMaSV.get(i), arrTenSV.get(i), null, null,null, arrResult.get(i));
						}
					}
					if (i==12 ) {
						for (int iRow = 14; iRow <= rowCount - 35; iRow++) {
							reuseQLSV(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									null, null, arrMaSV.get(i), arrTenSV.get(i), null, null, null, arrResult.get(i));
						}
					}
					if (i==13 || i== 14 ) {
						for (int iRow = 27; iRow <= rowCount - 22; iRow++) {
							reuseQLSV(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									null, null, arrMaSV.get(i), arrTenSV.get(i), null, null, null, arrResult.get(i));
						}
					}
					if (i==15 ) {
						for (int iRow = 40; iRow <= rowCount - 11; iRow++) {
							reuseQLSV(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									null, null, arrMaSV.get(i), arrTenSV.get(i), null, null,null, arrResult.get(i));
						}
					}
					if (i==16 ) {
						for (int iRow = 51; iRow <= rowCount; iRow++) {
							reuseQLSV(iRow);
							execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i),
									null, null, arrMaSV.get(i), arrTenSV.get(i), null, null, null, arrResult.get(i));
						}
					}
				}
		RecordVideo.stopRecord();
		reportInConsole();
	}
	public void reuseQLSV(int iRow) {
		System.out.println("Line:" + iRow);
		testsuiteID = ExcelUtils.getCellData("QLSinhVienPage", iRow, 1);
		Description = ExcelUtils.getCellData("QLSinhVienPage", iRow, 2);
		sActionKeyword = ExcelUtils.getCellData("QLSinhVienPage", iRow, 3);
		locatorType = ExcelUtils.getCellData("QLSinhVienPage", iRow, 4);
		locatorValue = ExcelUtils.getCellData("QLSinhVienPage", iRow, 5);
		testData = ExcelUtils.getCellData("QLSinhVienPage", iRow, 6);
		System.out.println(Description);

	}
	
	@Ignore
	@Test
	public void testSuiteDangNhap() throws Exception {
		ExcelUtils.setExcelFile(sPath, "DangNhapPage");
		Sheet sheet = ExcelUtils.getSheet("DangNhapPage");
		int rowCount = sheet.getLastRowNum();
		int row = 1;
		String tmp;
		// Lay du lieu tung dong trong file Data dua vao tung mang arrI
		ExcelUtils.setExcelFile(sPath, "DataDangNhap");
		Sheet dataSheet = ExcelUtils.getSheet("DataDangNhap");
		int rowCountData = dataSheet.getLastRowNum();
		while (row <= rowCountData) {
			tmp = ExcelUtils.getCellData("DataDangNhap", row, 1) + "";
			arrCasename.add(tmp);
			
			tmp = ExcelUtils.getCellData("DataDangNhap", row, 2) + "";
			arrTaikhoan.add(tmp);

			tmp = ExcelUtils.getCellData("DataDangNhap", row, 3) + "";
			arrMatkhau.add(tmp);

			tmp = ExcelUtils.getCellData("DataDangNhap", row, 4) + "";
			arrResult.add(tmp);

			row = row + 1;
		}

		RecordVideo.startRecord("TestSuiteDangNhap");

		// Ko lay hang tieu de dau tien
		for (int i = 0; i < arrCasename.size(); i++) {
			if (i == 0) {
				for (int iRow = 1; iRow <= rowCount - 8; iRow++) {
					reuseDangNhap(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i), null,
							null,null, null, null, null, null,arrResult.get(i));
				}
			}			
			if (i>=1 && i<=15 ) {
				for (int iRow = 9; iRow <= rowCount; iRow++) {
					reuseDangNhap(iRow);
					execute_Actions(testsuiteID, testData, arrCasename.get(i), arrTaikhoan.get(i), arrMatkhau.get(i), null,
							null,null, null, null, null, null,arrResult.get(i));
				}
			}
		}
		RecordVideo.stopRecord();
		reportInConsole();
	}
	public void reuseDangNhap(int iRow) {
		System.out.println("Line:" + iRow);
		testsuiteID = ExcelUtils.getCellData("DangNhapPage", iRow, 1);
		Description = ExcelUtils.getCellData("DangNhapPage", iRow, 2);
		sActionKeyword = ExcelUtils.getCellData("DangNhapPage", iRow, 3);
		locatorType = ExcelUtils.getCellData("DangNhapPage", iRow, 4);
		locatorValue = ExcelUtils.getCellData("DangNhapPage", iRow, 5);
		testData = ExcelUtils.getCellData("DangNhapPage", iRow, 6);
		System.out.println(Description);

	}
	public void execute_Actions(String testSuiteID, String testData, String CaseName, String sTaiKhoan, String sMatKhau,
			String sMaDot, String sTenDot, String sMaSV, String sTenSV, String sMaGV,
			String sTenGV, String sLink, String sResult) throws Exception {

		switch (sActionKeyword) {
			case "openBrowser":
				if (CaseName != null) {
						LogUtils.info("--------------Thực thi Test Case ID: " + CaseName + "--------------");						
				}
				ExtentTestManager.saveToReport(CaseName, "");
				try {
					ActionKeywords.openBrowser(testData);
					LogUtils.info("Executing: Open browser: " + testData);
					ExtentTestManager.logMessage(Status.PASS, Description);
				} catch (Exception e) {
					LogUtils.error("Executing: Open browser: " + testData + " FAIL");
					ExtentTestManager.logMessage(Status.FAIL, Description);
				}
				break;
			
			case "navigate":
				try {
					ActionKeywords.navigate(testData);
					LogUtils.info("Executing: Open Url: " + testData);
					ExtentTestManager.logMessage(Status.PASS, Description);
				} catch (Exception e) {
					LogUtils.error("Executing: Open Url:" + testData + " FAIL");
					ExtentTestManager.logMessage(Status.FAIL, Description);
				}

				break;
			case "setText":
				if (testData.equalsIgnoreCase("varTaiKhoan")) {
					try {
						ActionKeywords.setText(locatorType, locatorValue, sTaiKhoan);
						LogUtils.info("Executing: Enter text: " + sTaiKhoan);
						ExtentTestManager.logMessage(Status.PASS, Description);
					} catch (NoSuchElementException e) {
						LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue + " not found to sendKeys| "
								+ e.getMessage());
						ExtentTestManager.logMessage(Status.FAIL, Description);
					}
				} else {
					if (testData.equalsIgnoreCase("varMatKhau")) {
						try {
							ActionKeywords.setText(locatorType, locatorValue, sMatKhau);
							LogUtils.info("Executing: Enter text: " + sMatKhau);
							ExtentTestManager.logMessage(Status.PASS, Description);
						} catch (NoSuchElementException e) {
							LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue + " not found to sendKeys| "
									+ e.getMessage());
							ExtentTestManager.logMessage(Status.FAIL, Description);
						}
					} else {
						if (testData.equalsIgnoreCase("varMaDot")) {
							try {
								ActionKeywords.setText(locatorType, locatorValue, sMaDot);
								LogUtils.info("Executing: Enter text: " + sMaDot);
								ExtentTestManager.logMessage(Status.PASS, Description);
							} catch (NoSuchElementException e) {
								LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue
										+ " not found to sendKeys| " + e.getMessage());
								ExtentTestManager.logMessage(Status.FAIL, Description);
							}
						} else {
							 if (testData.equalsIgnoreCase("varTenDot")) {
								 try {
										ActionKeywords.setText(locatorType, locatorValue, sTenDot);
										LogUtils.info("Executing: Enter text: " + sTenDot);
										ExtentTestManager.logMessage(Status.PASS, Description);
									} catch (NoSuchElementException e) {
										LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue
												+ " not found to sendKeys| " + e.getMessage());
										ExtentTestManager.logMessage(Status.FAIL, Description);
									}
							} else {
								if (testData.equalsIgnoreCase("varMaSV")) {
									 try {
											ActionKeywords.setText(locatorType, locatorValue, sMaSV);
											LogUtils.info("Executing: Enter text: " + sMaSV);
											ExtentTestManager.logMessage(Status.PASS, Description);
										} catch (NoSuchElementException e) {
											LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue
													+ " not found to sendKeys| " + e.getMessage());
											ExtentTestManager.logMessage(Status.FAIL, Description);
										}
								} else {
									if (testData.equalsIgnoreCase("varTenSV")) {
										 try {
												ActionKeywords.setText(locatorType, locatorValue, sTenSV);
												LogUtils.info("Executing: Enter text: " + sTenSV);
												ExtentTestManager.logMessage(Status.PASS, Description);
											} catch (NoSuchElementException e) {
												LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue
														+ " not found to sendKeys| " + e.getMessage());
												ExtentTestManager.logMessage(Status.FAIL, Description);
											}
									} else {
										if (testData.equalsIgnoreCase("varMaGV")) {
											 try {
													ActionKeywords.setText(locatorType, locatorValue, sMaGV);
													LogUtils.info("Executing: Enter text: " + sMaGV);
													ExtentTestManager.logMessage(Status.PASS, Description);
												} catch (NoSuchElementException e) {
													LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue
															+ " not found to sendKeys| " + e.getMessage());
													ExtentTestManager.logMessage(Status.FAIL, Description);
												}
										} else {
											if (testData.equalsIgnoreCase("varTenGV")) {
												try {
													ActionKeywords.setText(locatorType, locatorValue, sTenGV);
													LogUtils.info("Executing: Enter text: " + sTenGV);
													ExtentTestManager.logMessage(Status.PASS, Description);
												} catch (NoSuchElementException e) {
													LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue
															+ " not found to sendKeys| " + e.getMessage());
													ExtentTestManager.logMessage(Status.FAIL, Description);
												}
											} else {
												try {
													ActionKeywords.setText(locatorType, locatorValue, sLink);
													LogUtils.info("Executing: Enter text: " + sLink);
													ExtentTestManager.logMessage(Status.PASS, Description);
												} catch (NoSuchElementException e) {
													LogUtils.error("SendKeys:" + locatorType + "=" + locatorValue
															+ " not found to sendKeys| " + e.getMessage());
													ExtentTestManager.logMessage(Status.FAIL, Description);
												}																								
											}
										}
									}
								}
							}
						}
					}
				}
				break;
			case "clickbutton":
				try {
					ActionKeywords.clickElement(locatorType, locatorValue);
					LogUtils.info("Executing: Click element: " + locatorValue);
					ExtentTestManager.logMessage(Status.PASS, Description);
				} catch (NoSuchElementException e) {
					LogUtils.error("Click:" + locatorValue + " not found to click " + e.getMessage());
					ExtentTestManager.logMessage(Status.FAIL, Description);
				}
				break;
			case "verifyUrl":
				if (ActionKeywords.verifyUrl(sResult)) {										
					CasePass++;
					LogUtils.info("Same result ---> pass");
					ExtentTestManager.logMessage(Status.PASS, Description);
				} else {
					CaseFail++;
					LogUtils.error("Different result ---> Fail");
					ExtentTestManager.addScreenShot(Status.FAIL, Description);
				} 
			break;
			case "verifyElementText":
				if (ActionKeywords.verifyText(locatorType, locatorValue, sResult)) {										
						CasePass++;
						LogUtils.info("Same result ---> pass");
						ExtentTestManager.logMessage(Status.PASS, Description);
					} else {
						CaseFail++;
						LogUtils.error("Different result ---> Fail");
						ExtentTestManager.addScreenShot(Status.FAIL, Description);
					} 
				break;
			case "verifyLoginTrue":
                if (ActionKeywords.verifyLoginTrue(sResult)) {
                	LogUtils.info("Same result ---> pass");
                    CasePass++;
                    ExtentTestManager.logMessage(Status.PASS, Description);
                } else {
                	LogUtils.error("Different result ---> Fail");
                    CaseFail++;
                    ExtentTestManager.addScreenShot(Status.FAIL, Description);
                }
                break;
			case "verifyLoginFalse":
                if (ActionKeywords.verifyLoginFalse(sResult)) {
                	LogUtils.info("Same result ---> pass");
                    CasePass++;
                    ExtentTestManager.logMessage(Status.PASS, Description);
                } else {
                	LogUtils.error("Different result ---> Fail");
                    CaseFail++;
                    ExtentTestManager.addScreenShot(Status.FAIL, Description);
                }
                break;
			case "verifySearchProject":
				if (ActionKeywords.verifySearchProject(sResult)) {
                	LogUtils.info("Same result ---> pass");
                    CasePass++;
                    ExtentTestManager.logMessage(Status.PASS, Description);
                } else {
                	LogUtils.error("Different result ---> Fail");
                    CaseFail++;
                    ExtentTestManager.addScreenShot(Status.FAIL, Description);
                }
                break;			
			case "verifySearchStudent":
				if (ActionKeywords.verifySearchStudent(sResult)) {
                	LogUtils.info("Same result ---> pass");
                    CasePass++;
                    ExtentTestManager.logMessage(Status.PASS, Description);
                } else {
                	LogUtils.error("Different result ---> Fail");
                    CaseFail++;
                    ExtentTestManager.addScreenShot(Status.FAIL, Description);
                }
                break;
			
			case "verifySearchTeacher":
				if (ActionKeywords.verifySearchTeacher(sResult)) {
                	LogUtils.info("Same result ---> pass");
                    CasePass++;
                    ExtentTestManager.logMessage(Status.PASS, Description);
                } else {
                	LogUtils.error("Different result ---> Fail");
                    CaseFail++;
                    ExtentTestManager.addScreenShot(Status.FAIL, Description);
                }
                break;
			
			case "screenshot":
				if (testSuiteID.equalsIgnoreCase("varTestCaseID")) {
					try {
						ActionKeywords.screenshot(CaseName);
						LogUtils.info("Executing: Screenshot taken: " + CaseName);
						ExtentTestManager.logMessage(Status.PASS, Description);
					} catch (Exception e) {
						LogUtils.error("Executing: Screenshot taken: " + CaseName + "FAIL");
						ExtentTestManager.logMessage(Status.FAIL, Description);
					}
				}
				else {
					try {
						ActionKeywords.screenshot(testSuiteID);
						LogUtils.info("Executing: Screenshot taken: " + testSuiteID );
						ExtentTestManager.logMessage(Status.PASS, Description);
					} catch (Exception e) {
						LogUtils.error("Executing: Screenshot taken: " + testSuiteID + "FAIL");
						ExtentTestManager.logMessage(Status.FAIL, Description);
					}
				}
				break;
			case "closeBrowser":
				try {
					ActionKeywords.quitDriver();
					LogUtils.info("Executing: Close brower");
					ExtentTestManager.logMessage(Status.PASS, Description);
				} catch (Exception e) {
					LogUtils.info("Executing: Closse brower FAIL");
					ExtentTestManager.logMessage(Status.FAIL, Description);
				}
				break;
			}

		ExtentManager.getExtentReports().flush();
	}
	public void reportInConsole() {
		java.util.Date date = new java.util.Date();
		System.out.println("==========================================================");
		System.out.println("-----------" + date + "--------------");
		System.out.println("Total number of Testcases run: " + (CasePass + CaseFail + CaseSkip));
		System.out.println("Total number of passed Testcases: " + CasePass);
		System.out.println("Total number of failed Testcases: " + CaseFail);
		System.out.println("Total number of skip Testcases: " + CaseSkip);
		System.out.println("==========================================================");
	}
}
