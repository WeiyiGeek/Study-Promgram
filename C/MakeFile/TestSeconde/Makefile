#CC=arm-linux-gcc
CC=gcc
OBJECT=main.o mytool1.o mytool2.o
all:$(OBJECT)
	$(CC) $(OBJECT) -o main
main.o:main.c
	$(CC) -c main.c -o main.o
mytool2.o:mytool2.c
	$(CC) -c mytool2.c -o mytool2.o
mytool1.o:mytool1.c
	$(CC) -c mytool1.c -o mytool1.o
clean:
	rm *.o main
