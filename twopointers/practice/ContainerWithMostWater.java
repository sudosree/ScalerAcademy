package twopointers.practice;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i=0;i<height.length;i++) {
            for (int j=i+1;j<height.length;j++) {
                int currArea = Math.min(height[i], height[j]) * (j-i);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }

    public int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length-1;
        while (left < right) {
            int currArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
