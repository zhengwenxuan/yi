package yi.guaming;

public enum TestGua8
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

    private static final TestGua8[] yiLiGuaXu = {
            乾, 坤, 震, 巽, 坎, 离, 艮, 兑 };

    public ZiRan ziRan()
    {
        for (int i = 0; i < size; i++) {
            if (this == yiLiGuaXu[i]) return ZiRan.values()[i];
        }
        return ZiRan.天;
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