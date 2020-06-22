package com.yh.xuanweilun.utils;

import com.yh.xuanweilun.entity.EquityDTO;
import com.yh.xuanweilun.entity.EquityProductDTO;
import com.yh.xuanweilun.entity.EquityTypeDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelTools {
    //分类列
    private static final int type_column = 0;
    //权益类型列
    private static final int equity_type_column = 1;
    //产品id列
    private static final int productId_column = 2;
    //产品名称列
    private static final int productName_colum = 3;
    //权益id列
    private static final int equityId_column = 4;
    //权益名称列
    private static final int equityName_column = 5;

    public static ExcelResult dealExcel(InputStream in, String fileName){
        List listResult = new ArrayList<>();
        Workbook work = getWorkBook(in, fileName);
        if (null == work) {
            return new ExcelResult(false,"创建Excel工作薄为空！",null);
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        List<EquityTypeDTO> equityTypeDTOS = new ArrayList<>();
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            //获取合并区域
            List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
            for (CellRangeAddress mergedRegion : mergedRegions) {
                int firstColumn = mergedRegion.getFirstColumn();
                //如果合并区域不是分类列
                if(type_column != firstColumn){
                    continue;
                }
                int firstRow = mergedRegion.getFirstRow();
                int lastRow = mergedRegion.getLastRow();
                row = sheet.getRow(firstRow);
                //获得分类
                String type = row.getCell(type_column).toString();
                //获取权益类型
                String equityType = row.getCell(equity_type_column).toString();
                EquityTypeDTO equityTypeDTO = new EquityTypeDTO();
                equityTypeDTO.setType(type);
                equityTypeDTO.setEquityType(equityType);
                equityTypeDTOS.add(equityTypeDTO);
                for (int j = firstRow; j <= lastRow; j++) {
                    row = sheet.getRow(j);
                    //获取 产品id和产品名称
                    cell = row.getCell(productId_column);
                    cell.setCellType(CellType.STRING);
                    String productId = cell.getStringCellValue();
                    String productName = row.getCell(productName_colum).toString();
                    if (null != productId && !"".equals(productId)
                            && null != productName && !"".equals(productName)) {
                        EquityProductDTO equityProductDTO = new EquityProductDTO();
                        equityProductDTO.setName(productName);
                        equityProductDTO.setProductId(productId);
                        equityTypeDTO.addEquityProduct(equityProductDTO);
                    }
                    //获取 权益id和权益名称
                    cell = row.getCell(equityId_column);
                    cell.setCellType(CellType.STRING);
                    String equityId = cell.getStringCellValue();
                    String equityName = row.getCell(equityName_column).toString();
                    if(null != equityId && !"".equals(equityId)
                            && null != equityName && !"".equals(equityName)){
                        EquityDTO equityDTO = new EquityDTO();
                        equityDTO.setProductId(equityId);
                        equityDTO.setName(equityName);
                        equityTypeDTO.addEquityDTO(equityDTO);
                    }
                    
                }
            }
            //


        }
        return new ExcelResult(true,null,equityTypeDTOS);
    }


    private static Workbook getWorkBook(InputStream inputStream, String fileName) {
        try {
            //判断什么类型文件
            if (fileName.endsWith(".xls")) {
                return new HSSFWorkbook(inputStream);
            } else if (fileName.endsWith(".xlsx")) {
                return new XSSFWorkbook(inputStream);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author xuanweilun
     * @Description //获取单元格的值
     * @Date 18:10 2020/6/5
     * @Param
     * @return
     **/
    public static String getCellValue(Cell cell){
        int cellType = cell.getCellType();
        String cellValue;
        switch (cellType){
            case Cell.CELL_TYPE_STRING:
            case Cell.CELL_TYPE_NUMERIC:
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }
}
