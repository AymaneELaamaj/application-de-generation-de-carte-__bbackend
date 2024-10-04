package com.example.redalback.login;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelperTemara {
    public static boolean hasExcelFormat(MultipartFile file) {
        try {
            WorkbookFactory.create(file.getInputStream());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Temara> excelToTemara(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Temara> salesList = new ArrayList<>();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();
                Temara sale = new Temara();
                int cellIdx = 0;

                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            sale.setQuartier(getCellValueAsString(currentCell));
                            break;
                        case 1:
                            if (currentCell.getCellType() == CellType.NUMERIC) {
                                sale.setDso_jr(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            }
                            break;
                        case 2:
                            sale.setImp_mdh(getCellValueAsString(currentCell));
                            break;
                        case 3:
                            sale.setNbrclient(getCellValueAsString(currentCell));
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                salesList.add(sale);
            }

            workbook.close();
            return salesList;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return "";
        }
    }
}
