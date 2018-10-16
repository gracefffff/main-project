package it.sevenbits;
public class Formatter {
    private int level;
    public Formatter() {
        level = 0;
    }
    private StringBuilder stringModification(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        input = input.replaceAll("} ", "}");
        input = input.replaceAll("\\{ ", "{");
        input = input.replaceAll("; ", ";");
        input = input.replaceAll(" ;", ";");
        return new StringBuilder(input);
    }
    private StringBuilder addTabulation(StringBuilder string, int indexOfSymbol) {
        for(int j = 0; j < this.level; ++j) {
            string.insert(indexOfSymbol, "\t");
        }
        return string;
    }
    private void addTransition(StringBuilder string, int indexOfSymbol) {
        string.insert(indexOfSymbol, "\n");
    }
    private void addTransitionAndTabulation(StringBuilder string, int indexOfSymbol) {
        this.addTransition(string, indexOfSymbol);
        this.addTabulation(string, indexOfSymbol + 1);
    }
    public String format(String input) {
        StringBuilder string = this.stringModification(input);
        int i = 1;
        while(i < string.length()) {
            switch(string.charAt(i - 1)) {
                case ';':
                    if (string.charAt(i) == '}') {
                        --this.level;
                    }
                    this.addTransitionAndTabulation(string, i);
                    i += 2;
                    break;
                case '{':
                    ++this.level;
                    this.addTransitionAndTabulation(string, i);
                    i += 2;
                    break;
                case '}':
                    --this.level;
                    this.addTransitionAndTabulation(string, i);
                default:
                    ++i;
            }
        }
        return string.toString();
    }
}
