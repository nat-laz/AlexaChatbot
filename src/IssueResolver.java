import java.util.Scanner;
import java.util.Set;

class IssueResolver {
    private static Scanner scanner = new Scanner(System.in);

    public Set<String> alexaNotRespondingKeywords() {
        return Set.of("responding issue", "not responding", "won't respond", "stopped working", "alexa isn't responding", "alexa not hearing");
    }

    public Set<String> wifiIssuesKeywords() {
        return Set.of("wifi", "internet", "connection", "connectivity", "no internet", "network issues", "loading", "slow", "speed");
    }

    public Set<String> adjustVolumeKeywords() {
        return Set.of("volume", "loudness", "sound", "increase volume", "decrease volume", "cant hear");
    }

    public Set<String> enablingSkillsKeywords() {
        return Set.of("skills", "enable skills", "add skills", "skill activation", "new skills");
    }

    public Set<String> checkForUpdatesKeywords() {
        return Set.of("update", "upgrade", "new version", "check for updates", "software update", "version");
    }

    public Set<String> setupDeviceKeywords() {
        return Set.of("setup", "install", "configure", "add device", "device setup", "connect iphone", "iphone");
    }

    public Set<String> generalTroubleshootingKeywords() {
        return Set.of("troubleshoot", "fix", "problem", "issues", "not working");
    }

    public Set<String> echoDotIssuesKeywords() {
        return Set.of("echo dot", "dot", "device issues", "echo problems");
    }

    public Set<String> playMusicKeywords() {
        return Set.of("play music", "music", "listen to music", "play a song", "play audio", "song", "audio");
    }

    public Set<String> scheduleACallKeywords() {
        return Set.of("schedule a call", "schedule", "talk", "call", "speak with");
    }

    public void alexaNotResponding() {
        Logger.printAndLog("Chatbot: If Alexa is not responding, try these steps:");
        Logger.printAndLog("1. Restart your device by unplugging it and plugging it back in.");
        Logger.printAndLog("2. Check if it's connected to power.");
        Logger.printAndLog("3. Make sure you’re using the wake word correctly.");

        if (Utils.askYesNoQuestion("Is it still not responding?", scanner)) {
            if (Utils.askYesNoQuestion("Have you reset it?", scanner)) {
                Logger.printAndLog("Chatbot: If the issue persists, consider contacting support.");
                if (Utils.askYesNoQuestion("Would you like to schedule a call with a representative to resolve the issue?", scanner)) {
                    scheduleACall();
                } else {
                    Logger.printAndLog("Chatbot: Let me know if you need further assistance.");
                }
            } else {
                Logger.printAndLog("Chatbot: Great! If you have any more questions, just ask.");
            }
        } else {
            Logger.printAndLog("Chatbot: I'm glad it worked! Let me know if you have any more questions.");
        }
    }

    public void wifiIssues() {
        Logger.printAndLog("Chatbot: To resolve Wi-Fi issues:");
        Logger.printAndLog("1. Ensure your device is connected to Wi-Fi. Check the Alexa app under 'Devices'.");
        Logger.printAndLog("2. Restart your router.");
        Logger.printAndLog("3. Move the device closer to the router.");
        Logger.printAndLog("4. Check for any service outages in your area.");

        if (Utils.askYesNoQuestion("Are you still having issues with Wi-Fi?", scanner)) {
            Logger.printAndLog("Chatbot: Try forgetting the Wi-Fi network in the Alexa app and reconnecting.");
            if (Utils.askYesNoQuestion("Did you try reconnecting?", scanner)) {
                Logger.printAndLog("Chatbot: If it still doesn’t connect, consider resetting your router.");
            } else {
                Logger.printAndLog("Chatbot: Let me know if you need any further assistance!");
            }
        } else {
            Logger.printAndLog("Chatbot: Awesome! Let me know if you need help with anything else.");
        }
    }

    public void adjustVolume() {
        Logger.printAndLog("Chatbot: To adjust the volume:");
        Logger.printAndLog("1. Say 'Alexa, set the volume to 5' for a specific level.");
        Logger.printAndLog("2. Use the physical volume buttons on your Alexa device.");
        Logger.printAndLog("3. Adjust the volume in the Alexa app under 'Devices'.");

        if (Utils.askYesNoQuestion("Are you satisfied with the volume now?", scanner)) {
            Logger.printAndLog("Chatbot: Great! If you have any more questions, just ask.");
        } else {
            Logger.printAndLog("Chatbot: You can also try saying 'Alexa, increase the volume' or 'decrease the volume'.");
            if (Utils.askYesNoQuestion("Did that work?", scanner)) {
                Logger.printAndLog("Chatbot: Great! If you have any more questions, just ask.");
            } else {
                Logger.printAndLog("Chatbot: If it's still not right, check if the Do Not Disturb mode is turned on.");
            }
        }
    }

    public void enablingSkills() {
        Logger.printAndLog("Chatbot: To enable skills:");
        Logger.printAndLog("1. Open the Alexa app and go to 'Skills & Games'.");
        Logger.printAndLog("2. Browse or search for skills you want to enable.");
        Logger.printAndLog("3. Tap 'Enable' to add the skill to your Alexa.");

        if (Utils.askYesNoQuestion("Have you enabled the skill you wanted?", scanner)) {
            Logger.printAndLog("Chatbot: Awesome! Enjoy your new skills. Let me know if you need anything else.");
        } else {
            Logger.printAndLog("Chatbot: If you need help finding skills, you can search for specific categories in the app.");
            if (Utils.askYesNoQuestion("Are you looking for a specific type of skill?", scanner)) {
                Logger.printAndLog("Chatbot: You can explore categories like Games, Music, or Smart Home.");
            } else {
                Logger.printAndLog("Chatbot: Let me know if you have any more questions about skills.");
            }
        }
    }

    public void checkForUpdates() {
        Logger.printAndLog("Chatbot: To check for updates:");
        Logger.printAndLog("1. Your Alexa device usually updates automatically.");
        Logger.printAndLog("2. Check the Alexa app under 'Settings' for any available updates.");

        if (Utils.askYesNoQuestion("Have you checked for updates?", scanner)) {
            Logger.printAndLog("Chatbot: Good! Let me know if you need help with anything else.");
        } else {
            Logger.printAndLog("Chatbot: Please check for updates and see if that resolves your issue.");
        }
    }

    public void setupDevice() {
        Logger.printAndLog("Chatbot: To set up a new device:");
        Logger.printAndLog("1. Open the Alexa app and go to 'Devices'.");
        Logger.printAndLog("2. Tap on 'Add Device' and select the type of device.");
        Logger.printAndLog("3. Follow the on-screen instructions to complete the setup.");

        if (Utils.askYesNoQuestion("Did you successfully set up your device?", scanner)) {
            Logger.printAndLog("Chatbot: Awesome! Enjoy your new device. Let me know if you need anything else.");
        } else {
            Logger.printAndLog("Chatbot: If you have trouble, try restarting your Alexa device and the new device.");
        }
    }

    public void generalTroubleshooting() {
        Logger.printAndLog("Chatbot: For general troubleshooting:");
        Logger.printAndLog("1. Restart your Alexa device.");
        Logger.printAndLog("2. Make sure it is connected to the internet.");
        Logger.printAndLog("3. Check if there are any known issues with Alexa services.");

        if (Utils.askYesNoQuestion("Did this help resolve your issue?", scanner)) {
            Logger.printAndLog("Chatbot: Great! Let me know if you have any more questions.");
        } else {
            Logger.printAndLog("Chatbot: You can also try resetting your device to factory settings.");
        }
    }

    public void echoDotIssues() {
        Logger.printAndLog("Chatbot: For Echo Dot issues:");
        Logger.printAndLog("1. Check the power connection.");
        Logger.printAndLog("2. Ensure the device is connected to Wi-Fi.");
        Logger.printAndLog("3. Restart the device by unplugging it and plugging it back in.");

        if (Utils.askYesNoQuestion("Is your Echo Dot working now?", scanner)) {
            Logger.printAndLog("Chatbot: Awesome! Let me know if you need any more help.");
        } else {
            Logger.printAndLog("Chatbot: If problems persist, consider resetting your Echo Dot to factory settings.");
        }
    }

    public void playMusic() {
        Logger.printAndLog("Chatbot: To play music, you can say:");
        Logger.printAndLog("1. 'Alexa, play music'.");
        Logger.printAndLog("2. 'Alexa, play [song name]'.");
        Logger.printAndLog("3. 'Alexa, play [artist name]'.");

        if (Utils.askYesNoQuestion("Is music playing as expected?", scanner)) {
            Logger.printAndLog("Chatbot: Great! Enjoy your music!");
        } else {
            Logger.printAndLog("Chatbot: Make sure your music service is connected in the Alexa app.");
        }
    }


    public void scheduleACall() {
        Logger.printAndLog("Chatbot: Please enter your phone number to schedule a call: ");
        String phoneNumber = scanner.nextLine();
        Logger.printAndLog("Phone number entered: " + phoneNumber);  // Log the phone number

        Logger.printAndLog("Please choose a time slot from the following options:");
        Logger.printAndLog("1. 10:00 AM - 12:00 PM");
        Logger.printAndLog("2. 1:00 PM - 3:00 PM");
        Logger.printAndLog("3. 4:00 PM - 6:00 PM");

        Logger.printAndLog("Chatbot: Please select a number for the preferred time slot: ");
        String choice = scanner.nextLine();
        Logger.log(choice);
        switch (choice) {
            case "1":
                Logger.printAndLog("Chatbot: You've selected 10:00 AM - 12:00 PM. A representative will contact you during this time tomorrow.");
                break;
            case "2":
                Logger.printAndLog("Chatbot: You've selected 1:00 PM - 3:00 PM. A representative will contact you during this time tomorrow.");
                break;
            case "3":
                Logger.printAndLog("Chatbot: You've selected 4:00 PM - 6:00 PM. A representative will contact you during this time tomorrow.");
                break;
            default:
                Logger.printAndLog("Chatbot: Invalid option. Please try again.");
                scheduleACall();
                break;
        }
    }
}