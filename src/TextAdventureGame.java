public class TextAdventureGame {
    // if I ever turn this into a GUI, add italics for *
    private static final String[] GUARD_DIALOGUE = {
            "Guard: \"No talking!\"",
            "Guard: \"What did I just say? NO TALKING!\"",
            "Guard: \"Don't make me come in there.\"",
            "Guard: *the guard becomes unresponsive. he is giving you the silent treatment*"
    };
    private int dialogueIndex = 0; // Counter variable to keep track of which line of dialogue to print next

    public String processInput(String input) {
        String output = "";

        if (input.trim().isEmpty()) {
            output += "You wake up in a jail cell. You have no idea how you got here.\n";
            output += "There is a guard standing outside your cell.\n";
            output += "Your options are \"talk,\" \"look\", \"escape\", or \"quit\"\n";
            return output;
        }

        String[] words = input.trim().split(" ");
        String command = words[0].toLowerCase();

        switch (command) {
            case "talk":
                if (dialogueIndex < GUARD_DIALOGUE.length) {
                    output += GUARD_DIALOGUE[dialogueIndex] + "\n";
                    dialogueIndex++; // Increment the counter variable to print the next line of dialogue next time
                } else {
                    output += "*do you not know how the silent treatment works?*\n";
                }
                break;
            case "look":
                output += "You look around the cell. It's small and cramped.\n";
                break;
            case "escape":
                output += "You try to escape, but the cell is too secure.\n";
                break;
            case "quit":
                output += "Goodbye!\n";
                break;
            default:
                output += "I'm sorry, I didn't understand that.\n";
                break;
        }

        return output;
    }
}
