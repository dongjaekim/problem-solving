package problems.lv2;

class JoyStick {
    public int solution(String name) {
        int upDown = 0;
        int leftRight = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            upDown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int index = i + 1;
            while (index < name.length() && name.charAt(index) == 'A')
                index++;
            
            leftRight = Math.min(leftRight, 2 * i + name.length() - index);
            leftRight = Math.min(leftRight, 2 * (name.length() - index) + i);
        }
        
        return upDown + leftRight;
    }
}
