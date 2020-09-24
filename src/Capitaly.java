import java.util.ArrayList;

public class Capitaly {

    final private ArrayList<Field> fields = new ArrayList<>();
    final private ArrayList<Player> players = new ArrayList<>();
    private int playerIndex = 0;

    // end
    public boolean getIsEnd() {
        return players.size() <= 1;
    }
    
    // field
    final public void addField(Field field) {
        this.fields.add(field);
    }

    final public ArrayList<Field> getFields() { return fields; }

    // player
    final public ArrayList<Player> getPlayers() { return players; }
    final public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void runGame() {
        try {
            boolean isEnd = getIsEnd();

            while (!isEnd) {
                handleOneCubeThrow();

                isEnd = getIsEnd();
            }

            Player winner = getWinner();

            if(winner == null) throw new Exception("No winner found");
            System.out.println("The winner is " + winner.getName());

        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public void handleOneCubeThrow() {
        Player player = players.get(playerIndex);

        int playerNewFieldIndex = getPlayersNewFieldIndex(player);

        Field currentField = fields.get(playerNewFieldIndex);

        player.setCurrentFieldIndex(playerNewFieldIndex);

        boolean isPlayerLost = currentField.handleStepAndGetIsPlayerLost(player);

        if(isPlayerLost) {
            for (Field field : fields) {

            }
            players.remove(player);
            // index marad a régi
        }else {
            playerIndex = playerIndex + 1 < players.size() -1 ? playerIndex + 1 : 0;
        }
    }

    private int getPlayersNewFieldIndex(Player player) {
        int cubeValue = getNewCubeValue();

        int maxFieldIndex = fields.size() - 1;

        int index = player.getCurrentFieldIndex() + cubeValue;

        int res = maxFieldIndex <= index ?  index - maxFieldIndex : index;

        return res;
    }

    final public int getNewCubeValue() {
        Cube cube = new Cube();
        System.out.println("New cube throw: " + cube.getValue());
        return cube.getValue();
    }

//    public void handleNextPlayerIndex() throws Exception {
//        boolean end = false;
//        while(!end) {
//            playerIndex =
//                playerIndex + 1 >= players.size()-1
//                    ? 0 : playerIndex + 1;
//            end = !players.get(playerIndex).isLost();
//        }
//    }

    final public Player getWinner() {
        for (Player player : players) {
            if(!player.isLost()) return player;
        }
        return null;
    }
}
