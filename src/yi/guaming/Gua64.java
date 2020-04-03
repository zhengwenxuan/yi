package yi.guaming;

import java.io.PrintStream;
import yi.Gua;

public enum Gua64
{
    坤,
    复,
    师,
    临,
    谦,
    明夷,
    升,
    泰,
    豫,
    震,
    解,
    归妹,
    小过,
    丰,
    恒,
    大壮,
    比,
    屯,
    坎,
    节,
    蹇,
    既济,
    井,
    需,
    萃,
    随,
    困,
    兑,
    咸,
    革,
    大过,
    夬,
    剥,
    颐,
    蒙,
    损,
    艮,
    贲,
    蛊,
    大畜,
    晋,
    噬嗑,
    未济,
    睽,
    旅,
    离,
    鼎,
    大有,
    观,
    益,
    涣,
    中孚,
    渐,
    家人,
    巽,
    小畜,
    否,
    无妄,
    讼,
    履,
    遁,
    同人,
    姤,
    乾;

    public static final int size = values().length;

    private static final Gua64[] guaXu = {
            乾, 坤, 屯, 蒙, 需, 讼, 师, 比, 小畜, 履, 泰, 否, 同人, 大有, 谦, 豫, 随, 蛊, 临, 观, 噬嗑, 贲, 剥, 复, 无妄, 大畜, 颐, 大过, 坎, 离,
            咸, 恒, 遁, 大壮, 晋, 明夷, 家人, 睽, 蹇, 解, 损, 益, 夬, 姤, 萃, 升, 困, 井, 革, 鼎, 震, 艮, 渐, 归妹, 丰, 旅, 巽, 兑, 涣, 节, 中孚, 小过, 既济, 未济 };

    private static final Gua64[][] fenGongGuaXu = {
            { 乾, 姤, 遁, 否, 观, 剥, 晋, 大有 },
            { 坎, 节, 屯, 既济, 革, 丰, 明夷, 师 },
            { 艮, 贲, 大畜, 损, 睽, 履, 中孚, 渐 },
            { 震, 豫, 解, 恒, 升, 井, 大过, 随 },
            { 巽, 小畜, 家人, 益, 无妄, 噬嗑, 颐, 蛊 },
            { 离, 旅, 鼎, 未济, 蒙, 涣, 讼, 同人 },
            { 坤, 复, 临, 泰, 大壮, 夬, 需, 比 },
            { 兑, 困, 萃, 咸, 蹇, 谦, 小过, 归妹 } };

    private static final Gua64[] fuZaGua1 = {
            乾, 坤, 剥, 复, 颐, 大过, 家人, 睽, 蹇, 解, 夬, 姤, 渐, 归妹, 既济, 未济 };

    private static final Gua64[] fuZaGua2 = {
            乾, 坤, 既济, 未济 };

    private static final Gua64[] menHu = {
            乾, 坤 };

    private static final Gua64[] ziZongGua = {
            乾, 坤, 颐, 大过, 坎, 离, 中孚, 小过 };

    private static final Gua64[] cuoZongTongGua = {
            泰, 否, 随, 蛊, 渐, 归妹, 既济, 未济 };

    private static final Gua64[] qianKunYiYaoBianGua = {
            师, 比, 谦, 豫, 剥, 复,
            小畜, 履, 同人, 大有, 夬, 姤 };

    private static final Gua64[] jiJiWeiJiYiYaoBianGua = {
            屯, 蒙, 需, 讼, 晋, 明夷,
            家人, 睽, 蹇, 解, 革, 鼎 };

    private static final Gua64[] xiaoXiGua = {
            复, 临, 泰, 大壮, 夬, 乾, 姤, 遁, 否, 观, 剥, 坤 };

    public static Gua64 getGuaMing(int value)
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

    public static Gua64 first() {
        return guaXu[0];
    }

    public Gua64 next() {
        int index = getXuShu();
        if (index == size - 1) {
            index = -1;
        }
        return guaXu[(index + 1)];
    }

    public Gua64 previous() {
        int index = getXuShu();
        if (index == 0) {
            index = size;
        }
        return guaXu[(index - 1)];
    }

    public Gua64 cuoGuaMing() {
        int cuoGuaShu = Gua.cuoGuaShu(getShu());
        return getGuaMing(cuoGuaShu);
    }

    public Gua64 zongGuaMing() {
        int zongGuaShu = Gua.zongGuaShu(getShu());
        return getGuaMing(zongGuaShu);
    }

    public Gua64 fuGuaMing() {
        int fuGuaShu = Gua.fuGuaShu(getShu());
        return getGuaMing(fuGuaShu);
    }

    public Gua64 zaGuaMing() {
        int zaGuaShu = Gua.zaGuaShu(getShu());
        return getGuaMing(zaGuaShu);
    }

    public Gua64 bianGuaMing(int bianWei) {
        int bianGuaShu = Gua.bianGuaShu(getShu(), bianWei);
        return getGuaMing(bianGuaShu);
    }

    public static void bianGuaGe()
    {
        System.out.print(渐.bianGuaMing(12) + ",");
    }

    public static void printChaXunBiao()
    {
        System.out.println("=============查询表==============");
        System.out.println(
                "卦\t综\t错\t综错\t复\t杂\t复复\t复杂");

        System.out.println("===============================");
        for (Gua64 guaMing : guaXu)
            System.out.println(
                    guaMing + "\t" +
                            guaMing.zongGuaMing() + "\t" +
                            guaMing.cuoGuaMing() + "\t" +
                            guaMing.zongGuaMing().cuoGuaMing() + "\t" +
                            guaMing.fuGuaMing() + "\t" +
                            guaMing.zaGuaMing() + "\t" +
                            guaMing.fuGuaMing().fuGuaMing() + "\t" +
                            guaMing.fuGuaMing().zaGuaMing());
    }
}