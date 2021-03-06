public class Taller4 {  

    /**
     * COMPLEJIDAD:
     * T(n)= c1+c2+c3n+c4n+c5
     * T(n) es O(c3n)
     * T(n) es 0(n)
     */
    public static int suma (int[]array){
        int res=0;
        for(int i=0;i<array.length;i++){
            res+=array[i];
        }
        return res;
    }

    /**
     * COMPLEJIDAD:
     * T(n)=c1n+c2(n^2)+c3(n^2)+c4(n^2)c5(n^2)+c6
     * T(n)=O((c2+c3+c4+c5)*n^2)
     * T(n) es O(n^2)
     */
    public static int[] insertionSort (int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<i;j++){
                int x=array[i];
                int y=array[j];
                if(x<y){ array[i]=y; array[j]=x; i--; break;}
            }
        }
        return array;
    }    

    
    
    public static void main2(String[] args){
        for (int i = 1000; i <= 2000; i = i + 100){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = (int)(Math.random()*100);
            }
            long start = System.currentTimeMillis();
            insertionSort(a);
            long fin = System.currentTimeMillis();       
            System.out.println(fin-start);
        }
    }
    
    
    
    public static void main(String[] args){
        for (int i = 10000000; i <= 200000000; i = i + 10000000){
            int[] a = new int[i];
            for (int j = 0; j < i; j++ ){
                a[j] = j;
            }
            long start = System.currentTimeMillis();
            suma(a);
            long fin = System.currentTimeMillis();       
            System.out.println(fin-start);
        }
    }

}