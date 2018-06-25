package top.hejiaxuan.util.excle;

/**
 * 表格每一页中 行 的类
 * @author 嘉旋
 *
 */
public class ExcelLine {
    /**
	 * 行中的内容
	 */
	private String[] lineContente;
	
	public ExcelLine() {
	}

	public ExcelLine(String[] lineContente) {
		super();
		this.lineContente = lineContente;
	}

	public String[] getLineContente() {
		return lineContente;
	}

	public void setLineContente(String[] lineContente) {
		this.lineContente = lineContente;
	}
	
	
}
