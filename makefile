JUNIT_JAR = junit-4.12.jar
JUNIT_URI = https://github.com/junit-team/junit4/releases/download/r4.12/$(JUNIT_JAR)
HAMCREST_JAR = hamcrest-core-1.3.jar
HAMCREST_URI = http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/$(HAMCREST_JAR)
CLASSPATH = -cp .:$(JUNIT_JAR):$(HAMCREST_JAR)
CC = javac $(CLASSPATH)

.SUFFIXES: .java .class
.java.class:
	$(CC) $<

default: Hello.class
	java $(CLASSPATH) Hello
test: Hello.class HelloTest.class
	java $(CLASSPATH) org.junit.runner.JUnitCore HelloTest
HelloTest.class: $(JUNIT_JAR) $(HAMCREST_JAR)
$(JUNIT_JAR):
	curl $(JUNIT_URI) -o $(JUNIT_JAR) --silent --location
$(HAMCREST_JAR):
	curl $(HAMCREST_URI) -o $(HAMCREST_JAR) --silent --location

clean:
	rm $(JUNIT_JAR)
	rm $(HAMCREST_JAR)
	rm *.class
