
public class RemoveElement {

    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        int len = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[len++] = A[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        
    }
}
