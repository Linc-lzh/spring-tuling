package cn.tulingxueyuan.proxy.dynamic;

import org.springframework.stereotype.Service;


public interface ICalculator {

    public Integer add(Integer i, Integer j);
    public Integer sub(Integer i, Integer j);
    public Integer mul(Integer i, Integer j);
    public Integer div(Integer i, Integer j);
}
