package yi.guaming;

public enum Xiang4
{
    太阴,
    少阴,
    少阳,
    太阳;

    public static final int size = values().length;
    private static final Xiang4[] xiangXu = {
            太阳, 少阴, 少阳, 太阴 };

    private static final Xiang4[] siShiXiangXu = {
            少阳, 太阳, 少阴, 太阴 };

    public static Xiang4 newInstance(int value)
    {
        if (value >= 0)
            return values()[(value % size)];
        if (value >= -4) {
            return siShiXiangXu[(-value - 1)];
        }
        return xiangXu[((value - 2) % size + 3)];
    }
}