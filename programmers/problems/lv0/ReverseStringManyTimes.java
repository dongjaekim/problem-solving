package problems.lv0;

class ReverseStringManyTimes {
  public static void main(String[] args) {
      String e1 = solution("rermgorpsam", new int[][] { { 2, 3 }, { 0, 7 }, { 5, 9 }, { 6, 10 } });
      System.out.println("e1 = " + e1);
  }  
  
  public static String solution(String my_string, int[][] queries) {
      char[] charArray = my_string.toCharArray();
      
      for(int[] query : queries) {
          int s = query[0];
          int e = query[1];
          while (s < e) {
              char temp = charArray[s];    
              charArray[s++] = charArray[e];
              charArray[e--] = temp;
          }    
      }
      
      return new String(charArray);
  }
}
