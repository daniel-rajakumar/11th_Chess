package GUI;

import java.awt.*;



public enum TileColor {
    LIGHT, 
    DARK,
    LEGAL;

	public static TileColor LEGAL(int i) { return null; }
	public static TileColor LIGHT(String string) { return null; }
    public static TileColor DARK(double d) { return null; }

    public static void main(String[] args) {
        Tile tile = new Tile(0, 0, null, null);

        
        
    }
}




// public enum TileColor {
    // LIGHT(Color.decode("#EEEED2")), 
    // DARK(Color.decode("#769656")),
    // LEGAL(Color.decode("#BBCA2B"));
    // 
    // Color color;
// 
    // TileColor(Color color){
        // this.color = color;
    // }
// 
    // public Color getColor() { return color; }
// }
// 




class BinarySearch { int binarySearch(int arr[], int l, int r, int x) { if (r >= l) { int mid = l + (r - l) / 2; if (arr[mid] == x) return mid; if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x); return binarySearch(arr, mid + 1, r, x); } return -1; } public static void main(String args[]) { BinarySearch ob = new BinarySearch(); int arr[] = { 2, 3, 4, 10, 40 }; int n = arr.length; int x = 10; int result = ob.binarySearch(arr, 0, n - 1, x); if (result == -1) System.out.println("Element not present"); else System.out.println("Element found at index " + result); } }