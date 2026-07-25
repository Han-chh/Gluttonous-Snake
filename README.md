# Gluttonous Snake

A Java desktop Snake game built around continuous movement, relative turning, apple collection, growth, timing, and collision.

[中文说明](README_zh.md)

## Overview

The project demonstrates a complete small game loop with a moving snake, randomly placed apples, length/time feedback, and terminal collision states. Unlike grid games that stop between moves, the snake advances continuously and the player steers with relative left/right turns.

## Screenshot

![The native Snake board after collecting an apple, with length and time metrics](assets/screenshots/gluttonous-snake.png)

The screenshot is captured directly from the running Java application.

## Features

- Continuous movement
- A/D relative steering
- Apple spawning, growth, and color change
- Length and elapsed-time display
- Boundary and self-collision detection

## Run

The committed JAR was verified with Java 25:

```bash
java -jar Gluttonous-Snake.jar
```

## Current limitations

- No deterministic seed or automated tests.
