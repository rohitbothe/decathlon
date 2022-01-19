# Decathlon

The task is about Decathlon competition. The input of the Java program is a CSV file (see file results.csv). The program should output an XML (to standard output) with all athletes in ascending order of their places, containing all the input data plus total score and the place in the competition (in case of equal scores, athletes must share the places, e.g. 3-4 and 3-4 instead of 3 and 4).
The rules of Decathlon competitions and formulas for points counting can be found here: http://en.wikipedia.org/wiki/Decathlon (see formulas at the end of the page).

Technical requirements:
· JDK 11 or newer should be used
· Code design should be simple yet flexible allowing easy modifications (e.g. new input/output formats)
· Clean code principles must be followed
· Code should be covered with Unit tests
· No external libraries are allowed in addition to the Java standard API except Junit and mocking libraries
· We recommend using the IntelliJ IDEA or Eclipse as the Java IDE
· Your project should be built using Gradle
