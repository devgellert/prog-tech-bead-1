public class LuckyField extends Field {

    private int amountToGet;

    public int getAmountToGet() { return amountToGet; }

    public LuckyField(int amountToGet) {
        this.amountToGet = amountToGet;
    }

    @Override
    public boolean handleStepAndGetIsPlayerLost(Player player) {
        player.handleLuckyFieldStep(this);
        return false;
    }
}

