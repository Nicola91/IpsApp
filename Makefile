# Makefile da inserire nella root dei sorgenti del progetto.
JFLAGS = -g
JC = javac
Z = Zones
A = Alg


compile:
	$(JC) $(Z)/*.java
	$(JC) $(A)/*.java
	$(JC) *.java
	@echo "Compilazione completata"

