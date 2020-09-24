public abstract class Player {

    private int money = 1000;
    private String name;
    private boolean isLost;


    private int currentFieldIndex;

    public Player(String name ){
        this.name = name;
        this.currentFieldIndex = 0;
    }


    // current field
    public int getCurrentFieldIndex() { return currentFieldIndex; }

    public void setCurrentFieldIndex(int currentFieldIndex) {
        this.currentFieldIndex = currentFieldIndex;
    }

    public String getName() { return name; }

    // lost
    public void setLost(){
        isLost = true;
    }

    public boolean isLost() {
        return isLost;
    }

    public int getMoney() {
        return money;
    }

    // money
    public void pay(int amount) {
        this.money -= amount;
    }

    public boolean payForOtherPlayerAndGetIsLost(Player player, int amount) {
        if(!getIsEnoughMoney(amount)) {
            return true;
        }

        System.out.println(getName() + " pays for " + player.getName());

        pay(amount);
        player.getMoney(amount);
        return false;
    }


    public void getMoney(int amount) {
        this.money += amount;
    }

    public abstract boolean getWillBuyHouse();

    // handlers
    public boolean handleHouseFieldStepAndGetIsLost(HouseField houseField) {
        if(!houseField.getHasOwner()) {
            if(!getWillBuyHouse()) return false;
            buyFieldWithoutHouseIfCan(houseField);
        }

        Player owner = houseField.getOwner();
        if(this == owner) {
            if(!houseField.isHouseBuilt()) buyHouseIfCan(houseField);
            return false;
        }

        boolean isHouseBuilt = houseField.isHouseBuilt();
        if(isHouseBuilt) {
            return payForOtherPlayerAndGetIsLost(houseField.getOwner(), HouseField.AMOUNT_TO_PAY_WITH_HOUSE);
        }

        return payForOtherPlayerAndGetIsLost(houseField.getOwner(), HouseField.AMOUNT_TO_PAY_WITH_NO_HOUSE);

    }
    public boolean handleEntertainmentFieldStepAndGetIsLost(EntertainmentField entertainmentField) {
        int amountToPay = entertainmentField.getAmountToPay();

        System.out.println(getName() + " has step on entertainment field, and needs to pay " + amountToPay );

        pay(amountToPay);
        if(getMoney() < 0) return true;
        return false;
    };
    public void handleLuckyFieldStep(LuckyField luckyField) {
        int amountToGet = luckyField.getAmountToGet();
        System.out.println(getName() + " has step on lucky field, and got " + amountToGet );
        getMoney(amountToGet);
    };

    protected boolean getIsEnoughMoney(int needed) {
        boolean isFailure = (getMoney() < needed);

        return isFailure;
    }


    protected void buyFieldWithoutHouseIfCan(HouseField houseField) {
        if(getIsEnoughMoney(HouseField.FIELD_PRICE)) return;

        houseField.setOwner(this);
        this.pay(HouseField.FIELD_PRICE);
        System.out.println(getName()+" has bought a field");
    }

    protected void buyHouseIfCan(HouseField houseField) {
        if(getIsEnoughMoney(HouseField.HOUSE_PRICE)) return;

        houseField.setHouseBuiltToTrue();
        this.pay(HouseField.HOUSE_PRICE);
        System.out.println(getName()+" has bought a house");
    }
}
