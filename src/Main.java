public class Main {

    public static void main(String[] args) {

        Capitaly game = new Capitaly();

        Field field1 = new HouseField();
        Field field2 = new EntertainmentField(2500);
        Field field3 = new HouseField();
        Field field4 = new LuckyField(3000);
        Field field5 = new HouseField();
        Field field6 = new LuckyField(3000);

        Player gellert = new GreedyPlayer("Gellert");
        Player ferenc = new GreedyPlayer("Ferenc");
        Player bela = new GreedyPlayer("Bela");
        Player sanyi = new TacticalPlayer("Sanyi");
        Player jacint = new TacticalPlayer("jacint");
        Player erzso = new CarefulPlayer("Erzso");
        Player spiderman = new CarefulPlayer("Spiderman");


        game.addField(field1);
        game.addField(field2);
        game.addField(field3);
        game.addField(field4);
        game.addField(field5);
        game.addField(field6);

        game.addPlayer(gellert);
        game.addPlayer(ferenc);
        game.addPlayer(bela);
        game.addPlayer(sanyi);
        game.addPlayer(jacint);
        game.addPlayer(erzso);
        game.addPlayer(spiderman);

        game.runGame();
    }
}
