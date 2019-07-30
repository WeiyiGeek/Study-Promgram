CC = gcc
OBJECT = menu.o music.o picture.o
TARGET = all
$(TARGET):$(OBJECT)
	$(CC) $^ -o menu
music.o:music.c
	$(CC) -c $< -o $@
picture.o:picture.c
	$(CC) -c $< -o $@
clean:
	rm *.o menu
