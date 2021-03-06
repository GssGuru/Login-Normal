# !!! In developing !!!
This repository is in development mode.

# Login page
Simple example login page with 1 Button, 2 EditText and internet request. 
We take the data from the input fields and when you click on the button, send a request to the server and wait for an answer

# About the aplication
 - MVP
 - REST(Retrofit)
 - Dagger2
 - RXAndroid
 - Android Anotation

# Preview
![](http://media.giphy.com/media/5b9xDSw5DBiGBGwRak/giphy.gif) ![](http://media.giphy.com/media/4VXZfmSXGJAiC3wsZb/giphy.gif)

# Code
Description of the application code
<details><summary>Open</summary>
<p>

## Manifest
In the [`Manifest`](https://github.com/GssGuru/Login-Normal/blob/master/app/src/main/AndroidManifest.xml) add permission on the Internet and initialize MyApp.class. Read the comments in the code

## gradle
In the [`gradle`](https://github.com/GssGuru/Login-Normal/blob/master/app/build.gradle) add only dependencies on the Internet, ButterKnife , Moxy(MVP) and library for work with image. Read the comments in the code

## Aplication code
[`Aplication code`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal) - is the code with the mechanics of the application.
Carefully read the code comments.

To make our code more flexible we apply the MVP architectural pattern. Divide application into parts:
- [`model`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/model) - here we will work with the business logic of the application
- [`ui`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/ui) - here we will work with the UI "View-Presenter"
- [`utils`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/utils) - here we will store our utilities
- [`MyApp.class`](https://github.com/GssGuru/Login-Normal/blob/master/app/src/main/java/gss/guru/loginnormal/MyApp.java) - root class in the application. Used for various flexible solutions and getting the context and any place of application

Package [`model`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/model). Divide package into parts:
- [`interactors`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/model/interactors) - Here we will work with entities.
- [`repositories`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/model/repository) - here we work only with data. We take and place them in the database, internal storage or work with Internet requests

Package [`ui`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/ui). Divide package into parts:
- [`login`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/ui/login) -  This package is called in accordance with the activation and in it are all the components necessary for the operation of this activit
- [`utils`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/ui/utils) - our utilities that only work with UI elements
- [`BaseView.java`](https://github.com/GssGuru/Login-Normal/blob/master/app/src/main/java/gss/guru/loginnormal/ui/BaseView.java) - our utilities that only work with UI elements

Package [`login`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/java/gss/guru/loginnormal/ui/login). Divide package into parts:
- [`LoginActivity.java`](https://github.com/GssGuru/Login-Normal/blob/master/app/src/main/java/gss/guru/loginnormal/ui/login/LoginActivity.java) - page with 1 Button, 2 EditText, progress and internet request.
- [`LoginActivityPresenter.java`](https://github.com/GssGuru/Login-Normal/blob/master/app/src/main/java/gss/guru/loginnormal/ui/login/LoginPresenter.java) - Element of the architectural pattern MVP. Binds business logic and view
- [`LoginActivityView.java`](https://github.com/GssGuru/Login-Normal/blob/master/app/src/main/java/gss/guru/loginnormal/ui/login/LoginPresenterView.java) - Element of the architectural pattern MVP. Binds Presenter and UI

## Resources code
[`Res folder.`](https://github.com/GssGuru/Login-Normal/tree/master/app/src/main/res) Change only Application Name

</p>
</details>
