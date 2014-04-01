mygame
======

This is a little project, where I am using slick2D library.
I am trying to implement the 15 puzzle. 


1. INSTALLATION LINUX<br>
 git clone or download zip and unpack into a local directory.<br>
 download and install gradle build tool from http://www.gradle.org<br>
 run "gradle build copyDeps runMain" to play.<br>

2. INSTALLATION WINDOWS<br> 
 download and unpack zip into a local directory.<br>
 download and unpack slick.zip from http://slick.ninjacave.com into the same directory<br>
 set JAVA_HOME to where you have JDK 7 or higher<br>
 change the dependency version of lwjgl to 2.9.1 so it<br>
 looks like this - compile group: 'org.lwjgl.lwjgl', name: 'lwjgl', version: '2.9.1'<br>
 set systemProperty in the build.gradle like this systemProperty 'java.library.path', 'C:/Temp/mygame-master' 
 to the path where you unpacked the slick.zip<br>
 
 run "gradle build copyDeps runMain" to play.<br>
 

3. PLAYING RULES<br>
<img src="https://github.com/ssppkenny/mygame/blob/master/res/screen.jpg?raw=true" width="25%" height="25%">

The button S makes shuffle of the cells.<br>
Escape closes the game.<br>
Arrow keys move the cells.<br>
Clicking on the cell neighboring the empty cell moves it.<br>



