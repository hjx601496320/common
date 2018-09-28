package top.hejiaxuan.excle;

import com.alibaba.fastjson.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析表格的工具类 fastJson包 表格格式 xls 2003版本
 *
 * @author 嘉旋
 */
public class ExcelUtil {

    public static JSONObject readExcleFileJson(File file, int begin) throws BiffException, IOException {
        // 读取表格
        Workbook workbook = Workbook.getWorkbook(file);
        return workbookToJson(workbook, begin);
    }

    public static Map<String, List<Map<String, String>>> readExcleFileMap(File file, int begin) throws BiffException, IOException {
        // 读取表格
        Workbook workbook = Workbook.getWorkbook(file);
        return workbookToMap(workbook, begin);
    }

    /**
     * 读取流解析表格
     * 何嘉旋
     *
     * @param inputStream
     * @param begin
     * @return JSONObject
     * @throws BiffException
     * @throws IOException   2015年12月21日-上午11:05:40
     */
    public static JSONObject readExcleStream(InputStream inputStream, int begin) throws BiffException, IOException {
        // 读取表格
        Workbook workbook = Workbook.getWorkbook(inputStream);
        JSONObject object = ExcelUtil.workbookToJson(workbook, begin);
        return object;
    }

    /**
     * 生成表格
     *
     * @param excel2003
     * @param url       生成的路径
     * @throws IOException
     * @throws WriteException
     * @throws RowsExceededException
     */
    public static void makeExcle(Excel2003 excel2003, String url) throws IOException, RowsExceededException, WriteException {
        // 设置字体
        WritableFont fontSet = new WritableFont(WritableFont.createFont("楷书"), 20);
        fontSet.setColour(Colour.DARK_BLUE);
        WritableCellFormat font = new WritableCellFormat(fontSet);
        // 表格中的 页
        List<ExcelSheet> sheets = excel2003.getSheet();
        OutputStream outputStream = new FileOutputStream(url + excel2003.getExcelName());
        WritableWorkbook workbook = Workbook.createWorkbook(outputStream);
        // 添加表格中的Sheet
        for (int i = 0; i < excel2003.getSheet().size(); i++) {
            // 单个的一页
            ExcelSheet excelSheet = sheets.get(i);
            //设置页的名称
            WritableSheet sheet = workbook.createSheet(excelSheet.getSheetName(), i);
            //添加每页的标题
            Label title;
            for (int t = 0; t < excelSheet.getTitle().length; t++) {
                title = new Label(t, 0, excelSheet.getTitle()[t], font);
                sheet.addCell(title);
            }
            //添加每页内容行   从第二行开始
            int x = 1;
            for (ExcelLine excelLine : excelSheet.getLine()) {
                // 遍历列   为数组的长度
                Label label;
                for (int y = 0; y < excelLine.getLineContente().length; y++) {
                    label = new Label(y, x, excelLine.getLineContente()[y]);
                    // 添加到页中
                    sheet.addCell(label);
                }
                x++;
            }
        }
        workbook.write();
        workbook.close();
    }

    /**
     * 从第几行开始解析,从0开始 表格第一行为注释
     *
     * @param workbook
     * @param begin
     * @return
     * @throws BiffException
     * @throws IOException
     */
    public static JSONObject workbookToJson(Workbook workbook, int begin) {
        Map map = workbookToMap(workbook, begin);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(map);
        return jsonObject;
    }

    /**
     * 解析 excel
     *
     * @param workbook
     * @param begin
     * @return
     */
    public static Map<String, List<Map<String, String>>> workbookToMap(Workbook workbook, int begin) {
        Map<String, List<Map<String, String>>> excleMap = new HashMap();
        for (Sheet sheet : workbook.getSheets()) {
            List<Map<String, String>> sheetMap = new ArrayList<Map<String, String>>();
            excleMap.put(sheet.getName(), sheetMap);
            for (int x = begin; x < sheet.getRows(); x++) {
                Map<String, String> lineMap = new HashMap();
                sheetMap.add(lineMap);
                for (int y = 0; y < sheet.getColumns(); y++) {
                    String title = sheet.getCell(y, 0).getContents();
                    if (begin == 0) {
                        title = y + "";
                    }
                    // y:列 x行
                    Cell cell = sheet.getCell(y, x);
                    lineMap.put(title, cell.getContents());
                }
            }
        }
        return excleMap;
    }

    /**
     * 解析 excel
     *
     * @param file
     * @param beginLine
     * @return
     * @throws IOException
     * @throws BiffException
     */
    public static Excel2003 excleToExcel2003(File file, int beginLine) {
        Excel2003 excel2003 = new Excel2003();
        excel2003.setExcelName(file.getName());
        List<ExcelSheet> excelSheets = new ArrayList<ExcelSheet>();
        excel2003.setSheet(excelSheets);
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        if (workbook == null) {
            return null;
        }
        for (Sheet sheet : workbook.getSheets()) {
            ExcelSheet excelSheet = new ExcelSheet();
            List<String> titles = new ArrayList<String>();
            excelSheets.add(excelSheet);
            List<ExcelLine> excelLines = new ArrayList<ExcelLine>();
            excelSheet.setLine(excelLines);
            for (int x = beginLine; x < sheet.getRows(); x++) {
                ExcelLine excelLine = new ExcelLine();
                excelLines.add(excelLine);
                List<String> line = new ArrayList<String>();
                for (int y = 0; y < sheet.getColumns(); y++) {
                    // 获取 标题
                    String title = sheet.getCell(y, 0).getContents();
                    titles.add(y, title);
                    Cell cell = sheet.getCell(y, x);// y:列 x行
                    line.add(cell.getContents());
                }
                excelLine.setLineContente(line.toArray(new String[]{}));
                if (excelSheet.getTitle() == null) {
                    excelSheet.setTitle(titles.toArray(new String[]{}));
                }
            }

        }
        return excel2003;
    }

}