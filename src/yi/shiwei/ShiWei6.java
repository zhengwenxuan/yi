package yi.shiwei;

public enum ShiWei6
{
    上,
    五,
    四,
    三,
    二,
    初;

    public static final int size = values().length;

    public ShiWei6 zongWei()
    {
        return values()[(size - 1 - ordinal())];
    }

    public ShiWei6 huYingWei()
    {
        return values()[((ordinal() + 3) % 6)];
    }

    public ShiWei6 previous() {
        int index = ordinal();
        if (index == size - 1) {
            index = -1;
        }
        return values()[(index + 1)];
    }

    public ShiWei6 next() {
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