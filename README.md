---



![ARISL Logo](https://github.com/arismoko/ARIS-Language/assets/19542195/82fe07c5-018c-4622-acf0-b5f112fcfdbf)
# ARISL: A Rapidly Interfacing Scripting Language 

Welcome to **ARISL** (A Rapidly Interfacing Scripting Language), a versatile and user-friendly scripting language designed to transcompile into C# code. ARISL aims to offer the flexibility and simplicity of dynamic scripting languages while harnessing the power and performance of C#.

---

## Table of Contents
1. [Introduction to ARISL](#introduction-to-arisl)
    - [Overview](#overview-of-arisl)
    - [Key Features](#key-features)
    - [Interpreter and Transcompiler](#arisls-interpreter-and-transcompiler)
    - [REPL Mode](#repl-mode)
2. [Core Syntax of ARISL](#core-syntax-of-arisl)
    - [Variable Declarations](#variable-declarations)
    - [Functions](#functions)
    - [Control Structures](#control-structures)
    - [Classes and Objects](#classes-and-objects)
    - [Error Handling](#error-handling)
    - [Tables](#tables)
3. [Importing and Using External Libraries](#importing-and-using-external-libraries)
    - [Creating Flappy Bird with Raylib](#creating-flappy-bird-with-raylib)
4. [Future Developments and Encouragement](#future-developments-and-encouragement)
5. [Acknowledgements](#acknowledgements)

---

## Introduction to ARISL

### Overview of ARISL
ARISL is designed to be intuitive, allowing developers to write code quickly and efficiently. It supports a wide range of features, including dynamic variable declarations, async functions, and class definitions. With ARISL, you can leverage the vast ecosystem of C# libraries and tools, making it a powerful choice for both small scripts and large applications.

### Key Features
- **Dynamic Typing**: Variables in ARISL can be declared without specifying a type, making the language flexible and easy to use.
- **C# Types**: Because the language transcompiles directly into C# we can explictly use C# types placing a ` ~ ` in front of a modifier. For example: `~int x = 1;`
- **Lua-style Collections**: You can create and manipulate tables in a way similar to Lua, offering a familiar syntax for many developers.
- **Interfacing with C# Libraries**: You can directly interact with C# types and libraries, integrating seamlessly with existing .NET code.

### ARISL's Interpreter and Transcompiler
The ARISL interpreter and transcompiler are at the heart of this language, converting ARISL scripts into executable C# code. This dual functionality ensures that you can both develop and execute your scripts in a streamlined environment.

### REPL Mode
ARISL includes a Read-Eval-Print Loop (REPL) mode, allowing you to write and test your code interactively. This mode is especially useful for experimenting with new features and debugging code on the fly.

**Entering REPL Mode**:  
To start ARISL in REPL mode, simply run the interpreter without any arguments:

```shell
ARISL.exe
```

**Example REPL Session**:
```csharp
ARISL> x = 5
ARISL> print(x)
5
```

### Installing Packages
ARISL allows you to extend its functionality by installing packages, similar to how you would manage dependencies in a typical C# project.

**Downloading a Package**:
```shell
ARISL --download Newtonsoft.Json 13.0.1
```

**Listing Installed Packages**:
```shell
ARISL --list
```

**Deleting a Package**:
```shell
ARISL --delete Newtonsoft.Json
```

**Setting Up ARISL**:
For convenience, you may want to add the folder containing `ARISL.exe` to your PATH environment variable. This will allow you to run ARISL from any command prompt or terminal without needing to specify the full path to the executable.

---

## Core Syntax of ARISL

### Variable Declarations
In ARISL, variables can be declared without specifying a type, making them dynamic by default. If no visibility is specified, variables are public.

**Examples**:
```csharp
x = 10; // dynamic type inferred as int
y = "Hello"; // dynamic type inferred as string
z = true; // dynamic type inferred as bool
```

If you want to specify a type, you can do so using the `~` symbol.
```csharp
~int a = 10;
~string b = "Hello";
~bool c = true;
```

### Functions
Functions in ARISL can be defined using the `func` keyword. If the return type is not specified, the function is compiled as `void`. Functions can also be asynchronous using the `async` keyword.

**Examples**:
```csharp
func SayHello() {
    Console.WriteLine("Hello, World!");
}

async func FetchData() {
    await Task.Delay(1000);
    Console.WriteLine("Data fetched!");
}
```

### Control Structures
ARISL supports typical control structures such as if-else statements, while loops, for loops, and foreach loops.

**If-Else Statements**:
```csharp
x = 10;
if (x > 5) {
    Console.WriteLine("x is greater than 5");
} else if (x == 5) {
    Console.WriteLine("x is equal to 5");
} else {
    Console.WriteLine("x is less than 5");
}
```

**While Loops**:
```csharp
x = 0;
while (x < 5) {
    Console.WriteLine(x);
    x++;
}
```

**For Loops**:
```csharp
for (~int i = 0; i < 5; i++) {
    Console.WriteLine(i);
}
```

**Foreach Loops**:
```csharp
numbers = tbl|1, 2, 3, 4, 5|;

foreach (~int num in numbers) {
    Console.WriteLine(num);
}
```

### Classes and Objects
ARISL allows you to define classes using the `class` keyword. Classes can have fields, properties, constructors, and methods.

**Example Class Definition**:
```csharp
class Dog {
    public ~string Name ~*~
    public ~int Age ~*~
    
    @(~string name, ~int age) { // constructor
        Name = name;
        Age = age;
    }
    
    func Bark() {
        Console.WriteLine(Name + " says Woof!");
    }
}

dog = new ~Dog("Buddy", 5);
dog.Bark(); // Output: Buddy says Woof!
```

### Error Handling
ARISL includes try-catch-finally statements for error handling.

**Example**:
```csharp
try {
    x = 10 / 0;
} catch (~Exception e) {
    Console.WriteLine("An error occurred: " + e.Message);
} finally {
    Console.WriteLine("This will always be executed.");
}
```

### Tables
ARISL supports Lua-style tables for creating associative arrays.

**Example**:
```csharp
arr = tbl|"x" = 50, "y" = 42|;
Console.WriteLine(arr["x"]); // prints 50
```

### Combining It All: A Complete Example
Here's a complete example that combines several features discussed above:
```csharp
class Dog {
    public ~string Name ~*~
    public ~int Age ~*~
    
    @(~string name, ~int age) {
        Name = name;
        Age = age;
    }
    
    func Bark() {
        Console.WriteLine(Name + " says Woof!");
    }
}

async func Main() {
    arr = tbl|"x" = 50, "y" = 42|;
    Console.WriteLine(arr["x"]); // prints 50
    
    dog = new ~Dog("Buddy", 5);
    dog.Bark(); // Output: Buddy says Woof!
    
    x = 0;
    while (x < 5) {
        Console.WriteLine(x);
        x++;
    }
    
    await TestAsync();
}

async ~Task func TestAsync() {
    await Task.Delay(1000);
    Console.WriteLine("Hello World Async!!");
}
```

---

## Importing and Using External Libraries

### Creating Flappy Bird with Raylib
Now, let's create a simple Flappy Bird game using Raylib. We'll go step-by-step, explaining our decisions and highlighting the differences between C# and ARISL syntax.

**Step 1: Importing Raylib**:
```csharp
dotnet(Raylib-cs);
using Raylib_cs;
```

**Step 2: Setting Up the Window**:
```csharp
func main() {
    ~int screenWidth = 800;
    ~int screenHeight = 450;

    Raylib.InitWindow(screenWidth, screenHeight, "Flappy Bird");
    Raylib.SetTargetFPS(60);

    // Other game setup code will go here

    Raylib.CloseWindow();
}
```

**Step 3: Defining Game Variables**:
```csharp
func main() {
    ~int screenWidth = 800;
    ~int screenHeight = 450;

    Raylib.InitWindow(screenWidth, screenHeight, "Flappy Bird");
    Raylib.SetTargetFPS(60);

    // Game variables
    birdX = screenWidth / 4;
    birdY = screenHeight / 2;
    birdRadius = 20;
    ~double

 birdSpeedY = 0;
    ~double gravity = 0.5;
    jumpStrength = -10;

    pipeWidth = 80;
    pipeGap = 200;
    pipeX = screenWidth;
    pipeHeight = Raylib.GetRandomValue(100, screenHeight - pipeGap - 100);

    gameOver = false;
    score = 0;

    // Other game code will go here

    Raylib.CloseWindow();
}
```

**Step 4: Handling Game Logic**:
```csharp
func main() {
    ~int screenWidth = 800;
    ~int screenHeight = 450;

    Raylib.InitWindow(screenWidth, screenHeight, "Flappy Bird");
    Raylib.SetTargetFPS(60);

    // Game variables
    birdX = screenWidth / 4;
    birdY = screenHeight / 2;
    birdRadius = 20;
    ~double birdSpeedY = 0;
    ~double gravity = 0.5;
    jumpStrength = -10;

    pipeWidth = 80;
    pipeGap = 200;
    pipeX = screenWidth;
    pipeHeight = Raylib.GetRandomValue(100, screenHeight - pipeGap - 100);

    gameOver = false;
    score = 0;

    while !Raylib.WindowShouldClose() {
        // Update
        if !gameOver {
            if Raylib.IsKeyPressed(KeyboardKey.Space) {
                birdSpeedY = jumpStrength;
            }

            birdSpeedY += gravity;
            birdY += (~int)<~birdSpeedY;

            pipeX -= 5;
            if pipeX < -pipeWidth {
                pipeX = screenWidth;
                pipeHeight = Raylib.GetRandomValue(100, screenHeight - pipeGap - 100);
                score++;
            }

            if  (birdY - birdRadius < 0) || (birdY + birdRadius > screenHeight) ||
                (birdX + birdRadius > pipeX && birdX - birdRadius < pipeX + pipeWidth) &&
                (birdY - birdRadius < pipeHeight || birdY + birdRadius > pipeHeight + pipeGap) {
                gameOver = true;
            }
        } else {
            if Raylib.IsKeyPressed(KeyboardKey.R) {
                // Reset game
                birdY = screenHeight / 2;
                birdSpeedY = 0;
                pipeX = screenWidth;
                pipeHeight = Raylib.GetRandomValue(100, screenHeight - pipeGap - 100);
                gameOver = false;
                score = 0;
            }
        }

        // Draw
        Raylib.BeginDrawing();
        Raylib.ClearBackground(Color.SkyBlue);

        // Draw bird
        Raylib.DrawCircle(birdX, birdY, birdRadius, Color.Yellow);

        // Draw pipes
        Raylib.DrawRectangle(pipeX, 0, pipeWidth, pipeHeight, Color.Green);
        Raylib.DrawRectangle(pipeX, pipeHeight + pipeGap, pipeWidth, screenHeight - pipeHeight - pipeGap, Color.Green);

        // Draw score
        Raylib.DrawText("Score: " + score.ToString(), 10, 10, 20, Color.Black);

        if gameOver {
            Raylib.DrawText("GAME OVER", screenWidth / 2 - 100, screenHeight / 2 - 50, 50, Color.Black);
            Raylib.DrawText("Press R to Restart", screenWidth / 2 - 120, screenHeight / 2 + 10, 20, Color.Black);
        }

        Raylib.EndDrawing();
    }

    Raylib.CloseWindow();
}
```

### Differences Between ARISL and C# Syntax
**Variable Casting**:
In ARISL, casting is done using the syntax `(~type)<~variable`. For example:
```csharp
birdY += (~int)<~birdSpeedY;
```
This line casts `birdSpeedY` to an `int` before adding it to `birdY`.

**Generic Types/Typed functions**
You can use `~int,~int@` to specify a type for a function. To create c# style generic function you can do the same `~T1,T2@`
```csharp
public static ~void func ~T@(ref ~T lhs, ref ~T rhs)
```
See how we specified that it was a void function? That's only there to ease the anxiety some of you Csharp veterans are probably feeling right about now. You dont need to specify that it's void the interpreter will assume it is.


**Complete Flappy Bird Game**:
Here's the complete code for our Flappy Bird game in ARISL:
```csharp
dotnet(Raylib-cs);
using Raylib_cs;

func main() {
    ~int screenWidth = 800;
    ~int screenHeight = 450;

    Raylib.InitWindow(screenWidth, screenHeight, "Flappy Bird");
    Raylib.SetTargetFPS(60);

    // Game variables
    birdX = screenWidth / 4;
    birdY = screenHeight / 2;
    birdRadius = 20;
    ~double birdSpeedY = 0;
    ~double gravity = 0.5;
    jumpStrength = -10;

    pipeWidth = 80;
    pipeGap = 200;
    pipeX = screenWidth;
    pipeHeight = Raylib.GetRandomValue(100, screenHeight - pipeGap - 100);

    gameOver = false;
    score = 0;

    while !Raylib.WindowShouldClose() {
        // Update
        if !gameOver {
            if Raylib.IsKeyPressed(KeyboardKey.Space) {
                birdSpeedY = jumpStrength;
            }

            birdSpeedY += gravity;
            birdY += (~int)<~birdSpeedY;

            pipeX -= 5;
            if pipeX < -pipeWidth {
                pipeX = screenWidth;
                pipeHeight = Raylib.GetRandomValue(100, screenHeight - pipeGap - 100);
                score++;
            }

            if  (birdY - birdRadius < 0) || (birdY + birdRadius > screenHeight) ||
                (birdX + birdRadius > pipeX && birdX - birdRadius < pipeX + pipeWidth) &&
                (birdY - birdRadius < pipeHeight || birdY + birdRadius > pipeHeight + pipeGap) {
                gameOver = true;
            }
        } else {
            if Raylib.IsKeyPressed(KeyboardKey.R) {
                // Reset game
                birdY = screenHeight / 2;
                birdSpeedY = 0;
                pipeX = screenWidth;
                pipeHeight = Raylib.GetRandomValue(100, screenHeight - pipeGap - 100);
                gameOver = false;
                score = 0;
            }
        }

        // Draw
        Raylib.BeginDrawing();
        Raylib.ClearBackground(Color.SkyBlue);

        // Draw bird
        Raylib.DrawCircle(birdX, birdY, birdRadius, Color.Yellow);

        // Draw pipes
        Raylib.DrawRectangle(pipeX, 0, pipeWidth, pipeHeight, Color.Green);
        Raylib.DrawRectangle(pipeX, pipeHeight + pipeGap, pipeWidth, screenHeight - pipeHeight - pipeGap, Color.Green);

        // Draw score
        Raylib.DrawText("Score: " + score.ToString(), 10, 10, 20, Color.Black);

        if gameOver {
            Raylib.DrawText("GAME OVER", screenWidth / 2 - 100, screenHeight / 2 - 50, 50, Color.Black);
            Raylib.DrawText("Press R to Restart", screenWidth / 2 - 120, screenHeight / 2 + 10, 20, Color.Black);
        }

        Raylib.EndDrawing();
    }

    Raylib.CloseWindow();
}
```

---

## Future Developments and Encouragement

### Current State of ARISL
ARISL is still very much in its infancy. While it already offers a range of features and functionality, there are many areas where the language can be expanded and improved.

### Upcoming Features
#### IntelliSense and Language Server
One of the most exciting developments is the upcoming ARISL language server, which will provide C# style IntelliSense in Visual Studio Code. This will greatly enhance the coding experience by offering auto-completion, method signatures, and other helpful features. The first version (0.0.1) will be uploaded soon, making it easier for developers to write and debug ARISL code.

### Encouraging Contributions and Feedback
We welcome feedback and contributions from the community. Whether you encounter bugs or have suggestions for new features, your input is invaluable. By working together, we can continue to improve ARISL and make it a powerful tool for developers.

### Encouragement for Aspiring Language Creators
Creating a new programming language is a challenging but incredibly rewarding endeavor. If you're passionate about programming and have ideas for a language, I encourage you to try building it. Here are a few tips to get you started:

**Start Small**:
Begin with a simple language specification and gradually add features. It's easier to manage a small, functional language and expand it over time than to start with an overly complex design.

**Use Existing Tools**:
Tools like ANTLR (Another Tool for Language Recognition) can simplify the process of creating parsers and interpreters. ARISL started with the intention of transcompiling into Lua code, but thanks to ANTLR, it was easy to pivot to transcompiling into C# when needed.

**Seek Feedback**:
Share your language with others and seek feedback. This can help you identify areas for improvement and new features that you might not have considered.

**Stay Persistent**:
There will be challenges and setbacks, but persistence is key. When things get complex, take a step back, analyze the problem, and keep pushing forward.

---

## Acknowledgements
Developing ARISL has been a collaborative and learning experience. I would like to extend my heartfelt thanks to:

- **TJ**: For his invaluable help in testing and for keeping me motivated when the project became complex.
- **ANTLR**: For providing the tools that made developing ARISL much easier.


---

## Conclusion
ARISL is at the beginning of its journey, and with your help and feedback, it has the potential to grow into a powerful and versatile language. Whether you're using ARISL or thinking about creating your own language, the key is to start, experiment, and enjoy the process.

Happy coding!

---
