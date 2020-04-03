package yi.shiwei;

public enum ShiWei3
{
    上,
    五,
    四,
    三,
    二,
    初;

    public static final int size = values().length;

    public ShiWei3 zongWei()
    {
        return values()[(size - 1 - ordinal())];
    }

    public ShiWei3 huYingWei()
    {
        return values()[((ordinal() + 3) % 6)];
    }

    public ShiWei3 previous() {
        int index = ordinal();
        if (index == size - 1) {
            index = -1;
        }
        return values()[(index + 1)];
    }

    public ShiWei3 next() {
        int index = ordinal();
        if (index == 0) {
            index = size;
        }
        return values()[(index - 1)];
    }

    public boolean isYangWei() {
        return ordinal() % 2 == 1;
    }
}