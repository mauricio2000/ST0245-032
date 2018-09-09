
/**
 * Write a description of class Lab2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab2
{
    public int countEvens(int[] nums) {
        int c=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]%2==0){
                c++;
            }
        }
        return c;
    }

    public boolean lucky13(int[] nums) {
        for(int i=0; i<nums.length;i++){
            if(nums[i]==1 || nums[i]==3){
                return false;
            }
        }
        return true;
    }

    public boolean more14(int[] nums) {
        int u=0;
        int c=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==1){
                u++;
            }else if(nums[i]==4){
                c++;
            }
        }
        if(u>c){
            return true;
        }
        return false;
    }

    public boolean tripleUp(int[] nums) {
        for(int i=0; i<nums.length-2;i++){
            if(nums[i]+1==nums[i+1] && nums[i+1]+1==nums[i+2]){
                return true;
            }
        }
        return false;
    }

    public int[] zeroFront(int[] nums) {
        int c=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=nums[c];
                nums[c]=0;
                c++;
            }
        }
        return nums;
    }

    public int maxSpan(int[] nums) {
        int aux=0;
        for(int i=0; i<nums.length;i++){
            for(int j=i; j<nums.length;j++){
                if(nums[i]==nums[j]){
                    aux=Math.max(aux,j-i+1);
                }
            }
        }
        return aux;
    }

    public int[] fix45(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==4 && nums[i+1]!=5){
                for(int j=0;j<nums.length;j++){
                    if(nums[j]==5 && j==0){
                        nums[j]=nums[i+1];
                        nums[i+1]=5;
                    }else if (nums[j]==5 && nums[j-1]!=4){
                        nums[j]=nums[i+1];
                        nums[i+1]=5;
                    }
                }
            }
        }
        return nums;
    }

    public boolean canBalance(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2==1){
            return false;
        }
        int aux=0;
        for(int j=0;j<nums.length;j++){
            aux=aux+nums[j];
            if(aux==sum/2){
                return true;
            }
        }
        return false;
    }

    public int countClumps(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length-1;i++){
            if(i!=0){
                if (nums[i]==nums[i+1] && nums[i]!=nums[i-1]){
                    c++;
                }
            }else if(nums[i]==nums[i+1]){
                c++;
            }

        }
        return c;
    } 

    public boolean linearIn(int[] outer, int[] inner) {
        int c=0;
        for(int j=0;j<inner.length;j++){
            for(int i=0;i<outer.length;i++){
                if(inner[j]==outer[i]){
                    c++;
                    break;
                }

            }
        }
        if(c==inner.length){
            return true;
        }
        return false;
    }
}
