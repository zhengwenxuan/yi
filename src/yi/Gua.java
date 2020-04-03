package yi;

import java.util.HashSet;
import java.util.Set;
import yi.guaming.Gua64;
import yi.shiwei.ShiWei6;

public class Gua
{
    private static final int size = ShiWei6.size;
    private static final int count = (int)Math.pow(2.0D, size);
    private int shu;
    private Gua64 name;
    private GuaZhongYao[] yaos = new GuaZhongYao[size];

    private static GuaZhongYao[] getYaosByShu(int shu) {
        GuaZhongYao[] yaos = new GuaZhongYao[size];
        for (int i = size - 1; i >= 0; i--) {
            int j = size - 1 - i;
            int k = (j + 3) % 6;
            ShiWei6 shiWei = ShiWei6.values()[i];
            boolean yang = (shu >> j & 0x1) == 1;
            boolean xiangYing = ((shu >> j ^ shu >> k) & 0x1) == 1;
            yaos[i] = new GuaZhongYao(yang, shiWei, xiangYing);
        }
        return yaos;
    }

    private static int getShuByYaos(Yao[] yaos) {
        int shu = 0;
        for (int i = size - 1; i >= 0; i--) {
            int j = size - 1 - i;
            if (yaos[i].isYang())
                shu += (1 << j);
        }
        return shu;
    }

    private void init(int value) {
        this.name = Gua64.getGuaMing(value);
        this.shu = this.name.getShu();
    }

    private void init(int value, boolean isInitYaos) {
        init(value);
        if (isInitYaos)
            this.yaos = getYaosByShu(this.shu);
    }

    private void update(Yao[] yaos, boolean isInitYaos)
    {
        init(getShuByYaos(yaos), isInitYaos);
    }

    public Gua(int value) {
        init(value, true);
    }

    public Gua(Gua64 name) {
        this(name.getShu());
    }

    public static int cuoGuaShu(int shu) {
        return count - 1 - shu;
    }

    public static int zongGuaShu(int shu) {
        int zongGuaShu = 0;
        for (int i = size - 1; i >= 0; i--) {
            int j = size - 1 - i;
            if ((shu >> j & 0x1) == 1) {
                zongGuaShu += (1 << i);
            }
        }
        return zongGuaShu;
    }

    public static int fuGuaShu(int shu) {
        int fuGuaShu = 0;
        if ((shu >> 1 & 0x1) == 1) {
            fuGuaShu++;
        }
        if ((shu >> 2 & 0x1) == 1) {
            fuGuaShu += 10;
        }
        if ((shu >> 3 & 0x1) == 1) {
            fuGuaShu += 20;
        }
        if ((shu >> 4 & 0x1) == 1) {
            fuGuaShu += 32;
        }
        return fuGuaShu;
    }

    public static int bianGuaShu(int shu, int bianWei) {
        bianWei = bianWei >= 0 ? bianWei % count : -bianWei % count;
        return shu ^ bianWei;
    }

    public static int zaGuaShu(int shu) {
        return cuoGuaShu(zongGuaShu(fuGuaShu(shu)));
    }

    public Gua cuoGua() {
        return new Gua(cuoGuaShu(this.shu));
    }

    public Gua zongGua() {
        return new Gua(zongGuaShu(this.shu));
    }

    public Gua fuGua() {
        return new Gua(fuGuaShu(this.shu));
    }

    public Gua zaGua() {
        return new Gua(zaGuaShu(this.shu));
    }

    public Gua zhiGua(int bianWei) {
        return bianGua(bianWei);
    }

    public Gua bianGua(int bianWei) {
        return new Gua(bianGuaShu(this.shu, bianWei));
    }

    public GuaZhongYao get(ShiWei6 shiWei)
    {
        return this.yaos[shiWei.ordinal()];
    }

    public GuaZhongYao set(Yao yao) {
        if (yao == null) {
            return null;
        }
        GuaZhongYao oldYao = get(yao.getShiWei());
        this.yaos[yao.getShiWei().ordinal()] = new GuaZhongYao(yao.isYang(), yao.getShiWei(), false);
        update(this.yaos, true);
        return oldYao;
    }

    private boolean checkShiWei(Yao[] yaos) {
        Set set = new HashSet();
        for (Yao yao : yaos) {
            if (set.contains(yao.getShiWei())) {
                return false;
            }
            set.add(yao.getShiWei());
        }

        return true;
    }

    public GuaZhongYao[] set(Yao[] newYaos)
    {
        if ((newYaos == null) || (newYaos.length > size)) {
            return null;
        }
        if (!checkShiWei(newYaos)) {
            return null;
        }
        GuaZhongYao[] oldYaos = new GuaZhongYao[newYaos.length];
        for (int i = 0; i < newYaos.length; i++) {
            Yao newYao = newYaos[i];
            oldYaos[i] = get(newYao.getShiWei());
            this.yaos[newYao.getShiWei().ordinal()] = new GuaZhongYao(newYao.isYang(), newYao.getShiWei(), false);
        }
        update(this.yaos, true);
        return oldYaos;
    }

    public Gua64 getName() {
        return this.name;
    }

    public String toString()
    {
        String guaXiang = "";
        String offXiang = "";
        for (int i = 0; i < size; i++) {
            guaXiang = guaXiang + this.yaos[i];
        }
        for (int i = 0; i < 3; i++) {
            offXiang = offXiang + "   ";
        }
        guaXiang = offXiang + this.name + Util.lineSeparator + guaXiang;
        return guaXiang;
    }

    protected Object clone()
    {
        return new Gua(this.shu);
    }
}