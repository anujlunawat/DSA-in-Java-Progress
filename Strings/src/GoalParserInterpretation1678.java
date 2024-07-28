public class GoalParserInterpretation1678 {
    public static void main(String[] args) {
        String command = "G()(al)";
        System.out.println(interpret(command));
        System.out.println(interpret2(command));
    }

    public static String interpret(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
    }

    public static String interpret2(String command){
        StringBuilder sb = new StringBuilder(command.length());
        int i=0;

        while(i < command.length()){
            if(command.charAt(i) == 'G'){
                sb.append('G');
                i++;
            }
            else if (command.charAt(i) == '('){
                if(command.charAt(i+1) == ')'){
                    sb.append("o");
                    i+=2;
                }
                else{
                    sb.append("al");
                    i+=4;
                }
            }
        }
        return sb.toString();
    }
}
