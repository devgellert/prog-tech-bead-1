public class HouseField extends Field {

    private Player owner = null;
    private boolean isHouseBuilt = false;

    static int FIELD_PRICE = 1000;
    static int HOUSE_PRICE = 4000;

    static int AMOUNT_TO_PAY_WITH_NO_HOUSE = 500;
    static int AMOUNT_TO_PAY_WITH_HOUSE = 2000;


    @Override
    public boolean handleStepAndGetIsPlayerLost(Player player) {
        return player.handleHouseFieldStepAndGetIsLost(this);
    }

    public Player getOwner() { return owner; }

    public boolean getHasOwner() { return owner != null; }

    public boolean isHouseBuilt() { return isHouseBuilt; }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setHouseBuiltToTrue() {
        isHouseBuilt = true;
    }
}

