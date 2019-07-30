CC=gcc
OBJECT=main.o study.o visit.o
all:$(OBJECT)
	$(CC) $^ -o main
main.o:main.c 
	$(CC) -c $< -o $@
study.o:study.c study.h
	$(CC) -c $< -o $@
visit.o:visit.c visit.h
	$(CC) -c $< -o $@
clean:
	rm *.o main
