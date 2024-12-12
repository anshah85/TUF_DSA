public class Test {
    public static void main(String[] args) {

    }

    public int[] arrayRankTransfor(int[] arr) {
        int[] ans = new int[arr.length];
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < sorted.length; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        dfs(root1, set);
        return dfs2(root2, set, target);
    }

    private void dfs(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }

        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }

    private boolean dfs2(TreeNode root, Set<Integer> set, int target) {
        if (root == null) {
            return false;
        }

        if (set.contains(target - root.val)) {
            return true;
        }

        return dfs2(root.left, set, target) || dfs2(root.right, set, target);
    }
}
