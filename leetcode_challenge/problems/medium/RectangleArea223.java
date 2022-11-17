package problems.medium;

public class RectangleArea223 {
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int output = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);

        if (ax1 > bx2 || bx1 > ax2 || ay1 > by2 || by1 > ay2)
            return output;
        else
            return output - (Math.min(ax2, bx2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
    }

    public static void main(String[] args) {
        int p1 = computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println("p1 = " + p1);

        int p2 = computeArea(-2, -2, 2, 2, -2, -2, 2, 2);
        System.out.println("p2 = " + p2);

        int p3 = computeArea(-2, -2, 2, 2, -3, -3, 3, -1);
        System.out.println("p3 = " + p3);
    }
}
