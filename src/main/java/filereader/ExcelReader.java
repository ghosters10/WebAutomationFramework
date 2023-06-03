package filereader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bo.TestcaseBO;

public class ExcelReader{
	
	public List<TestcaseBO> read() {

		// excel -> workbook
		// multiple sheets
		// row and col

		// create workbook
		XSSFWorkbook workbook = null;

		// read entire workbook
		try {
			workbook = new XSSFWorkbook("src/test/resources/testCases.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("InitialDraft");

		// get total rows in sheet
		int totalRows = sheet.getLastRowNum();

		// to create list of testcases
		List<TestcaseBO> testcaseList = new ArrayList<TestcaseBO>();

		// check if end of file is reached
		boolean isEndOfData = false;

		// iterate on all rows
		for (int i = 0; i < totalRows; i++) {
			// store data of each cell
			Map<String, String> testcaseMap = new HashedMap<String, String>();

			// total columns for each row
			int colNum = sheet.getRow(i).getLastCellNum();

			// iterate on each cell
			for (int j = 0; j < colNum; j++) {

				// get column header
				String key = sheet.getRow(0).getCell(j).getStringCellValue().toLowerCase();

				// to store cell value
				String value = null;
				try {

					// identify cell type to store corresponding value
					CellType cellType = sheet.getRow(i + 1).getCell(j).getCellType();

					switch (cellType) {
					case STRING:
						value = sheet.getRow(i + 1).getCell(j).getStringCellValue();
						break;
					case NUMERIC:
						value = String.valueOf(sheet.getRow(i + 1).getCell(j).getNumericCellValue());
						break;
					default:
						// store value is blank if does not match any type
						value = "";
					}

				} catch (NullPointerException e) {
					// store value as blank when cells are empty
					value = "";
				}

				// check if end of data
				if (value.equals("END")) {
					isEndOfData = true;
				} else
					testcaseMap.put(key, value);

			}

			// stop reading the file as we reahed end of data
			if (isEndOfData)
				break;

			// add data to BO
			if (testcaseMap.get("testcase_name") != ""
					&& testcaseMap.get(ConfigReader.getProperty("suiteToRun")).equals("Y")
					&& !testcaseMap.get("is_disabled").equals("Y")) {
				TestcaseBO testcase = new TestcaseBO();
				testcase.setTestcaseName(testcaseMap.get("testcase_name"));
				testcase.setPageName(testcaseMap.get("page_name"));

				testcaseList.add(testcase);
			}
		}
		System.out.println("Total Cases to Execute:: " + testcaseList.size());
		System.out.println("Testcases to execute:: " + testcaseList);

		return testcaseList;
	}

}
