What is VanillaClassic?
----------------
VanillaClassic is a plugin for the Spout platform that provides vanilla Minecraft Classic functionality and gameplay.

Copyright (c) 2011-2012, Greatman & Contributors

Who is Greatman?
------------------------
[![Greatman](http://www.gravatar.com/avatar/9f5dab0846895bfb4308393bd2aac4c9?d=mm&r=pg&s=48)](http://www.spout.org/members/greatman.101/)
Visit our [website][Website] or get support on our [forums][Forums].  
Track and submit issues and bugs on our [issue tracker][Issues].


Source
------
The latest and greatest source can be found on [GitHub].  
Download the latest builds from [Jenkins].  [![Build Status](http://jenkins.greatmancode.com/VanillaClassic/badge/icon)][Jenkins]  
View the latest [Javadoc].

License
-------
VanillaClassic is licensed under the [GNU Lesser General Public License Version 3][License], but with a provision that files are released under the MIT license 180 days after they are published. Please see the `LICENSE.txt` file for details.

Compiling
---------
VanillaClassic uses Maven to handle its dependencies.

* Install [Maven 2 or 3](http://maven.apache.org/download.html)  
* Checkout this repo and run: `mvn clean install`

Using with Your Project
-----------------------
For those using [Maven](http://maven.apache.org/download.html) to manage project dependencies, simply include the following in your pom.xml:

    <dependency>
        <groupId>com.greatmancode</groupId>
        <artifactId>vanillaclassic</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>

If you do not already have repo.spout.org in your repository list, you will need to add this also:

    <repository>
        <id>greatman-repo</id>
        <url>http://repo.greatmancode.com/content/groups/public/</url>
    </repository>

Coding and Pull Request Formatting
----------------------------------
* Generally follow the Oracle coding standards.
* Use tabs, no spaces.
* No trailing whitespaces.
* 200 column limit for readability.
* All new files must include the license header. This can be done automatically with Maven by running mvn clean.
* All changes made via pull requests first be compiled locally to verify that the code does indeed compile, and tested to verify that it actually works.
* Where practical, a test should be included to verify the change. Except in exceptional cases, bug fixes **MUST** include a test case which fails for the current version and passes for the updated version.
* Commit messages must include:
    - A brief description of the change
    - A more detailed description of the change (second line and below, optional)
    - Sign-off, verifying agreement with the license terms
* Number of commits in a pull request should be kept to **one commit** and all additional commits must be **squashed** except for circumstantial exceptions.
* You may have more than one commit in a pull request if the commits are separate changes, otherwise squash the commits.
* For clarification, see the full pull request guidelines [here](http://spout.in/prguide).

**Please follow the above conventions if you want your pull request(s) accepted.**

[License]: http://www.spout.org/SpoutDevLicenseV1.txt
[Website]: http://forums.spout.org/threads/gamemode-vanillaclassic-bringing-minecraft-classic-in-spout.6173/
[Forums]: http://forums.spout.org/threads/gamemode-vanillaclassic-bringing-minecraft-classic-in-spout.6173/
[GitHub]: https://github.com/greatman/VanillaClassic
[Javadoc]: http://jenkins.greatmancode.com/Job/VanillaClassic/Javadoc
[Jenkins]: http://jenkins.greatmancode.com/Job/VanillaClassic/
[Issues]: https://github.com/greatman/VanillaClassic/issues