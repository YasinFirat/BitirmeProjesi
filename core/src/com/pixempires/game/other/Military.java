package com.pixempires.game.other;

import com.pixempires.game.enums.Command;

public class Military {
    private Command command =Command.defance;
    private ListOfCharacters characters;
    private CommandPositions command_positions;

    public Command getCommand() {
        return command;
    }

    public Military setCommand(Command command) {
        this.command = command;
        return this;
    }

    public ListOfCharacters getCharacters() {
        return characters;
    }

    public Military setCharacters(ListOfCharacters characters) {
        this.characters = characters;
        return this;
    }

    public CommandPositions getCommandPositions() {
        return command_positions;
    }

    public Military setCommandPositions(CommandPositions command_positions) {
        this.command_positions = command_positions;
        return this;
    }
}
