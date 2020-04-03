package yi.guaming;

import yi.Gua;

public enum Gua8
{
    坤,
    震,
    坎,
    兑,
    艮,
    离,
    巽,
    乾;

    public static final int size = values().length;

    private static final Gua8[] guaXu = {
            乾, 坎, 艮, 震, 巽, 离, 坤, 兑 };

    private static final Gua8[] xianTianGuaXu = {
            乾, 兑, 离, 震, 巽, 坎, 艮, 坤 };

    private static final Gua8[] yiLiGuaXu = {
            乾, 坤, 震, 巽, 坎, 离, 艮, 兑 };

    public ZiRan ziRan()
    {
        for (int i = 0; i < size; i++) {
            if (this == yiLiGuaXu[i]) return ZiRan.values()[i];
        }
        return ZiRan.天;
    }

    public static Gua8 newInstance(int value)
    {
        return value >= 0 ? values()[(value % size)] : guaXu[(-(value + 1) % size)];
    }

    public int getShu() {
        return ordinal();
    }

    private int getXuShu() {
        int index = 0;
        while (index < size) {
            if (equals(guaXu[index])) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static Gua8 first() {
        return guaXu[0];
    }

    public Gua8 next() {
        int index = getXuShu();
        if (index == size - 1) {
            index = -1;
        }
        return guaXu[(index + 1)];
    }

    public Gua8 previous() {
        int index = getXuShu();
        if (index == 0) {
            index = size;
        }
        return guaXu[(index - 1)];
    }

    public Gua8 cuoGuaMing() {
        int cuoGuaShu = Gua.cuoGuaShu(getShu());
        return newInstance(cuoGuaShu);
    }

    public Gua8 zongGuaMing() {
        int zongGuaShu = Gua.zongGuaShu(getShu());
        return newInstance(zongGuaShu);
    }

    public Gua8 bianGuaMing(int bianWei) {
        int bianGuaShu = Gua.bianGuaShu(getShu(), bianWei);
        return newInstance(bianGuaShu);
    }

    public static enum DongWu
    {
        马, 牛, 龙, 鸡, 豕, 雉, 狗, 羊;
    }

    public static enum GuaYi
    {
        健, 顺, 动, 入, 陷, 丽, 止, 说;
    }

    public static enum JiaTing
    {
        父, 母, 长男, 长女, 中男, 中女, 少男, 少女;
    }

    public static enum ShenTi
    {
        首, 腹, 足, 股, 耳, 目, 手, 口;
    }

    public static enum ZiRan
    {
        天, 地, 雷, 风, 水, 火, 山, 泽;
    }
}