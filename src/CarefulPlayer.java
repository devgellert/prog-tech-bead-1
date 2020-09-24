public class CarefulPlayer extends Player {
    public CarefulPlayer(String name) {
        super(name);
    }

    @Override
    public boolean getWillBuyHouse() {
        int halfMoney = getMoney() / 2;
        return HouseField.FIELD_PRICE <= halfMoney;
    }
}

