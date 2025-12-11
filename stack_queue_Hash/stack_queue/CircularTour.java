public class CircularTour {

    public static int findStartPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;
        int deficit = 0;
        int balance = 0;

        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];

            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }
        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        System.out.println(findStartPoint(petrol, distance));
    }
}
