/**
 *
 *  
 *
 */


/**
 *
 *  从数组里面找到出现大多数的元素。
 *  这里大多数定义为大于n/2 （n数组元素个数）。
 *  时间复杂度和空间复杂度都为O(1)
 *  
 */
public int majorityElement(int[] nums){
    int m = nums[0];
    int c = 1;

    for (int i = 1; i < nums.length; i++) {
        if (m == nums[i]) {
            c++;
        } else if (c > 1) {
            c--;
        } else {
            m = nums[i];
        }
    }

    return m;
}


/**
 *
 *  同上，不过这里大多数定义为大于n/3。
 *  理解题目意思，一个数组里如果存在这样的数，一定不会多于两个。
 *
 */
public List<Integer> majorityElement(int[] nums) {
    List<Integer> rt = new ArrayList<Integer>();

    if (nums == null || nums.length == 0) {
        return rt;
    }
    int m1 = nums[0];
    int m2 = 0;

    int c1 = 1;
    int c2 = 0;
    for (int i = 1; i < nums.length; i++) {
        int x = nums[i];
        if (x == m1) {
            c1++;
        } else if (x == m2) {
            c2++;
        } else if (c1 == 0) {
            m1 = x;
            c1 = 1;
        } else if (c2 == 0) {
            m2 = x;
            c2 = 1;
        } else {
            c1--;
            c2--;
        }
    }
    c1 = 0;
    c2 = 0;

    for (int i = 0; i < nums.length; i++) {
        if (m1 == nums[i]) {
            c1++;
        } else if (m2 == nums[i]) {
            c2++;
        }
    }
    if (c1 > nums.length / 3) {
        rt.add(m1);
    }
    if (c2 > nums.length / 3) {
        rt.add(m2);
    }

    return rt;
}

/**
 *
 *  给出商品一段时间的价目表，找出最大利润。
 *
 */
public int maxProfit(int[] prices){
    if (prices.length <= 1) {
        return 0;
    }    
    int maxProfit = 0;
    int lowest = Integer.MAX_VALUE;

    for (int v : prices) {
        lowest = Math.min(v, lowest);
        maxProfit = Math.max(maxProfit, v - lowest);
    }
    return maxProfit;
}
