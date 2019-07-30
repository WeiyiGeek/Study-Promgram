#CC = arm-linux-gcc
CC = gcc
TARGET = all
INCLUDE_DIR = ../include/
SRC_DIR = ./
OBJ_DIR = ../obj/
BIN_DIR = ../bin/
$(TARGET):$(OBJ_DIR)menu.o $(OBJ_DIR)music.o $(OBJ_DIR)picture.o
	$(CC) $^ -o $(BIN_DIR)menu
include $(SRC_DIR)menu/Makefile
#$(OBJ_DIR)menu.o:$(SRC_DIR)menu/menu.c
#	$(CC) -I $(INCLUDE_DIR) -c $< -o $@
include $(SRC_DIR)music/Makefile
#$(OBJ_DIR)music.o: $(SRC_DIR)music/music.c
#	$(CC) -c $< -o $@
include $(SRC_DIR)picture/Makefile
#$(OBJ_DIR)picture.o:$(SRC_DIR)picture/picture.c
#	$(CC) -c $< -o $@
clean:
	rm $(OBJ_DIR)*.o $(BIN_DIR)menu
