#include <iostream>
#include <fstream>
#include "big_number.h"
#include "big_number.cpp"
#include "interpreter.h"
#include "interpreter.cpp"
#include "program.h"
#include "program.cpp"
using namespace std;

int main(int argc, char *argv[]) {
    running();
    BigNumber numar1, numar2, numar3;
    numar1.LoadFromString("44748564589467812374783957123");
    numar2.LoadFromString("17000000000000000000000000000");
    numar3 = numar1 + numar2;
    cout << "\033[29;1mcompiler test:\033[0m ";
    numar3.PrintNumber();
    cout << " ... \033[32;1mok!\033[0m" << endl;
    //cout << " ... ok!" << endl;

    Program program;
    program.Loop();
    return 0;
}