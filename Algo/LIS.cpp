#include <iostream>
#include <climits>
using namespace std;

// Function to find length of longest increasing subsequence
int LIS(int arr[], int i, int n, int prev)
{	cout<<prev<<endl;
	// Base case: nothing is remaining
	if (i == n)
		return 0;

	// case 1: exclude the current element and process the
	// remaining elements
	int excl = LIS(arr, i + 1, n, prev);

	// case 2: include the current element if it is greater
	// than previous element in LIS
	int incl = 0;
	if (arr[i] > prev)
		incl = 1 + LIS(arr, i + 1, n, arr[i]);

	// return maximum of above two choices
	return max(incl, excl);
}

// main function
int main()
{
	int arr[] = { 3, 10, 2, 1};
	int n = sizeof(arr) / sizeof(arr[0]);

	cout << "Length of LIS is " << LIS(arr, 0, n, INT_MIN);

	return 0;
}
