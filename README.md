<h1 align="center">ARC 🧑‍💻</h1>
<h2 align="center">Advanced rowland-hall-Robot Controller</h2>

---

#### Notera (Note)!
Before contributing, please read the [CONTRIBUTING.md](https://github.com/Rowland-Hall-Iron-Lions/ARC/blob/master/CONTRIBUTING.md) file.

# Välkommen (Welcome)!
Why did we greet you in Sweedish? You'll never know, and neither will we.

This repository is based off of the FtcRobotController, and this is where all of our code goes. You can find the code that we wrote inside the `TeamCode/src/main/java/org/firstinspires/ftc/teamcode` directory. From there, there is another README explaining the anotomy and layout of the source code.

You can find the original README (for the FtcRobotController repository) [here](https://github.com/FIRST-Tech-Challenge/FtcRobotController).

## Byggnad (Building)!
### Förutsättningar (Prerequisites)
1. JDK 11 (JDK 6+ is required for Gradle, and FTC seems to only like JDK 11)
2. Gradle (not strictly required, the wrapper should install it for you)
3. An IDE of your choice

### Låt oss fortsätta med det (Let's get on with it)
Because of the nature of the FTC Tech Challege (yes, I know, [RAS syndome](https://en.wikipedia.org/wiki/RAS_syndrome)), all of our code is put inside of the FtcRobotController source tree. They use `gradle`, and so do we. Never used Gradle? Well, you don't really need to. Android Studio (our IDE of choice, for most of us anyways) already has Gradle integration, so building should be as simple as pressing the build button. As for running the program, please refer to the original FtcRobotController repository.

However, if you are an enterprising person, you may want to do things "the old fashioned way", and just use the command line. Lucky for us, Gradle is a command line tool (in fact, Android Studio just calls it). You can find the official documentation for building a Gradle project from the command line [here](https://spring.io/guides/gs/gradle/). For your convience, we have listed the steps below!

```bash
./gradlew build
```

Thats it. `gradlew` is a script that downloads Gradle and runs the commands for you, so theres no fuss! This README will be extended to contain instructions on how to run this "binary" from the command line when we figure it out.

## Författare och meriter (Authors and credits)!
### Programvaruingenjörer (Software engineers)
1. Rapheal Andrea
2. Milo Banks
3. Aurora Chichos/Chicken
4. Jack Revoy
5. Teo Welton

### Bibliotek används (Libraries used)
##### Driver for our code (pun intended!)
1. [FtcRobotController](https://github.com/FIRST-Tech-Challenge/FtcRobotController) (not technically a library, but it's still nice to include)

##### Wheeled mobile robot motion planning library
2. [Road Runner](https://github.com/acmerobotics/road-runner)

### Lagtränare (Team coach)
1. Rob Lingstuyl

