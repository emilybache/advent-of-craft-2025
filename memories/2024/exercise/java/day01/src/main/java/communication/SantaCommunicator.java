package communication;

public class SantaCommunicator {
    private final int numberOfDaysToRest;
    private final Logger logger;

    public SantaCommunicator(int numberOfDaysToRest, Logger logger) {
        this.numberOfDaysToRest = numberOfDaysToRest;
        this.logger = logger;
    }

    public String composeMessage(String reindeerName, String currentLocation, int numbersOfDaysForComingBack, int numberOfDaysBeforeChristmas) {
        var daysBeforeReturn = daysBeforeReturn(numbersOfDaysForComingBack, numberOfDaysBeforeChristmas);

        return "Dear " + reindeerName + ", please return from " + currentLocation +
                " in " + daysBeforeReturn + " day(s) to be ready and rest before Christmas.";
    }

    public boolean isOverdue(String reindeerName, String currentLocation, int numbersOfDaysForComingBack, int numberOfDaysBeforeChristmas) {
        if (daysBeforeReturn(numbersOfDaysForComingBack, numberOfDaysBeforeChristmas) <= 0) {
            this.logger.log("Overdue for " + reindeerName + " located " + currentLocation + ".");
            return true;
        }
        return false;
    }

    private int daysBeforeReturn(int numbersOfDaysForComingBack, int numberOfDaysBeforeChristmas) {
        return numberOfDaysBeforeChristmas - numbersOfDaysForComingBack - numberOfDaysToRest;
    }
}