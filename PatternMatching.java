
public class PatternMatching {

    private final static String[][] data = new String[][] {
            {"aaaaaaaaaaaaa", "baaa"}, //No Occurrences Best Case
            {"aaaaaaaaaaaaa", "aaab"}, //No Occurrences Worst Case
            {"aaaaaaaaaaaaa", "aaaa"}, //Single Occurrence Best Case
            {"aaaaaaaaaaaab", "aaab"}, //Single Occurrence Worst Case
            {"aaaaaaaaabaaa", "baaa"}, //All Occurrences Best Case
            {"aaaaaaaaaaaab", "aaab"}, //All Occurrences Worst Case
    };

    public static void main(String[] args){
        for (var pair : data){
            Brute(pair[0], pair[1]);
        }
    }

    public static void Brute(String text, String pattern){
        if (text == null)
            throw new IllegalArgumentException("text is null");
        if (pattern == null)
            throw new IllegalArgumentException("pattern is null");
        System.out.println("Brute force / text[" + text + "] pattern[" + pattern + "]");
        ArrayList<Integer> ret = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int location = 0;
        int iteration = 0;
        while (location <= n - m){
            int index = 0;
            while (index < m){
                iteration++;
                if (pattern.charAt(index) != text.charAt(location + index))
                    break;
                if (index == m - 1){
                    ret.addToBack(location);
                }
                index++;
            }
            location++;
        }
        if (ret.size() == 0){
            System.out.println("pattern not found");
        }
        else{
            System.out.print("pattern found at index: ");
            for (int i = 0; i < ret.size(); i++){
                System.out.print(i + ",");
            }
            System.out.println();
        }
        System.out.println("number of iterations: " + iteration + "\n");
    }
}
