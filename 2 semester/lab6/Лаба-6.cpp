// ConsoleApplication2.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <Windows.h>
#include"Mnogochlen.h"
#include <iostream>

int main()
{
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	vector <double> k = {1,1,2,2,3,3,4,4};
	Mnogochlen Mnog, Mnog2(k);
	Mnog.set_mnogochlen(); cout << endl;
	cout << Mnog << endl << endl;
	cout << "Значение многочлена: " << Mnog.znach() << endl << endl;
	Mnog.podob(); cout << endl;
	cout << "Продифференцированный многочлен" << endl; -Mnog; cout << Mnog << endl;
	Mnog < Mnog2;
	system("pause");
    return 0;
}

