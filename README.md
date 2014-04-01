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
 change the dependency version of lwjgl to 2.9.1<br>
 run "gradle build copyDeps runMain" to play.<br>
 

3. PLAYING RULES
<pre>
________________________
¦     ¦     ¦     ¦     ¦
¦  1  ¦  2  ¦  3  ¦  4  ¦
¦_____¦_____¦_____¦_____¦
¦     ¦     ¦     ¦     ¦
¦  5  ¦  6  ¦  7  ¦  8  ¦
¦_____¦_____¦_____¦_____¦
¦     ¦     ¦     ¦     ¦
¦  9  ¦  10 ¦  11 ¦  12 ¦
¦_____¦_____¦_____¦_____¦
¦     ¦     ¦     ¦     ¦
¦  13 ¦  14 ¦  15 ¦     ¦
¦_____¦_____¦_____¦_____¦
</pre>

The button S makes shuffle of the cells.<br>
Escape closes the game.<br>
Arrow keys move the cells.<br>
Clicking on the cell neighboring the empty cell moves it.<br>

<img src="https://github.com/ssppkenny/mygame/blob/master/res/screen.jpg?raw=true" width="50%" height="50%">

