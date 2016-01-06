package com.skyjoo.skyper.biz.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.eyeieye.melos.util.Money;
import com.eyeieye.melos.util.StringUtil;

public class NumberFormat {

    private static final Log log = LogFactory.getLog(NumberFormat.class);

    public NumberFormat() {
        super();
        if (log.isDebugEnabled()) {
            log.debug("ControlTool constructor");
        }
    }

    /**
     * long2idouble
     * 
     * @param value ��Ҫ���������
     * @param m һ��Ϊ100����1000
     * @return
     */
    public static Double l2d(Long value, Integer m) {
        if (m == null || m == 0) return 0.00;
        if (null != value) return BigDecimal.valueOf(value).divide(BigDecimal.valueOf(m), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return 0.00;
    }

    /**
     * long2idouble
     * 
     * @param value ��Ҫ���������
     * @param m һ��Ϊ100����1000
     * @return
     */
    public static Double l2d(Long value, Long m) {
        if (m == null || m == 0) return 0.00;
        if (null != value) return BigDecimal.valueOf(value).divide(BigDecimal.valueOf(m), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return 0.00;
    }

    /**
     * double * int
     * 
     * @param value ��Ҫ���������
     * @param m һ��Ϊ100����1000
     * @return
     */
    public static Long l2m(Double value, Integer m) {
        if (null != value) return BigDecimal.valueOf(value).multiply(BigDecimal.valueOf(m)).longValue();
        return 0L;
    }

    /**
     * ��С��ת��Ϊ�ٷֱȱ�ʾ������С�����2λ
     * 
     * @param d
     */
    public String percent(Double d) {
        if (d == null) {
            return "";
        }
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(d * 100) + "%";
    }

    /**
     * ��С��ת��Ϊ�ٷֱȱ�ʾ������С�����2λ
     * 
     * @param d
     * @return
     */
    public static String percent(Long d) {
        return l2d(d, 100).toString();
    }

    /**
     * ��С��ת��Ϊ�ٷֱȱ�ʾ������С�����2λ
     * 
     * @param d
     * @return
     */
    public static Long percent(String d) {
        if (StringUtil.isBlank(d)) return 0L;
        return l2m(Double.valueOf(d), 100);
    }

    /**
     * ȡ����ѧ������
     */
    public String formatNumber(Double d) {
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(d);
    }

    /**
     * ȡ����ѧ������
     */
    public String formatNumber(String str) {
        if (StringUtil.isBlank(str)) {
            return "";
        }
        Double d = new Double(str);
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(d);
    }

    /**
     * β�Ų��㲹0
     * 
     * @param digitNO
     * @param tailNO
     * @return
     * @author chenxi
     * @date 2010-4-27
     */
    public String formatTail(String str_digitNO, String str_tailNO) {
        int digitNO = Integer.parseInt(str_digitNO);
        int length = str_tailNO.length();
        for (int i = 0; i < (digitNO - length); i++) {
            str_tailNO = "0" + str_tailNO;
        }
        return str_tailNO;
    }

    /**
     * ����� �õ�Ԫ
     * 
     * @param MoneyFen
     * @return
     */
    public static String formatToYuan(Long MoneyFen) {
        if (MoneyFen == null || MoneyFen.longValue() == 0L) {
            return "0.00";
        }

        Money money = new Money();
        money.setCent(MoneyFen);
        return money.toString();
    }

    /**
     * ����Ԫ �õ�Ԫ ��ֹ��ѧ������ ����Ч�ı�����λ(�漰��Ǯ�����⻹����Money��Ƚϱ���)
     * 
     * @param MoneyFen
     * @return
     */
    public static String formatYuan(Double MoneyYuan) {
        if (MoneyYuan == null || MoneyYuan.longValue() == 0L) {
            return "0.00";
        }

        Money money = new Money(MoneyYuan);
        return money.toString();
    }

    /**
     * ����� �õ�Ԫ
     * 
     * @param MoneyHao
     * @return
     */
    public static String formatHaoToYuan(Long MoneyHao) {
        if (MoneyHao == null || MoneyHao.longValue() == 0L) {
            return "0.00";
        }

        Money money = new Money();
        money.setCent(Math.round(MoneyHao / 10));
        return money.toString();
    }

    /**
     * ����Ԫ �õ���
     * 
     * @param MoneyYuan
     * @return
     */
    public static Long formatToFen(String MoneyYuan) {
        if (MoneyYuan == null) {
            return 0L;
        }

        Money money = new Money(MoneyYuan);
        return money.getCent();
    }

    /**
     * ����Ԫ �õ���
     * 
     * @param MoneyYuan
     * @return
     */
    public static Long formatToHao(String MoneyYuan) {
        return formatToFen(MoneyYuan) * 10;
    }

    /**
     * ��ʽ�����
     * 
     * @param money ��
     * @param format ��ʽ  eg:',###.00'
     * @return
     */
    public static String formatToYuan(Long money, String format) {
        if (money == null || money.longValue() == 0) {
            return "0.00";
        }

        Money m = new Money();
        m.setCent(money);
        
        double yuan = m.getAmount().doubleValue();

        DecimalFormat f = new DecimalFormat(format);

        return f.format(yuan);
    }
    
    public static String formatToYuanDefault(Long money) {
        return formatToYuan(money, ",##0.00");
    }

    public static void main(String[] arg) {
//        System.out.println(NumberFormat.percent(2356L));
         System.out.println(formatToYuan(1l, ",##0.00"));

    }
}
