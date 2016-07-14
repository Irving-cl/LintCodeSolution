
public class HashFunction {

    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public static int hashCode(char[] key, int HASH_SIZE) {
        long hash = 0;
        for (int i = 0; i < key.length; i++) {
            hash = (hash * 33 + (int) key[i]) % HASH_SIZE;
        }
        return (int) hash;
    }

    public static void main(String[] args) {
        char test1[] = { 'a', 'b', 'c', 'd' };
        System.out.println(hashCode(test1, 100));
    }

}
