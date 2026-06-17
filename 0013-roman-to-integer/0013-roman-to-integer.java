class Solution {
    public int romanToInt(String s)
    {
            char I = 'I';
		    char V = 'V';
		    char X = 'X';
		    char L = 'L';
		    char C = 'C';
		    char D = 'D';
		    char M = 'M';
            int prev=0;
            int total=0;
            for(int i=s.length()-1;i>=0;i--)
            {
                char ch=s.charAt(i);
                int curr=ch;

                 if (ch==I)
            {
                curr=1;
            }
            else if (ch==V)
            {
                curr=5;
            }
             else if (ch==X)
            {
                curr=10;
            }
             else if (ch==L)
            {
                curr=50;
            }
             else if (ch==C)
            {
                curr=100;
            }
             else if (ch==D)
            {
                curr=500;
            }
             else if (ch==M)
            {
                curr=1000;
            }

            if(prev>curr)
            {
                total-=curr;
            }
            else
            {
                total+=curr;
            }
            prev=curr;
            }
           return total;
    }
}