# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.13

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2018.3.4\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2018.3.4\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\aaron\Desktop\School\CS12B\src\C

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\aaron\Desktop\School\CS12B\src\C\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/C.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/C.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/C.dir/flags.make

CMakeFiles/C.dir/library.c.obj: CMakeFiles/C.dir/flags.make
CMakeFiles/C.dir/library.c.obj: ../library.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\aaron\Desktop\School\CS12B\src\C\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/C.dir/library.c.obj"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\C.dir\library.c.obj   -c C:\Users\aaron\Desktop\School\CS12B\src\C\library.c

CMakeFiles/C.dir/library.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/C.dir/library.c.i"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E C:\Users\aaron\Desktop\School\CS12B\src\C\library.c > CMakeFiles\C.dir\library.c.i

CMakeFiles/C.dir/library.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/C.dir/library.c.s"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S C:\Users\aaron\Desktop\School\CS12B\src\C\library.c -o CMakeFiles\C.dir\library.c.s

CMakeFiles/C.dir/Dictionary.c.obj: CMakeFiles/C.dir/flags.make
CMakeFiles/C.dir/Dictionary.c.obj: ../Dictionary.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\aaron\Desktop\School\CS12B\src\C\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/C.dir/Dictionary.c.obj"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\C.dir\Dictionary.c.obj   -c C:\Users\aaron\Desktop\School\CS12B\src\C\Dictionary.c

CMakeFiles/C.dir/Dictionary.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/C.dir/Dictionary.c.i"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E C:\Users\aaron\Desktop\School\CS12B\src\C\Dictionary.c > CMakeFiles\C.dir\Dictionary.c.i

CMakeFiles/C.dir/Dictionary.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/C.dir/Dictionary.c.s"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S C:\Users\aaron\Desktop\School\CS12B\src\C\Dictionary.c -o CMakeFiles\C.dir\Dictionary.c.s

CMakeFiles/C.dir/test.c.obj: CMakeFiles/C.dir/flags.make
CMakeFiles/C.dir/test.c.obj: ../test.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\aaron\Desktop\School\CS12B\src\C\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building C object CMakeFiles/C.dir/test.c.obj"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\C.dir\test.c.obj   -c C:\Users\aaron\Desktop\School\CS12B\src\C\test.c

CMakeFiles/C.dir/test.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/C.dir/test.c.i"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E C:\Users\aaron\Desktop\School\CS12B\src\C\test.c > CMakeFiles\C.dir\test.c.i

CMakeFiles/C.dir/test.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/C.dir/test.c.s"
	C:\MinGW\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S C:\Users\aaron\Desktop\School\CS12B\src\C\test.c -o CMakeFiles\C.dir\test.c.s

# Object files for target C
C_OBJECTS = \
"CMakeFiles/C.dir/library.c.obj" \
"CMakeFiles/C.dir/Dictionary.c.obj" \
"CMakeFiles/C.dir/test.c.obj"

# External object files for target C
C_EXTERNAL_OBJECTS =

libC.a: CMakeFiles/C.dir/library.c.obj
libC.a: CMakeFiles/C.dir/Dictionary.c.obj
libC.a: CMakeFiles/C.dir/test.c.obj
libC.a: CMakeFiles/C.dir/build.make
libC.a: CMakeFiles/C.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\aaron\Desktop\School\CS12B\src\C\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Linking C static library libC.a"
	$(CMAKE_COMMAND) -P CMakeFiles\C.dir\cmake_clean_target.cmake
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\C.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/C.dir/build: libC.a

.PHONY : CMakeFiles/C.dir/build

CMakeFiles/C.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\C.dir\cmake_clean.cmake
.PHONY : CMakeFiles/C.dir/clean

CMakeFiles/C.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\aaron\Desktop\School\CS12B\src\C C:\Users\aaron\Desktop\School\CS12B\src\C C:\Users\aaron\Desktop\School\CS12B\src\C\cmake-build-debug C:\Users\aaron\Desktop\School\CS12B\src\C\cmake-build-debug C:\Users\aaron\Desktop\School\CS12B\src\C\cmake-build-debug\CMakeFiles\C.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/C.dir/depend
