package com.qq.util;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelUtil_wxj {
    public static List<HashMap<String, String>> readExcel(File file,String sheetName) throws IOException {
        // 创建一个list 用来存储读取的内容
        List<HashMap<String, String>> dataList = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file);
        @SuppressWarnings("resource")
        //加载sheet
        Sheet sh1 = workbook.getSheetAt(0);
        for (int i=1;i<sh1.getPhysicalNumberOfRows(); i++) {
            HashMap<String, String> line = new HashMap<String, String>();
            // 创建一个数组用来存储每一列的值
            String[] str = new String[sh1.getRow(i).getPhysicalNumberOfCells()];
            // 列数
            for (int j=1;j<sh1.getRow(i).getPhysicalNumberOfCells(); j++) {
                // 获取第i行，第j列的值
                str[j] = sh1.getRow(i).getCell(j).getStringCellValue();
                line.put(sh1.getRow(0).getCell(j).getStringCellValue(), str[j]);
            }
            dataList.add(line);
        }
        return dataList;
    }
}
