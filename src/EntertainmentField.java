public class EntertainmentField extends Field {
    private int amountToPay;

    public int getAmountToPay() {
        return amountToPay;
    }

    public EntertainmentField(int amountToPay) {
        this.amountToPay = amountToPay;
    }

    @Override
    public boolean handleStepAndGetIsPlayerLost(Player player) {
        return player.handleEntertainmentFieldStepAndGetIsLost(this);
    }
}

