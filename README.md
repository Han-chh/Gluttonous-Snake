# Gluttonous Snake Game

A classic Snake game implemented in Java using Swing GUI framework.

## Description

This is a simple implementation of the popular Snake game where the player controls a snake that grows by eating apples while avoiding collisions with walls and its own body. The game features a graphical interface with real-time updates, scoring, and timer functionality.

## Features

- **Classic Gameplay**: Control the snake using keyboard inputs (A for left turn, D for right turn)
- **Dynamic Snake Growth**: Snake changes color based on length (Cyan → Green → Blue → Yellow → Pink → Gray → Black)
- **Real-time Scoring**: Track snake length and elapsed time
- **Apple Generation**: Red apples appear randomly every 5 seconds
- **Collision Detection**: Game ends when snake hits walls or its own body
- **User Interface**: Clean GUI with info panel showing current stats and control buttons

## Requirements

- Java Runtime Environment (JRE) 8 or higher
- Java Development Kit (JDK) for compilation

## How to Run

1. **Compile the project**:
   ```bash
   javac -d bin src/game/*.java
   ```

2. **Run the game**:
   ```bash
   java -cp bin game.Game
   ```

## Game Controls

- **A**: Turn snake left
- **D**: Turn snake right
- **START Button**: Begin the game
- **INSTRUCTIONS Button**: View game rules

## Game Rules

1. This is a game of a hungry snake
2. Use A or D to make the snake turn left and right
3. Try to eat red apples to make yourself longer!
4. Never hit the boundary or your own body

## Project Structure

```
src/game/
├── Game.java          # Main class and entry point
├── Window.java        # Main window and GUI setup
├── Snake_head.java    # Snake logic and movement
├── Control.java       # Game control and map initialization
├── Map_things.java    # Individual map grid cell
├── Apple.java         # Apple (food) class
├── Decorations.java   # Base class for decorations
├── ButtonPerform.java # Button action handlers
├── timer.java         # Timer thread for game timing
```

## Contributing

Feel free to fork this project and submit pull requests with improvements or bug fixes.

## License

This project is open source and available under the [MIT License](LICENSE).