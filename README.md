<h1 align="center">ARC 🧑‍💻</h1>
<h2 align="center">Advanced rowland-hall-Robot Controller</h2>

---

#### Notera (Note)!
Before contributing, please read the [CONTRIBUTING.md](https://github.com/Rowland-Hall-Iron-Lions/ARC/blob/master/CONTRIBUTING.md) file.

#### Notera (Note)!
If you are an outside party, and are not part of the FTC team named "Rowland Hall Iron Lions", **please refer to the license**.

# Välkommen (Welcome)!
Why did we greet you in Sweedish? You'll never know, and neither will we.

This repository is based on the FtcRobotController, and this is where all of our code goes. You can find the code that we wrote inside the `TeamCode/src/main/java/org/rowlandhall/arc` directory (you can find minimal driver code in `Teamcode/src/main/java/org/firstinspires/ftc/teamcode/`). From there, there is another README explaining the anatomy and layout of the source code.

You can find the original README (for the FtcRobotController repository) [here](https://github.com/FIRST-Tech-Challenge/FtcRobotController).

## Byggnad (Building)!
### Förutsättningar (Prerequisites)
1. JDK 11 (JDK 6+ is required for Gradle, and FTC seems only to like JDK 11)
2. Gradle (not strictly required, the wrapper should install it for you)
3. An IDE of your choice

# IMPORTANT!
Do these steps before you ask how to build.

### Låt oss fortsätta med det (Let's get on with it)
Because of the nature of the FTC Tech Challenge (yes, I know, [RAS syndome](https://en.wikipedia.org/wiki/RAS_syndrome)), all of our code is put inside of the FtcRobotController source tree. They use `gradle`, and so do we. Never used Gradle? Well, you don't need to. Android Studio (our IDE of choice, for most of us anyway) already has Gradle integration, so building should be as simple as pressing the build button. **You need to do some setup the first time you build.** Run this:
```bash
./scripts/setup.sh
```

However, if you are an enterprising person, you may want to do things "the old-fashioned way", and use the command line. **You still need to do the setup, mentioned above** Lucky for us, Gradle is a command-line tool (in fact, Android Studio calls it). You can find the official documentation for building a Gradle project from the command line [here](https://spring.io/guides/gs/gradle/). For your convenience, we have listed the steps below!

```bash
./gradlew build
```

That's it. `gradlew` is a script that downloads Gradle and runs the commands for you, so there's no fuss! This README will be extended to contain instructions on how to run this "binary" from the command line when we figure it out.

### libOpenCvAndroid453.so
For Easy Open Cv to work you have to download the libOpenCvAndroid453.so file and copy it to the robot controller; you can find download and further instructions [here](https://github.com/OpenFTC/EasyOpenCV)

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

