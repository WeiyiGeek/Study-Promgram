#CC = arm-linux-gcc
CC = gcc
TARGET = all
INCLUDE_DIR = ../include/
SRC_DIR = ./
OBJ_DIR = ../obj/
BIN_DIR = ../bin/
$(TARGET):$(OBJ_DIR)menu.o $(OBJ_DIR)music.o $(OBJ_DIR)picture.o
	$(CC) $^ -o $(BIN_DIR)menu
$(OBJ_DIR)menu.o:$(SRC_DIR)menu.c $(INCLUDE_DIR)menu.h
	$(CC) -I $(INCLUDE_DIR) -c $< -o $@
$(OBJ_DIR)music.o:$(SRC_DIR)music.c
	$(CC) -c $< -o $@
$(OBJ_DIR)picture.o:$(SRC_DIR)picture.c
	$(CC) -c $< -o $@
clean:
	rm $(OBJ_DIR)*.o $(BIN_DIR)menu
