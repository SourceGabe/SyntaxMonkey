import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hexworks.zircon.api.CP437TilesetResources;
import org.hexworks.zircon.api.SwingApplications;
import org.hexworks.zircon.api.application.AppConfig;
import org.hexworks.zircon.api.application.Application;
import org.hexworks.zircon.api.color.ANSITileColor;
import org.hexworks.zircon.api.data.Position;
import org.hexworks.zircon.api.data.Tile;
import org.hexworks.zircon.api.grid.TileGrid;

public class Main {
    public static void main(String[] args) {

        //Application application = SwingApplications.startApplication();
        TileGrid tileGrid = SwingApplications.startTileGrid();

        AppConfig.newBuilder()
                .withSize(100, 50)
                .withDefaultTileset(CP437TilesetResources.rexPaint16x16())
                .build();

        tileGrid.draw(
                Tile.newBuilder()
                        .withBackgroundColor(ANSITileColor.CYAN)
                        .withForegroundColor(ANSITileColor.WHITE)
                        .withCharacter('x')
                        .build(),
                Position.create(25, 0));


/*
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        String response;
        List<String> questions = new ArrayList<>();
        questions.add("int var = 0;");
        questions.add("String var = \"hello world\";");
        questions.add("boolean switch = false;");

        System.out.println("copy the code syntax");
        for(int i = 0; i < questions.size();){
            System.out.println(questions.get(i));
            response = input.nextLine();
            if(response.equals(questions.get(i))){
                System.out.println("Correct");
                i++;
            }
            else{
                System.out.println("WRONG, do it again");
            }
        }
        System.out.println("Congrats you win!");

            */
    }
}