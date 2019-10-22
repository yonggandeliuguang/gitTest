package com.youngclass;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        new Solution().reConstructBinaryTree(new int[]{8, 5, 6, 4}, new int[]{4, 5, 6, 8});
    }
}

class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        List<Integer> preList = new ArrayList<Integer>();
        List<Integer> inList = new ArrayList<Integer>();
        for (int i : pre) {
            preList.add(i);
        }
        for (int i : in) {
            inList.add(i);
        }
        Map<Integer, List<Integer>> left = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> right = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> l = new HashMap<Integer, Integer>();
        Map<Integer, Integer> r = new HashMap<Integer, Integer>();

        List<Integer> nums = new ArrayList<Integer>();
        nums.add(getNodeMap(preList, inList, left, right));
        int size = nums.size();
        while (size != 0) {
            for (int i = 0; i < size; i++) {
                int num = nums.get(i);
                if (left.get(num).size() > 1) {
                    Integer j = getNodeMap(preList, left.get(num), left, right);
                    l.put(num, j);
                    nums.add(j);
                } else if (left.get(num).size() > 0) {
                    l.put(num, left.get(num).get(0));
                }
                if (right.get(num).size() > 1) {
                    Integer j = getNodeMap(preList, right.get(num), left, right);
                    r.put(num, j);
                    nums.add(j);
                } else if (right.get(num).size() > 0) {
                    r.put(num, right.get(num).get(0));
                }
            }
            if (nums.size() > size) {
                nums = nums.subList(size, nums.size());
                size = nums.size();
            } else {
                size = 0;
            }

        }
        TreeNode root = new TreeNode(preList.get(0));
        TreeNode temp = null;

        List<TreeNode> tempList = new ArrayList<TreeNode>();
        tempList.add(root);
        size = tempList.size();
        while (size != 0) {

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = tempList.get(i);
                if (l.get(treeNode.val) != null) {
                    temp = new TreeNode(l.get(treeNode.val));
                    treeNode.left = temp;
                    tempList.add(temp);
                }
                if (r.get(treeNode.val) != null) {
                    temp = new TreeNode(r.get(treeNode.val));
                    treeNode.right = temp;
                    tempList.add(temp);
                }

            }

            if (tempList.size() > size) {
                tempList = tempList.subList(size, tempList.size());
                size = tempList.size();
            } else {
                size = 0;
            }

        }
        return root;
    }

    private Integer getNodeMap(List<Integer> preList, List<Integer> inList, Map<Integer, List<Integer>> left, Map<Integer, List<Integer>> right) {
        List<Integer> indexList = new ArrayList<Integer>();
        for (Integer i : inList) {
            indexList.add(preList.indexOf(i));
        }
        //获得根在preList位置
        Integer minIndex = Collections.min(indexList);
        //获得根对应的数
        Integer minNum = preList.get(minIndex);

        //获得根在inList位置
        int index = inList.indexOf(minNum);

        left.put(minNum, inList.subList(0, index));
        right.put(minNum, inList.subList(index + 1, inList.size()));
        return minNum;
    }
}