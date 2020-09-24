public class GreedyPlayer extends Player {
    public GreedyPlayer(String name) { super(name); }

    @Override
    public boolean getWillBuyHouse() {
        return true;
    }
}
