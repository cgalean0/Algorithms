public class FiboPD {
  
  public static int calculateFibo(int n) {
    int aux1 = 0;
    int aux2 = 1;
    for (int i = 2; i < n; i++) {
      int aux = aux2;
      aux2 = aux2 + aux1;
      aux1 = aux;
    }
    return aux2;
  }
}