package com.aflying.bean;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 会飞的狼 on 2018/4/4.
 */
public class TestBean {
    public String sayHello(String name) {
        return name + "，你好";
    }

    public String circleArea(double r, String unit) {
        DecimalFormat dfl = new DecimalFormat("####.00");
        return dfl.format(r * r * 3.14)+"平方" + unit;
    }

    public String serverDate() {
        Date now = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        return fmt.format(now).toString();
    }

    public String[][] strArray(int i, int j) {
        String[][] array = new String[i][j];
        for(int r=0;r<i;r++) {
            for(int c=0;c<j;c++) {
                array[r][c] = "第" + (r+1) + "行， 第" + (c+1)+"列";
            }
        }
        return array;
    }
}
