class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1)return x;
    int lo = 1, hi = x;
    while(lo<=hi){
        int mid = lo + (hi-lo)/2;
        if((long) mid*mid == (long)x)return mid;
        else if((long)mid*mid > (long)x) hi = mid-1;
        else lo = mid+1;
    }
    return hi;
    }
}