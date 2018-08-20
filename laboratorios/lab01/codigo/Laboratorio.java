
/**
 * Write a description of class Laboratorio here.
 *
 * @author (Jose Miguel Gil y Mauricio Castaño)
 * @version (20 de agosto de 2018)
 */
public class Laboratorio
{ //punto1
    public static int fibo(int n) {  
        if(n==0){return 0;}
        if(n==1){return 1;}
        {return fibo(n-1)+fibo(n-2);}
    }
    //punto 2.1
    public int bunnyEars(int bunnies) {
        if(bunnies==0)return 0;
        if(bunnies==1)return 2;
        return 2+bunnyEars(bunnies-1);
    }

    public int sumDigits(int n) {
        if(n<10)return n;
        return n%10+sumDigits(n/10);
    }

    public int powerN(int base, int n) {
        if(n==1){return base;}
        return base*powerN(base,n-1);
    }

    public boolean array6(int[] nums, int index) {
        if(nums.length==0){return false;}
        if(nums[index]==6){return true;}
        if(index>=nums.length-1){return false;}
        else {return array6(nums,index+1);}
    }

    public int array11(int[] nums, int index) {
        if(nums.length==index){
            return 0;
        }else if(nums[index]==11){
            return 1+array11(nums,index+1);
        }else{
            return array11(nums,index+1);
        }
    }
    // punto 2.2
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start>=nums.length)return target==0;
        else if (nums[start]==6){
            return groupSum6(start+1,nums,target-nums[start]);
        } else{       
            return groupSum6(start+1,nums,target-nums[start]) || groupSum6(start+1,nums,target);
        }
    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if(start>=nums.length)return target==0;
        else if (nums[start]%5==0){
            return groupSum5(start+1,nums,target-nums[start]);
        }else if(start>0 && nums[start]==1 && nums[start-1]==5){
            return groupSum5(start+1,nums,target);
        } else{       
            return groupSum5(start+1,nums,target-nums[start]) || groupSum5(start+1,nums,target);
        }
    }

    public boolean splitArray(int[] nums) {
        return metodoDeAyuda(0, nums, 0, 0);
    }

    public boolean metodoDeAyuda(int cont, int[] nums, int g1, int g2) {
        if(cont >= nums.length) return g1 == g2;
        else {
            return metodoDeAyuda(cont+1, nums, g1, g2 + nums[cont]) || metodoDeAyuda(cont+1, nums, g1+ nums[cont], g2);
        }
    }

    public boolean splitOdd10(int[] nums) {
        return metodoDeAyuda2(0,nums,0,0);
    }

    public boolean metodoDeAyuda2(int cont, int[] nums, int g1,  int g2) {
        if(cont >= nums.length) return g1%10 ==0 && g2%2==1;
        else {
            return metodoDeAyuda2(cont+1, nums, g1, g2 + nums[cont]) || metodoDeAyuda(cont+1, nums, g1+ nums[cont], g2);
        }
    }

    public boolean split53(int[] nums) {
        return metodoDeAyuda3(0,nums,0,0);
    }

    public boolean metodoDeAyuda3(int cont, int[] nums, int g1, int g2) {
        if(cont >= nums.length) return g1 == g2;
        else if(nums[cont]%5==0){
            return metodoDeAyuda3(cont+1, nums, g1+ nums[cont], g2);
        }else if(nums[cont]%3==0){
            return metodoDeAyuda3(cont+1, nums, g1, g2+ nums[cont]);
        }
        else {
            return metodoDeAyuda3(cont+1, nums, g1, g2 + nums[cont]) || metodoDeAyuda(cont+1, nums, g1+ nums[cont], g2);
        }
    }
}
