/**
 * @author Bandit
 * @createTime 2022/5/4 9:46
 */
public class Test {

    @org.junit.Test
    public void test() {
        int amount = 5, coins[] = {1,2,5};
        int[] dp = new int[amount+1];
        dp[0] = 1;
        System.out.println("先背包再物品:排列数");
        for (int i = 0; i <= amount; i++) {//先遍历背包
            for (int j = 0; j < coins.length; j++) {//再遍历物品
                if (i >= coins[j]) dp[i] += dp[i-coins[j]];
            }
            printNums(dp);
        }
        System.out.println("dp[amount]="+dp[amount]);
        dp = new int[amount+1];
        dp[0] = 1;
        System.out.println("先物品再背包:组合数");
        for (int i = 0; i < coins.length; i++) {//先遍历物品
            for (int j = coins[i]; j <= amount; j++) {//再遍历背包
                dp[j] += dp[j-coins[i]];
            }
            printNums(dp);
        }
        System.out.println("dp[amount]="+dp[amount]);
    }

    public static void printNums(int[] nums) {
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.print("\n");
    }
}
