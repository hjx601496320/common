package top.hejiaxuan;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Stack;

/**
 * 计算文字版的加减乘除
 */
public class EvalMath {

    /**
     * 小数点前的位数
     */
    private int newScale = 2;

    /**
     * 四舍五入的模式
     */
    private int roundingMode = BigDecimal.ROUND_HALF_UP;

    /**
     * 要计算的公式
     */
    private String solution;

    /**
     * 公式中的值
     */
    private Map<String, String> params;

    /**
     * @param solution
     * @param params
     * @param newScale
     * @param roundingMode
     */
    public EvalMath(String solution, Map<String, String> params, int newScale, int roundingMode) {
        this.newScale = newScale;
        this.roundingMode = roundingMode;
        this.solution = solution;
        this.params = params;
    }

    /**
     * @param solution
     * @param params
     * @param newScale
     */
    public EvalMath(String solution, Map<String, String> params, int newScale) {
        this.newScale = newScale;
        this.solution = solution;
        this.params = params;
    }

    /**
     * @param solution
     * @param params
     */
    public EvalMath(String solution, Map<String, String> params) {
        this.solution = solution;
        this.params = params;
    }

    /**
     * 得到结果
     *
     * @return
     */
    public BigDecimal getValue() {
        String compile = compile();
        System.out.println(compile);
        return eval(compile);
    }

    /**
     * 编译出要计算的字符串
     *
     * @return
     */
    String compile() {
        //编译要计算的字符串公式
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null || value == null) {
                throw new RuntimeException("计算参数为空！");
            }
            solution = solution.replace(key, value);
        }
        //需要给表达式添加结束符
        solution += ENDCHAR;
        return solution;
    }

    /**
     * 计算
     *
     * @param solution
     * @return
     */
    BigDecimal eval(String solution) {
        Stack<BigDecimal> digital = new Stack<>();
        Stack<Character> opeators = new Stack<>();
        int begin = 0;
        int length = 0;
        char current = 0;
        for (int i = 0; i < solution.length(); i++) {
            current = solution.charAt(i);
            if (('0' <= current && current <= '9') || current == '.') {
                length++;
                continue;
            }
            if (length > 0) {
                digital.add(new BigDecimal(solution.substring(begin, begin + length)));
                begin += length;
                length = 0;
            }
            begin++;
            //如果扫描结束,但数字栈及符号栈还有数据需要计算,比如1+2+(1+3),不进行此步骤"[3, 4],[+]"为两个栈的元素
            if (ENDCHAR == current) {
                while (!opeators.isEmpty()) {
                    operator(digital, opeators);
                }
                continue;
            }
            //处理当前操作字符,无限循环,处理当前操作字符后跳出循环
            while (true) {
                if (opeators.isEmpty()) {
                    opeators.push(current);
                    break;
                } else {
                    if (OPERATORCOMPARE[OPERATOR.indexOf(current)]
                            [OPERATOR.indexOf(opeators.lastElement())] > 0) {
                        opeators.push(current);
                        break;
                    } else if (opeators.lastElement() == '('
                            && current == ')') {
                        opeators.pop();
                        break;
                    } else if (opeators.lastElement() == '('
                            && current != ')') {
                        opeators.push(current);
                        break;
                    } else {
                        operator(digital, opeators);
                    }
                }

            }
        }
        BigDecimal result = digital.pop();
        result.setScale(newScale, roundingMode);
        return result;
    }

    /**
     * 从符号栈弹出一个符号,从数字栈弹出两个数字,进行数学运算并压入数字栈
     *
     * @param digital
     * @param opeators
     */
    void operator(Stack<BigDecimal> digital, Stack<Character> opeators) {
        BigDecimal number1 = digital.pop();
        BigDecimal number2 = digital.pop();
        Character symbols = opeators.pop();
        switch (symbols) {
            case '+':
                digital.push(number2.add(number1));
                break;
            case '-':
                digital.push(number2.subtract(number1));
                break;
            case '*':
                digital.push(number2.multiply(number1));
                break;
            case '/':
                digital.push(number2.divide(number1, newScale, roundingMode));
                break;
            default:
                throw new RuntimeException("算数符号不支持: " + symbols);
        }
    }

    /**
     * 常用加减乘除括号字符
     */
    static final String OPERATOR = "+-*/()";
    /**
     * 算法符号的优先级二维表
     */
    static int[][] OPERATORCOMPARE = new int[][]{
            {0, 0, -1, -1, -1, 1},
            {0, 0, -1, -1, -1, 1},
            {1, 1, 0, 0, -1, 1},
            {1, 1, 0, 0, -1, 1},
            {1, 1, 1, 1, 0, 1},
            {-1, -1, -1, -1, -1, 0}
    };
    /**
     * 特殊字符用于标记给定表达式结尾
     */
    private static final char ENDCHAR = ';';

}  