package cn.tulingxueyuan.proxy.dynamic;


/**
 *  计算器类
 */
public class Calculator implements ICalculator {
    // 加
    public Integer add(Integer i, Integer j) {
        Integer result = i+j;
        return result;
    }
    // 减
    public Integer sub(Integer i, Integer j){
        Integer result = i-j;
        return result;
    }

    // 乘
    public Integer mul(Integer i, Integer j){
        Integer result = i*j;
        return result;
    }

    // 除法
    public Integer div(Integer i, Integer j) {
        Integer result = i/j;
        return result;
    }
}
