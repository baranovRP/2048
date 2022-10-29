package lc;

public class FindDifference {

    public char findTheDifference(String s, String t) {
        int[] res = new int[26];
        char[] pattern = s.toCharArray();
        char[] sample = t.toCharArray();
        for (char c : pattern) {
            res[c - 97]++;
        }
        for (char c : sample) {
            res[c - 97]--;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0) return (char) (i + 97);
        }
        return ' ';
    }
}

/*
public class FindDifference {

    char[] pattern;
    char[] sample;

    public char findTheDifference(String s, String t) {
        pattern = s.toCharArray();
        sample = t.toCharArray();
        selectionSort(pattern);
        selectionSort(sample);
        for (int i = 0; i < sample.length; i++) {
            if (sample.length != pattern.length && i == sample.length - 1) return sample[i];
            if (sample[i] != pattern[i]) return sample[i];
        }
        return ' ';
    }

    private void selectionSort(char[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) min = j;

            }
            swap(a, i, min);
        }
    }

    private void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}*/
