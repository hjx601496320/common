package top.hejiaxuan.excle;

import java.util.ArrayList;
import java.util.List;

/**
 * 建立表格文件对象
 *
 * @author 嘉旋
 */
public class Excel2003 {

    private String excelName;//表格的名称

    private List<ExcelSheet> sheet;//表格中的页

    public Excel2003() {
        super();
        // TODO 自动生成的构造函数存根
    }

    public Excel2003(String excelName, List<ExcelSheet> sheet) {
        super();
        this.excelName = excelName;
        this.sheet = sheet;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public List<ExcelSheet> getSheet() {
        return sheet;
    }

    public void setSheet(List<ExcelSheet> sheet) {
        this.sheet = sheet;
    }

    public void addSheet(ExcelSheet excelSheet) {
        if (this.sheet == null) {
            this.sheet = new ArrayList<>();
        }
        this.sheet.add(excelSheet);
    }

}
