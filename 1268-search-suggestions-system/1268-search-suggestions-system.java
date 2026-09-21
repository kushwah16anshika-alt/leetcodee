class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) 
    {
        Arrays.sort(products);

        List<List<String>> ans=new ArrayList<>();
        String prefix = "";
        for (char ch : searchWord.toCharArray()) 
        {
        prefix += ch;
        int left=0;
        int right=products.length-1;

        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(products[mid].compareTo(prefix)<0)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
         List<String> list = new ArrayList<>();

         for(int i=left;i<Math.min(left+3,products.length);i++)
         {
            if(products[i].startsWith(prefix))
            {
                list.add(products[i]);
            }
            else
            {
                break;
            }
             
         }
         ans.add(list);
        }
         return ans;
    }
}