public class tugas4 {
    public static int findmin(int a, int b,int c) {
        if(a<=b&&a<=c){
            return a;
        } else if (b<=a&&b<=c) {
            return b;
        }else{
            return c;
        }
    }
    public static void main(String[] args) {
        int hasil1 = findmin(1,2,3);
        if(hasil1 == 1){
            System.out.println("Skenario 1: Min(1,2,3) = " + hasil1 + " → LULUS");
        }else{
            System.out.println("Skenario 1: Min(1,2,3) = " + hasil1 + " → GAGAL");
        }
        int hasil2 = findmin(-1,-2,-3);
        if(hasil2 == -3){
            System.out.println("Skenario 1: Min(1,2,3) = " + hasil2 + " → LULUS");
        }else{
            System.out.println("Skenario 1: Min(1,2,3) = " + hasil2 + " → GAGAL");
        }
        int hasil3 = findmin(0,0,1);
        if(hasil3 == 0){
            System.out.println("Skenario 1: Min(1,2,3) = " + hasil3 + " → LULUS");
        }else{
            System.out.println("Skenario 1: Min(1,2,3) = " + hasil3 + " → GAGAL");
        }
    }


}
