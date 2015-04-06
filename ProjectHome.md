A simple java tool for renaming files (Windows, Mac OS X, Windows) :

![https://lh4.googleusercontent.com/-i4nPaEGplPA/TWqOVh83QOI/AAAAAAAAAiA/u4T8BLHehbg/s1600/jRename.png](https://lh4.googleusercontent.com/-i4nPaEGplPA/TWqOVh83QOI/AAAAAAAAAiA/u4T8BLHehbg/s1600/jRename.png)

# Installation #

There is yet no package distribution for Windows, Mac OS X or Linux. Just a simple Java executable archive you can run the following way :

## Windows ##

Open a command prompt and dir to the directory in wich you placed the jRename.jar file and type the following command :

`java -jar jRename.jar`

If double clicking on the jRename.jar file doesn't do nothing, you can setup Windows to open .jar file with java by default.

Check the Windows explorer > Tools > Folder Options > File Types.

Create an application association for executable Jar files :

`c:\Program Files\Java\j2re\bin\javaw.exe -jar "%1"`

Save the association. You can now double click on executable Jar files to open them.

## Mac OS X ##

On Mac OS X, you just need to double click on the jRename.jar icon...
Nothing more simple !

You can also open a Terminal window and cd to the directory in wich you placed the jRename.jar file and then type the following command :

`java -jar jRename.jar`

## Linux ##

Open a Terminal window and cd to the directory in wich you placed the jRename.jar file and type the following command :

`java -jar jRename.jar`