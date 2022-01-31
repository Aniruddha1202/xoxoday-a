package com.xoxoday.mode;

import com.xoxoday.OutputPrinter;
import com.xoxoday.commands.CommandExecutorFactory;
import com.xoxoday.commands.ExitCommandExecutor;
import com.xoxoday.model.Command;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Mode running in which input commands are given from an interactive shell.
 */
public class InteractiveMode extends Mode {

  public InteractiveMode(
      final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
    super(commandExecutorFactory, outputPrinter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void process() throws IOException {
    outputPrinter.welcome();
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      final String input = reader.readLine();
      final Command command = new Command(input);
      processCommand(command);
      if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
        break;
      }
    }
  }
}
