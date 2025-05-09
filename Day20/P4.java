public class P4 {
    public static void main(String[] args) {
        try {
            int[] arr = null;
            int index = 5;
            System.out.println(arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
