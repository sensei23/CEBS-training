package cebs_training;

import java.util.HashMap;
import java.util.Map;

public class ArrayDemo
{
	public void print(int arr[])
	{
		for(int a : arr)
			System.out.print(a + " ");
		System.out.println();
	}
	public int[] reverse(int arr[])
	{
		int i = 0;
		int j = arr.length - 1;
		while(i <= j) {
			int a = arr[i];
			arr[i] = arr[j];
			arr[j] = a;
			i++;
			j--;
		}
		return arr;
	}

	public static void main(String...s)
	{
		ArrayDemo ad = new ArrayDemo();
		int arr[] = ad.reverse(new int []{2,3,4,5,6,7});
		
		ad.print(arr);

		ad.print(ad.reverse(new int[]{1,2,3,4,5,6,7}));
		
		int a[] = {1,2,1,1,1,2,2,2,3,3,3,2,2,4,4,4,5};
		ad.sequenceCount(a);
		ad.frequencyCount(a);
		int ar[][] = {{1, 2, 17},
						{2, 5, -11},
							{17, -11, 9}};
		System.out.println(ad.isSymmetricMatrix(ar));
		
		int b[][] = {{0, -2, 7},
						{2, 0, -3},
							{-7, 3, 0}};
		System.out.println(ad.isSkewSymmetricMatrix(b));
	}

	public void sequenceCount(int arr[])
	{
	  /*
		arr={1,2,1,1,1,2,2,2,3,3,3,2,2,4,4,4,5};
		o/p
		1 occ at 1 time
		2 occ at 1 time
		1 occ at 3 times
		2 occ at 3 times
		3 occ at 3 times
		2 occ at 2 times
		4 occ at 3 times
		5 occ at 1 time
		*/
		int count = 1;
		for(int i = 0; i < arr.length; i++) {
			if(i != arr.length-1) {
				if(arr[i] != arr[i+1]) {
					System.out.println(arr[i] + " occured " + count + " times.");
					count = 1;
				}
				else
					count++;
			}
			else {
				System.out.println(arr[i] + " occured " + count + " times.");
			}
				
		}
		
	}
	
	public void frequencyCount(int arr[])
	{
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int a: arr) {
			if(hm.containsKey(a))
				hm.replace(a, hm.get(a) + 1);
			else
				hm.put(a, 1);
		}
		for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			System.out.println("Frequency count: " + entry.getKey() + " => " + entry.getValue());
		}
	}
	public int max(int arr[])
	{
		int max = Integer.MIN_VALUE;
		for(int a: arr)
			if(max < a)
				max = a;
		return max;
	}
	public int min(int arr[])
	{
		int min = Integer.MAX_VALUE;
		for(int a: arr)
			if(min > a)
				min = a;
		return min;
	}
	public int max1(int arr[][])
	{
		int max = Integer.MIN_VALUE;
		for(int ar[]: arr)
			for(int a: ar)
				if(max < a)
					max = a;
		return max;

	}
	public int min1(int arr[][])
	{
		int min = Integer.MAX_VALUE;
		for(int ar[]: arr)
			for(int a: ar)	
				if(min > a)
					min = a;
		return min;

	}
	public int[][] matrixSum(int mat1[][],int mat2[][])
	{
		if(mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
			System.out.println("matrix size not same ......can't add");
			return null;
		}
			int sum[][] = new int[mat1.length][mat1[0].length];
			for(int i=0; i<mat1.length; i++)
				for(int j=0; j<mat1[i].length; j++)
					sum[i][j] = mat1[i][j] + mat2[i][j];
			return sum;
	}
	public int[][] matrixMult(int mat1[][],int mat2[][])
	{
		if(mat1[0].length != mat2.length) {
			System.out.println("The size of column of first does not match with size of row of second....can't multiply");
			return null;
		}
		
		int mult[][] = new int[mat1.length][mat2[0].length];
		for(int i=0; i<mat1.length ; i++)
			for(int j=0; j<mat2[i].length; j++) {
				mult[i][j] = 0;
				for(int k=0; k<mat2.length; k++)
					mult[i][j] += mat1[i][k] * mat2[k][j];
			}
		return mult;
	}
	public int[][] matrixTranspose(int mat[][])
	{
		for(int i=0; i<mat.length; i++)
			for(int j=i+1; j<mat[i].length; j++) {
				int temp = mat[j][i];
				mat[j][i] = mat[i][j];
				mat[i][j] = temp;
			}
		return mat;
	}
	public boolean isSymmetricMatrix(int mat[][])
	{
		int transpose[][] = matrixTranspose(mat);
		for(int i=0; i<mat.length; i++)
			for(int j=0; j<mat[i].length; j++)
				if(mat[i][j] != transpose[i][j])
					return false;
		return true;
	}

	public int sum(int m1[][])
	{
		int sum=0;
		for(int ar[] : m1)
			for(int a: ar)
				sum += a;
		return sum;
	}


	public boolean isSkewSymmetricMatrix(int mat[][])
	{
		int transpose[][] = matrixTranspose(mat);
		for(int i=0; i<mat.length; i++)
			for(int j=0; j<mat[i].length; j++)
				transpose[i][j] = -transpose[i][j];
		
		
		for(int i=0; i<mat.length; i++)
			for(int j=0; j<mat[i].length; j++)
				if(mat[i][j] != transpose[i][j])
					return false;
		return true;
	}
	public boolean isIdentityMatrix(int mat[][])
	{	
		for(int i=0; i<mat.length; i++)
			for(int j=0; j<mat[i].length; j++) {
				if(i == j && mat[i][j] != 1)
					return false;
				else if(i != j && mat[i][j] != 0)
					return false;
			}
		return true;
	}
	public void leftDiagonal(int mat[][])
	{
		for(int i=0; i<mat.length; i++) {
			System.out.println("Left Diagonal: " + (i+1) + " => " + mat[i][i]);
		}
	}
	public void rightDiagonal(int mat[][])
	{
		for(int i=0, j=mat.length-1; i<mat.length; i++, j--) {
			System.out.println("Left Diagonal: " + (i+1) + " => " + mat[i][j]);
		}		
	}		
}