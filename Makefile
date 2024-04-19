SRCS = $(shell find . -name "*.java")
MAIN = AvajLauncher


all: $(SRCS)
	@javac $^

clean: fclean

fclean:
	@find . -name "*.class" -delete

run: all
	@java ${MAIN} ./scenarios/scenario.txt