# Tempo
A metronome mobile app.

This is a project to compare the difference between [quasar](https://quasar.dev/), [ionic](https://ionicframework.com/docs) and working directly on AndroidStudio.

Works with multiple time signatures, multiple bmps and and the beats can be audio, visual and vibration.

You can see a web deployment version of this app on [https://tempo.devartiral.com](https://tempo.devartiral.com)

## Comparison

### Quasar

Pros:
- Has the most complete component catalog.
- Has, by far, the best documentation I have ever seen.
- Lets you choose any technology you want to code: Javascript, Typescript, Sass, Less, Stylus, Pug, Webpack, Vite...
- Vue encourages you to follow good practices and modularization.
- You can deploy this project for web, mobile (Android/IOS) and desktop(Linux/MAC/Windows)
- The dark mode is the easiest to implement of all.

Cons:
- Is the less known framework so the average developer have no experience with it.
- Since has the most deploy options also is the one who needs more configuration steps.
- You have to work with the `./src-capacitor ` directory as its own project. If you want to add capacitor plugins which can be confusing some times.

### ionic

Pros:
- As soon as you are done with the app you can build the project without depending on AndroidStudio.
- Includes by default a unit test by component encouraging good developing practices.
- Every component is really isolated, so you can easily released in its own repo.
- The modules and components relationships helps you with the organization of big projects.
- Services architecture are more straightforward to understand than the pinia stores.

Cons:
- Has a more limited list of icons to work with than material.
- The components catalog is not as complete as the Quasar has.
- You are kind of forced to work with Typescript.
- Angular has a tendency to generate more bulky components.
- Any other thing than a Typescript file is complicated to import.
- The code is strongly based on classes which personally I don't like for a non object oriented language like Javascript.

### Android

Pros:
- You don't have to work with `setTimeout`.
- The performance is as good as can be.
- You are able to work to an low level as the Google's engineers has intended.
- Kotlin is an okayish language to work with.

Cons:
- Practically, every pro in the other project exist to cover a problem here.
- If you want to deploy the app for IOS you have to redo it in Swift from the very beginning.
- You are forced to work with AndroidStudio which has a lot of bugs and consumes a lot pc's resources.
- It's really difficult to maintain a health clean code.
- The standard way to develop in this platform changes every 2 or 3 years. What you develop today, it would be deprecated tomorrow.
- You are forced to work with Gradle.
- Modularization is complicated and the result is often more verbose than having everything in the same class.
- Every Android version released has a new unpredictable way to request permissions, access to resources or even compile the project.
- Styling a component is a lottery, it can be as ease as adding an attribute on the XML or as difficult as configure 5 objects.
- Many OOP Good practices are broken to allow retro compatibility with old architecture choices from 15 years ago.

## Installation

### Installation Quasar

You need to install the quasar CLI first:

```bash
npm i -g @quasar/cli
```

Navigate to the quasar project:

```bash
cd ./tempo-quasar
```

Install the dependencies:

```bash
npm i
```

Check the `./tempo-quasar/quasar.config.js` file for the `bin.linuxAndroidStudio` attribute to change it for your path to your AndroidStudio launcher.

To build the project run:

```bash
quasar build -m capacitor -T android --ide
```

This will open AndroidStudio to run the project

### Install angular

You need to install the ionic CLI first:

```bash
npm install -g @ionic/cli
```

Navigate to the angular project:

```bash
cd ./tempo-angular
```

Install the dependencies:

```bash
npm i
```

Build the project with:

```bash
ionic cap build android
```

Open AndroidStudio with:

```bash
ionic cap open android
```

### Install Android

Just open the `./tempo-android` project with AndroidStudio and run.
