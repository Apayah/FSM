
import java.util.List;
import java.util.stream.Collectors;

public class FSA {

    public FSA() {
    }

    public static String validate(String in) {
        int state = 1;
        List<Character> chars = in.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        String s;
        char c;

        while (!chars.isEmpty()) {
            c = chars.remove(0);
            s = "" + c;
            switch (state) {
                case 1:
                    if (s.matches("\\.")) {
                        chars.clear();
                    } else if (s.matches("[a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]")) {
                        state = 2;
                    } else {
                        chars.clear();
                    }
                    break;
                case 2:
                    if (s.matches("\\.")) {
                        state = 1;
                    } else if (s.matches("@")) {
                        state = 3;
                    } else if (s.matches("[a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]")) {
                        state = 2;
                    } else {
                        chars.clear();
                    }
                    break;
                case 3:
                    if (s.matches("[a-zA-Z0-9]")) {
                        state = 4;
                    } else {
                        chars.clear();
                    }
                    break;
                case 4:
                    if (s.matches("-")) {
                        state = 3;
                    } else if (s.matches("\\.")) {
                        state = 5;
                    } else if (s.matches("[a-zA-Z0-9]")) {
                        state = 4;
                    } else {
                        chars.clear();
                    }
                    break;
                case 5:
                    if (s.matches("\\.")) {
                        chars.clear();
                    } else if (s.matches("[a-zA-Z]")) {
                        state = 6;
                    } else {
                        chars.clear();
                    }
                    break;
                case 6:
                    if (s.matches("\\.")) {
                        state = 5;
                    } else if (s.matches("[a-zA-Z]")) {
                        state = 6;
                    } else {
                        chars.clear();
                    }
                    break;
            }
        }
        if (state != 6) {
            return "tidak valid";
        }
        return "valid";
    }
}
