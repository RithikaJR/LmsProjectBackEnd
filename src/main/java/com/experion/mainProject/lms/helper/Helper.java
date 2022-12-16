package com.experion.mainProject.lms.helper;


import com.experion.mainProject.lms.entity.Employees;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of products

    public static List<Employees> convertExcelToListOfProduct(InputStream is) {
        List<Employees> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cellId = 0;

                Employees emp = new Employees();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cellId) {
                        case 0:
                            emp.setEmployeeId((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            emp.setEmployeeFirstName(cell.getStringCellValue());
                            break;
                        case 2:
                            emp.setEmployeeLastName(cell.getStringCellValue());
                            break;
                        case 3:
                            emp.setEmployeeEmail(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cellId++;

                }

                list.add(emp);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

}
