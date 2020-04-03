package yi;

import yi.shiwei.ShiWei6;

public class Yao
{
    public static final int off = 3;
    private ShiWei6 shiWei;
    private boolean yang;
    private boolean dangWei;

    public Yao(boolean isYang, ShiWei6 shiWei)
    {
        this.yang = isYang;
        this.shiWei = shiWei;
        this.dangWei = (shiWei.isYangWei() == isYang);
    }

    public String toString()
    {
        String yaoXiang = "";
        for (int i = 0; i < 3; i++) {
            yaoXiang = yaoXiang + "—";
        }
        if (this.yang)
            yaoXiang = yaoXiang + "——";
        else {
            yaoXiang = yaoXiang + "  ";
        }
        for (int i = 0; i < 3; i++) {
            yaoXiang = yaoXiang + "—";
        }

        String shuXing = "";
        if ((this.shiWei == ShiWei6.初) || (this.shiWei == ShiWei6.上))
            shuXing = this.shiWei + (this.yang ? "九" : "六");
        else {
            shuXing = (this.yang ? "九" : "六") + this.shiWei;
        }
        shuXing = shuXing + " " + (this.dangWei ? "    当位" : "不当位");

        return yaoXiang + "   " + shuXing;
    }

    public ShiWei6 getShiWei() {
        return this.shiWei;
    }

    public boolean isYang() {
        return this.yang;
    }

    public boolean isDangWei() {
        return this.dangWei;
    }

    public Yao yaoBian() {
        this.yang = (!this.yang);
        this.dangWei = (!this.dangWei);
        return this;
    }
}