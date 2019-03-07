cmake_minimum_required(VERSION 3.13)
project(C C)

set(CMAKE_C_STANDARD 99)

add_library(C library.c library.h Dictionary.c test.c)