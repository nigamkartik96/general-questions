class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[nums.length];
        for(int i =0; i < nums.length; i++) a[i] = nums[i];
        Arrays.sort(a);
        int i = 0, j = nums.length - 1;
        
        while(i != j) {
            System.out.println(i +" "+ j + " " + (a[i] + a[j]));
            if((a[i] + a[j]) == target) {
                break;
            } else if ((a[i] + a[j]) < target) {
                i ++;
            } else {
                j --;
            }
        }
        System.out.println(i +" "+ j + " " + (a[i] + a[j]));
        int flagI = 0, flagJ = 0;
        
        for(int k = 0; k < nums.length; k ++) {
            System.out.println(nums[k]);
            if(nums[k] == a[i] && flagI == 0) {
                i = k;
                flagI = 1;
            } else
            if (nums[k] == a[j] && flagJ == 0) {
                j = k;
                flagJ = 1;
            }
            if(flagI == 1 && flagJ == 1) break;
        }
        
        return new int[]{ i , j };
    }
}