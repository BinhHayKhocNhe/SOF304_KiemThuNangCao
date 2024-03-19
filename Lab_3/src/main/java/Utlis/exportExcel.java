package Utlis;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.FileOutputStream;
import java.io.IOException;
public class exportExcel {
	public static void writeResultsToExcel(Result result, String filePath) throws IOException {
        Workbook workbook = new HSSFWorkbook(); // HSSFWorkbook for xls format, XSSFWorkbook for xlsx format
        Sheet sheet = workbook.createSheet("Test Results");
        
        // Create header row
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Test Case");
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Failure Message");

        // Populate data rows
        int rowNum = 1;
        for (Failure failure : result.getFailures()) {
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(failure.getDescription().getMethodName());
            cell = row.createCell(1);
            cell.setCellValue(failure.getMessage());
        }
        
        Row resultRow = sheet.createRow(rowNum);
        Cell resultCell = resultRow.createCell(0);
        resultCell.setCellValue("Result == " + result.wasSuccessful());
        // Write the workbook content to file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }

}
