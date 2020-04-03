package yi;

import yi.shiwei.ShiWei6;

public class GuaZhongYao extends Yao
{
    private boolean xiangYing;

    public GuaZhongYao(boolean isYang, ShiWei6 shiWei, boolean xiangYing)
    {
        super(isYang, shiWei);
        this.xiangYing = xiangYing;
    }

    public boolean isXiangYing() {
        return this.xiangYing;
    }

    public void setXiangYing(boolean xiangYing) {
        this.xiangYing = xiangYing;
    }

    public String toString()
    {
        String shuXing = " " + (this.xiangYing ? "    相应" : "不相应");
        return super.toString() + shuXing + Util.lineSeparator;
    }

    public Yao yaoBian()
    {
        super.yaoBian();
        this.xiangYing = (!this.xiangYing);
        return this;
    }
}