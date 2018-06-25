package top.hejiaxuan.util.excle;

import java.util.List;

/**
 * 建立表格中的页对象
 * @author 嘉旋
 *
 */
public class ExcelSheet {

    private String sheetName;//表格中的页名称
	
	/**
	 * 表格的 第一行   内容
	 */
	private String [] title;
	
	private List<ExcelLine> line;//列

	public ExcelSheet() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ExcelSheet(String sheetName, String[] title, List<ExcelLine> line) {
		super();
		this.sheetName = sheetName;
		this.title = title;
		this.line = line;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String[] getTitle() {
		return title;
	}

	public void setTitle(String[] title) {
		this.title = title;
	}

	public List<ExcelLine> getLine() {
		return line;
	}

	public void setLine(List<ExcelLine> line) {
		this.line = line;
	}
	
}