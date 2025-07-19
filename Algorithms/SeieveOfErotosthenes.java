package DS.Algorithms;

import java.util.*;

public class SeieveOfErotosthenes {
    List<Integer> primes = new ArrayList<>();
    public void seieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primes.add(i);
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("Total prime numbers found: " + primes.size());
        System.out.print(primes.get(primes.size() - 1) + primes.get(primes.size() - 2));
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n=inp.nextInt();
        SeieveOfErotosthenes seieve = new SeieveOfErotosthenes();
        seieve.seieve(n);
        inp.close();
    
    }
}
