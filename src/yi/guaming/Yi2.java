package yi.guaming;

public enum Yi2
{
    阴,
    阳;

    public static final int size = values().length;

    public static Yi2 newInstance(boolean isYang) {
        return isYang ? 阳 : 阴;
    }

    public static Yi2 newInstance(int value) {
        return value % size == 0 ? 阴 : 阳;
    }

    public boolean isYang() {
        return 阳 == this;
    }
}