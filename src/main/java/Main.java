import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hexworks.zircon.api.*;
import org.hexworks.zircon.api.application.AppConfig;
import org.hexworks.zircon.api.component.*;
import org.hexworks.zircon.api.data.Position;
import org.hexworks.zircon.api.graphics.BoxType;
import org.hexworks.zircon.api.grid.TileGrid;
import org.hexworks.zircon.api.screen.Screen;
import org.hexworks.zircon.api.uievent.ComponentEventType;
import org.hexworks.zircon.api.uievent.UIEventResponse;

import static org.hexworks.zircon.api.ComponentDecorations.box;
import static org.hexworks.zircon.api.ComponentDecorations.shadow;

public class Main {
    public static void main(String[] args) {

        String response;
        List<String> questions = new ArrayList<>();
        questions.add("int var = 0;");
        questions.add("String var = \"hello\";");
        questions.add("boolean switch = false;");
        int currentQuestion = 0;

        final TileGrid tileGrid = SwingApplications.startTileGrid(
                AppConfig.newBuilder()
                        .withSize(60, 30)
                        .withDefaultTileset(CP437TilesetResources.aduDhabi16x16())
                        .build());
        final Screen screen = Screen.create(tileGrid);

        Panel panel = Components.panel()
                .withDecorations(
                        // panels can be wrapped in a box
                        box(BoxType.SINGLE, "Panel"),
                        shadow()) // shadow can be added
                .withSize(32, 16) // the size must be smaller than the parent's size
                .withPosition(1, 1)
                .build(); // position is always relative to the parent

        final Header header = Components.header()
                // this will be 1x1 left and down from the top left
                // corner of the panel
                .withPosition(1, 1)
                .withText("SyntaxMonkey")
                .build();

        final TextArea textInput = Components.textArea()
                // this will be 1x1 left and down from the top left
                // corner of the panel
                .withSize(25,1)
                .withPosition(Position.create(3, -2).relativeToBottomOf(header))
                .build();

        final CheckBox checkBox = Components.checkBox()
                .withText("Check me!")
                .withPosition(Position.create(0, 0)
                        // the position class has some convenience methods
                        // for you to specify your component's position as
                        // relative to another one
                        .relativeToBottomOf(header))
                .build();

        final Button start = Components.button()
                .withPosition(Position.create(0, 0) // this means 1 row below the check box
                        .relativeToBottomOf(checkBox))
                .withText("start")
                .build();
        final Button submit = Components.button()
                .withPosition(Position.create(0, -1) // this means 1 row below the check box
                        .relativeToBottomOf(checkBox))
                .withText("submit")
                .build();
        final Label label = Components.label()
                .withText(questions.get(0))
                .withSize(25,1)
                .withPosition(30,0)
                .build();



        panel.addComponent(header);
        panel.addComponent(start);
        panel.addComponent(submit);
        //panel.addComponent(textInput);


        start.handleComponentEvents(ComponentEventType.ACTIVATED, (event) -> {
            //panel.setTheme(ColorThemes.capturedByPirates());
            screen.addComponent(textInput);
            return UIEventResponse.processed();
        });
        submit.handleComponentEvents(ComponentEventType.ACTIVATED, (event) -> {
            if (textInput.getText().equals(questions.get(0))) {
                System.out.println("correct");
                panel.setTheme(ColorThemes.capturedByPirates());
                label.setText(questions.get(1));
            }
            else if(textInput.getText().equals(questions.get(1))){
                System.out.println("correct");
                panel.setTheme(ColorThemes.monokaiBlue());
                label.setText(questions.get(2));
            }
            else if(textInput.getText().equals(questions.get(2))){
                System.out.println("correct");
                panel.setTheme(ColorThemes.afterglow());
                label.setText("YOU WIN!!!!");
            }
            return UIEventResponse.processed();
        });
        screen.addComponent(label);
        screen.addComponent(panel);

// we can apply color themes to a screen
        screen.setTheme(ColorThemes.monokaiBlue());


// in order to see the changes you need to display your screen.
        screen.display();


       /* tileGrid.draw(
                Tile.newBuilder()
                        .withBackgroundColor(ANSITileColor.CYAN)
                        .withForegroundColor(ANSITileColor.WHITE)
                        .withCharacter('x')
                        .build(),
                Position.create(25, 0));*/


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