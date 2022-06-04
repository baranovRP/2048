package lc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        int l = nums.length;
        if (l < 3) return Math.max(nums[0], nums[l - 1]);

        int fstMax, sndMax = -2147483648, trdMax = -2147483648;
        fstMax = nums[0];
        int counter = 1;
        for (int i = 1; i < l; i++) {
            if (fstMax == nums[i]) {
                continue;
            }
            if (counter == 1) {
                if (nums[i] > fstMax) {
                    trdMax = sndMax;
                    sndMax = fstMax;
                    fstMax = nums[i];
                } else if (nums[i] > sndMax) {
                    trdMax = sndMax;
                    sndMax = nums[i];
                } else if (nums[i] > trdMax) {
                    trdMax = nums[i];
                }
                counter++;
                continue;
            }
            if (sndMax == nums[i]) {
                continue;
            }
            if (counter == 2) {
                if (nums[i] > fstMax) {
                    trdMax = sndMax;
                    sndMax = fstMax;
                    fstMax = nums[i];
                } else if (nums[i] > sndMax) {
                    trdMax = sndMax;
                    sndMax = nums[i];
                } else if (nums[i] > trdMax) {
                    trdMax = nums[i];
                }
                counter++;
                continue;
            }
            if (trdMax == nums[i]) {
                continue;
            }
            if (nums[i] > fstMax) {
                trdMax = sndMax;
                sndMax = fstMax;
                fstMax = nums[i];
            } else if (nums[i] > sndMax) {
                trdMax = sndMax;
                sndMax = nums[i];
            } else if (nums[i] > trdMax) {
                trdMax = nums[i];
            }
        }
        return counter == 3 ? trdMax : fstMax;
    }

    public int thirdMax1(int[] nums) {
        Integer fm = null, sm = null, tm = null;
        for (int num : nums) {
            if (fm == null || num > fm) {
                tm = sm; sm = fm; fm = num;
            } else if (num == fm) {
                continue;
            } else if (sm == null || num > sm) {
                tm = sm; sm = num;
            } else if (num == sm) {
                continue;
            } else if (tm == null || num > tm) {
                tm = num;
            }
        }
        if (tm != null) {
            return tm;
        } else {
            return fm;
        }
    }


    // Time = O(N)
    // Space = O(1)
    public int thirdMax2(int[] nums) {
        Set<Integer> maximums = new HashSet<Integer>();
        for (int num : nums) {
            maximums.add(num);
            if (maximums.size() > 3) {
                maximums.remove(Collections.min(maximums));
            }
        }
        return maximums.size() < 3 ? Collections.max(maximums) : Collections.min(maximums);
    }

    public static void main(String[] args) {
        ThirdMaximumNumber tmn = new ThirdMaximumNumber();
        System.out.println(tmn.thirdMax2(new int[]{1,-2147483648,2}));
        System.out.println(tmn.thirdMax2(new int[]{3,2,1}));
    }
}
