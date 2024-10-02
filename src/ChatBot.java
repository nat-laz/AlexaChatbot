import java.util.*;

class ChatBot {
    private final IssueResolver issueResolver;
    private final List<String> conversationHistory;

    public ChatBot() {
        issueResolver = new IssueResolver();
        conversationHistory = new ArrayList<>();
    }

    public void start(Scanner scanner) {
        String userInput = "";
        displayMenu();

        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye! Hope I could help you.");
                break;
            }

            if (userInput.equalsIgnoreCase("history")) {
                displayHistory();
                continue;
            }

            conversationHistory.add("You: " + userInput);
            respondToUser(userInput);
        }
    }

    private void displayMenu() {
        System.out.println("\nWhat do you need help with?");
        System.out.println("1. Alexa not responding");
        System.out.println("2. Wi-Fi connection issues");
        System.out.println("3. Volume adjustment");
        System.out.println("4. Enabling skills");
        System.out.println("5. Updating Alexa");
        System.out.println("6. Setting up a device");
        System.out.println("7. General troubleshooting");
        System.out.println("8. Echo Dot issues");
        System.out.println("9. Play music");
        System.out.println("10. Schedule a call with our representative");
        System.out.println("Type 'history' to view conversation history.");
        System.out.println("You can also type your question or choose a number.");
    }

    private void respondToUser(String input) {
        input = input.toLowerCase();
        Map<String, Integer> keywordCount = new HashMap<>();

        // Count occurrences of keywords for each issue
        countKeywords(input, issueResolver.alexaNotRespondingKeywords(), keywordCount, "alexaNotResponding");
        countKeywords(input, issueResolver.wifiIssuesKeywords(), keywordCount, "wifiIssues");
        countKeywords(input, issueResolver.adjustVolumeKeywords(), keywordCount, "adjustVolume");
        countKeywords(input, issueResolver.enablingSkillsKeywords(), keywordCount, "enablingSkills");
        countKeywords(input, issueResolver.checkForUpdatesKeywords(), keywordCount, "checkForUpdates");
        countKeywords(input, issueResolver.setupDeviceKeywords(), keywordCount, "setupDevice");
        countKeywords(input, issueResolver.generalTroubleshootingKeywords(), keywordCount, "generalTroubleshooting");
        countKeywords(input, issueResolver.echoDotIssuesKeywords(), keywordCount, "echoDotIssues");
        countKeywords(input, issueResolver.playMusicKeywords(), keywordCount, "playMusic");
        countKeywords(input, issueResolver.scheduleACallKeywords(), keywordCount, "scheduleACall");


        // Determine the issue with the highest count
        String mostRelevantIssue = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : keywordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostRelevantIssue = entry.getKey();
            }
        }

        // Respond to the most relevant issue
        if (mostRelevantIssue != null) {
            switch (mostRelevantIssue) {
                case "alexaNotResponding":
                    issueResolver.alexaNotResponding();
                    break;
                case "wifiIssues":
                    issueResolver.wifiIssues();
                    break;
                case "adjustVolume":
                    issueResolver.adjustVolume();
                    break;
                case "enablingSkills":
                    issueResolver.enablingSkills();
                    break;
                case "checkForUpdates":
                    issueResolver.checkForUpdates();
                    break;
                case "setupDevice":
                    issueResolver.setupDevice();
                    break;
                case "generalTroubleshooting":
                    issueResolver.generalTroubleshooting();
                    break;
                case "echoDotIssues":
                    issueResolver.echoDotIssues();
                    break;
                case "playMusic":
                    issueResolver.playMusic();
                    break;
                case "scheduleACall":
                    issueResolver.scheduleACall();
                    break;
            }
        } else {
            System.out.println("Chatbot: I'm sorry, I didn't understand that. Please try asking about common issues with Alexa or refer to the menu.");
            displayMenu();
        }
    }

    private void countKeywords(String input, Set<String> keywords, Map<String, Integer> keywordCount, String issueKey) {
        int count = 0;
        for (String keyword : keywords) {
            if (input.contains(keyword)) {
                count++;
            }
        }
        keywordCount.put(issueKey, count);
    }

    private void displayHistory() {
        if (conversationHistory.isEmpty()) {
            System.out.println("Chatbot: No conversation history available.");
        } else {
            System.out.println("Chatbot: Here is your conversation history:");
            for (String entry : conversationHistory) {
                System.out.println(entry);
            }
        }
    }
}