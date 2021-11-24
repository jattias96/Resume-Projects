/*

Merge two pre-sorted arrays into one combined, sorted array.

Bonus:

What if we wanted to merge several sorted arrays?
Write a method that takes as an input an array of sorted arrays and
outputs a single sorted array with all the items from each array.

*/

public class MergeArrays {
  public static int[] mergeTwoArrays(int[] arr1, int[] arr2) {
    int[] finalArr = new int[arr1.length + arr2.length];

    int indexFinal = 0;
    int index1 = 0;
    int index2 = 0;

    while (index1 < arr1.length && index2 < arr2.length) {
      if (arr1[index1] <= arr2[index2]) {
        finalArr[indexFinal] = arr1[index1];
        indexFinal++;
        index1++;
      } else {
        finalArr[indexFinal] = arr2[index2];
        indexFinal++;
        index2++;
      }
    }

    while (index1 < arr1.length) {
      finalArr[indexFinal] = arr1[index1];
      indexFinal++;
      index1++;
    }

    while (index2 < arr2.length) {
      finalArr[indexFinal] = arr2[index2];
      indexFinal++;
      index2++;
    }

    return finalArr;
  }

  public static int[] mergeNArrays(int[][] arrs) {
    
  }
}
