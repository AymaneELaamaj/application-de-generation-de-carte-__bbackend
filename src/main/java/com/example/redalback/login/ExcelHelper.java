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

public class ExcelHelper {
    public static boolean hasExcelFormat(MultipartFile file) {
        try {
            WorkbookFactory.create(file.getInputStream());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Communes> excelToCommunes(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Communes> communesList = new ArrayList<>();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();
                Communes commune = new Communes();
                int cellIdx = 0;

                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            commune.setQuartier(getCellValueAsString(currentCell));
                            break;
                        case 1:
                            if (currentCell.getCellType() == CellType.NUMERIC) {
                                commune.setDso_jr(BigDecimal.valueOf(currentCell.getNumericCellValue()));
                            }
                            break;
                        case 2:
                            commune.setImp_mdh(getCellValueAsString(currentCell));
                            break;
                        case 3:
                            commune.setNbrclient(getCellValueAsString(currentCell));
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                communesList.add(commune);
            }

            workbook.close();
            return communesList;

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
