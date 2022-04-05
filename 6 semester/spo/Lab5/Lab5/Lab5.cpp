#include <iostream>
#include <Windows.h>
#define DIV 1024
#define WIDTH 7

int main()
{
    setlocale(LC_ALL, "Russian");
    MEMORYSTATUS stat;

    GlobalMemoryStatus(&stat);

    printf("Размер структуры MEMORYSTATUS %ld\n",
        stat.dwLength);
    printf("Процентов используемой памяти %ld\n",
        stat.dwMemoryLoad);
    printf("Количетсво кбайтов физической памяти %*ld\n",
        WIDTH, stat.dwTotalPhys / DIV);
    printf("Количетсво свободных кбайтов физической памяти %*ld\n",
        WIDTH, stat.dwAvailPhys / DIV);
    printf("Размер в кбайтах файла подкачки %*ld\n",
        WIDTH, stat.dwTotalPageFile / DIV);
    printf("Количство свободных кбайтов файла подкачки %*ld\n",
        WIDTH, stat.dwAvailPageFile / DIV);
    printf("Количество кбайтов адресного пространства %*ld\n",
        WIDTH, stat.dwTotalVirtual / DIV);
    printf("Количество свободных кбайтов адресного пространства %*ld\n",
        WIDTH, stat.dwAvailVirtual / DIV);
}
