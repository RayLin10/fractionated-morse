run: fractionatedMorse.class
	java fractionatedMorse $(ARGS)

fractionatedMorse.class: fractionatedMorse.java
	javac fractionatedMorse.java

clean:
	rm*.class