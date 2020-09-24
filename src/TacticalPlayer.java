public class TacticalPlayer extends Player {
    private int buyAmount = 0;

    public void increaseBuyAmount() {
        this.buyAmount++;
    }

    public boolean getIsBuyAmountEven() {
        return buyAmount % 2 == 0;
    }

    public TacticalPlayer(String name) {
        super(name);
    }

    @Override
    protected void buyFieldWithoutHouseIfCan(HouseField houseField) {
        super.buyFieldWithoutHouseIfCan(houseField);
        increaseBuyAmount();
    }

    @Override
    protected void buyHouseIfCan(HouseField houseField) {
        super.buyHouseIfCan(houseField);
        increaseBuyAmount();
    }

    @Override
    public boolean getWillBuyHouse() {
        return HouseField.FIELD_PRICE <= getMoney() && !getIsBuyAmountEven();
    }
}
